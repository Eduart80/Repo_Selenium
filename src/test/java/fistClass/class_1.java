package fistClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class class_1 {
    @Test
    public void testMe(){
        System.setProperty("webdriver.chrome.driver","./chrome/chromedriver.exe");
        WebDriver driveN = new ChromeDriver();
        driveN.get("https://google.com/");

    }
    @Test
    public void test2(){
        System.setProperty("webdriver.chrome.driver","./chrome/chromedriver.exe");
        WebDriver driveN = new ChromeDriver();
        driveN.get("https://facebook.com/");

        String actual = driveN.getTitle();
        String newtitle = "Facebook - Log In or Sign Up";
        Assert.assertEquals(actual, newtitle, "or rrong");
        driveN.quit();

    }

}
