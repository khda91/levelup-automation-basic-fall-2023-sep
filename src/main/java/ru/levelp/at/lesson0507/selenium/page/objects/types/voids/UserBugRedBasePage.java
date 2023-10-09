package ru.levelp.at.lesson0507.selenium.page.objects.types.voids;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class UserBugRedBasePage {

    private static final String BASE_URL = "http://users.bugred.ru";

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    protected UserBugRedBasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        PageFactory.initElements(driver, this);
    }

    protected void open(final String relativeUrl) {
        driver.navigate().to(BASE_URL + relativeUrl);
    }

    public abstract void open();
}
