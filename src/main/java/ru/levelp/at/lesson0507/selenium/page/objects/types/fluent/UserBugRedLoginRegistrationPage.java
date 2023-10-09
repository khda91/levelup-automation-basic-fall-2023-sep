package ru.levelp.at.lesson0507.selenium.page.objects.types.fluent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserBugRedLoginRegistrationPage extends UserBugRedBasePage<UserBugRedLoginRegistrationPage> {

    private static final String URL = "/user/login/index.html";

    @FindBy(xpath = "//form[contains(@action, '/register/')]//input[@name='name']")
    private WebElement nameTextField;

    @FindBy(xpath = "//form[contains(@action, '/register/')]//input[@name='email']")
    private WebElement emailTextField;

    @FindBy(xpath = "//form[contains(@action, '/register/')]//input[@name='password']")
    private WebElement passwordTextField;

    @FindBy(xpath = "//form[contains(@action, '/register/')]//input[@name='act_register_now']")
    private WebElement registerButton;

    @FindBy(xpath = "//form[contains(@action, '/register/')]/p")
    private WebElement errorMessageLabel;

    public UserBugRedLoginRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public UserBugRedLoginRegistrationPage open() {
        open(URL);
        return this;
    }

    public UserBugRedLoginRegistrationPage sendKeysToNameTextField(final String name) {
        wait.until(ExpectedConditions.visibilityOf(nameTextField)).sendKeys(name);
        return this;
    }

    public UserBugRedLoginRegistrationPage sendKeysToEmailTextField(final String email) {
        wait.until(ExpectedConditions.visibilityOf(emailTextField)).sendKeys(email);
        return this;
    }

    public UserBugRedLoginRegistrationPage sendKeysToPasswordTextField(final String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordTextField)).sendKeys(password);
        return this;
    }

    public UserBugRedIndexPage clickRegisterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
        return new UserBugRedIndexPage(driver);
    }

    public UserBugRedIndexPage clickRegisterButtonSuccess() {
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
        return new UserBugRedIndexPage(driver);
    }

    public UserBugRedLoginRegistrationPage clickRegisterButtonFail() {
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
        return this;
    }

    public String getTextFromErrorMessageLabel() {
        return wait.until(ExpectedConditions.visibilityOf(errorMessageLabel)).getText();
    }
}
