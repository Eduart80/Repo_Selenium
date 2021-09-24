package secondClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class darksky {
    @Test
    public void enterDarkSky(){
        System.setProperty("webdriver.chrome.driver","./chrome/chromedriver.exe");
        WebDriver driveN = new ChromeDriver();
        //driveN.get("https://darksy.net/");
        driveN.get("https://google.com/");

        driveN.findElement(By.xpath("//input[@title='Search']")).sendKeys("darksky.net");
        //send search
        driveN.findElement(By.name("btnK")).submit();
        //click on website link
        driveN.findElement(By.xpath("//span[contains(text(),'Dark Sky - 1 City Hall, New York, NY')]")).click();
        // search bar in the webpage
        driveN.findElement(By.xpath("//input[@type='text']")).clear();   //
        driveN.findElement(By.xpath("//input[@type='text']")).sendKeys("Tirana, Albania");
        driveN.findElement(By.xpath("//a[@class='searchButton']")).submit();




    }
}
