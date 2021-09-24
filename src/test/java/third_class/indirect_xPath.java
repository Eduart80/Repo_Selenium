package third_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class indirect_xPath {
    @Test
    public void test(){
        System.setProperty("webdriver.chrome.driver","./chrome/chromedriver.exe");
        WebDriver driveN = new ChromeDriver();
        driveN.get("https://darksky.net/");

    driveN.findElement(By.xpath("//body/div[@id='header']/div[1]/div[1]/div[2]")).click();
        driveN.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[2]")).click();

    }


}
