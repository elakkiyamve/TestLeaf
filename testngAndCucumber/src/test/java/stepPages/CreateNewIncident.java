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
import testngAndCucumber.ScenarioContext;

public class CreateNewIncident extends ProjectSpecificMethods{

	Shadow shadow = new Shadow(driver);
	
	@Given("Click New")
	public void clickNew() {
		WebElement eleFrame= shadow.findElementByXPath(("//iframe[@title='Main Content']"));
		driver.switchTo().frame(eleFrame);
		driver.findElement(By.xpath("//button[text()='New']")).click();
		text2 = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		System.out.println("Inident NUmber"+text2);
	} 
	
	@When("Type the short_description as (.*)$")
	public void typeShortDesc(String shortDescription) {
		driver.findElement(By.id("incident.short_description")).sendKeys(shortDescription);
	}
	
	@And("Click Submit Button")
	public void clickSubmit() {
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		driver.switchTo().defaultContent();
	}
	@Then("Verify the create incident with number")
	public void verifyIncident() {
		WebElement eleFrame2 = shadow.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(eleFrame2);
		WebElement numberDropDown = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select numberDD=new Select(numberDropDown);
		numberDD.selectByVisibleText("Number");
		
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(text2,Keys.ENTER);
		driver.switchTo().defaultContent();
	}
}
