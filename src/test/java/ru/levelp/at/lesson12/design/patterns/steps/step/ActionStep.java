package ru.levelp.at.lesson12.design.patterns.steps.step;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson1011.cicd.pages.UserBugRedIndexPage;
import ru.levelp.at.lesson1011.cicd.pages.UserBugRedLoginRegistrationPage;
import ru.levelp.at.lesson12.design.patterns.steps.model.UserModel;

public class ActionStep {

    private final WebDriver driver;

    public ActionStep(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открываем сайт")
    public void openWebSite() {
        new UserBugRedIndexPage(driver).open();
    }

    @Step("Регистрируем пользователя на сайте")
    public void registerUser(UserModel user) {
        new UserBugRedIndexPage(driver).clickEnterButton();

        var registerPage = new UserBugRedLoginRegistrationPage(driver);
        registerPage.sendKeysToNameTextField(user.getName());
        registerPage.sendKeysToEmailTextField(user.getEmail());
        registerPage.sendKeysToPasswordTextField(user.getPassword());
        registerPage.clickRegisterButton();
    }
}
