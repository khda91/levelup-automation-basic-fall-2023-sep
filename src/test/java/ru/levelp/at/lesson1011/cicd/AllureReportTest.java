package ru.levelp.at.lesson1011.cicd;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import io.qameta.allure.TmsLinks;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.levelp.at.lesson1011.cicd.context.TestContext;
import ru.levelp.at.lesson1011.cicd.extension.AllureAttachmentCallback;
import ru.levelp.at.lesson1011.cicd.pages.UserBugRedIndexPage;
import ru.levelp.at.lesson1011.cicd.pages.UserBugRedLoginRegistrationPage;

@DisplayName("UserBugReg проверка функционала регистрации")
@Epic("Epic 1")
@ExtendWith(AllureAttachmentCallback.class)
class AllureReportTest {

    private static final Faker FAKER = new Faker();

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        TestContext.getInstance().add("driver", driver);
    }

    @Test
    @DisplayName("Проверка регистрации пользователя")
    @Description("Генерируем пользователя и выполняем процедуру регистрации на сайте")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Пётр Сергеев")
    @TmsLink("LUP-1")
    @Feature("Feature 1")
    @Story("Registration")
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
        step("Выполняем проверку, что имя пользователя корректно", () ->
            assertThat(actualUserName)
                .as("Проверка корректности имени пользователя")
                .containsIgnoringCase(name));
    }

    @Test
    @DisplayName("Проверка метода разлогина пользователя")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Иван Иванов")
    @TmsLinks({@TmsLink("LUP-2"), @TmsLink("LUP-3")})
    @Feature("Feature 1")
    @Story("Logout")
    void testLogout() {
        var indexPage = new UserBugRedIndexPage(driver);

        indexPage.open();
        indexPage.clickEnterButton();

        // Не самый лучший вариант написания шагов
        //        AtomicReference<String> name = new AtomicReference<>();
        //        AtomicReference<String> email = new AtomicReference<>();
        //        AtomicReference<String> password = new AtomicReference<>();
        //        step("Поиск тестовых данных", () -> {
        //            name.set(FAKER.name().firstName());
        //            email.set(FAKER.internet().emailAddress());
        //            password.set((FAKER.internet().password()));
        //        });

        final var testUser = step("Поиск тестовых данных", () ->
            new UserModel(FAKER.name().firstName(), FAKER.internet().emailAddress(), FAKER.internet().password()));

        var registerPage = new UserBugRedLoginRegistrationPage(driver);
        registerPage.sendKeysToNameTextField(testUser.getName());
        registerPage.sendKeysToEmailTextField(testUser.getEmail());
        registerPage.sendKeysToPasswordTextField(testUser.getPassword());
        registerPage.clickRegisterButton();

        indexPage = new UserBugRedIndexPage(driver);
        indexPage.clickUserDropdownMenu();
        indexPage.clickExitButton();
        var logoutSuccessful = indexPage.isUserDropdownMenuDisplayed();

        step("Проерка, что разлогин прошёл успешно", () ->
            assertThat(logoutSuccessful)
                .as("Проверка что меню пропало")
                .isFalse());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @RequiredArgsConstructor
    @Getter
    private static class UserModel {
        private final String name;
        private final String email;
        private final String password;
    }
}
