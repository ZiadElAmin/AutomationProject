package StepsDefinition;

import pages.ContactUsPage;
import pages.HomePage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ContactUsSteps {

    WebDriver driver = Hooks.driver;

    HomePage homePage = new HomePage(driver);
    ContactUsPage contactUsPage = new ContactUsPage(driver);

    @When("I click on Contact Us")
    public void i_click_on_contact_us() {
        homePage.clickContactUs();
    }

    @When("I fill the contact form with name {string} email {string} subject {string} message {string}")
    public void i_fill_contact_form(String name, String email, String subject, String message) {
        contactUsPage.enterName(name);
        contactUsPage.enterEmail(email);
        contactUsPage.enterSubject(subject);
        contactUsPage.enterMessage(message);
    }

    @When("I submit the contact form")
    public void i_submit_the_contact_form() {
        contactUsPage.clickSubmit();
        contactUsPage.acceptAlert();
    }

    @Then("I should see contact success message")
    public void i_should_see_contact_success_message() {
        String message = contactUsPage.getSuccessMessage();
        Assert.assertTrue(message.contains("Success! Your details have been submitted successfully."),
                "Success message not found!");
    }
}
