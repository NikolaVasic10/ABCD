import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;


public class Assignment4 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jonny\\Desktop\\Selenium course\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/");

        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();

        driver.findElement(By.xpath("//a[text()='Click Here']")).click();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();

        driver.switchTo().window(childWindow);

        System.out.println(driver.findElement(By.cssSelector("div.example h3")).getText());

        driver.switchTo().window(parentWindow);

        System.out.println(driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText());
    }
}
