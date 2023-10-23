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
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PeopleTest {

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
    void testCreatePerson() {
        given()
            .spec(requestSpecification)
            .body("{\n"
                + "  \"role\": \"LECTOR\",\n"
                + "  \"email\": \"person@mail.ru\",\n"
                + "  \"phoneNumber\": \"+79211234567\",\n"
                + "  \"placeOfWork\": \"Engineer\",\n"
                + "  \"identity\": {\n"
                + "    \"firstName\": \"Vasily\",\n"
                + "    \"lastName\": \"Pupkin\",\n"
                + "    \"middleName\": \"Ivanovich\",\n"
                + "    \"gender\": \"MALE\",\n"
                + "    \"dateOfBirth\": \"1980-02-07\",\n"
                + "    \"placeOfBirth\": \"Moscow\",\n"
                + "    \"passport\": {\n"
                + "      \"series\": \"1234\",\n"
                + "      \"number\": \"123456\",\n"
                + "      \"placeOfIssue\": \"\",\n"
                + "      \"dateOfIssue\": \"1980-02-07\",\n"
                + "      \"departmentCode\": \"123-456\"\n"
                + "    }\n"
                + "  },\n"
                + "  \"address\": {\n"
                + "    \"street\": \"Beethovenstrasse\",\n"
                + "    \"houseNumber\": 12,\n"
                + "    \"houseBuilding\": 1,\n"
                + "    \"houseLetter\": \"A\",\n"
                + "    \"flat\": 123,\n"
                + "    \"city\": \"Moscow\",\n"
                + "    \"postalCode\": \"123456\"\n"
                + "  }\n"
                + "}")
            .when()
            .post("/people")
            .then()
            .spec(responseSpecification)
            .statusCode(HttpStatus.SC_CREATED)
            .body("data.id", not(emptyOrNullString()))
            .body("data.role", equalTo("LECTOR"));
    }

    @Test
    void testCreatePersonDynamicVariable() {
        final var email = FAKER.internet().emailAddress();

        given()
            .spec(requestSpecification)
            .body("{\n"
                + "  \"role\": \"LECTOR\",\n"
                + "  \"email\": \"" + email + "\",\n"
                + "  \"phoneNumber\": \"+79211234567\",\n"
                + "  \"placeOfWork\": \"Engineer\",\n"
                + "  \"identity\": {\n"
                + "    \"firstName\": \"Vasily\",\n"
                + "    \"lastName\": \"Pupkin\",\n"
                + "    \"middleName\": \"Ivanovich\",\n"
                + "    \"gender\": \"MALE\",\n"
                + "    \"dateOfBirth\": \"1980-02-07\",\n"
                + "    \"placeOfBirth\": \"Moscow\",\n"
                + "    \"passport\": {\n"
                + "      \"series\": \"1234\",\n"
                + "      \"number\": \"123456\",\n"
                + "      \"placeOfIssue\": \"\",\n"
                + "      \"dateOfIssue\": \"1980-02-07\",\n"
                + "      \"departmentCode\": \"123-456\"\n"
                + "    }\n"
                + "  },\n"
                + "  \"address\": {\n"
                + "    \"street\": \"Beethovenstrasse\",\n"
                + "    \"houseNumber\": 12,\n"
                + "    \"houseBuilding\": 1,\n"
                + "    \"houseLetter\": \"A\",\n"
                + "    \"flat\": 123,\n"
                + "    \"city\": \"Moscow\",\n"
                + "    \"postalCode\": \"123456\"\n"
                + "  }\n"
                + "}")
            .when()
            .post("/people")
            .then()
            .spec(responseSpecification)
            .statusCode(HttpStatus.SC_CREATED)
            .body("data.id", not(emptyOrNullString()))
            .body("data.role", equalTo("LECTOR"))
            .body("data.email", equalTo(email));
    }
}
