package StepsDefinition;

import pages.*;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartCheckoutSteps {



    @When("I go to the Products page")
    public void i_go_to_the_products_page() {
        new HomePage(Hooks.driver).clickProducts(); // ✅ grabs driver at the moment it's needed
    }

    @Given("I am logged in with email {string} and password {string}")
    public void i_am_logged_in(String email, String password) {
        new HomePage(Hooks.driver).clickSignupLogin();
        new LoginPage(Hooks.driver).enterLoginEmail(email);
        new LoginPage(Hooks.driver).enterLoginPassword(password);
        new LoginPage(Hooks.driver).clickLoginButton();
    }

    @When("I hover over a product and add it to cart")
    public void i_hover_and_add_to_cart() {
        new ProductPage(Hooks.driver).hoverOverFirstProductAndAddToCart();
    }

    @When("I click Continue Shopping")
    public void i_click_continue_shopping() {
        new ProductPage(Hooks.driver).clickContinueShopping();
    }

    @When("I open the Cart")
    public void i_open_the_cart() {
        new HomePage(Hooks.driver).clickCart();
    }

    @Then("the cart should have at least one product")
    public void the_cart_should_have_products() {
        Assert.assertTrue(new CartPage(Hooks.driver).isCartNotEmpty(), "Cart is empty!");
    }

    @When("I click Proceed To Checkout")
    public void i_click_proceed_to_checkout() {
        new CartPage(Hooks.driver).clickProceedToCheckout();
    }

    @Then("I should see the delivery address")
    public void i_should_see_delivery_address() {
        Assert.assertTrue(new CheckoutPage(Hooks.driver).isDeliveryAddressVisible(), "Delivery address not visible!");
    }

    @When("I enter comment {string} and click Place Order")
    public void i_enter_comment_and_place_order(String comment) {
        new CheckoutPage(Hooks.driver).enterOrderComment(comment);
        new CheckoutPage(Hooks.driver).clickPlaceOrder();
    }

    @When("I fill payment details name {string} card {string} cvc {string} month {string} year {string}")
    public void i_fill_payment_details(String name, String card, String cvc, String month, String year) {
        new CheckoutPage(Hooks.driver).enterNameOnCard(name);
        new CheckoutPage(Hooks.driver).enterCardNumber(card);
        new CheckoutPage(Hooks.driver).enterCvc(cvc);
        new CheckoutPage(Hooks.driver).enterExpiryMonth(month);
        new CheckoutPage(Hooks.driver).enterExpiryYear(year);
    }

    @When("I click Pay and Confirm Order")
    public void i_click_pay_and_confirm() {
        new CheckoutPage(Hooks.driver).clickPayAndConfirmOrder();
    }

    @Then("I should see Order Placed confirmation")
    public void i_should_see_order_placed() {
        String message = new CheckoutPage(Hooks.driver).getOrderPlacedMessage();
        Assert.assertTrue(message.contains("ORDER PLACED!"), "Order placed message not found!");
    }
}
