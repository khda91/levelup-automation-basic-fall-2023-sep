package ru.levelp.at.lesson1011.cicd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserBugRedTasksPage extends UserBugRedBasePage {

    @FindBy(xpath = "//a[text()='Добавить задачу']")
    private WebElement createTaskButton;

    public UserBugRedTasksPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        throw new RuntimeException("Не имплементирвоан");
    }

    public void clickCreateTaskButton() {
        wait.until(ExpectedConditions.elementToBeClickable(createTaskButton)).click();
    }
}
