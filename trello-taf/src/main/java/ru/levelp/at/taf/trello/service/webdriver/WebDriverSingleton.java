package ru.levelp.at.taf.trello.service.webdriver;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import ru.levelp.at.taf.trello.dictionary.BrowserType;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class WebDriverSingleton {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            var browserType = BrowserType.getByName(System.getProperty("browser.type"));
            driver = WebDriverFactory.createDriver(browserType);
        }

        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
