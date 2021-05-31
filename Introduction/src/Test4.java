import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test4 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jonny\\Desktop\\Selenium course\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        System.out.println(driver.getTitle());

     //   driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("myownemailaddress"); // xPath
     //   driver.findElement(By.cssSelector("#pass")).sendKeys("mypassword");
     //   driver.findElement(By.cssSelector("input[name='pass']")).sendKeys("mypass"); // CSS
        driver.findElement(By.cssSelector("input#email")).sendKeys("Jonnyemail");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("Jonnyemail");
    }
}
