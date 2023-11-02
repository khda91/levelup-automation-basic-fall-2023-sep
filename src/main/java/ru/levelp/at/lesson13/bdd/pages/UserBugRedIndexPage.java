package ru.levelp.at.lesson13.bdd.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserBugRedIndexPage extends UserBugRedBasePage {

    @FindBy(xpath = "//span[text()='Войти']")
    private WebElement enterButton;

    @FindBy(xpath = "//*[@class='dropdown-toggle']")
    private WebElement userDropdownMenu;

    @FindBy(xpath = "//a[text()='Выход']")
    private WebElement exitButton;

    public UserBugRedIndexPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        open("");
    }

    @Step("Нажимаем на кнопку 'Войти'")
    public void clickEnterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(enterButton)).click();
    }

    public String getTextFromUserDropdownMenu() {
        return wait.until(ExpectedConditions.visibilityOf(userDropdownMenu)).getText();
    }

    public void clickUserDropdownMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(userDropdownMenu)).click();
    }

    public boolean isUserDropdownMenuDisplayed() {
        return !wait.until(ExpectedConditions.invisibilityOf(userDropdownMenu));
    }

    public void clickExitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(exitButton)).click();
    }
}
