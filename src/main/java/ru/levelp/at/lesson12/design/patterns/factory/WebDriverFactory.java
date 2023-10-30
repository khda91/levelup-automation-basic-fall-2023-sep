package ru.levelp.at.lesson12.design.patterns.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.levelp.at.lesson12.design.patterns.factory.exceptions.UnsupportedBrowserTypeException;

public final class WebDriverFactory {

    private WebDriverFactory() {

    }

    public static WebDriver createDriver(final BrowserType type) {
        WebDriver driver;

        switch (type) {
            case CHROME:
                driver = createChrome();
                break;
            case FIREFOX:
                driver = createFirefox();
                break;
            default:
                throw new UnsupportedBrowserTypeException(type);
        }

        return driver;
    }

    private static WebDriver createChrome() {
        return new ChromeDriver();
    }

    private static WebDriver createFirefox() {
        return new FirefoxDriver();
    }
}
