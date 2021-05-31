import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test3 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jonny\\Desktop\\Selenium course\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://login.salesforce.com/");


    //    driver.findElement(By.xpath("//*[@id='Login']")).click();
    //    driver.findElement(By.cssSelector("#forgot_password_link")).click();
        driver.findElement(By.id("username")).sendKeys("blabla");
        driver.findElement(By.name("pw")).sendKeys("blabla");
        driver.findElement(By.xpath("//*[@id='Login']")).click();

        WebElement element = driver.findElement(By.xpath("//*[@id=\"error\"]"));
        String string = element.getText();

        System.out.println(string);
       // System.out.println(driver.findElement(By.xpath("//*[@id=\"error\"]")).getText());
    }
}
