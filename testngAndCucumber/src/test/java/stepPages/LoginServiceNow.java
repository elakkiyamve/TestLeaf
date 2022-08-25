package stepPages;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.sukgu.Shadow;

public class LoginServiceNow extends ProjectSpecificMethods{

	Shadow shadow = new Shadow(driver);
	
	@Given("Enter the username as (.*)$")
	public void typeUserName(String username) {
		driver.findElement(By.id("user_name")).sendKeys(username);
	}
	
	@And("Enter the password as (.*)$")
	public void typePassword(String password) {
		driver.findElement(By.id("user_password")).sendKeys(password);
	}
	
	@When("Click on Login button")
	public void clickLogin() {
		driver.findElement(By.id("sysverb_login")).click();
	}
	
	@Then("Homepage should be displayed")
	public void verifyHomePage() {
			System.out.println("Home page is displayed");
	}
	
	@Given("Click All Link")
	public void clickAllLink() {
		shadow.setImplicitWait(20);
		shadow.findElementByXPath("//div[@id='all']").click();
	}
	
	@And("Click Incidents")
	public void clickIncidents() {
		shadow.findElementByXPath("//span[text()='Incidents']").click();
	}
	

}
