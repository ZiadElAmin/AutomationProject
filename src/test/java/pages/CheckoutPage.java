package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isDeliveryAddressVisible() {
        try { Thread.sleep(2000); }
        catch (InterruptedException e) {}
        return driver.findElement(By.id("address_delivery")).isDisplayed();
    }

    public void enterOrderComment(String comment) {
        driver.findElement(By.name("message")).sendKeys(comment);
    }

    public void clickPlaceOrder() {
        driver.findElement(By.linkText("Place Order")).click();
    }

    public void enterNameOnCard(String name) {
        driver.findElement(By.name("name_on_card")).sendKeys(name);
    }

    public void enterCardNumber(String number) {
        driver.findElement(By.name("card_number")).sendKeys(number);
    }

    public void enterCvc(String cvc) {
        driver.findElement(By.name("cvc")).sendKeys(cvc);
    }

    public void enterExpiryMonth(String month) {
        driver.findElement(By.name("expiry_month")).sendKeys(month);
    }

    public void enterExpiryYear(String year) {
        driver.findElement(By.name("expiry_year")).sendKeys(year);
    }

    public void clickPayAndConfirmOrder() {
        driver.findElement(By.id("submit")).click();
    }

    public String getOrderPlacedMessage() {
        String message = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[@data-qa='order-placed']"))).getText();
        System.out.println("Order message: " + message);
        return message;
    }
}