package ru.levelp.at.lesson0507.selenium.page.objects.composite.widget;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class WildberiesAbstractWidget {

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    protected WildberiesAbstractWidget(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        PageFactory.initElements(driver, this);
    }
}
