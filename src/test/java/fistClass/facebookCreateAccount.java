package fistClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class facebookCreateAccount {

    @Test
    public  void facebookSignUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","./chrome/chromedriver.exe");
        WebDriver driveN = new ChromeDriver();
        driveN.get("https://facebook.com/");

        //create new account
        WebElement clickButt = driveN.findElement(By.xpath("//a[@role='button']"));
        clickButt.click();
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        //enter data
        driveN.findElement(By.xpath("//input[@name='firstname']")).sendKeys("fName");
        driveN.findElement(By.xpath("//input[@name='lastname']")).sendKeys("fLast");
        driveN.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("SampleEmail@gmail.com");
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        WebElement checkIt = driveN.findElement(By.name("reg_email_confirmation__"));
        boolean ifYes = checkIt.isDisplayed();
        Assert.assertTrue(ifYes,"Re-enter not displayed");
        checkIt.sendKeys("SampleEmail@gmail.com");
        driveN.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("12");
        //dropDown
        //month
        WebElement openMonth = driveN.findElement(By.name("birthday_month"));
        Select sMonth = new Select(openMonth);
        sMonth.selectByValue("7");
        //day
        WebElement openDay = driveN.findElement(By.name("birthday_day"));
        Select sDay = new Select(openDay);
        sDay.selectByValue("4");
        //Year
        WebElement openYear = driveN.findElement(By.name("birthday_year"));
        Select sYear = new Select(openYear);
        sYear.selectByValue("1998");
        WebElement radioButtom = driveN.findElement(By.id("u_2_o"));
        String name = "Female";
        switch (name){
            case "Female":
                driveN.findElement(By.xpath("//input[@id='u_2_4']")).click();
                break;
            case "Male":
                driveN.findElement(By.xpath("//input[@id='u_2_5']")).click();
                break;
            case "Custom":
                driveN.findElement(By.xpath("//input[@id='u_2_6']")).click();
                break;
            default:
                break;
        }
        driveN.findElement(By.name("websubmit")).click();

        /**
         * Scenario: SignUp - User gets error if doesn't select the gender
         * 1. Launch facebook.com
         * 2. Click on "Create New Account" button
         * 3. Enter first name
         * 4. Enter last name
         * 5. Enter phone number
         * 6. Enter New Password
         * 7. Click Sign Up button
         * 8. check error message
         */
    }
}
