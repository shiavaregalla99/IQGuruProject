package TestBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
//browserinitialization and browser termination
	public static WebDriver driver;

	public static void openBrowserAndLaunchApplication(String browserName) {

		switch (browserName) {
		case "chrome":

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			throw new RuntimeException("Invalid browser name");
		}

		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
	}
	public static void closeBrowser(){
        driver.quit();
    }
}
