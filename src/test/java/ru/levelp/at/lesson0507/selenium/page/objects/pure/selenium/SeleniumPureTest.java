package ru.levelp.at.lesson0507.selenium.page.objects.pure.selenium;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.javafaker.Faker;
import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class SeleniumPureTest {

    private static final String URL = "http://users.bugred.ru/";
    private static final Faker FAKER = new Faker();

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
    }

    @Test
    void testExplicitTimeout() {
        driver.navigate().to(URL);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Войти']"))).click();

        var name = FAKER.name().firstName();
        var email = FAKER.internet().emailAddress();
        var password = FAKER.internet().password();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//form[contains(@action, '/register/')]//input[@name='name']")))
            .sendKeys(name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//form[contains(@action, '/register/')]//input[@name='email']")))
            .sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//form[contains(@action, '/register/')]//input[@name='password']")))
            .sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(By
                .xpath("//form[contains(@action, '/register/')]//input[@name='act_register_now']")))
            .click();

        var actualUserName = wait.until(ExpectedConditions.visibilityOfElementLocated(By
                                     .xpath("//*[@class='dropdown-toggle']")))
                                 .getText();
        assertThat(actualUserName)
            .as("Проверка корректности имени пользователя")
            .containsIgnoringCase(name);
    }

    @Test
    void testLogout() {
        driver.navigate().to(URL);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Войти']"))).click();

        var name = FAKER.name().firstName();
        var email = FAKER.internet().emailAddress();
        var password = FAKER.internet().password();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//form[contains(@action, '/register/')]//input[@name='name']")))
            .sendKeys(name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//form[contains(@action, '/register/')]//input[@name='email']")))
            .sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//form[contains(@action, '/register/')]//input[@name='password']")))
            .sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(By
                .xpath("//form[contains(@action, '/register/')]//input[@name='act_register_now']")))
            .click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='dropdown-toggle']")))
            .click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Выход']")))
            .click();

        var toolBox = wait.until(ExpectedConditions.invisibilityOfElementLocated(By
            .xpath("//*[@class='dropdown-toggle']")));

        assertThat(toolBox)
            .as("Проверка что меню пропало")
            .isTrue();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
