package ru.levelp.at.lesson0507.selenium.page.objects.types.fluent;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class SeleniumPageObjectFluentTypeTest {

    private static final Faker FAKER = new Faker();

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    void testExplicitTimeout() {
        var name = FAKER.name().firstName();
        var email = FAKER.internet().emailAddress();
        var password = FAKER.internet().password();

        var registerPage = new UserBugRedIndexPage(driver)
            .open()
            .clickEnterButton();

        var actualUserName = registerPage.sendKeysToNameTextField(name)
                                         .sendKeysToEmailTextField(email)
                                         .sendKeysToPasswordTextField(password)
                                         .clickRegisterButton()
                                         .getTextFromUserDropdownMenu();

        assertThat(actualUserName)
            .as("Проверка корректности имени пользователя")
            .containsIgnoringCase(name);
    }

    @Test
    void testLogout() {
        var name = FAKER.name().firstName();
        var email = FAKER.internet().emailAddress();
        var password = FAKER.internet().password();

        var registerPage = new UserBugRedIndexPage(driver)
            .open()
            .clickEnterButton();

        var indexPage = registerPage.sendKeysToNameTextField(name)
                                    .sendKeysToEmailTextField(email)
                                    .sendKeysToPasswordTextField(password)
                                    .clickRegisterButton();

        var logoutSuccessful = indexPage.clickUserDropdownMenu()
                                        .clickExitButton()
                                        .isUserDropdownMenuDisplayed();

        assertThat(logoutSuccessful)
            .as("Проверка что меню пропало")
            .isFalse();
    }

    // ТАК НЕ ДЕЛАТЬ C FLUENT PAGE OBJECT
    @Test
    void testLogoutWrong() {
        var name = FAKER.name().firstName();
        var email = FAKER.internet().emailAddress();
        var password = FAKER.internet().password();

        var logoutSuccessful = new UserBugRedIndexPage(driver)
            .open()
            .clickEnterButton()
            .sendKeysToNameTextField(name)
            .sendKeysToEmailTextField(email)
            .sendKeysToPasswordTextField(password)
            .clickRegisterButton()
            .clickUserDropdownMenu()
            .clickExitButton()
            .isUserDropdownMenuDisplayed();

        assertThat(logoutSuccessful)
            .as("Проверка что меню пропало")
            .isFalse();
    }

    @Test
    void testNegativeRegistration() {
        var name = FAKER.name().firstName();
        var email = FAKER.name().firstName();
        var password = FAKER.internet().password();

        var actualErrorText = new UserBugRedLoginRegistrationPage(driver)
            .open()
            .sendKeysToNameTextField(name)
            .sendKeysToEmailTextField(email)
            .sendKeysToPasswordTextField(password)
            .clickRegisterButtonFail()
            .getTextFromErrorMessageLabel();

        assertThat(actualErrorText)
            .as("Проверка сообщение об ошибке с неправильным email")
            .isEqualTo("register_not_correct_field (email)");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
