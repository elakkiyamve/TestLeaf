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

public class AdminCertifications {

	public static void main(String[] args) {
		/*
		 * Assignments 1. Administrator Certifications
			==============================
			1. Launch Salesforce application https://login.salesforce.com/
			2. Login with username as "ramkumar.ramaiah@testleaf.com " and password as "Password$123"
			3. Click on Learn More link in Mobile Publisher
			4. Click confirm on Confirm redirect
			5. Click Resources and mouse hover on Learning On Trailhead
			6. Clilck on Salesforce Certifications
			6. Click on Ceritification Administrator
			7. Navigate to Certification - Administrator Overview window
			8. Verify the Certifications available for Administrator Certifications should be displayed
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
		System.out.println(driver.getTitle());

		//clicks shadow dom resources
		Shadow dom=new Shadow(driver);
		dom.findElementByXPath("//span[text()='Learning']").click();
		
		//actions class mouse hover to element
		Actions action = new Actions(driver);
		WebElement trailHead = dom.findElementByXPath("//span[text()='Learning on Trailhead']");
		action.moveToElement(trailHead);
		trailHead.click();

		//wait for element to be clickable
		WebElement element = dom.findElementByXPath("//a[text()='Salesforce Certification']");
		driver.executeScript("arguments[0].click();", element);					//JavaScript execution for element to be clicked
		
		//clicks on Certification Administrator
		driver.findElement(By.linkText("Administrator")).click();

		//get the certifications list			
		List<WebElement> certifications = driver.findElements(By.xpath("(//div[@class='trailMix-card-body']/div[2])/a"));
		System.out.println(certifications.size());
		for (WebElement webElement : certifications) {
			String text = webElement.getText();
			System.out.println(text);
			}

	}

}
