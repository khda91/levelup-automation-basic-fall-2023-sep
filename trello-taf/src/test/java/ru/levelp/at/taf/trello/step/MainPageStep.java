package ru.levelp.at.taf.trello.step;

import io.qameta.allure.Step;
import ru.levelp.at.taf.trello.service.page.MainPage;

public class MainPageStep {

    @Step("Открываем веб-сайт")
    public static void openWebSite() {
        new MainPage().open();
    }
}
