package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage {

    WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterName(String name) {
        driver.findElement(By.name("name")).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(By.name("email")).sendKeys(email);
    }

    public void enterSubject(String subject) {
        driver.findElement(By.name("subject")).sendKeys(subject);
    }

    public void enterMessage(String message) {
        driver.findElement(By.id("message")).sendKeys(message);
    }

    public void clickSubmit() {
        driver.findElement(By.name("submit")).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(By.xpath("//div[contains(@class,'alert-success')]")).getText();
    }

    public void clickHomeButton() {
        driver.findElement(By.linkText("Home")).click();
    }


    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }
}