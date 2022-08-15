package LambdaTest;

import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectSpecificMethods {
	RemoteWebDriver driver;
	String variable="Welcome to LambdaTest";
	String browsername="chrome";
	static WebDriverWait wait;

	/*
	 * https://www.lambdatest.com/selenium-playground
	 */
	@Parameters("url")
	@BeforeTest
	public void setup(String url) {

		if(browsername.equals("chrome")) {
			//we have to call wdm for the browser driver
			WebDriverManager.chromedriver().setup();

			//HAndle browser notifications
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");

			//launch the browser
			 driver=new ChromeDriver(options);
		}
		else if(browsername.equals("firefox")){
			//we have to call wdm for the browser driver
			WebDriverManager.firefoxdriver().setup();

			//HAndle browser notifications
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--disable-notifications");

			//launch the browser
			 driver=new FirefoxDriver(options);

		}

		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//explicit wait
		wait = new  WebDriverWait(driver,Duration.ofSeconds(5));

		//navigate to website url
		driver.get(url);

		//maximize
		driver.manage().window().maximize();
	}


}
