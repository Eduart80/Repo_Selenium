package fourthClass;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

public class mouseActions {
    /**
     * 1. Launch darksky.net
     * 2. Scroll to Time Machine button (scroll by pixels)
     * 3. Click on Time Machine button
     * 4. Verify currentDate is highlighted
     */
    @Test    // Actions : moveToElement  mouse action
    public void Study() {
        System.setProperty("webdriver.chrome.driver", "./chrome/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://darksky.net/");

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scrollBy(0,1200);");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Actions act = new Actions(driver);

        WebElement find = driver.findElement(By.xpath("//a[@class='button']"));
        find.click();
        WebElement find2 = driver.findElement(By.xpath("//td[@class='is-today']"));

        Date today = new Date();


    }
    /**
     * scroll by pixel
     */
//    JavascriptExecutor js = (JavascriptExecutor)driver;
//    // type-casting - changing the driver-datatype into JavaScriptExecutor and
//    // storing in JavaScriptExecutor variable.
//        js.executeScript("scrollBy(0,700);");   // scroll downward 700 pixels
//        Thread.sleep(500);
//        js.executeScript("scrollBy(0,-700);");   // scroll upward 700 pixels
    /**
     * scroll upto a particular webElement
     */
//    WebElement elem = driver.findElement(By.id(""));
//        js.executeScript("arguments[0].scrollIntoView(true);", elem);
    /**
     * scroll to bottom
     */
//        js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
}
