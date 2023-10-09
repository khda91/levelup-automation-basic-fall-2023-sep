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

class SeleniumExplicitVsImplicitWaitTimeoutTest {

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
    void testBaseTimeout() {
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

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='dropdown-toggle']")))
                .click();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Выход']")))
                .click();

            var toolBox = wait.until(ExpectedConditions.invisibilityOfElementLocated(By
                .xpath("//*[@class='dropdown-toggle']")));

            assertThat(toolBox)
                .as("Проверка что меню пропало")
                .isTrue();
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.printf("Test duration 'testBaseTimeout' -> %s", (endTime - startTime));
        }
    }

    @Test
    void testExplicitGreaterThatImplicitTimeout() {
        wait = new WebDriverWait(driver, Duration.ofMillis(11000));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

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

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='dropdown-toggle']")))
                .click();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Выход']")))
                .click();

            var toolBox = wait.until(ExpectedConditions.invisibilityOfElementLocated(By
                .xpath("//*[@class='dropdown-toggle']")));

            assertThat(toolBox)
                .as("Проверка что меню пропало")
                .isTrue();
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.printf("Test duration 'testExplicitGreaterThatImplicitTimeout' -> %s", (endTime - startTime));
        }
    }

    @Test
    void testExplicitLessThanImplicitTimeout() {
        wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(6000));

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

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='dropdown-toggle']")))
                .click();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Выход']")))
                .click();

            var toolBox = wait.until(ExpectedConditions.invisibilityOfElementLocated(By
                .xpath("//*[@class='dropdown-toggle']")));

            assertThat(toolBox)
                .as("Проверка что меню пропало")
                .isTrue();
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.printf("Test duration 'testExplicitGreaterThatImplicitTimeout' -> %s", (endTime - startTime));
        }
    }

    @Test
    void testExplicitTogetherImplicitTimeout() {
        wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

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
            driver.findElement(By.xpath("//form[contains(@action, '/register/')]//input[@name='act_register_now']"))
                  .click();

            driver.findElement(By.xpath("//*[@class='dropdown-toggle']")).click();

            driver.findElement(By.xpath("//a[text()='Выход']")).click();

            var toolBox = false;
            var timeout = driver.manage().timeouts().getImplicitWaitTimeout();
            driver.manage().timeouts().implicitlyWait(Duration.ZERO);

            try {
                toolBox = wait.until(ExpectedConditions.invisibilityOfElementLocated(By
                    .xpath("//*[@class='dropdown-toggle']")));
            } finally {
                driver.manage().timeouts().implicitlyWait(timeout);
            }

            assertThat(toolBox)
                .as("Проверка что меню пропало")
                .isTrue();
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.printf("Test duration 'testExplicitTogetherImplicitTimeout' -> %s", (endTime - startTime));
        }
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
