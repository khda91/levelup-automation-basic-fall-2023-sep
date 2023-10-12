package ru.levelp.at.lesson0507.selenium.page.objects.composite.widget;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WildberriesProductCardWidget extends WildberiesAbstractWidget {

    private static final By ADD_TO_BASKET_BUTTON = By
        .xpath(".//*[contains(@class, 'product-card__add-basket')]");

    private final WebElement root;

    public WildberriesProductCardWidget(WebDriver driver, WebElement root) {
        super(driver);
        this.root = root;
    }

    public void hover() {
        new Actions(driver)
            .moveToElement(wait.until(ExpectedConditions.visibilityOf(root)))
            .build()
            .perform();
    }

    public void addToBasket() {
        WebElement button = wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(root, ADD_TO_BASKET_BUTTON));
        wait.until(ExpectedConditions.elementToBeClickable(button)).click();
    }
}
