package ru.levelp.at.lesson0507.selenium.basic.sample;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.levelp.at.utils.SleepUtils;

class GoogleSampleTest {

    private static final String GOOGLE_URL = "https://google.com";

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    void testOpenGoogle() {
        SleepUtils.sleep(2500);
        driver.navigate().to(GOOGLE_URL);

        SleepUtils.sleep(1500);
        assertThat(driver.getTitle())
                .as("Проверка названия страницы")
                .isEqualTo("Google");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
