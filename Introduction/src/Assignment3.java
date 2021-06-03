import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Assignment3 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jonny\\Desktop\\Selenium course\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);

        driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");

        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[text()='Click to load get data via Ajax!']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='results']")));
        System.out.println(driver.findElement(By.cssSelector("div[id='results']")).getText());

    }
}
