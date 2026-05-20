package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
public class HomePage {

    WebDriver driver;
    WebDriverWait wait;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickSignupLogin() {
        driver.findElement(By.linkText("Signup / Login")).click();
    }

    public void clickProducts() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[href='/products']"))).click();
    }

    public void clickCart() {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Cart"))).click();
    }

    public void clickContactUs() {
        driver.findElement(By.linkText("Contact us")).click();
    }

    public void clickTestCases() {
        driver.findElement(By.linkText("Test Cases")).click();
    }

    public void clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[href='/logout']"))).click();
    }

    public String getLoggedInText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a/b"))).getText();
    }


    public boolean isLoggedIn() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("a[href='/logout'] b"))).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}