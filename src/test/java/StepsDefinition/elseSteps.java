package StepsDefinition;

import pages.*;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class elseSteps {





    @When("I click on Test Cases")
    public void i_click_on_test_cases() {
        new HomePage(Hooks.driver).clickTestCases();
    }

    @Then("the Test Cases page should load")
    public void the_test_cases_page_should_load() {
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("test_cases"), "Not on Test Cases page!");
    }

    @When("I navigate to Products page")
    public void i_navigate_to_products_page() {
        new HomePage(Hooks.driver).clickProducts(); // ✅ line 33 fix
    }

    @Then("I should see all products listed")
    public void i_should_see_all_products_listed() {
        Assert.assertTrue(new ProductPage(Hooks.driver).isAllProductsTitleVisible(), "All Products title not visible!");
        Assert.assertTrue(new ProductPage(Hooks.driver).areProductsListed(), "No products found on the page!");
    }

    @When("I click View Product on the first product")
    public void i_click_view_product() {
        new ProductPage(Hooks.driver).clickFirstProductViewProduct();
    }

    @Then("I should see the product detail page")
    public void i_should_see_product_detail_page() {
        Assert.assertTrue(new ProductPage(Hooks.driver).isProductDetailPageVisible(), "Product detail page not visible!");
    }

    @Given("I am logged in with email {string} and password {string} for logout")
    public void i_am_logged_in_for_logout(String email, String password) {
        new HomePage(Hooks.driver).clickSignupLogin();
        new LoginPage(Hooks.driver).enterLoginEmail(email);
        new LoginPage(Hooks.driver).enterLoginPassword(password);
        new LoginPage(Hooks.driver).clickLoginButton();
    }

    @When("I click Logout")
    public void i_click_logout() {
        new HomePage(Hooks.driver).clickLogout();
    }

    @Then("I should be redirected to the Login page")
    public void i_should_be_redirected_to_login_page() {
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("login"), "Not redirected to login page!");
    }
}
