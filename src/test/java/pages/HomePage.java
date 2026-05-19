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
        driver.findElement(By.linkText("Cart")).click();
    }

    public void clickContactUs() {
        driver.findElement(By.linkText("Contact us")).click();
    }

    public void clickTestCases() {
        driver.findElement(By.linkText("Test Cases")).click();
    }

    public void clickLogout() {
        driver.findElement(By.linkText("Logout")).click();
    }

    public String getLoggedInText() {
        return driver.findElement(By.xpath("//li/a/b")).getText();
    }


    public boolean isLoggedIn() {
        try {

            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li/a/b"))).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}