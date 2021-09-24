package fistClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class googleImage {
    @Test
    public void searchImage (){
        // webpage url
        System.setProperty("webdriver.chrome.driver","./chrome/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com/");
        // enter text in search bar

        String enter = "q";
        By enterIN = By.name(enter);
        WebElement enterW = driver.findElement(enterIN);
        enterW.sendKeys("image");
        // click to submit
        String clickEnter = "btnK";
        By enteringText = By.name(clickEnter);
        WebElement sendAt = driver.findElement(enteringText);
        sendAt.submit();

        driver.close();

    }
}
