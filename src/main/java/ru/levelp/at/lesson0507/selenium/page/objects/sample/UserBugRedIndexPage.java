package ru.levelp.at.lesson0507.selenium.page.objects.sample;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserBugRedIndexPage {

    private static final String URL = "http://users.bugred.ru/";

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//span[text()='Войти']")
    private WebElement enterButton;

    @FindBy(xpath = "//*[@class='dropdown-toggle']")
    private WebElement userDropdownMenu;

    @FindBy(xpath = "//a[text()='Выход']")
    private WebElement exitButton;

    public UserBugRedIndexPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to(URL);
    }

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
