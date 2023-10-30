package ru.levelp.at.lesson12.design.patterns.steps.step;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson1011.cicd.pages.UserBugRedIndexPage;

public class AssertionStep {

    private final WebDriver driver;

    public AssertionStep(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Проверка имени пользователя")
    public void assertThatUsernameIsEqualToCreateUsername(String expectedUsername) {
        var actualUserName = new UserBugRedIndexPage(driver).getTextFromUserDropdownMenu();

        step("Выполняем проверку, что имя пользователя корректно", () ->
            assertThat(actualUserName)
                .as("Проверка корректности имени пользователя")
                .containsIgnoringCase(expectedUsername));
    }
}
