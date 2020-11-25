package homeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class homeWork_13 {
    /**Testcase-2: User should get error on invalid date of birth
     *      * 1. Launch facebook.com
     *      * 2. Click 'Create new Account' button
     *      * 3. Enter fname as Firstname
     *      * 4. Enter lname as Lastname
     *      * 5. "abcd@test.com" as email address
     *      * 6. "abcd@1234" as New Password
     *      * 7. Enter your "Jan 4 1998" as birth date
     *      * 8. Click the 'Sign Up' button
     *      * 9. Verify user see the error msg for gender. (Please choose a gender. You can change who can see this later.)
     */
    @Test
    public void facebookSignUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./chrome/chromedriver.exe");
        WebDriver driveN = new ChromeDriver();
        driveN.get("https://facebook.com/");

        //create new account
        WebElement clickButt = driveN.findElement(By.xpath("//a[@role='button']"));
        clickButt.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //enter data
        driveN.findElement(By.xpath("//input[@name='firstname']")).sendKeys("fName");
        driveN.findElement(By.xpath("//input[@name='lastname']")).sendKeys("fLast");
        driveN.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("SampleEmail@gmail.com");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement checkIt = driveN.findElement(By.name("reg_email_confirmation__"));
        boolean ifYes = checkIt.isDisplayed();
        Assert.assertTrue(ifYes, "Re-enter not displayed");
        checkIt.sendKeys("SampleEmail@gmail.com");
        driveN.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("12");
        //dropDown
        //month
        WebElement openMonth = driveN.findElement(By.name("birthday_month"));
        Select sMonth = new Select(openMonth);
        sMonth.selectByValue("1");
        //day
        WebElement openDay = driveN.findElement(By.name("birthday_day"));
        Select sDay = new Select(openDay);
        sDay.selectByValue("4");
        //Year
        WebElement openYear = driveN.findElement(By.name("birthday_year"));
        Select sYear = new Select(openYear);
        sYear.selectByValue("1998");

        driveN.findElement(By.name("websubmit")).click();
        WebElement popUP = driveN.findElement(By.xpath("//div[contains(text(),'Please choose a gender. You can change who can see this later.')]"));
        boolean isTrue = popUP.isEnabled();
        Assert.assertTrue(isTrue, "PopUp not showing message of missing radio button");

        driveN.close();

    }
    @Test
    public void yahooPage(){
        /**
         *Testcase - 1:User should be able to click on the yahoo notification
         * Launch yahoo.com
         *  Move mouse to bell icon
         *  user should be able to click the first notification
         */
       System.setProperty("webdriver.chrome.driver", "./chrome/chromedriver.exe");
       WebDriver driver = new ChromeDriver();
       driver.get("https://www.yahoo.com");

       WebElement findBell = driver.findElement(By.xpath("//label[@for='ybarNotificationMenu']"));
        Actions act = new Actions(driver);
        act.moveToElement(findBell).perform();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement checkNotification = driver.findElement(By.xpath("//div[@id='yns-panel']"));
        boolean ifTrue = checkNotification.isDisplayed();
        Assert.assertTrue(ifTrue,"Panel notification is not showing");
        checkNotification.findElement(By.xpath("//ul[@class='yns-notifications ']/li[2]")).click(); //I choose <li [2] just to see reaction

        driver.close();


    }


}