package ru.levelp.at.taf.trello.tests;

import static org.assertj.core.api.Assertions.assertThat;

import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.levelp.at.taf.trello.configuration.ConfigurationProvider;
import ru.levelp.at.taf.trello.hooks.BaseHooks;
import ru.levelp.at.taf.trello.step.AuthorizationStep;
import ru.levelp.at.taf.trello.step.MainPageStep;

@Epic("Авторизация")
class LoginTest extends BaseHooks {

    @Test
    @DisplayName("Тест на логин пользователя")
    @Story("Пользователь может авторизоваться на ресурсе")
    void loginTest() {
        var username = ConfigurationProvider.uiConfiguration().username();
        var password = ConfigurationProvider.uiConfiguration().password();

        MainPageStep.openWebSite();
        AuthorizationStep.login(username, password);

        Allure.step("Проверка что пользователь залогинился", () ->
            assertThat(AuthorizationStep.isUserIconDisplayed())
                .as("Проверка что пользователь залогинился")
                .isTrue());
    }
}
