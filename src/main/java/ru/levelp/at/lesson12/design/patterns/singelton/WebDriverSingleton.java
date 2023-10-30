package ru.levelp.at.lesson12.design.patterns.singelton;

import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson12.design.patterns.factory.BrowserType;
import ru.levelp.at.lesson12.design.patterns.factory.WebDriverFactory;

public final class WebDriverSingleton {

    private static WebDriver driver;

    private WebDriverSingleton() {

    }

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
