package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCartNotEmpty() {
        List<WebElement> cartRows = driver.findElements(By.xpath("//tbody/tr"));
        return cartRows.size() > 0;
    }

    public void clickProceedToCheckout() {
        driver.findElement(By.linkText("Proceed To Checkout")).click();
    }
}