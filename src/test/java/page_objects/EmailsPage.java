package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmailsPage {
    private WebDriver driver;

    public EmailsPage(WebDriver driver) {
        this.driver = driver;
    }


    private WebElement getBillingPeriodButton(String period) {
        return driver.findElement(By.xpath("//*[@data-qa='" + period + "-months']"));
    }

    private WebElement getChoosePaymentButton() {
        return driver.findElement(By.xpath("//*[@data-qa='purchase-button-complete']"));
    }

    private WebElement getSelectEmailPlanButton(int emailPlanIndex) {
        return driver.findElement(By.xpath("(//*[@id='hpanel_tracking-emails-select_button'])[" + emailPlanIndex + "]"));
    }

    public void initiatePlanPurchase(int emailPlanButtonIndex, String billingPeriod) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id='hpanel_tracking-emails-select_button'])[" + emailPlanButtonIndex + "]")));
        getSelectEmailPlanButton(emailPlanButtonIndex).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-qa='purchase-button-complete']")));
        getBillingPeriodButton(billingPeriod).click();
        SharedPageObjects.scrollToElement(driver, getChoosePaymentButton());
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-qa='purchase-button-complete']")));
        getChoosePaymentButton().click();
    }
}
