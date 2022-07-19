package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BondWithButtons {

	public static void main(String[] args) {
		/*// http://leafground.com/pages/Button.html
		 * 		1. click button
		 * 		2. find position of button
 		3. find button color
 		4.find the height and width
		 */	
		
		
		//we have to call wdm for the browser driver
		WebDriverManager.chromedriver().setup();
		//launch the browser
		ChromeDriver driver=new ChromeDriver();
		//navigate to website url
		driver.get("http://leafground.com/pages/Button.html");
		//maximize
		driver.manage().window().maximize();


		driver.findElement(By.id("home")).click(); // click button -- go to home page
		System.out.println(driver.findElement(By.xpath("//h1[contains(text(),'Locators')]")).isDisplayed());
		
		driver.findElement(By.xpath("//h5[contains(text(),'Button')]/following-sibling::img")).click(); //click button --Button
		
		WebElement position = driver.findElement(By.id("position")); //  position
		System.out.println(position.getLocation());
		System.out.println(driver.findElement(By.id("color")).getCssValue("background-color")); // color

		System.out.println(driver.findElement(By.id("size")).getSize()); // size

	}

}
