package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page_objects.*;

import java.time.Duration;

public class AutomationTaskTest extends BaseTest {

    @BeforeTest
    void login() {
        setUp();
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        EmailsPage emailsPage = new EmailsPage(driver);
        SharedPageObjects sharedPageObjects = new SharedPageObjects(driver);

        homePage.clickLoginButton();
        loginPage.login();
        sharedPageObjects.getHeaderMenuItem("emails").click();
        emailsPage.initiatePlanPurchase(2, "24");
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("braintree_paypal")));
    }

    @Test
    void testPaymentMethodsExistence() {
        PaymentsPage paymentsPage = new PaymentsPage(driver);

        Assert.assertTrue(paymentsPage.getPaypalMethod().isDisplayed(), "Paypal method is not displayed");
        Assert.assertTrue(paymentsPage.getCardMethod().isDisplayed(), "Card method is not displayed");
        Assert.assertTrue(paymentsPage.getGooglePayMethod().isDisplayed(), "Google Pay method is not displayed");
    }
}