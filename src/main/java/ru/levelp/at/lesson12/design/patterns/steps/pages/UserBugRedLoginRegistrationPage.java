package ru.levelp.at.lesson12.design.patterns.steps.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserBugRedLoginRegistrationPage extends UserBugRedBasePage {

    private static final String URL = "/user/login/index.html";

    @FindBy(xpath = "//form[contains(@action, '/register/')]//input[@name='name']")
    private WebElement nameTextField;

    @FindBy(xpath = "//form[contains(@action, '/register/')]//input[@name='email']")
    private WebElement emailTextField;

    @FindBy(xpath = "//form[contains(@action, '/register/')]//input[@name='password']")
    private WebElement passwordTextField;

    @FindBy(xpath = "//form[contains(@action, '/register/')]//input[@name='act_register_now']")
    private WebElement registerButton;

    public UserBugRedLoginRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        open(URL);
    }

    @Step("Вводем имя пользователя")
    public void sendKeysToNameTextField(final String name) {
        wait.until(ExpectedConditions.visibilityOf(nameTextField)).sendKeys(name);
    }

    @Step("Вводим почтовый адрес")
    public void sendKeysToEmailTextField(final String email) {
        wait.until(ExpectedConditions.visibilityOf(emailTextField)).sendKeys(email);
    }

    @Step("Вводим почтовый пароль")
    public void sendKeysToPasswordTextField(final String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordTextField)).sendKeys(password);
    }

    @Step("Нажимаем на кнопку 'Зарегистрироваться'")
    public void clickRegisterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
    }
}
