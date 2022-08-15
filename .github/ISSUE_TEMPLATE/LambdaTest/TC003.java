package LambdaTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC003 extends ProjectSpecificMethods {

	String browsername = "chrome";
	String text="Thanks for contacting us, we will get back to you shortly.";
	@Test
	public void login() {
		driver.findElement(By.xpath("//p[@class='inline-block']")).click();
		driver.findElement(By.linkText("Input Form Submit")).click();
		driver.findElement(By.id("name")).sendKeys("");
		Assert.assertTrue(false);
		driver.findElement(By.id("name")).sendKeys("name");
		driver.findElement(By.name("email")).sendKeys("mail@gmail.com");
		driver.findElement(By.id("inputPassword4")).sendKeys("v@123");
		driver.findElement(By.id("company")).sendKeys("company");
		driver.findElement(By.id("websitename")).sendKeys("Website name");
		WebElement country = driver.findElement(By.tagName("select")); 
		Select select = new Select(country);
				select.selectByVisibleText("India"); 
		driver.findElement(By.id("inputCity")).sendKeys("city");
		driver.findElement(By.id("inputAddress1")).sendKeys("address");
		driver.findElement(By.id("inputAddress2")).sendKeys("address");
		driver.findElement(By.id("inputState")).sendKeys("state");
		driver.findElement(By.id("inputZip")).sendKeys("639004");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String thanksForContacting = driver.findElement(By.xpath("//p[@class='success-msg hidden']")).getText();
		if(text.equals(thanksForContacting))
			System.out.println("success");
	}
}
