package ru.levelp.at.lesson0709.api.srv.person.profile;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
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
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.levelp.at.lesson0709.api.srv.person.profile.model.CreatePersonRequest;
import ru.levelp.at.lesson0709.api.srv.person.profile.model.CreatePersonResponse;
import ru.levelp.at.lesson0709.api.srv.person.profile.model.IdentityData;

class JacksonPeopleTest {

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
        final var requestBody = createRequestBody();

        given()
            .spec(requestSpecification)
            .body(requestBody)
            .when()
            .post("/people")
            .then()
            .spec(responseSpecification)
            .statusCode(HttpStatus.SC_CREATED)
            .body("data.id", not(emptyOrNullString()))
            .body("data.role", equalTo(requestBody.getRole()))
            .body("data.email", equalTo(requestBody.getEmail()))
            .body("data.phoneNumber", equalTo(requestBody.getPhoneNumber()))
            .body("data.identity.middleName", equalTo(requestBody.getIdentity().getMiddleName()));
    }

    @Test
    void testCreatePersonHardAssertion() {
        final var requestBody = createRequestBody();

        final var actualResponse = given()
            .spec(requestSpecification)
            .body(requestBody)
            .when()
            .post("/people")
            .then()
            .spec(responseSpecification)
            .statusCode(HttpStatus.SC_CREATED)
            .extract()
            .as(CreatePersonResponse.class);

        assertThat(actualResponse.getData().getId())
            .as("Проверка что поле id заполнено")
            .isNotNull()
            .isNotBlank();
        assertThat(actualResponse.getData().getRole())
            .as("Проверка заполнености роли в соответствии с запросом")
            .isEqualTo("LECTOR");
        assertThat(actualResponse.getData().getEmail())
            .as("Проверка заполнености email в соответствии с запросом")
            .isEqualTo(requestBody.getEmail());
        assertThat(actualResponse.getData().getIdentity().getFirstName())
            .as("Проверка заполнености identity.firstName в соответствии с запросом")
            .isEqualTo(requestBody.getIdentity().getFirstName());
    }

    @Test
    void testCreatePersonSoftAssertion() {
        final var requestBody = createRequestBody();

        final var actualResponse = given()
            .spec(requestSpecification)
            .body(requestBody)
            .when()
            .post("/people")
            .then()
            .spec(responseSpecification)
            .statusCode(HttpStatus.SC_CREATED)
            .extract()
            .as(CreatePersonResponse.class);

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(actualResponse.getData().getId())
                  .as("Проверка что поле id заполнено")
                  .isNotNull()
                  .isNotBlank();
            softly.assertThat(actualResponse.getData().getRole())
                  .as("Проверка заполнености роли в соответствии с запросом")
                  .isEqualTo("LECTOR12");
            softly.assertThat(actualResponse.getData().getEmail())
                  .as("Проверка заполнености email в соответствии с запросом")
                  .isEqualTo(requestBody.getEmail() + "asas");
            softly.assertThat(actualResponse.getData().getPhoneNumber())
                  .as("Проверка заполнености phoneNumber в соответствии с запросом")
                  .isEqualTo(requestBody.getPhoneNumber() + "asas");
            softly.assertThat(actualResponse.getData().getIdentity().getFirstName())
                  .as("Проверка заполнености identity.firstName в соответствии с запросом")
                  .isEqualTo(requestBody.getIdentity().getFirstName() + "asas");
            softly.assertThat(actualResponse.getData().getIdentity().getLastName())
                  .as("Проверка заполнености identity.lastName в соответствии с запросом")
                  .isEqualTo(requestBody.getIdentity().getLastName() + "asas");
            softly.assertThat(actualResponse.getData().getIdentity().getMiddleName())
                  .as("Проверка заполнености identity.middleName в соответствии с запросом")
                  .isEqualTo(requestBody.getIdentity().getMiddleName() + "asas");
        });
    }

    @Test
    void testCreatePersonObjectComparison() {
        final var requestBody = createRequestBody();

        final var actualResponse = given()
            .spec(requestSpecification)
            .body(requestBody)
            .when()
            .post("/people")
            .then()
            .spec(responseSpecification)
            .statusCode(HttpStatus.SC_CREATED)
            .extract()
            .as(CreatePersonResponse.class);

        assertThat(actualResponse.getData().getId())
            .as("Проверка что поле id заполнено")
            .isNotNull()
            .isNotBlank();
        assertThat(actualResponse)
            .as("Сравние данных ответа и данных которые были отправлены в запросе")
            .usingRecursiveComparison()
            .ignoringExpectedNullFields()
            // .ignoringFields("data.id")
            .isEqualTo(requestBody.toCreatePersonResponse());
    }

    @Test
    void testCreatePersonDefaultValuesInLombok() {
        final var requestBody = CreatePersonRequest.builder().build();

        final var actualResponse = given()
            .spec(requestSpecification)
            .body(requestBody)
            .when()
            .post("/people")
            .then()
            .spec(responseSpecification)
            .statusCode(HttpStatus.SC_CREATED)
            .extract()
            .as(CreatePersonResponse.class);

        assertThat(actualResponse.getData().getId())
            .as("Проверка что поле id заполнено")
            .isNotNull()
            .isNotBlank();
        assertThat(actualResponse)
            .as("Сравние данных ответа и данных которые были отправлены в запросе")
            .usingRecursiveComparison()
            .ignoringExpectedNullFields()
            // .ignoringFields("data.id")
            .isEqualTo(requestBody.toCreatePersonResponse());
    }

    @Test
    void testCreatePersonNegative() {
        final var requestBody = CreatePersonRequest.builder()
                                                   .email(null)
                                                   .build();

        given()
            .spec(requestSpecification)
            .body(requestBody)
            .when()
            .post("/people")
            .then()
            .spec(responseSpecification)
            .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    private CreatePersonRequest createRequestBody() {
        return CreatePersonRequest
            .builder()
            .role("LECTOR")
            .email(FAKER.internet().emailAddress())
            .phoneNumber(FAKER.phoneNumber().phoneNumber())
            .identity(IdentityData
                .builder()
                .firstName(FAKER.name().firstName())
                .lastName(FAKER.name().lastName())
                .middleName(FAKER.name().nameWithMiddle().split(" ")[1])
                .build())
            .build();
    }
}
