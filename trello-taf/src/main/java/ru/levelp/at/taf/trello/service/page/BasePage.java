package ru.levelp.at.taf.trello.service.page;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.levelp.at.taf.trello.configuration.ConfigurationProvider;
import ru.levelp.at.taf.trello.service.webdriver.WebDriverSingleton;

public abstract class BasePage {

    private static final String URL;
    private static final long TIMEOUT_DEFAULT;

    static {
        URL = ConfigurationProvider.uiConfiguration().siteUrl();
        TIMEOUT_DEFAULT = ConfigurationProvider.uiConfiguration().timeoutMillis();
    }

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    protected BasePage() {
        this.driver = WebDriverSingleton.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofMillis(TIMEOUT_DEFAULT));
        PageFactory.initElements(driver, this);
    }

    public abstract void open();

    protected void open(final String relativeUrl) {
        driver.navigate().to(String.format("%s%s", URL, relativeUrl));
    }
}
