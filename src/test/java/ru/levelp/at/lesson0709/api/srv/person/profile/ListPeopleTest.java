package ru.levelp.at.lesson0709.api.srv.person.profile;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;

import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.levelp.at.lesson0709.api.srv.person.profile.model.PersonListResponse;

class ListPeopleTest {

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
        final var response = given()
            .spec(requestSpecification)
            .when()
            .get("/people")
            .then()
            .spec(responseSpecification)
            .statusCode(HttpStatus.SC_OK)
            .body("data.id", hasSize(greaterThanOrEqualTo(6)))
            .extract()
            .as(PersonListResponse.class);

        System.out.println(response);
    }
}
