import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class Assignment2 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jonny\\Desktop\\Selenium course\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://cleartrip.com/");

        driver.manage().window().maximize();

        Thread.sleep(5000L);

        List <WebElement> messages = driver.findElements(By.xpath("//div[@class='banner-section'] //p"));

        for(WebElement message : messages) {
            if(message.getText().contains("View latest")) {
                Assert.assertTrue(true);
                System.out.println("Message identified.");
                break;
            }
        }

        driver.findElement(By.cssSelector("#FromTag")).sendKeys("New");
        Thread.sleep(2000L);
        driver.findElement(By.xpath("//ul[@class='autoComplete'] //a[text()='New York, US - All airports (NYC)']")).click();

        driver.findElement(By.xpath("//input[@id='ToTag']")).sendKeys("Belg");
        Thread.sleep(2000L);
        List<WebElement> options = driver.findElements(By.xpath("//ul[@class='autoComplete'] //a"));

        for(WebElement option : options) {
            if(option.getText().equalsIgnoreCase("Belgrade, CS - Belgrade Beograd (BEG)")) {
                option.click();
                break;
            }
        }

        driver.findElement(By.id("DepartDate")).click();
        Thread.sleep(2000L);
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();


        WebElement adDrop = driver.findElement(By.id("Adults"));
        Select adultsDropdown = new Select(adDrop);
        adultsDropdown.selectByIndex(3);

        WebElement chDrop = driver.findElement(By.id("Childrens"));
        Select childrenDropdown = new Select(chDrop);
        childrenDropdown.selectByValue("5");

        WebElement inDrop = driver.findElement(By.id("Infants"));
        Select infantsDropdown = new Select(inDrop);
        infantsDropdown.selectByVisibleText("1");

        driver.findElement(By.id("MoreOptionsLink")).click();

        WebElement classDrop = driver.findElement(By.name("class"));
        Select classDropdown = new Select(classDrop);
        classDropdown.selectByVisibleText("First");

        driver.findElement(By.name("airline")).sendKeys("Something");
        driver.findElement(By.id("creditShell")).click();
        driver.findElement(By.id("SearchBtn")).click();

    }
}
