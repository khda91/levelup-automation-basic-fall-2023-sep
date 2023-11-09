package ru.levelp.at.taf.trello.service.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    private static final String PAGE_URL = "/home";

    @FindBy(xpath = "//a[contains(@data-uuid, '_login')]")
    private WebElement loginButton;

    @Override
    public void open() {
        open(PAGE_URL);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }
}
