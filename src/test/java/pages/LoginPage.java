package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }



    public void enterSignupName(String name) {
        driver.findElement(By.name("name")).sendKeys(name);
    }

    public void enterSignupEmail(String email) {
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(email);
    }

    public void clickSignupButton() {
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.urlContains("signup"));
    }

    public void clickLoginButtonAndWait() {
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.urlToBe("https://automationexercise.com/"));
    }

    public void enterLoginEmail(String email) {
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys(email);
    }

    public void enterLoginPassword(String password) {
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
    }

    public String getLoginErrorMessage() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//p[contains(@style,'color: red')]")));
        return driver.findElement(By.xpath("//p[contains(@style,'color: red')]")).getText();
    }
}