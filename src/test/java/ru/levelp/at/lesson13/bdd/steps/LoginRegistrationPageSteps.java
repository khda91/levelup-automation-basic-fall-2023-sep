package ru.levelp.at.lesson13.bdd.steps;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson13.bdd.context.TestContext;
import ru.levelp.at.lesson13.bdd.model.UserModel;
import ru.levelp.at.lesson13.bdd.pages.UserBugRedLoginRegistrationPage;

public class LoginRegistrationPageSteps {

    private final WebDriver driver;

    public LoginRegistrationPageSteps() {
        this.driver = (WebDriver) TestContext.getInstance().get("driver");
    }

    @When("I set {string} to the Имя text field in Registration section on the Login Registration page")
    public void setToTheNameTextFieldInTheRegistrationSectionOnTheLoginRegistrationPage(String name) {
        new UserBugRedLoginRegistrationPage(driver).sendKeysToNameTextField(name);
    }

    @When("I set {string} to the Email text field in Registration section on the Login Registration page")
    public void setToTheEmailTextFieldInTheRegistrationSectionOnTheLoginRegistrationPage(String email) {
        new UserBugRedLoginRegistrationPage(driver).sendKeysToEmailTextField(email);
    }

    @When("I set {string} to the Пароль text field in Registration section on the Login Registration page")
    public void setToThePasswordTextFieldInTheRegistrationSectionOnTheLoginRegistrationPage(String password) {
        new UserBugRedLoginRegistrationPage(driver).sendKeysToPasswordTextField(password);
    }

    @When("I click to Зарегистрироваться button in Registration section on the Login Registration page")
    public void clickRegistartionButtonInTheRegistrationSectionOnTheLoginRegistrationPage() {
        new UserBugRedLoginRegistrationPage(driver).clickRegisterButton();
    }

    @When("I register user with following parameters")
    public void registerUserWithFollowingParameters(UserModel user) {
        new UserBugRedLoginRegistrationPage(driver).sendKeysToNameTextField(user.getUsername());
        new UserBugRedLoginRegistrationPage(driver).sendKeysToEmailTextField(user.getEmail());
        new UserBugRedLoginRegistrationPage(driver).sendKeysToPasswordTextField(user.getPassword());
        new UserBugRedLoginRegistrationPage(driver).clickRegisterButton();
    }
}
