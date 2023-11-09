package ru.levelp.at.taf.trello.service.api;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BoardsRestClient {

    private static final String BOARDS_ENDPOINT = "/boards";

    private final RequestSpecification requestSpecification;

    public Response createBoard(final String name) {
        return given()
            .spec(requestSpecification)
            .queryParam("name", name)
            .when()
            .post(BOARDS_ENDPOINT)
            .thenReturn();
    }
}
