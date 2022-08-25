package testngAndCucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class DeleteIncident extends ProjectSpecificMethods {
	
		@Test(dependsOnMethods = "testngAndCucumber.CreateNewIncident.CreateIncident")
		public void deleteIncident() {
			
		WebElement eleFrame= shadow.findElementByXPath(("//iframe[@title='Main Content']"));
		driver.switchTo().frame(eleFrame);
		driver.findElement(By.xpath("//th[@name='number']/following::a[@class='linked formlink']")).click();
		
		//5. Delete the incident
		shadow.findElementByXPath("//button[text()='Delete']").click();
		driver.findElement(By.id("ok_button")).click();
		
		//6. Verify the deleted incident
		driver.switchTo().frame(eleFrame);
		driver.findElement(By.xpath("//th[@name='number']/following::a[@class='linked formlink']")).click();
		

	}

}
