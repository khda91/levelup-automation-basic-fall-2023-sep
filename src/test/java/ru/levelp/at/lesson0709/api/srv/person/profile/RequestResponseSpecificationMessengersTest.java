package ru.levelp.at.lesson0709.api.srv.person.profile;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

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

class RequestResponseSpecificationMessengersTest {

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
    void testCreateNewMessenger() {
        final var newMessengerName = FAKER.funnyName().name().replaceAll("[^a-zA-Z]", "_").toUpperCase();

        given()
            .spec(requestSpecification)
            .pathParam("messengerId", newMessengerName)
            .when()
            .put("/messengers/{messengerId}")
            .then()
            .spec(responseSpecification)
            .statusCode(HttpStatus.SC_NO_CONTENT);

        given()
            .spec(requestSpecification)
            .when()
            .get("/messengers")
            .then()
            .spec(responseSpecification)
            .statusCode(HttpStatus.SC_OK)
            .body("data.id", hasItem(newMessengerName));
    }

    @Test
    void testCreateNewMessengerWithExistingTitle() {
        given()
            .spec(requestSpecification)
            .pathParam("messengerId", "TELEGRAM")
            .when()
            .put("/messengers/{messengerId}")
            .then()
            .spec(responseSpecification)
            .statusCode(HttpStatus.SC_BAD_REQUEST)
            .body("type", equalTo("validation"))
            .body("title", equalTo("Bad Request"))
            .body("status", equalTo("400"))
            .body("detail", equalTo("A malformed request was sent"))
            .body("violations.code", hasItem("duplicated_item"),
                "violations.field", hasItem("MessengerData.messengerId"),
                "violations.detail", hasItem("Messenger with id TELEGRAM already exist"));
    }
}
