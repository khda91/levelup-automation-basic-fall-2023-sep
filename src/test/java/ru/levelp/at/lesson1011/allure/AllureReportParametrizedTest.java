package ru.levelp.at.lesson1011.allure;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Param;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import io.qameta.allure.model.Parameter.Mode;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.levelp.at.lesson1011.allure.context.TestContext;
import ru.levelp.at.lesson1011.allure.extension.AllureAttachmentCallback;
import ru.levelp.at.lesson1011.allure.pages.UserBugRedIndexPage;
import ru.levelp.at.lesson1011.allure.pages.UserBugRedLoginRegistrationPage;

@DisplayName("UserBugReg проверка функционала регистрации")
@Epic("Epic 2")
@ExtendWith(AllureAttachmentCallback.class)
class AllureReportParametrizedTest {

    private static final Faker FAKER = new Faker();

    private WebDriver driver;

    static Stream<Arguments> userDataProvider() {
        return Stream.of(
            Arguments.of(FAKER.name().firstName(), FAKER.internet().emailAddress(), FAKER.internet().password()),
            Arguments.of(FAKER.name().firstName(), FAKER.internet().domainName(), FAKER.internet().password()),
            Arguments.of(FAKER.name().firstName(), FAKER.internet().emailAddress(), FAKER.internet().password())
        );
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        TestContext.getInstance().add("driver", driver);
    }

    @ParameterizedTest(name = "(username = {0}, email = {1})")
    @DisplayName("Проверка регистрации пользователя")
    @MethodSource("userDataProvider")
    @Description("Генерируем пользователя и выполняем процедуру регистрации на сайте")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Пётр Сергеев")
    @TmsLink("LUP-1")
    @Feature("Feature 3")
    @Story("Parametrized")
    void testExplicitTimeout(
        /*@Param(name = "username")*/ final String name,
        @Param(name = "email") final String email,
        @Param(name = "password", mode = Mode.MASKED) final String password) {
        var indexPage = new UserBugRedIndexPage(driver);

        indexPage.open();
        indexPage.clickEnterButton();

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

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
