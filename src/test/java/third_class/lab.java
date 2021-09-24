package third_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class lab {
    @Test
    public void testing(){

        System.setProperty("webdriver.chrome.driver","./chrome/chromedriver.exe");
        WebDriver driveN = new ChromeDriver();
        driveN.get("https://hotels.com/");

        //ul[@class='primary-section']//a[text()='Create account']
    }
    @Test
    public void verifyHumidityValue() {
        /**
         * Test scenario: Verify Humidity value is less then 100
         * Launch Darksky.net
         * get xpath locator -> //span[@class='num swip humidity__value']
         * get the text
         * convert in Integer
         * verify if less than 100
         */
        System.setProperty("webdriver.chrome.driver","./chrome/chromedriver.exe");
        WebDriver driveN = new ChromeDriver();
        driveN.get("https://darksky.net/");
        WebElement find = driveN.findElement(By.xpath("//span[@class='num swip humidity__value']"));
        String foundNumb = find.getText();
        int foundInt = Integer.parseInt(foundNumb);
        Assert.assertTrue(foundInt < 100,"No is more than 100");
        driveN.close();
        System.out.println("Hummidity is "+foundInt);
    }
}

