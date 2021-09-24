package manualTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.util.concurrent.TimeUnit.SECONDS;

public class testing1 {
    @Test(description= "testing1")
    public void testing() {
        System.setProperty("webdriver.chrome.driver", "./chrome/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        driver.manage().timeouts().implicitlyWait(10,SECONDS);
         driver.findElement(By.name("q")).sendKeys("Monday");
         driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        driver.close();


    }

}
