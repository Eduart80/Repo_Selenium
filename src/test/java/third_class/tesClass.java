package third_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.TestException;
import org.testng.annotations.Test;

public class tesClass {
    @Test
    public void radioButtonIsSelected(){

        System.setProperty("webdriver.chrome.driver","./chrome/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://facebook.com/");
        try{
            Thread.sleep(3000); // wait 2 sec
        }catch (TestException | InterruptedException e){
            e.getStackTrace();
        }
        WebElement clickMe = driver.findElement(By.id("u_0_2"));
        clickMe.click();
        try{
            Thread.sleep(3000); // wait 3 sec
        }catch (TestException | InterruptedException e){
            e.getStackTrace();
        }
       WebElement checkIF = driver.findElement(By.xpath("//label[contains(text(),'Male')]/following-sibling::input"));
       boolean checkIs=  checkIF.isDisplayed();
       Assert.assertTrue(checkIs,"Button is selected");
       WebElement selectThat = driver.findElement(By.xpath("//label[contains(text(),'Male')]/following-sibling::input"));
        selectThat.click();
        boolean buttSelected = selectThat.isSelected();
        Assert.assertTrue(buttSelected, "Button not selected");
        //driver.close();

    }
}
