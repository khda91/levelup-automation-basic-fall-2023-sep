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

class SeleniumImplicitWaitTimeoutTest {

    private static final String URL = "http://users.bugred.ru/";
    private static final Faker FAKER = new Faker();

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
    }

    @Test
    void testImplicitTimeout() {
        long startTime = System.currentTimeMillis();
        try {
            driver.navigate().to(URL);

            driver.findElement(By.xpath("//span[text()='Войти']")).click();

            var name = FAKER.name().firstName();
            var email = FAKER.internet().emailAddress();
            var password = FAKER.internet().password();

            driver.findElement(By.xpath("//form[contains(@action, '/register/')]//input[@name='name']"))
                  .sendKeys(name);
            driver.findElement(By.xpath("//form[contains(@action, '/register/')]//input[@name='email']"))
                  .sendKeys(email);
            driver.findElement(By.xpath("//form[contains(@action, '/register/')]//input[@name='password']"))
                  .sendKeys(password);
            driver.findElement(By.xpath("//form[contains(@action, '/register/')]"
                + "//input[@name='act_register_now']")).click();

            var actualUserName = driver.findElement(By.xpath("//*[@class='dropdown-toggle']")).getText();
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
