package fistClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
       // driveN.quit();

        // email Locator By.id
        String logIn = "email";
        By logInName = By.id(logIn);
        WebElement emailIn = driveN.findElement(logInName);
        emailIn.sendKeys("email@gmail.com");

        // password locator By.name
        String logPass = "pass";
        By logInPass = By.name(logPass);
        WebElement PassIn = driveN.findElement(logInPass);
        PassIn.sendKeys("1234");

        // click button Locator By.name
        String logClick = "login";
        By logInClick = By.name(logClick);
        WebElement clickIn = driveN.findElement(logInClick);
        clickIn.click();

        driveN.close();

    }

}
