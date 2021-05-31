import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SauceLabsTest {

    public static final String URL = "https://oauth-nikolavasic505-38529:e04ad22b-2d4a-4c12-8920-77e81c2fc026@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

    public static void main(String[] args) throws MalformedURLException {

      /*  DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("platform", "Windows 7");
        caps.setCapability("version", "51.0"); */

        MutableCapabilities sauceOptions = new MutableCapabilities();

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setExperimentalOption("w3c", true);
        browserOptions.setCapability("platformName", "Windows 7");
        browserOptions.setCapability("browserVersion", "75.0"); // w3c - browser version higher than 75
        browserOptions.setCapability("sauce:options", sauceOptions);

    //    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        WebDriver driver = new RemoteWebDriver(new URL(URL), browserOptions);
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());

    }

}
