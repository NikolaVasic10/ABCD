import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;


public class FluentWaitExample {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jonny\\Desktop\\Selenium course\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.manage().window().maximize();

        driver.findElement(By.xpath("//div[@id='start'] //button")).click();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
                                                                .pollingEvery(Duration.ofSeconds(3))
                                                                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//div[@id='finish'] //h4"));
            }
        });

        System.out.println(driver.findElement(By.xpath("//div[@id='finish'] //h4")).isDisplayed());
    }
}
