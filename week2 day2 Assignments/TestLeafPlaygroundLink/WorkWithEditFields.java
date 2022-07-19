package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkWithEditFields {

	public static void main(String[] args) {
		
/*
		
		* 	Launch the browser  //http://leafground.com/pages/Edit.html
		* 1. Enter the email
		  2. Append a text
		  3. get default text
		  4. clear the text
		  5. confirm that edit field is disabled
*/
		
		//we have to call wdm for the browser driver
		WebDriverManager.chromedriver().setup();
		//launch the browser
		ChromeDriver driver=new ChromeDriver();
		//navigate to website url
		driver.get("http://leafground.com/pages/Edit.html");
		//maximize
		driver.manage().window().maximize();
		
		driver.findElement(By.id("email")).sendKeys("elakkiya@gmail.com");    // enter email
		WebElement element = driver.findElement(By.xpath("//input[@value='Append ']"));  //append a text
		element.sendKeys("append text",Keys.TAB);
		element.sendKeys("again",Keys.ENTER);
		
		String text = driver.findElement(By.xpath("//input[@value='TestLeaf']")).getAttribute("value"); // get default text
		System.out.println(text);
		
		driver.findElement(By.xpath("//input[@value='Clear me!!']")).clear(); // clear the text
		
		boolean result = driver.findElement(By.xpath("//label[contains(text(),'disabled')]")).isEnabled();
		System.out.println(result);
		
	}

}
