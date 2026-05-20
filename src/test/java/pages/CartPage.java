package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import java.util.List;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCartNotEmpty() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr")));
        List<WebElement> cartRows = driver.findElements(By.xpath("//tbody/tr"));
        return cartRows.size() > 0;
    }

    public void clickProceedToCheckout() {
        driver.findElement(By.linkText("Proceed To Checkout")).click();
    }
}