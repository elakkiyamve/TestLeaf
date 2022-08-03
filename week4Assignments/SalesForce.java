package week4.Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce {

	public static void main(String[] args) {
		/**
		 * 
		 * Salesforce Customer service:
		1.Launch the browser
		2.Load the url as " https://login.salesforce.com/ "
		3.Enter the username as " ramkumar.ramaiah@testleaf.com "
		4. Enter the password as " Password$123 "
		5.click on the login button
		6.click on the learn more option in the Mobile publisher
		7.Switch to the next window using Windowhandles.
		8.click on the confirm button in the redirecting page
		9.Get the title
		10.Get back to the parent window
		11.close the browser
		 */
		//we have to call wdm for the browser driver
		WebDriverManager.chromedriver().setup();
		//launch the browser
		ChromeDriver driver=new ChromeDriver();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//explicit wait
		WebDriverWait wait = new  WebDriverWait(driver,Duration.ofSeconds(5));

		//primary window handle
		String primary = driver.getWindowHandle();

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
		//switch to primary window and close
		driver.switchTo().window(primary).close();
		
	}

}
