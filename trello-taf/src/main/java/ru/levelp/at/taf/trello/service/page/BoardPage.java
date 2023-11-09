package ru.levelp.at.taf.trello.service.page;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BoardPage extends BasePage {

    private static final By LIST_NAMES_XPATH = By.xpath("//h2[@data-testid='list-name']");

    @FindBy(xpath = "//button[@data-testid='list-composer-button']")
    private WebElement addAnotherListButton;

    @FindBy(xpath = "//form/textarea[@data-testid='list-name-textarea']")
    private WebElement listNameTextArea;

    @FindBy(xpath = "//button[@data-testid='list-composer-add-list-button']")
    private WebElement addListButton;

    @Override
    public void open() {
        throw new UnsupportedOperationException();
    }

    public void clickAddAnotherListButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addAnotherListButton)).click();
    }

    public void sendTextToListNameTextArea(final String listName) {
        wait.until(ExpectedConditions.visibilityOf(listNameTextArea)).sendKeys(listName);
    }

    public void clickAddListButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addListButton)).click();
    }

    public List<String> getListNames() {
        return wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(LIST_NAMES_XPATH, 1))
            .stream()
            .map(listItem -> wait.until(ExpectedConditions.visibilityOf(listItem)).getText())
            .collect(Collectors.toList());
    }
}
