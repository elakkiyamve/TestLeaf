package testngAndCucumber;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;


public class ProjectSpecificMethods {

ChromeDriver driver;
Shadow shadow = new Shadow(driver);
public static String text2="";

@Parameters({"url","username","password"})
@BeforeClass
public void setup(String url,String username, String password) throws InterruptedException {
	//we have to call wdm for the browser driver
			WebDriverManager.chromedriver().setup();
			//launch the browser
			driver=new ChromeDriver();
			//navigate to website url
			driver.get(url);
			//maximize
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
			//find the username and enter the value
			driver.findElement(By.id("user_name")).sendKeys(username);
			//find the password and enter the value
			driver.findElement(By.id("user_password")).sendKeys(password);

			//click login
			driver.findElement(By.id("sysverb_login")).click();
			shadow.setImplicitWait(30);
			shadow.findElementByXPath("//div[@id='all']").click();
			Thread.sleep(2000);
			shadow.findElementByXPath("//span[text()='Incidents']").click();
			System.out.println("completed before method");
}
	
@AfterClass
public void TearDown() {
	String title = driver.getTitle();
	System.out.println(title);
	driver.close();
	
}



}
