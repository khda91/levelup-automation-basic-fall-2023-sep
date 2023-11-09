package ru.levelp.at.taf.trello.extension;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.levelp.at.taf.trello.service.webdriver.WebDriverSingleton;

public class AllureAttachmentCallback implements AfterTestExecutionCallback {

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) {
        extensionContext.getExecutionException().ifPresent(throwable -> {
            var driver = WebDriverSingleton.getDriver();
            attachScreenshot(driver);
            attachPageSource(driver);
        });
    }

    @Attachment(value = "image", type = "image/png", fileExtension = "png")
    private byte[] attachScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    private void attachPageSource(WebDriver driver) {
        Allure.addAttachment("page_source", "text/html", driver.getPageSource(), ".html");
    }
}
