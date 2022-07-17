package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	public static void main(String[] args) {
		/*
		 *  1. Launch URL "http://leaftaps.com/opentaps/control/login"
		  2. Enter UserName and Password Using Id Locator
		  3. Click on Login Button using Class Locator
		  4. Click on CRM/SFA Link
		  5. Click on Leads Button
		  6. Click on Create Lead 
		  7. Enter CompanyName Field Using id Locator
		  8. Enter FirstName Field Using id Locator
		  9. Enter LastName Field Using id Locator
		  10. Enter FirstName(Local) Field Using id Locator
		  11. Enter Department Field Using any Locator of Your Choice
		  12. Enter Description Field Using any Locator of your choice 
		  13. Enter your email in the E-mail address Field using the locator of your choice
		  14. Select State/Province as NewYork Using Visible Text
		  15. Click on Create Button
          16. Get the Title of Resulting Page. refer the video  using driver.getTitle()
       
		 */

		//we have to call wdm for the browser driver
				WebDriverManager.chromedriver().setup();
				//launch the browser
				ChromeDriver driver=new ChromeDriver();
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
				driver.findElement(By.linkText("Leads")).click();	
				driver.findElement(By.linkText("Create Lead")).click();	
				//createLeadForm_companyName
				driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");	//company name
				driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Elakkiya"); 	//first name
				driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Aravind");		//last name
				driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Elakkiya");	//first name local
				driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("QA Analyst");	//department
				driver.findElement(By.id("createLeadForm_description")).sendKeys("verification for create lead");	//description
				driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("elakkiya_tl@testleaf.com");	//email
				WebElement dropdown = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
				
				Select select = new Select(dropdown);
				select.selectByVisibleText("Texas");
				
				driver.findElement(By.className("smallSubmit")).click();

				String title = driver.getTitle();
				System.out.println(title);
				if(title.equals("View Lead | opentaps CRM"))
					System.out.println("success");

				
				
	}

}
