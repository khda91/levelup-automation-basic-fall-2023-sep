package ru.levelp.at.lesson13.bdd.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.levelp.at.lesson13.bdd.context.TestContext;

public class WebDriverHook {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        TestContext.getInstance().add("driver", driver);
    }

    @After
    public void tearDown() {
        driver.quit();
        TestContext.clean();
    }
}
