package fistClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class darksky {
    @Test
    public void findLock(){
        System.setProperty("webdriver.chrome.driver","./chrome/chromedriver.exe");
        WebDriver driveN = new ChromeDriver();
        driveN.get("https://darksky.net/");
        driveN.findElement(By.xpath("//input[@type='text']")).clear();
        driveN.findElement(By.xpath("//input[@type='text']")).sendKeys("10001");

        driveN.findElement(By.className("searchButton")).click();
        driveN.close();
    }
}
