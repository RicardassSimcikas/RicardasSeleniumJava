package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentsPage {
    private WebDriver driver;

    public PaymentsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getPaypalMethod() {
        return driver.findElement(By.id("braintree_paypal"));
    }

    public WebElement getCardMethod() {
        return driver.findElement(By.id("processout"));
    }

    public WebElement getGooglePayMethod() {
        return driver.findElement(By.id("googlepay"));
    }
}