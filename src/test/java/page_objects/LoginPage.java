package page_objects;

import org.openqa.selenium.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoginPage {
    private WebDriver driver;
    private Properties properties;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        properties = new Properties();
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("user.properties");
            if (inputStream != null) {
                properties.load(inputStream);
                inputStream.close();
            } else {
                throw new FileNotFoundException("user.properties file was not found in the path: src/test/resources");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private WebElement getEmailInput() {
        return driver.findElement(By.id("email-input"));
    }

    private WebElement getPasswordInput() {
        return driver.findElement(By.id("password-input"));
    }

    private WebElement getLoginButton() {
        return driver.findElement(By.xpath("//*[@data-qa='login-button']"));
    }

    public void login() {
        getEmailInput().sendKeys(properties.getProperty("email"));
        getPasswordInput().sendKeys(properties.getProperty("password"));
        getLoginButton().click();
    }
}






