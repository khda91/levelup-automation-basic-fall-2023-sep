package ru.levelp.at.lesson0709.api.srv.person.profile;

import static org.assertj.core.api.Assertions.assertThat;

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
import ru.levelp.at.lesson0709.api.srv.person.profile.model.CreatePersonRequest;
import ru.levelp.at.lesson0709.api.srv.person.profile.model.CreatePersonResponse;
import ru.levelp.at.lesson0709.api.srv.person.profile.model.PersonResponse;
import ru.levelp.at.lesson0709.api.srv.person.profile.service.object.PeopleApiClient;

public class TrueApiTest {

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
        final var requestBody = CreatePersonRequest.builder().build();

        final var actualResponse = new PeopleApiClient(requestSpecification, responseSpecification)
            .createPerson(requestBody)
            .then()
            .statusCode(HttpStatus.SC_CREATED)
            .extract()
            .as(CreatePersonResponse.class);

        assertThat(actualResponse.getData().getId())
            .as("Проверка что поле id заполнено")
            .isNotNull()
            .isNotBlank();

        final var actualPersonResponse = new PeopleApiClient(requestSpecification, responseSpecification)
            .getPerson(actualResponse.getData().getId())
            .then()
            .statusCode(HttpStatus.SC_OK)
            .extract()
            .as(PersonResponse.class);

        assertThat(actualPersonResponse)
            .as("Сравние данных ответа и данных которые были отправлены в запросе")
            .usingRecursiveComparison()
            .ignoringExpectedNullFields()
            // .ignoringFields("data.id")
            .isEqualTo(requestBody.toPersonResponse());
    }
}
