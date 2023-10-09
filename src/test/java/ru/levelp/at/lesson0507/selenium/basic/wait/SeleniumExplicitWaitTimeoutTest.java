package ru.levelp.at.lesson0507.selenium.basic.wait;

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

class SeleniumExplicitWaitTimeoutTest {

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
        long startTime = System.currentTimeMillis();
        try {
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
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.printf("Test duration -> %s", (endTime - startTime));
        }
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
