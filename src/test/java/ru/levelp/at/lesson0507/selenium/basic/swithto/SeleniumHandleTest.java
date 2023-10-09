package ru.levelp.at.lesson0507.selenium.basic.swithto;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.levelp.at.utils.SleepUtils;

class SeleniumHandleTest {

    private static final String GOOGLE_URL = "https://google.com";
    private static final String DZEN_URL = "https://dzen.ru";
    private static final String MAIL_RU_URL = "https://mail.ru";

    @Test
    void testSeleniumHandles() {
        System.out.printf("Открываем браузер%n");
        WebDriver driver = new ChromeDriver();
        var handles = driver.getWindowHandles();
        System.out.printf("current handles: %s%n", handles);

        System.out.printf("Открываем %s%n", GOOGLE_URL);
        driver.navigate().to(GOOGLE_URL);
        SleepUtils.sleep(3000);
        handles = driver.getWindowHandles();
        System.out.printf("current handles: %s%n", handles);

        System.out.printf("Открываем в новой вкладке %s%n", MAIL_RU_URL);
        driver = driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(MAIL_RU_URL);
        SleepUtils.sleep(3000);
        handles = driver.getWindowHandles();
        System.out.printf("current handles: %s%n", handles);

        System.out.printf("Открываем в новом окне %s%n", DZEN_URL);
        driver = driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to(DZEN_URL);
        SleepUtils.sleep(3000);
        handles = driver.getWindowHandles();
        System.out.printf("current handles: %s%n", handles);

        System.out.printf("Закрываем вкладку %s%n", GOOGLE_URL);
        var currentHandle = driver.getWindowHandle();
        for (String handle : handles) {
            driver = driver.switchTo().window(handle);
            if ("Google".equals(driver.getTitle())) {
                break;
            }
        }
        driver.close();
        driver = driver.switchTo().window(currentHandle);
        SleepUtils.sleep(5000);
        handles = driver.getWindowHandles();
        System.out.printf("current handles: %s%n", handles);

        driver.quit();
    }
}
