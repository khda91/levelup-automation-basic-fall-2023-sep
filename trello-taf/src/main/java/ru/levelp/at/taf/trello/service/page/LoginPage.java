package ru.levelp.at.taf.trello.service.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//*[@id='username']")
    private WebElement usernameTextField;

    @FindBy(xpath = "//*[@id='login-submit']")
    private WebElement continueButton;

    @FindBy(xpath = "//*[@id='password']")
    private WebElement passwordTextField;

    @FindBy(xpath = "//*[@id='login-submit']")
    private WebElement loginButton;

    @Override
    public void open() {
        throw new UnsupportedOperationException();
    }

    public void sendTextToUsernameTextField(final String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameTextField)).sendKeys(username);
    }

    public void sendTextToPasswordTextField(final String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordTextField)).sendKeys(password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public void clickContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }
}
