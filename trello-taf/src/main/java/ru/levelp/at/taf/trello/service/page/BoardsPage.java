package ru.levelp.at.taf.trello.service.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BoardsPage extends BasePage {

    private static final By BOARDS_TITLES_XPATH = By
        .xpath("//li[@class='boards-page-board-section-list-item']/a");

    @FindBy(xpath = "//button[@data-testid='header-member-menu-button']")
    private WebElement accountButton;

    @Override
    public void open() {
        throw new UnsupportedOperationException();
    }

    public boolean isAccountButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(accountButton)).isDisplayed();
    }

    public void openTaskBoard(final String boardName) {
        var boardTitles = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(BOARDS_TITLES_XPATH, 1));
        for (WebElement boardTitle : boardTitles) {
            if (boardName.contains(wait.until(ExpectedConditions.visibilityOf(boardTitle)).getText())) {
                wait.until(ExpectedConditions.elementToBeClickable(boardTitle)).click();
                break;
            }
        }
    }
}
