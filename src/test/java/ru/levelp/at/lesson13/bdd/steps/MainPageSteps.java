package ru.levelp.at.lesson13.bdd.steps;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson13.bdd.context.TestContext;
import ru.levelp.at.lesson13.bdd.pages.UserBugRedIndexPage;

public class MainPageSteps {

    private final WebDriver driver;

    public MainPageSteps() {
        this.driver = (WebDriver) TestContext.getInstance().get("driver");
    }

    @Given("I open UsersBugRed site")
    public void openUsersbugredSite() {
        new UserBugRedIndexPage(driver).open();
    }

    @Given("I click to Войти button in the Header on the Main page")
    public void clickToEnterButtonInTheHeaderOnTheMainPage() {
        new UserBugRedIndexPage(driver).clickEnterButton();
    }

    @Then("username in the header should be equal to the {string} on the Main page")
    public void usernameInTheHeaderShouldBeEqualOnTheMainPage(String expectedName) {
        var actualUserName = new UserBugRedIndexPage(driver).getTextFromUserDropdownMenu();

        assertThat(actualUserName)
            .as("Проверка корректности имени пользователя")
            .containsIgnoringCase(expectedName);
    }
}
