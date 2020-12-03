package homeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class homeWork_14 {
    @Test
    public void darkSky(){
        System.setProperty("webdriver.chrome.driver","./chrome/chromedriver.exe");
        WebDriver driveN = new ChromeDriver();
        driveN.get("https://darksky.net/");
        JavascriptExecutor js = (JavascriptExecutor)driveN;
        js.executeScript("scrollBy(0,700)");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driveN.findElement(By.xpath("//a[@data-day='0']")).click();
        WebElement temp1 = driveN.findElement(By.xpath("//a[@class='day revealed']/span[2]/span[1]")); //LowTemp
        String temp11 = temp1.getText();
        WebElement temp2 = driveN.findElement(By.xpath("//a[@class='day revealed']/span[2]/span[3]")); //HighTemp
        String temp22 = temp2.getText();
        WebElement compare1 = driveN.findElement(By.xpath("//div[@class='highLowTemp swip']/span[1]/span[1]"));
        String compare11 = compare1.getText();
        WebElement compare2 = driveN.findElement(By.xpath("//div[@class='highLowTemp swip']/span[3]/span[1]"));
        String compare22 = compare2.getText();
        Assert.assertEquals(temp11,compare11,"Low temperature not equal");
        Assert.assertEquals(temp22, compare22, "High temperature not equal");
        System.out.println(temp11+temp22+compare11+compare22);
    }
    @Test
    public void hotel(){
        /**
         * check in tomorrow checkout 7days
         * veryfy the briefcase
         */
        System.setProperty("webdriver.chrome.driver","./chrome/chromedriver.exe");
        WebDriver driveN = new ChromeDriver();
        driveN.get("https://hotels.com/");

        Calendar cal2 = Calendar.getInstance();
        cal2.add(Calendar.DATE,1);
        cal2.add(Calendar.MONTH,-1);
        Date myDate2 = cal2.getTime();
        SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-d");
        String form = dff.format(myDate2);

        //checkIn date
        WebElement checkIn = driveN.findElement(By.id("qf-0q-localised-check-in"));
        checkIn.click();
        //select tomorrow date
        WebElement findDayIn = driveN.findElement(By.xpath("//td[@data-date='"+form+"']"));
        findDayIn.click();
        //checkOut date
        WebElement checkOut = driveN.findElement(By.id("qf-0q-localised-check-out"));
        checkOut.click();
        //add date on calendar
        cal2.add(Calendar.DATE,7);
        Date myDate3 = cal2.getTime();
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-d");
        String form2 = df2.format(myDate3);

        //select how many date in all
        WebElement findDayOut = driveN.findElement(By.xpath("//td[@data-date='"+form2+"']"));
        findDayOut.click();
        //verify how many nights
        WebElement nights = driveN.findElement(By.xpath("//span[@class='widget-query-num-nights']"));
        String numberNights = nights.getText();

        Assert.assertEquals(numberNights, "7","calculation error for nights in");

    }
    /**
     * room 1 adult 1 children 2 age 1 and 2
     * veryfy the data on next page
     */
    @Test
    public  void hotel2(){
        System.setProperty("webdriver.chrome.driver","./chrome/chromedriver.exe");
        WebDriver driveN = new ChromeDriver();
        driveN.get("https://hotels.com/");
        //destination
        driveN.findElement(By.id("qf-0q-destination")).clear();
        driveN.findElement(By.id("qf-0q-destination")).sendKeys("Washington DC");
        //room
        WebElement addroom = driveN.findElement(By.xpath("//select[@name='q-rooms']/option[1]"));
        addroom.click();
        String room = addroom.getText();
        //adults
        WebElement addadult = driveN.findElement(By.xpath("//select[@name='q-room-0-adults']/option[1]"));
        addadult.click();
        String adult = addadult.getText();
        //children
        WebElement addchld = driveN.findElement(By.xpath("//select[@name='q-room-0-children']/option[3]"));
        addchld.click();
        String chld1 = addchld.getText();
        //age 1
        WebElement addAge = driveN.findElement(By.xpath("//select[@name='q-room-0-child-0-age']/option[3]"));
        addAge.click();
        String age1 = addAge.getText();
        //age 2
        WebElement addAge2 = driveN.findElement(By.xpath("//select[@name='q-room-0-child-1-age']/option[4]"));
        addAge2.click();
        String age2 = addAge2.getText();
        //submit
        driveN.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals(room,"1","Not as expected.");
        Assert.assertEquals(adult,"1","Not as expected.");
        Assert.assertEquals(chld1,"2","Not as expected.");
        Assert.assertEquals(age1,"1","Not as expected.");
        Assert.assertEquals(age2,"2","Not as expected.");

    }
}
