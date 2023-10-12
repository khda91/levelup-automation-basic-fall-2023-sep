package ru.levelp.at.lesson0507.selenium.page.objects.inheritance;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class SeleniumPageObjectInheritanceTest {

    private static final Faker FAKER = new Faker();

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    void testExplicitTimeout() {
        var indexPage = new UserBugRedIndexPage(driver);

        indexPage.open();
        indexPage.clickEnterButton();

        var name = FAKER.name().firstName();
        var email = FAKER.internet().emailAddress();
        var password = FAKER.internet().password();

        var registerPage = new UserBugRedLoginRegistrationPage(driver);
        registerPage.sendKeysToNameTextField(name);
        registerPage.sendKeysToEmailTextField(email);
        registerPage.sendKeysToPasswordTextField(password);
        registerPage.clickRegisterButton();

        indexPage = new UserBugRedIndexPage(driver);
        var actualUserName = indexPage.getTextFromUserDropdownMenu();
        assertThat(actualUserName)
            .as("Проверка корректности имени пользователя")
            .containsIgnoringCase(name);
    }

    @Test
    void testLogout() {
        var indexPage = new UserBugRedIndexPage(driver);

        indexPage.open();
        indexPage.clickEnterButton();

        var name = FAKER.name().firstName();
        var email = FAKER.internet().emailAddress();
        var password = FAKER.internet().password();

        var registerPage = new UserBugRedLoginRegistrationPage(driver);
        registerPage.sendKeysToNameTextField(name);
        registerPage.sendKeysToEmailTextField(email);
        registerPage.sendKeysToPasswordTextField(password);
        registerPage.clickRegisterButton();

        indexPage = new UserBugRedIndexPage(driver);
        indexPage.clickUserDropdownMenu();
        indexPage.clickExitButton();
        var logoutSuccessful = indexPage.isUserDropdownMenuDisplayed();

        assertThat(logoutSuccessful)
            .as("Проверка что меню пропало")
            .isFalse();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
