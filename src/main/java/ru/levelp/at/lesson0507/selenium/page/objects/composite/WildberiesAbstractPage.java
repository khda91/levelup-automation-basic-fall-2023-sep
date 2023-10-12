package ru.levelp.at.lesson0507.selenium.page.objects.composite;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class WildberiesAbstractPage {

    private static final String URL = "https://www.wildberries.ru";

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    protected WildberiesAbstractPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        PageFactory.initElements(driver, this);
    }

    protected void open(final String relativeUrl) {
        driver.navigate().to(String.format("%s/%s", URL, relativeUrl));
    }

    public abstract void open();
}
