package StepsDefinition;

import pages.*;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSteps {

    WebDriver driver = Hooks.driver;

    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);

    @When("I enter valid email {string} and password {string} and click Login")
    public void i_enter_valid_credentials_and_login(String email, String password) {
        loginPage.enterLoginEmail(email);
        loginPage.enterLoginPassword(password);
        loginPage.clickLoginButton();
    }

    @Then("I should be logged in as {string}")
    public void i_should_be_logged_in_as(String username) {
        String loggedInText = homePage.getLoggedInText();
        Assert.assertTrue(loggedInText.contains(username), "Expected to be logged in as: " + username);
    }

    @When("I enter wrong email {string} and wrong password {string} and click Login")
    public void i_enter_wrong_credentials_and_login(String email, String password) {
        loginPage.enterLoginEmail(email);
        loginPage.enterLoginPassword(password);
        loginPage.clickLoginButton();
    }

    @Then("I should see login error message")
    public void i_should_see_login_error_message() {
        String errorMsg = loginPage.getLoginErrorMessage();
        Assert.assertTrue(errorMsg.contains("Your email or password is incorrect!"), "Error message not shown!");
    }
}