import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;

public class switchingTabs {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jonny\\Desktop\\Selenium course\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/loginpagePractise/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector(".blinkingText")).click();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentID = it.next();
        String childID = it.next();
        driver.switchTo().window(childID);

        String message = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];

        System.out.println(message);

        driver.switchTo().window(parentID);

        driver.findElement(By.id("username")).sendKeys(message);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("password123");
        driver.findElement(By.xpath("//label[@class='customradio'] //input[@value='admin']")).click();
        Thread.sleep(5000L);
        driver.findElement(By.cssSelector("input#terms")).click();
        driver.findElement(By.id("signInBtn")).click();




    }
}
