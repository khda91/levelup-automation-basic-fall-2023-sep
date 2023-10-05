package ru.levelp.at.lesson0507.selenium.basic.locators;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.levelp.at.utils.SleepUtils;

public class CssLocatorsTest {

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
        // var element = driver.findElement(By.id("main-menu")); DOM
        // var element = driver.findElement(By.cssSelector("[id='main-menu']"));
        var element = driver.findElement(By.cssSelector("#main-menu"));
        System.out.println(element.getText());
    }

    @Test
    void testFindByClassName() {
        // var element = driver.findElement(By.className("newlink")); DOM
        // var element = driver.findElement(By.cssSelector("[class='newlink']"));
        var element = driver.findElement(By.cssSelector(".newlink"));
        System.out.println(element.getText());
    }

    @Test
    void testFindByName() {
        driver.navigate().to("http://users.bugred.ru/user/login/index.html");
        // var element = driver.findElement(By.name("name")); DOM
        var element = driver.findElement(By.cssSelector("[name='name']"));
        element.sendKeys("1231231");
        SleepUtils.sleep(1000);
    }

    @Test
    void testFindByOtherAttribute() {
        var element = driver.findElement(By.cssSelector("[href='/user/login/index.html']"));
        element.sendKeys("1231231");
        SleepUtils.sleep(1000);
    }

    @Test
    void testFindByTagName() {
        // var elements = driver.findElements(By.tagName("div")); DOM
        var elements = driver.findElements(By.cssSelector("div"));
        System.out.println(elements.size());
    }

    @Test
    void testFindByTagNameAndAttribute() {
        var element = driver.findElement(By.cssSelector("input[value='Зарегистрироваться']"));
        System.out.println(element.getText());
    }

    @Test
    void testFindByComplexLocator() {
        driver.navigate().to("http://users.bugred.ru/user/login/index.html");
        final var locator = "form[action='/user/register/index.html'] input[name='password']";
        var element = driver.findElement(By.cssSelector(locator));
        element.sendKeys("1231231");
        SleepUtils.sleep(1000);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
