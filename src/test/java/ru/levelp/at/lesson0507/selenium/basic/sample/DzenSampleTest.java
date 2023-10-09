package ru.levelp.at.lesson0507.selenium.basic.sample;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import ru.levelp.at.utils.SleepUtils;

class DzenSampleTest {

    private static final String DZEN_URL = "https://dzen.ru";

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new EdgeDriver();
    }

    @Test
    void testOpenDzen() {
        SleepUtils.sleep(2500);
        driver.navigate().to(DZEN_URL);

        SleepUtils.sleep(1500);
        assertThat(driver.getTitle())
            .as("Проверка названия страницы")
            .isEqualTo("Дзен");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
