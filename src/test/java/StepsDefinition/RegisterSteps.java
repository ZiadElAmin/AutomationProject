package StepsDefinition;

import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegisterSteps {

    WebDriver driver = Hooks.driver;

    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    RegisterPage registerPage = new RegisterPage(driver);

    @Given("I navigate to the homepage")
    public void i_navigate_to_the_homepage() {

    }

    @When("I click on Signup Login")
    public void i_click_on_signup_login() {
        homePage.clickSignupLogin();
    }

    @When("I enter new name {string} and email {string}")
    public void i_enter_new_name_and_email(String name, String email) {
        loginPage.enterSignupName(name);
        loginPage.enterSignupEmail(email);
    }

    @When("I click the Signup button")
    public void i_click_the_signup_button() {
        loginPage.clickSignupButton();
    }

    @When("I fill all registration details with password {string}")
    public void i_fill_all_registration_details(String password) {
        registerPage.selectTitleMr();
        registerPage.enterPassword(password);
        registerPage.selectDayOfBirth("10");
        registerPage.selectMonthOfBirth("5");
        registerPage.selectYearOfBirth("1995");
        registerPage.enterFirstName("Test");
        registerPage.enterLastName("User");
        registerPage.enterAddress("123 Test Street");
        registerPage.selectCountry("United States");
        registerPage.enterState("California");
        registerPage.enterCity("Los Angeles");
        registerPage.enterZipcode("90001");
        registerPage.enterMobileNumber("0123456789");
    }

    @When("I click Create Account")
    public void i_click_create_account() {
        registerPage.clickCreateAccount();
    }

    @Then("I should see account created message")
    public void i_should_see_account_created_message() {
        String message = registerPage.getAccountCreatedMessage();
        Assert.assertTrue(message.contains("ACCOUNT CREATED!"), "Account created message not found!");
    }
}
