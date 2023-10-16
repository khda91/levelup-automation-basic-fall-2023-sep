package ru.levelp.at.lesson0507.selenium.page.objects.composite.widget;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WildberiesMenuWidget extends WildberiesAbstractWidget {

    private static final By MENU_ITEM_LOCATOR = By
        .xpath("//a[contains(@class, 'menu-burger__main-list-link')]");

    private static final By CATEGORY_ITEM_LOCATOR = By
        .xpath("//span[contains(@class, 'menu-burger__next')]");

    @FindBy(xpath = "//button[@data-wba-header-name='Catalog']")
    private WebElement menuButton;

    public WildberiesMenuWidget(WebDriver driver) {
        super(driver);
    }

    public void clickMenuButton() {
        // wait.until(ExpectedConditions.elementToBeClickable(menuButton)).click();
        new Actions(driver)
            .moveToElement(menuButton, -23, 23)
            .click(menuButton)
            .build()
            .perform();
        // wait.until(ExpectedConditions.elementToBeClickable(menuButton)).click();
        System.out.println("клац");
    }

    public void hoverMenu(final String menuItemTitle) {
        List<WebElement> menuItems = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(MENU_ITEM_LOCATOR, 3));
        for (WebElement menuItem : menuItems) {
            if (menuItemTitle.equals(menuItem.getText())) {
                new Actions(driver)
                    .moveToElement(menuItem)
                    .build()
                    .perform();
                break;
            }
        }
    }

    public void clickCategory(final String categoryItemTitle) {
        List<WebElement> categoryItems =
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(CATEGORY_ITEM_LOCATOR, 3));
        for (WebElement categoryItem : categoryItems) {
            if (categoryItemTitle.equals(categoryItem.getText())) {
                categoryItem.click();
                break;
            }
        }
    }
}
