package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) {

		/*http://leaftaps.com/opentaps/control/main
		
		* 1	Launch the browser
		* 2	Enter the username
		* 3	Enter the password
		* 4	Click Login
		* 5	Click crm/sfa link
		* 6	Click Leads link
		* 7	Click Find leads
		* 8	Enter first name
		* 9	Click Find leads button
		* 10 Click on first resulting lead
		* 11 Verify title of the page
		* 12 Click Edit
		* 13 Change the company name
		* 14 Click Update
		* 15 Confirm the changed name appears
		* 16 Close the browser (Do not log out)
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
		driver.findElement(By.linkText("Find Leads")).click();	//findClick Find leads button
		driver.findElement(By.linkText("Find Leads")).click();		//Clicks on first resulting lead
		String attribute = driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody[1]/tr[1]/td[1]/div[1]/a[1]")).getText();	//Clicks on first resulting lead
		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody[1]/tr[1]/td[1]/div[1]/a[1]")).click();		//Clicks on first resulting lead
		driver.findElement(By.xpath("//a[contains(text(),'Edit')]")).click();		//Clicks on edit button
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).clear();			// clear old company value
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).sendKeys("ABC company");	//pass company value
		driver.findElement(By.xpath("//input[@value='Update']")).click();	//click update
		String companyName = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();	//get new company name
	
		if(companyName.equals("ABC company" + " " + "(" + attribute + ")")) {
			System.out.println("updated " + companyName);
		}
		else {
			System.out.println("update not happened");
		}
								
	}

}
