package ru.levelp.at.taf.trello.step;

import io.qameta.allure.Param;
import io.qameta.allure.Step;
import io.qameta.allure.model.Parameter.Mode;
import ru.levelp.at.taf.trello.service.page.BoardsPage;
import ru.levelp.at.taf.trello.service.page.LoginPage;
import ru.levelp.at.taf.trello.service.page.MainPage;

public class AuthorizationStep {

    @Step("Авторизация пользователя")
    public static void login(@Param(value = "Имя пользователя") final String username,
                             @Param(mode = Mode.HIDDEN) final String password) {
        new MainPage().clickLoginButton();

        var loginPage = new LoginPage();
        loginPage.sendTextToUsernameTextField(username);
        loginPage.clickContinueButton();
        loginPage.sendTextToPasswordTextField(password);
        loginPage.clickLoginButton();
    }

    public static boolean isUserIconDisplayed() {
        return new BoardsPage().isAccountButtonDisplayed();
    }
}
