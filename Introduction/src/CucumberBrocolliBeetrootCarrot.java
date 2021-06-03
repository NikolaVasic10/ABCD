import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CucumberBrocolliBeetrootCarrot {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jonny\\Desktop\\Selenium course\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait w = new WebDriverWait(driver, 5);
        //    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        driver.manage().window().maximize();

        String[] itemsNedded = {"Brocolli", "Cucumber", "Beetroot", "Carrot"};

        addItems(driver, itemsNedded);

        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='promoCode']")));

        driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");

        driver.findElement(By.xpath("//button[@class='promoBtn']")).click();

        // Explicit wait
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));

        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

        driver.close();
    }

    public static void addItems(WebDriver driver, String[] itemsNedded) {

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
