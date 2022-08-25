package stepPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.sukgu.Shadow;

public class DeleteIncident extends ProjectSpecificMethods {
	Shadow shadow = new Shadow(driver);
	
	@Given("Enter Incident number in search box")
	public void searchIncident()
	{
		WebElement eleFrame = shadow.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(eleFrame);
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(text2,Keys.ENTER);
		}
	
	@When ("click incident number to delete")
	public void clickIncidentNo(){
		driver.findElement(By.xpath("//th[@name='number']/following::a[@class='linked formlink']")).click();
		}
	@And ("Click Delete Button")
	public void clickDelete() {
		shadow.findElementByXPath("//button[text()='Delete']").click();
		driver.findElement(By.id("ok_button")).click();
	}
	@Then ("Verify the Delete incident with number") 
	public void verifyDeletedIncident() {
		System.out.println("verified");
		
	}
}
