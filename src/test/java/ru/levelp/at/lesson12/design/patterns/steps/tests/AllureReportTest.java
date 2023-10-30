package ru.levelp.at.lesson12.design.patterns.steps.tests;

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
import ru.levelp.at.lesson12.design.patterns.steps.model.UserModel;
import ru.levelp.at.lesson12.design.patterns.steps.step.ActionStep;
import ru.levelp.at.lesson12.design.patterns.steps.step.AssertionStep;

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
        final var testUser = step("Поиск тестовых данных", () ->
            new UserModel(FAKER.name().firstName(), FAKER.internet().emailAddress(), FAKER.internet().password()));
        var actionStep = new ActionStep(driver);

        actionStep.openWebSite();
        actionStep.registerUser(testUser);

        new AssertionStep(driver).assertThatUsernameIsEqualToCreateUsername(testUser.getName());
    }

    @Test
    @DisplayName("Проверка метода разлогина пользователя")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Иван Иванов")
    @TmsLinks({@TmsLink("LUP-2"), @TmsLink("LUP-3")})
    @Feature("Feature 1")
    @Story("Logout")
    void testLogout() {
        final var testUser = step("Поиск тестовых данных", () ->
            new UserModel(FAKER.name().firstName(), FAKER.internet().emailAddress(), FAKER.internet().password()));
        var actionStep = new ActionStep(driver);

        actionStep.openWebSite();
        actionStep.registerUser(testUser);

        var indexPage = new UserBugRedIndexPage(driver);
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
}
