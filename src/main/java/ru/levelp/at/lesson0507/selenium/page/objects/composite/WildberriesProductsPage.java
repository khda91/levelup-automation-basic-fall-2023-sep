package ru.levelp.at.lesson0507.selenium.page.objects.composite;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.levelp.at.lesson0507.selenium.page.objects.composite.widget.WildberriesProductCardWidget;

public class WildberriesProductsPage extends WildberiesAbstractPage {

    private static final By PRODUCT_CARD_LOCATOR = By
        .xpath("//article[contains(@class, 'product-card')]");

    public WildberriesProductsPage(WebDriver driver) {
        super(driver);
    }

    public WildberriesProductCardWidget getProductCard(int index) {
        List<WebElement> productCards =
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(PRODUCT_CARD_LOCATOR, 3));
        return new WildberriesProductCardWidget(driver, productCards.get(index - 1));
    }

    @Override
    public void open() {

    }
}
