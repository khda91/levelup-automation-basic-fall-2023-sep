package ru.levelp.at.taf.trello.hooks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.levelp.at.taf.trello.service.webdriver.WebDriverSingleton;

public abstract class BaseHooks {

    @BeforeEach
    protected void setUp() {
        WebDriverSingleton.getDriver();
    }

    @AfterEach
    protected void tearDown() {
        WebDriverSingleton.quitDriver();
    }
}
