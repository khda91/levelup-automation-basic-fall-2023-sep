package ru.levelp.at.lesson0709.api.srv.person.profile;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import com.github.javafaker.Faker;
import com.jayway.jsonpath.JsonPath;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JsonPathPeopleTest {

    private static final Faker FAKER = new Faker();
    private static final String BASE_URI = "http://localhost";
    private static final int BASE_PORT = 8082;
    private static final String BASE_PATH = "/srv-person-profile";

    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecification;

    @BeforeEach
    void setUp() {
        requestSpecification = new RequestSpecBuilder()
            .log(LogDetail.ALL)
            .setBaseUri(BASE_URI)
            .setPort(BASE_PORT)
            .setBasePath(BASE_PATH)
            .setContentType(ContentType.JSON)
            .build();

        responseSpecification = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .build();
    }

    @Test
    void testCreatePersonDynamicVariable() {
        final var email = FAKER.internet().emailAddress();
        final var phoneNumber = FAKER.phoneNumber().phoneNumber();
        final var firstName = FAKER.name().firstName();
        final var lastName = FAKER.name().lastName();
        final var middleName = FAKER.name().nameWithMiddle().split(" ")[1];

        String requestBody = JsonPath
            .parse(this.getClass().getResourceAsStream(
                "/ru/levelp/at/lesson0709/api/person/profile/jsonpath/create_person_default.json"))
            .set("$.email", email)
            .set("$.phoneNumber", phoneNumber)
            .jsonString();

        given()
            .spec(requestSpecification)
            .body(requestBody)
            .when()
            .post("/people")
            .then()
            .spec(responseSpecification)
            .statusCode(HttpStatus.SC_CREATED)
            .body("data.id", not(emptyOrNullString()))
            .body("data.role", equalTo("LECTOR"))
            .body("data.email", equalTo(email))
            .body("data.phoneNumber", equalTo(phoneNumber));
    }

    @Test
    void testCreatePersonDynamicVariableWithoutIdentity() {
        final var email = FAKER.internet().emailAddress();
        final var phoneNumber = FAKER.phoneNumber().phoneNumber();
        final var firstName = FAKER.name().firstName();
        final var lastName = FAKER.name().lastName();
        final var middleName = FAKER.name().nameWithMiddle().split(" ")[1];

        String requestBody = JsonPath
            .parse(this.getClass().getResourceAsStream(
                "/ru/levelp/at/lesson0709/api/person/profile/jsonpath/create_person_default.json"))
            .set("$.email", email)
            .set("$.phoneNumber", phoneNumber)
            .delete("$.identity")
            .jsonString();

        given()
            .spec(requestSpecification)
            .body(requestBody)
            .when()
            .post("/people")
            .then()
            .spec(responseSpecification)
            .statusCode(HttpStatus.SC_CREATED)
            .body("data.id", not(emptyOrNullString()))
            .body("data.role", equalTo("LECTOR"))
            .body("data.email", equalTo(email))
            .body("data.phoneNumber", equalTo(phoneNumber));
    }
}
