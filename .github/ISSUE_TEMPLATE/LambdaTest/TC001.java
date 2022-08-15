package LambdaTest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TC001 extends ProjectSpecificMethods{

	String browsername = "chrome";
	@Test
	public void login(String url, String variable)  {

		driver.findElement(By.linkText("Simple Form Demo")).click();
		String getURL = driver.getCurrentUrl();
		if(getURL.contentEquals(url+"simple-form-demo"))
			System.out.println(getURL);
		
		driver.findElement(By.xpath("//input[@id='user-message']")).sendKeys(variable);
		driver.findElement(By.id("showInput")).click();
		String welcomeToLambdaTest = driver.findElement(By.xpath("//div[@id='user-message']//p")).getText();
		if(variable.equals(welcomeToLambdaTest))
			System.out.println("success");
	}
}
