package LambdaTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TC002 extends ProjectSpecificMethods{

	String browsername = "firefox";
	@Test
	public void login()  {

		driver.findElement(By.xpath("//p[text()='Progress Bar & Sliders']")).click();
		driver.findElement(By.linkText("Drag & Drop Sliders")).click();
		WebElement dd = driver.findElement(By.xpath("(//input[@class='sp__range'])[3]/following-sibling::output"));
		Actions act = new Actions(driver);
		act.dragAndDropBy(dd, 0, 12);
	}
}
