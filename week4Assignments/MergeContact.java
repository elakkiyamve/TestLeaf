package week4.Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {

		/*
		 * //Pseudo Code
		 * 
		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		 * 
		 * 2. Enter UserName and Password Using Id Locator
		 * 
		 * 3. Click on Login Button using Class Locator
		 * 
		 * 4. Click on CRM/SFA Link
		 * 
		 * 5. Click on contacts Button
		 * 	
		 * 6. Click on Merge Contacts using Xpath Locator
		 * 
		 * 7. Click on Widget of From Contact
		 * 
		 * 8. Click on First Resulting Contact
		 * 
		 * 9. Click on Widget of To Contact
		 * 
		 * 10. Click on Second Resulting Contact
		 * 
		 * 11. Click on Merge button using Xpath Locator
		 * 
		 * 12. Accept the Alert
		 * 
		 * 13. Verify the title of the page
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
				driver.get("http://leaftaps.com/opentaps/control/main");
				//maximize
				driver.manage().window().maximize();
				//find the username and enter the value
				driver.findElement(By.id("username")).sendKeys("demosalesmanager");
				//find the password and enter the value
				driver.findElement(By.id("password")).sendKeys("crmsfa");

				//click login
				driver.findElement(By.className("decorativeSubmit")).click();
				
				driver.findElement(By.linkText("CRM/SFA")).click();	
				driver.findElement(By.linkText("Contacts")).click(); 		//clicks contact button
				driver.findElement(By.xpath("(//ul[@class='shortcuts']/li)[4]")).click(); 		//clicks merge contact button
				
				driver.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdFrom']/following-sibling::a")).click(); 		//clicks widget of from contact 
				
				//move handle to sec window
				wait.until(ExpectedConditions.numberOfWindowsToBe(2));
				//get window handles
				Set<String> windowHandles = driver.getWindowHandles();
				System.out.println("Window handles size: " + windowHandles.size());
				
				List<String> window = new ArrayList<String>(windowHandles);
				String secWindow = window.get(1);
				
				driver.switchTo().window(secWindow);
				driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
				
				//move handle to primary window
				driver.switchTo().window(primary);
				driver.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdTo']/following-sibling::a")).click(); 		//clicks widget of to contact
				
				//move handle to sec window
				wait.until(ExpectedConditions.numberOfWindowsToBe(2));
				//get window handles
				Set<String> winHandles = driver.getWindowHandles();
				System.out.println("Window handles size: " + winHandles.size());
				
				List<String> win = new ArrayList<String>(winHandles);
				String secWin = win.get(1);
				
				driver.switchTo().window(secWin);
				driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click(); 		//clicks second resulting contact 
				
				//move handle to primary window
				driver.switchTo().window(primary);
				driver.findElement(By.xpath("//a[text()='Merge']")).click(); 		//clicks on merge button
				
				//accept the alert
				driver.switchTo().alert().accept();
				
				//get the result in DOM and verify
				System.out.println(driver.getTitle());
	
	
	}

}
