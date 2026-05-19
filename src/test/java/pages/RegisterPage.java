package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectTitleMr() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender1")));
        driver.findElement(By.id("id_gender1")).click();
    }

    public void enterPassword(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    public void selectDayOfBirth(String day) {
        Select select = new Select(driver.findElement(By.id("days")));
        select.selectByValue(day);
    }

    public void selectMonthOfBirth(String month) {
        Select select = new Select(driver.findElement(By.id("months")));
        select.selectByValue(month);
    }

    public void selectYearOfBirth(String year) {
        Select select = new Select(driver.findElement(By.id("years")));
        select.selectByValue(year);
    }

    public void enterFirstName(String firstName) {
        driver.findElement(By.id("first_name")).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(By.id("last_name")).sendKeys(lastName);
    }

    public void enterAddress(String address) {
        driver.findElement(By.id("address1")).sendKeys(address);
    }

    public void selectCountry(String country) {
        Select select = new Select(driver.findElement(By.id("country")));
        select.selectByVisibleText(country);
    }

    public void enterState(String state) {
        driver.findElement(By.id("state")).sendKeys(state);
    }

    public void enterCity(String city) {
        driver.findElement(By.id("city")).sendKeys(city);
    }

    public void enterZipcode(String zipcode) {
        driver.findElement(By.id("zipcode")).sendKeys(zipcode);
    }

    public void enterMobileNumber(String mobile) {
        driver.findElement(By.id("mobile_number")).sendKeys(mobile);
    }

    public void clickCreateAccount() {
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
    }

    public String getAccountCreatedMessage() {
        return driver.findElement(By.xpath("//h2[@data-qa='account-created']")).getText();
    }

    public void clickContinue() {
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
    }
}