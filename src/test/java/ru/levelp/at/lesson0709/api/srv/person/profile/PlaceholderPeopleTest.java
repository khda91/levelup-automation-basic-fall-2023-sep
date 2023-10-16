package ru.levelp.at.lesson0709.api.srv.person.profile;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlaceholderPeopleTest {

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
        String requestBody;
        try {
            requestBody = FileUtils
                .readFileToString(new File(this
                        .getClass()
                        .getResource(
                            "/ru/levelp/at/lesson0709/api/person/profile/placeholder"
                                + "/create_person_default_request.json")
                        .getFile()),
                    StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        final var email = FAKER.internet().emailAddress();
        final var phoneNumber = FAKER.phoneNumber().phoneNumber();
        final var firstName = FAKER.name().firstName();
        final var lastName = FAKER.name().lastName();
        final var middleName = FAKER.name().nameWithMiddle().split(" ")[1];

        requestBody = requestBody.replace("{email}", email)
                                 .replace("{phoneNumber}", phoneNumber)
                                 .replace("{firstName}", firstName)
                                 .replace("{lastName}", lastName)
                                 .replace("{middleName}", middleName);

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
