package ru.levelp.at.lesson0507.selenium.page.objects.composite;

import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson0507.selenium.page.objects.composite.widget.WildberiesMenuWidget;

public class WildberiesMainPage extends WildberiesAbstractPage {

    private WildberiesMenuWidget menu;

    public WildberiesMainPage(WebDriver driver) {
        super(driver);
        this.menu = new WildberiesMenuWidget(driver);
    }

    @Override
    public void open() {
        open("");
    }

    public WildberiesMenuWidget menu() {
        return menu;
    }
}
