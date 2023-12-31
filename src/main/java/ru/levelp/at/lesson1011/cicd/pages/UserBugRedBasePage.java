package ru.levelp.at.lesson1011.cicd.pages;

import io.qameta.allure.Step;
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

    @Step("Окрываем страницу по относительному адресу '{relativeUrl}'")
    protected void open(final String relativeUrl) {
        driver.navigate().to(BASE_URL + relativeUrl);
    }

    public abstract void open();
}
