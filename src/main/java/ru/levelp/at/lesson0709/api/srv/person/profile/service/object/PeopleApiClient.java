package ru.levelp.at.lesson0709.api.srv.person.profile.service.object;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.util.Collections;
import java.util.Map;
import ru.levelp.at.lesson0709.api.srv.person.profile.model.CreatePersonRequest;

public class PeopleApiClient {

    private static final String PEOPLE_ENDPOINT = "/people";
    private static final String PERSON_ENDPOINT = PEOPLE_ENDPOINT + "/{personId}";

    private final RequestSpecification requestSpecification;
    private final ResponseSpecification responseSpecification;

    public PeopleApiClient(RequestSpecification requestSpecification, ResponseSpecification responseSpecification) {
        this.requestSpecification = requestSpecification;
        this.responseSpecification = responseSpecification;
    }

    public Response createPerson(final CreatePersonRequest createPersonRequest) {
        return given()
            .spec(requestSpecification)
            .body(createPersonRequest)
            .when()
            .post(PEOPLE_ENDPOINT)
            .then()
            .spec(responseSpecification)
            .extract()
            .response();
    }

    public Response getPeople(Map<String, Object> queryParams) {
        return given()
            .spec(requestSpecification)
            .queryParams(queryParams)
            .when()
            .get(PEOPLE_ENDPOINT)
            .then()
            .spec(responseSpecification)
            .extract()
            .response();
    }

    public Response getPeople() {
        return getPeople(Collections.emptyMap());
    }

    public Response getPerson(final String personId) {
        return given()
            .spec(requestSpecification)
            .pathParam("personId", personId)
            .when()
            .get(PERSON_ENDPOINT)
            .then()
            .spec(responseSpecification)
            .extract()
            .response();
    }
}
