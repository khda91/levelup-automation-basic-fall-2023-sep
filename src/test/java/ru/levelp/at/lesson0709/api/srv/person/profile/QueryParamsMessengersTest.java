package ru.levelp.at.lesson0709.api.srv.person.profile;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.util.Map;
import java.util.stream.Stream;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class QueryParamsMessengersTest {

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

    @ParameterizedTest
    @MethodSource("queryParamsDataProvider")
    void testGetMessengerLimit(Map<String, Object> queryParams, int expectedRecordsCount) {
        given()
            .spec(requestSpecification)
            .queryParams(queryParams)
            .when()
            .get("/messengers")
            .then()
            .spec(responseSpecification)
            .statusCode(HttpStatus.SC_OK)
            .body("meta.pagination.limit", equalTo(expectedRecordsCount))
            .body("data.id", hasSize(expectedRecordsCount));

    }

    @ParameterizedTest
    @MethodSource("queryParamsDataProvider")
    void testGetMessengerOffset(Map<String, Object> queryParams, int expectedOffset) {
        given()
            .spec(requestSpecification)
            .queryParams(queryParams)
            .when()
            .get("/messengers")
            .then()
            .spec(responseSpecification)
            .statusCode(HttpStatus.SC_OK)
            .body("meta.pagination.offset", equalTo(expectedOffset));
    }

    private static Stream<Arguments> queryParamsDataProvider() {
        return Stream.of(Arguments.of(Map.of("offset", "1"), 1),
            Arguments.of(Map.of("offset", "5"), 5));
    }
}
