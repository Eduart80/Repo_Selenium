package homeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.TestException;
import org.testng.annotations.Test;

public class homeWork_12 {
    /**
     * Homework - 12
     * Due Date: Nov 23, 2020 (Monday)
     */
    @Test
    public void firstHW() throws InterruptedException {
        /**
         * Testcase 1: Verify the feels-like temp value is between low and high temp values at any zipcode
         * launch the web,  need to wait 5 sec to load the page properly
         * get the locator
         * split it by ""                                           // Alt + 0176 on my keyboard for degrees
         * get length of array
         * get substring 0 to length -1
         * convert String values in Integers
         * (if statement) - find if value is between high and low temperature
         */
        System.setProperty("webdriver.chrome.driver","./chrome/chromedriver.exe");
        WebDriver driveN = new ChromeDriver();
        driveN.get("https://darksky.net/");
        driveN.findElement(By.xpath("//input[@type='text']")).clear();          //  for practice porpoise i selected North Pole
        driveN.findElement(By.xpath("//input[@type='text']")).sendKeys("154–190 Snowman Ln, North Pole, AK");
        driveN.findElement(By.xpath("//a[@class='searchButton']")).submit();   //154–190 Snowman Ln, North Pole, AK
        try{
            Thread.sleep(5000); // wait 5 sec
        }catch (TestException e){
            e.getStackTrace();
        }
        //find Low
        WebElement gatheringData = driveN.findElement(By.xpath("//span[@class='low-temp-text']"));
        String getString = gatheringData.getText();
        String[] getIndex = getString.split("");
        int findLength = getIndex.length;
        String getTex = getString.substring(0, findLength-1);
        int getLow = Integer.parseInt(getTex);
        System.out.println("Low temp "+getLow);
        //find high
        WebElement gatheringData2 = driveN.findElement(By.xpath("//span[@class='high-temp-text']"));
        String getString2 = gatheringData2.getText();
        String[] getIndex2 = getString2.split("");
        int findLength2 = getIndex2.length;
        String getTex2 = getString2.substring(0, findLength2-1);
        int getHigh = Integer.parseInt(getTex2);
        System.out.println("High temp "+getHigh);
        //find feels like
        WebElement gatheringData3 = driveN.findElement(By.xpath("//span[@class='feels-like-text']"));
        String getString3 = gatheringData3.getText();
        String[] getIndex3 = getString3.split("");
        int findLength3 = getIndex3.length;
        String getTex3 = getString3.substring(0, findLength3-1);
        int getFeels = Integer.parseInt(getTex3);
        System.out.println("Feels like "+getFeels);

        if(getFeels<getHigh || getFeels>getLow){
            System.out.println("Feels-like temperature is between High and Low values.");
        }else {
            System.out.println("Error in temperature input");
        }
    }
    @Test
    public void SecondHW(){
        /**
         * Testcase 2: Verify the dates on the Blog Page appears in reverse chronological order
         */
    }
    @Test
    public void thirdHW(){
        /**
         * Testcase 3: Verify the temperature value converts as expected as the the unit selected
         */
    }
}

