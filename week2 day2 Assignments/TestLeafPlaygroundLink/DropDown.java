package week2.day2;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

	public static void main(String[] args) throws InterruptedException {
		// http://www.leafground.com/pages/Dropdown.html
		/*1. selection using index
		 * 2. selection using text
		 * 3. selection using value
		 * 4. get total number of dropdown options
		 * 5.selection using sendkeys
		 * 6.select multiple
		 * 
		 * 
		 */



		//we have to call wdm for the browser driver
		WebDriverManager.chromedriver().setup();
		//launch the browser
		ChromeDriver driver=new ChromeDriver();
		//navigate to website url
		driver.get("http://leafground.com/pages/Dropdown.html");
		//maximize
		driver.manage().window().maximize();
		
		WebElement byIndex = driver.findElement(By.id("dropdown1"));  //selection using index
		Select a = new Select(byIndex);
		a.selectByIndex(2);

		WebElement byText = driver.findElement(By.name("dropdown2"));	//selection using text
		Select b = new Select(byText);
		b.selectByVisibleText("Selenium");

		WebElement byValue = driver.findElement(By.id("dropdown3"));  //selection using value
		Select c = new Select(byValue);
		c.selectByValue("4");

		WebElement total = driver.findElement(By.className("dropdown"));	//get total number of dropdown options
		Select d = new Select(total);

		List<WebElement> options = d.getOptions();
		int f = options.size();
		System.out.println(f);

		//if cursor not mouse hover...element not interactable exception will occur
		driver.findElement(By.xpath("//div[@class='example'][5]")).click();
		driver.findElement(By.xpath("//div[@id='contentblock']/section/div[5]/select")).sendKeys("Loadrunner",Keys.ENTER);
		 
		//select multiple cntrl + element 
		Actions actions = new Actions(driver);
				actions = actions.keyDown(Keys.CONTROL);
				actions = actions.click(driver.findElement(By.xpath("//div[@id='contentblock']/section/div[6]/select/option[2]")));
				actions = actions.click(driver.findElement(By.xpath("//div[@id='contentblock']/section/div[6]/select/option[3]")));
				actions = actions.keyUp(Keys.CONTROL);
				actions.perform();
		
	}
}