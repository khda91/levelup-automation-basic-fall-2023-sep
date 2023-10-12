package ru.levelp.at.lesson0507.selenium.page.objects.composite;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.levelp.at.utils.SleepUtils;

class WildberriesCompositeTest {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }


    @Test
    void testCompareProducts() {
        var mainPage = new WildberiesMainPage(driver);
        mainPage.open();

        mainPage.menu().clickMenuButton();
        mainPage.menu().hoverMenu("Электроника");
        mainPage.menu().clickCategory("Ноутбуки и компьютеры");

        SleepUtils.sleep(5000);

        var productPage = new WildberriesProductsPage(driver);
        var productCardNumberTwo = productPage.getProductCard(2);
        productCardNumberTwo.hover();
        productCardNumberTwo.addToBasket();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
