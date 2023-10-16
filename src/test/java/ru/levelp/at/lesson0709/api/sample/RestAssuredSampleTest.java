package ru.levelp.at.lesson0709.api.sample;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import io.restassured.http.ContentType;
import java.util.Map;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class RestAssuredSampleTest {

    @Test
    void testGetCookies() {
        when()
            .get("http://httpbin.org/cookies")
            .then()
            .statusCode(200);
    }

    @Test
    void testSetCookies() {
        given()
            .redirects().follow(true)
            .log().all()
            .contentType(ContentType.TEXT)
            .accept(ContentType.TEXT)
            .header("User-Agent", "NNNjsa")
            .pathParams(Map.of("name", "eat", "value", "meat"))
            .when()
            .get("http://httpbin.org/cookies/set/{name}/{value}")
            .then()
            .log().all()
            .statusCode(200)
            .body("cookies", Matchers.equalTo(Map.of("eat", "meat")));
    }
}
