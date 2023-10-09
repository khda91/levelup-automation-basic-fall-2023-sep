package ru.levelp.at.lesson0507.selenium.page.objects.types.fluent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserBugRedIndexPage extends UserBugRedBasePage<UserBugRedIndexPage> {

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
    public UserBugRedIndexPage open() {
        open("");
        return this;
    }

    public UserBugRedLoginRegistrationPage clickEnterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(enterButton)).click();
        return new UserBugRedLoginRegistrationPage(driver);
    }

    public String getTextFromUserDropdownMenu() {
        return wait.until(ExpectedConditions.visibilityOf(userDropdownMenu)).getText();
    }

    public UserBugRedIndexPage clickUserDropdownMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(userDropdownMenu)).click();
        return this;
    }

    public boolean isUserDropdownMenuDisplayed() {
        return !wait.until(ExpectedConditions.invisibilityOf(userDropdownMenu));
    }

    public UserBugRedIndexPage clickExitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(exitButton)).click();
        return this;
    }
}
