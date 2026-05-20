package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductPage {

    WebDriver driver;
    WebDriverWait wait;
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isAllProductsTitleVisible() {
        return driver.findElement(By.xpath("//h2[contains(text(),'All Products')]")).isDisplayed();
    }

    public boolean areProductsListed() {
        List<WebElement> products = driver.findElements(By.className("product-image-wrapper"));
        return products.size() > 0;
    }

    public void hoverOverFirstProductAndAddToCart() {
        WebElement firstProduct = driver.findElements(By.className("product-image-wrapper")).get(0);
        Actions actions = new Actions(driver);
        actions.moveToElement(firstProduct).perform();

        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        driver.findElements(By.xpath("//div[@class='product-overlay']//a[contains(text(),'Add to cart')]")).get(0).click();
    }

    public void clickContinueShopping() {
        WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//button[contains(text(),'Continue Shopping')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    }

    public void clickViewCartFromModal() {
        driver.findElement(By.xpath("//u[contains(text(),'View Cart')]")).click();
    }

    public void clickFirstProductViewProduct() {
        driver.findElements(By.xpath("//a[contains(text(),'View Product')]")).get(0).click();
    }

    public String getProductName() {
        return driver.findElement(By.xpath("//div[@class='product-information']//h2")).getText();
    }

    public boolean isProductDetailPageVisible() {
        return driver.findElement(By.xpath("//div[@class='product-information']")).isDisplayed();
    }

    public void searchForProduct(String productName) {
        driver.findElement(By.id("search_product")).sendKeys(productName);
        driver.findElement(By.id("submit_search")).click();
    }
}