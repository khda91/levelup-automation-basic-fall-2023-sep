package ru.levelp.at.lesson0507.selenium.basic.sample;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.levelp.at.utils.SleepUtils;

class UserBugRedScrollTest {

    private static final String URL = "http://users.bugred.ru/";

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        driver.manage().window().setSize(new Dimension(480, 640));
        driver.navigate().to(URL);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void testScrollDown() {
        SleepUtils.sleep(1500);

        var jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        SleepUtils.sleep(1500);
        var footerDisplayed = driver.findElement(By.xpath("//footer")).isDisplayed();

        assertThat(footerDisplayed)
            .isTrue();
    }
}
