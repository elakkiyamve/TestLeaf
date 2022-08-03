package week4.Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class CustomerServiceOptions {

	public static void main(String[] args) {
		/*
		 * Assignments 3.Customer_Service_Options
		====================================
		1. Launch Salesforce application https://login.salesforce.com/
		2. Login with Provided Credentials
		3. Click on Learn More link in Mobile Publisher
		4. Clilck on Products and Mousehover on Service 
		5. Click on Customer Services
		6. Get the names Of Services Available 
		7. Verify the title
		 */

		//we have to call wdm for the browser driver
		WebDriverManager.chromedriver().setup();
		//launch the browser
		ChromeDriver driver=new ChromeDriver();
		//HAndle browser notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//explicit wait
		WebDriverWait wait = new  WebDriverWait(driver,Duration.ofSeconds(5));

		//navigate to website url
		driver.get("https://login.salesforce.com/");

		//maximize
		driver.manage().window().maximize();

		//enter salesforce username
		driver.findElement(By.name("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password$123");		//enter password
		driver.findElement(By.id("Login")).click(); 	//clicks login

		//wait for learn more element to be clicked
		WebElement ele = driver.findElement(By.xpath("//button[@title='Learn More']//span[1]"));  		//clicks learn more button of mobile publisher
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.click();

		//get window handles
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(windowHandles);
		String secWin = winList.get(1);
		//driver holds sec window 
		driver.switchTo().window(secWin);

		//clicks confirm button
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		String title1 =driver.getTitle();
		System.out.println(title1);
		
		//clicks shadow dom resources
		Shadow dom=new Shadow(driver);
		dom.findElementByXPath("//span[text()='Products']").click();		//clicks products
		
		//actions class mouse hover to element
		Actions action = new Actions(driver);
		WebElement service = dom.findElementByXPath("//span[text()='Service']");
		action.moveToElement(service);
		service.click();
		
		dom.findElementByXPath("//a[text()='Customer Service']").click();		//clicks customer service
		
		//get the certifications list			
				List<WebElement> certifications = driver.findElements(By.xpath("(//div[@class='caption']/div/h2//following-sibling::span)"));
				System.out.println(certifications.size());
				for (WebElement webElement : certifications) {
					String text = webElement.getText();
					System.out.println(text);
					}
				
		//get title
		String title = driver.getTitle();
		System.out.println(title);
		
	}

}
