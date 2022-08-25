package testngAndCucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CreateNewIncident extends ProjectSpecificMethods{
	
	@DataProvider(name="create")
	public String[] fetchData() {
		
		String[] data = new String [2];
		//1st data
		data[0]="Created Via Automation";
		
		//2nd data
		data[1]="Created incident via automation";
		return data;
	}
	
	
	@Test(dataProvider = "create")
	public void CreateIncident(String desc) {
		String all = "return document.querySelector('body > macroponent-f51912f4c700201072b211d4d8c26010').shadowRoot.querySelector('div > sn-canvas-appshell-root > sn-canvas-appshell-layout > sn-polaris-layout').shadowRoot.querySelector('div.sn-polaris-layout.polaris-enabled > div.header-bar > sn-polaris-header').shadowRoot.querySelector('/'all')";
		shadow.findElementByXPath(all).click();
			
		//5. Click on Create new option and fill the mandatory fields
		WebElement eleFrame= shadow.findElementByXPath(("//iframe[@title='Main Content']"));
		driver.switchTo().frame(eleFrame);
		driver.findElement(By.xpath("//button[text()='New']")).click();
		String text2 = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");

		System.out.println("Incident NUmber"+text2);
		driver.findElement(By.id("incident.short_description")).sendKeys(desc);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		driver.switchTo().defaultContent();

		//6. Verify the newly created incident by getting the incident number and put it in search field and 
		//   enter then verify the instance number created or not

		WebElement eleFrame2 = shadow.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(eleFrame2);
		WebElement numberDropDown = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select numberDD=new Select(numberDropDown);
		numberDD.selectByVisibleText("Number");
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(text2,Keys.ENTER);
		driver.switchTo().defaultContent();
		
		//// Confirm incident exists !
		driver.switchTo().frame(eleFrame2);
		String text = driver.findElement(By.xpath("//a[text()='Number']/following::a[@class='linked formlink']")).getText();
		System.out.println(text); 

	}

}
