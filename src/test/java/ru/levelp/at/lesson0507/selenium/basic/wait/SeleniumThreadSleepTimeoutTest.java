package ru.levelp.at.lesson0507.selenium.basic.wait;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.levelp.at.utils.SleepUtils;

class SeleniumThreadSleepTimeoutTest {

    private static final String URL = "http://users.bugred.ru/";
    private static final Faker FAKER = new Faker();

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    void testSleepTimeout() {
        long startTime = System.currentTimeMillis();
        try {
            driver.navigate().to(URL);
            SleepUtils.sleep(1000);

            driver.findElement(By.xpath("//span[text()='Войти']")).click();
            SleepUtils.sleep(2000);

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

            SleepUtils.sleep(3000);

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
