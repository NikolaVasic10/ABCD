import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class CucumberBrocolliBeetrootCarrot {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jonny\\Desktop\\Selenium course\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        driver.manage().window().maximize();

        Thread.sleep(3000L);

        String[] itemsNedded = {"Brocolli", "Cucumber", "Beetroot", "Carrot"};

        int j = 0;

        List<WebElement> options = driver.findElements(By.cssSelector("h4.product-name"));

        for (int i = 0; i < options.size(); i++) {
            String[] names = options.get(i).getText().split("-");
            String formattedName = names[0].trim();
            List itemsNeededList = Arrays.asList(itemsNedded);

            if (itemsNeededList.contains(formattedName)) {
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                if (j == itemsNedded.length) {
                    break;
                }
            }
        }

        driver.findElement(By.className("cart-icon")).click();

    }
}
