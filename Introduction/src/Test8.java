import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class Test8 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Jonny\\Downloads\\selenium-firefox-driver-2.4.0.jar\\selenium-firefox-driver-2.4.0.jar");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.id("autosuggest")).sendKeys("Ind");

        Thread.sleep(3000);

        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

        for(WebElement option : options) {
            if(option.getText().equalsIgnoreCase("india")) {
                option.click();
                break;
            }
        }

        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

        System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());



        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1")).click();
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
            System.out.println("It is enabled!");
            Assert.assertTrue(true);
        }

        driver.findElement(By.id("divpaxinfo")).click();

        Thread.sleep(3000L);

        for(int i = 1; i < 4; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }

        driver.findElement(By.id("btnclosepaxoption")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div[id='divpaxinfo']")).getText(), "4 Adult");

        driver.findElement(By.cssSelector("span[class='btn-find-flight-home'] input[type='submit']")).click();

        Thread.sleep(1000L);
        driver.close();
    }
}
