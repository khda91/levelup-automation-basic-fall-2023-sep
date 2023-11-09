package ru.levelp.at.taf.trello.tests;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.javafaker.Faker;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import java.util.Map;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.levelp.at.taf.trello.configuration.ConfigurationProvider;
import ru.levelp.at.taf.trello.hooks.BaseHooks;
import ru.levelp.at.taf.trello.service.api.BoardsRestClient;
import ru.levelp.at.taf.trello.step.AuthorizationStep;
import ru.levelp.at.taf.trello.step.BoardStep;
import ru.levelp.at.taf.trello.step.MainPageStep;

@Epic("Проверка досок")
public class BoardsTest extends BaseHooks {

    private BoardsRestClient boardsRestClient;

    @Override
    @BeforeEach
    protected void setUp() {
        super.setUp();
        var apiConf = ConfigurationProvider.apiConfiguration();
        var reqSpec = new RequestSpecBuilder()
            .setBaseUri(apiConf.apiSiteUrl())
            .log(LogDetail.ALL)
            .setContentType(ContentType.JSON)
            .addQueryParams(
                Map.of("key", apiConf.key(),
                    "token", apiConf.token())
            )
            .build();
        boardsRestClient = new BoardsRestClient(reqSpec);
    }

    @Test
    @DisplayName("Тест создание списка внутри доски")
    @Story("Пользователь может авторизоваться на ресурсе")
    void loginTest() {
        var username = ConfigurationProvider.uiConfiguration().username();
        var password = ConfigurationProvider.uiConfiguration().password();

        var boardName = new Faker().funnyName().name();
        boardsRestClient.createBoard(boardName)
                        .then()
                        .log().all()
                        .statusCode(HttpStatus.SC_OK);

        MainPageStep.openWebSite();
        AuthorizationStep.login(username, password);

        BoardStep.openBoard(boardName);

        var listName = new Faker().funnyName().name();
        BoardStep.createNewList(listName);

        step("Проверка что новый список создался на доске", () -> {
            assertThat(BoardStep.getListNames())
                .as("Проверка что новый список создался на доске")
                .contains(listName);
        });
    }
}
