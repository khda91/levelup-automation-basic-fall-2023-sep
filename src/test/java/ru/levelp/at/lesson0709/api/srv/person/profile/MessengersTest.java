package ru.levelp.at.lesson0709.api.srv.person.profile;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

class MessengersTest {

    private static final Faker FAKER = new Faker();
    private static final String BASE_URI = "http://localhost";
    private static final int BASE_PORT = 8082;
    private static final String BASE_PATH = "/srv-person-profile";

    @Test
    void testCreateNewMessenger() {
        final var newMessengerName = FAKER.funnyName().name().replaceAll("[^a-zA-Z]", "_").toUpperCase();

        given()
            .baseUri(BASE_URI)
            .port(BASE_PORT)
            .basePath(BASE_PATH)
            .contentType(ContentType.JSON)
            .pathParam("messengerId", newMessengerName)
            .log().all()
            .when()
            .put("/messengers/{messengerId}")
            .then()
            .log().all()
            .statusCode(HttpStatus.SC_NO_CONTENT);

        given()
            .baseUri(BASE_URI)
            .port(BASE_PORT)
            .basePath(BASE_PATH)
            .contentType(ContentType.JSON)
            .log().all()
            .when()
            .get("/messengers")
            .then()
            .log().all()
            .statusCode(HttpStatus.SC_OK)
            .body("data.id", hasItem(newMessengerName));
    }

    @Test
    void testCreateNewMessengerWithExistingTitle() {
        given()
            .baseUri(BASE_URI)
            .port(BASE_PORT)
            .basePath(BASE_PATH)
            .contentType(ContentType.JSON)
            .pathParam("messengerId", "TELEGRAM")
            .log().all()
            .when()
            .put("/messengers/{messengerId}")
            .then()
            .log().all()
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
