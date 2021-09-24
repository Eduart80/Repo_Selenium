package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

public class hotell {
    @Test
    public void Testin() {
        System.setProperty("webdriver.chrome.driver", "./chrome/chromedriver.exe");
        WebDriver driveN = new ChromeDriver();
        driveN.get("https://hotels.com/");
        driveN.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        By enterInSearch = By.xpath("//input[@id='qf-0q-destination']");
        driveN.findElement(enterInSearch).sendKeys("Lake York");

        By searchIN = By.xpath("//input[@aria-expanded='true']");

        WebElement found = driveN.findElement(searchIN);
        boolean dd = found.isDisplayed();
        System.out.println(dd);

        driveN.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        By ss= By.xpath("//tbody[@class='autosuggest-city']//div[@class='autosuggest-category-result']");
        //By ss= By.xpath("//tbody[@class='autosuggest-city']//span");
        String aa = "Lake George, New York, Unite";
        List<WebElement>my= driveN.findElements(ss);
        for (WebElement ff : my){
            System.out.println("from outside "+ff.getText());
            if(ff.getText().contains(aa)){
                System.out.println("from iside "+ff.getText());
                ff.click();
                break;
            }
        }

    }
}
