package week2.day2;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InteractWithImages {

	public static void main(String[] args) {
/*
		
		* 	Launch the browser  //http://leafground.com/pages/Image.html
		* 1. click on image to traverse to home page
		  2. verify broken image
		  3. click on image using keyboard or mouse
		  4.  confirm that the image is selected
*/
		
		//we have to call wdm for the browser driver
		WebDriverManager.chromedriver().setup();
		//launch the browser
		ChromeDriver driver=new ChromeDriver();
		//navigate to website url
		driver.get("http://leafground.com/pages/Image.html");
		//maximize
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath(" //label[contains(text(),'Click on this image ')]/following-sibling::img")).click();
		System.out.println(driver.findElement(By.xpath("//h1[contains(text(),'Locators')]")).isDisplayed());
		driver.findElement(By.xpath("//h5[contains(text(),'Image')]/following-sibling::img")).click(); //click button --Image
		
		
		boolean selected = driver.findElement(By.xpath("//label[contains(text(),'Broken Image')]/following-sibling::img")).isSelected();
		
		if(selected != true)
			System.out.println("Image is broken");
		
		WebElement element = driver.findElement(By.xpath("//label[contains(text(),'Mouse')]/following-sibling::img"));
		Actions action =new Actions(driver);
		action.click(element).perform();
		System.out.println(driver.findElement(By.xpath("//h1[contains(text(),'Locators')]")).isDisplayed());
		System.out.println("Action performed");
	}

}
