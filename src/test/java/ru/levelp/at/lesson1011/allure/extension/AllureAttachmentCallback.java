package ru.levelp.at.lesson1011.allure.extension;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson1011.allure.context.TestContext;

public class AllureAttachmentCallback implements AfterTestExecutionCallback {

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) {
        System.out.println("AllureAttachmentCallback");
        extensionContext.getExecutionException().ifPresent(throwable -> {
            var driver = (WebDriver) TestContext.getInstance().get("driver");
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
