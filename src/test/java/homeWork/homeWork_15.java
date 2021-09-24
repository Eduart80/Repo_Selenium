package homeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class homeWork_15 {
    /**
     * 1. Launch the naurki application
     * 2. Close the advertisement windows (Do NOT close the main window)
     * 3. Type 'testing' in Skills, Designation and Company
     * 4. Select 'testing tools' from auto suggestion
     * 5. Click Search button
     * 6. Verify 'Testing Tools Jobs' appears above the search results
     */
    @Test
    public void testcase(){
        System.setProperty("webdriver.chrome.driver","./chrome/chromedriver.exe");
        WebDriver driveN = new ChromeDriver();
        driveN.get("https://naukri.com/");
        driveN.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //testing tool
        String mainPage = driveN.getWindowHandle();
        Set<String> otherPages = driveN.getWindowHandles();
        for(String handle : otherPages){
            if(!handle.equalsIgnoreCase(mainPage)){
                driveN.switchTo().window(handle);
                driveN.close();
                //break;
            }
        }
        driveN.switchTo().window(mainPage);
        WebElement input = driveN.findElement(By.xpath("//input[@id='qsb-keyword-sugg']"));
        input.clear();
        input.sendKeys("testing");
        //i had to use sleep in order to write the full word, because wait option at the moment
         //suggestion appear the program continue and the list get different outputs,
        //most of the time will get options from 'test' and not the full word 'testing'.
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String nameToFind = "Testing Tools"; //Testing Tools Jobs
        By lookingOutoSuggestion = By.xpath("//div[@id='sugDrp_qsb-keyword-sugg']//ul[@class='Sdrop']//li");
        List<WebElement> myList = driveN.findElements(lookingOutoSuggestion);

        for(WebElement divIn : myList){
            if (divIn.getText().equalsIgnoreCase(nameToFind)){
                System.out.println(divIn.getText());
                divIn.click();
                break;
            }
        }
        //click search
        driveN.findElement(By.xpath("//button[contains(text(),'Search')]")).click();
        //title text
        WebElement titleCheck = driveN.findElement(By.xpath("//h1[contains(text(),'Testing Tools Jobs')]"));
        String titleChecker = titleCheck.getText();

        Assert.assertEquals(titleChecker,nameToFind,"Title not equal");

    }
}
/**
 * Verify user selection from autosuggestion appears on search page
 * i am on hotel landing page
 * i enter 'york' in search
 * i select 'Lake George, New York, Unite' from autosuggestion
 * i click search button
 * i verify search header contains text selected from autosuggestion
 * i verify text under 'Destination, property, or landmark is the same text selected from autosuggestion
 */
/**
 * Verify the cheapest hotel is less than $100
 * i am on hotel landing page
 * i enter 'york' in search
 * i select 'Lake George, New York, Unite' from autosuggestion
 * i select 2 in children dropdown
 * i enter children 1 age as "4"
 * i enter children 2 age as "<1"
 * i click search button
 * i sort the result by "Price (Low to high)"
 * i print the lowest price and hotel name in the console
 * i verify the lowest price id less than $100
 */