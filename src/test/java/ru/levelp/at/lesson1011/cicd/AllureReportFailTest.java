package ru.levelp.at.lesson1011.cicd;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.javafaker.Faker;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Issues;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
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

@DisplayName("UserBugReg проверка функционала регистрации (падающий)")
@Epic("1")
@Feature("Feature 2")
@ExtendWith(AllureAttachmentCallback.class)
class AllureReportFailTest {

    private static final Faker FAKER = new Faker();

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        TestContext.getInstance().add("driver", driver);
    }

    @Test
    @DisplayName("Регистрация падающая")
    @Severity(SeverityLevel.TRIVIAL)
    @Owner("Вася Пупкин")
    @TmsLink("LUP-4")
    @Issues({@Issue("LUPB-1")})
    @Story("Fail test")
    @Link(name = "abcd", url = "http://jajhasdjhkvklhs.ru")
    void testFailForReport() {
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
            .containsIgnoringCase(name + " 1231");
    }

    @AfterEach
    void tearDown() {
        System.out.println("AllureReportFailTest.tearDown");
        driver.quit();
    }
}
