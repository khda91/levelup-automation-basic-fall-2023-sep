package ru.levelp.at.taf.trello.service.webdriver;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.levelp.at.taf.trello.dictionary.BrowserType;
import ru.levelp.at.taf.trello.exception.UnsupportedBrowserTypeException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class WebDriverFactory {

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
