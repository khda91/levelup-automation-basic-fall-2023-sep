package ru.levelp.at.lesson0507.selenium.basic.locators;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.levelp.at.utils.SleepUtils;

public class DomLocatorsTest {

    private static final String URL = "http://users.bugred.ru/";

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to(URL);
        SleepUtils.sleep(2500);
    }

    @Test
    void testFindById() {
        var element = driver.findElement(By.id("main-menu"));
        System.out.println(element.getText());
    }

    @Test
    void testFindByClassName() {
        var element = driver.findElement(By.className("newlink"));
        System.out.println(element.getText());
    }

    @Test
    void testFindByName() {
        driver.navigate().to("http://users.bugred.ru/user/login/index.html");
        var element = driver.findElement(By.name("name"));
        element.sendKeys("1231231");
        SleepUtils.sleep(1000);
    }

    @Test
    void testFindByLinkText() {
        var element = driver.findElement(By.linkText("Войти"));
        System.out.println(element.getText());
    }

    @Test
    void testFindByPartialLinkText() {
        var element = driver.findElement(By.partialLinkText("ватели"));
        System.out.println(element.getText());
    }

    @Test
    void testFindByTagName() {
        var elements = driver.findElements(By.tagName("div"));
        System.out.println(elements.size());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
