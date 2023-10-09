package ru.levelp.at.lesson0507.selenium.basic.swithto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.levelp.at.utils.SleepUtils;

class MailRuFrameSampleTest {

    private static final String MAIL_RU_URL = "https://mail.ru";

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        SleepUtils.sleep(2500);
        driver.navigate().to(MAIL_RU_URL);
    }

    @Test
    void testOpenMailRu() {
        SleepUtils.sleep(1500);

        var loginButton = driver.findElement(By.xpath("//*[@data-testid='enter-mail-primary']"));
        loginButton.click();

        SleepUtils.sleep(7500);
        // находится внутри frame. Selenium из-за этого не может его найти
        var usernameTextField = driver.findElement(By.xpath("//input[@name='username']"));
        usernameTextField.sendKeys("abcde");

        SleepUtils.sleep(3000);
    }

    @Test
    void testOpenMailRuFrame() {
        SleepUtils.sleep(1500);

        var loginButton = driver.findElement(By.xpath("//*[@data-testid='enter-mail-primary']"));
        loginButton.click();

        SleepUtils.sleep(7500);
        var frameElement = driver.findElement(By.xpath("//iframe[@class='ag-popup__frame__layout__iframe']"));
        driver = driver.switchTo().frame(frameElement);
        var usernameTextField = driver.findElement(By.xpath("//input[@name='username']"));
        usernameTextField.sendKeys("abcde");

        SleepUtils.sleep(3000);
        // вернуться в основное окно
        driver = driver.switchTo().defaultContent();
        // тут ещё продолжение теста на основной странице
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
