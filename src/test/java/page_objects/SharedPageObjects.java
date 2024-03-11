package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SharedPageObjects {
    private WebDriver driver;

    public SharedPageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getHeaderMenuItem(String menuItem) {
        return driver.findElement(By.xpath("//*[@id='hpanel_tracking-h_header-header_menu_item-link-" + menuItem + "']"));
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
