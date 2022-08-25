package testngAndCucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EditIncident extends ProjectSpecificMethods {
	/*
	@DataProvider(name="edit")
	public String[] fetchData() {
		
		String[] data = new String [2];
		//1st data
		data[0]="Edited Via Automation";
		data[1]="Abel Tuter";
		
		return data;
	}
	*/
	@Test
	public void editIncident() throws InterruptedException {
		System.out.println("entered test");
		WebElement eleFrame= shadow.findElementByXPath(("//iframe[@title='Main Content']"));
		driver.switchTo().frame(eleFrame);
		
		//4. Search for the existing incident and click on the incident
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(text2,Keys.ENTER);
		driver.findElement(By.xpath("//th[@name='number']/following::a[@class='linked formlink']")).click();
		
		//5. Update the incident with Urgency as High and State as In Progress
		WebElement eleCallerID = driver.findElement(By.id("sys_display.incident.caller_id"));
		eleCallerID.clear();
		eleCallerID.sendKeys("Abel Tuter",Keys.TAB);
		//select urgency
		WebElement dd = driver.findElement(By.id("incident.urgency"));
		Select s1 =new Select(dd);
		s1.selectByIndex(1);
		
		//select state
		WebElement dd2 = driver.findElement(By.id("incident.state"));
		Select s2 =new Select(dd2);
		s2.selectByIndex(2);
		
		//enter description
		WebElement eleShortDesc = driver.findElement(By.id("incident.short_description"));
		eleShortDesc.clear();
		eleShortDesc.sendKeys("edited via automation");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Update']")).click();	//click update
		
		//6. Verify the update information is available in the incident
		
	}
}
