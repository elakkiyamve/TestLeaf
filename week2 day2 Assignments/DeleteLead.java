package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		/*http://leaftaps.com/opentaps/control/main
		 
		Delete Lead:
		1	Launch the browser
		2	Enter the username
		3	Enter the password
		4	Click Login
		5	Click crm/sfa link
		6	Click Leads link
		7	Click Find leads
		8	Click on Phone
		9	Enter phone number
		10	Click find leads button
		11	Capture lead ID of First Resulting lead
		12	Click First Resulting lead
		13	Click Delete
		14	Click Find leads
		15	Enter captured lead ID
		16	Click find leads button
		17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		18	Close the browser (Do not log out)
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
		driver.findElement(By.linkText("Find Leads")).click();	//Click Find leads button
		driver.findElement(By.xpath("(//span[@class='x-tab-strip-text '])[2]")).click();   //clicks phone tab
		driver.findElement(By.xpath("(//input[@name='phoneCountryCode']/following::input)[1]")).sendKeys("91");
		driver.findElement(By.xpath("(//input[@name='phoneCountryCode']/following::input)[2]")).sendKeys("9900088000");
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();  //clicks find leads
		Thread.sleep(2000);
		String LeadId = driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody/tr/td[1]/div/a[1]")).getText(); //clicks on 1st result
		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody/tr/td[1]/div/a[1]")).click(); //clicks on 1st result
		driver.findElement(By.xpath("//a[text()='Delete']")).click(); 	// delete lead id
		driver.findElement(By.linkText("Find Leads")).click();	//Click Find leads button
		driver.findElement(By.name("id")).sendKeys(LeadId); 	//enter lead id
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();  //clicks find leads
		boolean message = driver.findElement(By.xpath("//div[@class= 'x-paging-info']")).isDisplayed();
		if(message == true) {
		System.out.println("Successfull deletion");
		}
		driver.close();
		
		
		

	}

}
