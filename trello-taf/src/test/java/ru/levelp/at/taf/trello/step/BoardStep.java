package ru.levelp.at.taf.trello.step;

import io.qameta.allure.Step;
import java.util.List;
import ru.levelp.at.taf.trello.service.page.BoardPage;
import ru.levelp.at.taf.trello.service.page.BoardsPage;

public class BoardStep {

    @Step("Открываем доску")
    public static void openBoard(final String boardName) {
        new BoardsPage().openTaskBoard(boardName);
    }

    @Step("Создаём новый список на доске")
    public static void createNewList(final String listName) {
        var boardPage = new BoardPage();
        boardPage.clickAddAnotherListButton();
        boardPage.sendTextToListNameTextArea(listName);
        boardPage.clickAddListButton();
    }

    public static List<String> getListNames() {
        return new BoardPage().getListNames();
    }
}
