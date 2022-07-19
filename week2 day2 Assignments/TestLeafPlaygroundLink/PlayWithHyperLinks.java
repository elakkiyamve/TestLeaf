package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PlayWithHyperLinks {

	public static void main(String[] args) {
		/**
		 * load url "http://leafground.com/pages/Link.html"
		 * 1. go to home page and verify
		 * 2. find link without clicking me

		 * 3. verify broken link
		 * 4. verify home page link
		 *	5. find no of links in current page
		 */ 


		//we have to call wdm for the browser driver
		WebDriverManager.chromedriver().setup();
		//launch the browser
		ChromeDriver driver=new ChromeDriver();
		//navigate to website url
		driver.get("http://leafground.com/pages/Link.html");
		//maximize
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[contains(text(),'Go to Home Page')][1]" )).click(); // click -1st home page link
		System.out.println(driver.findElement(By.xpath("//h1[contains(text(),'Locators')]")).isDisplayed());
		driver.findElement(By.xpath("//h5[contains(text(),'HyperLink')]/following-sibling::img")).click(); //click button --HyperLink
		
		String link = driver.findElement(By.xpath("//a[contains(text(),'Find where am supposed to go without clicking me?')]")).getAttribute("href");
		System.out.println(link);																	// verify link
		
		driver.findElement(By.xpath("//a[contains(text(),'Verify')]")).click();
		String resultingPage = driver.getTitle(); 		//verify broken link
		if(resultingPage.equals("404 Not Found"))
			System.out.println("broken link verified");
		else
			System.out.println("error");
		driver.get("http://leafground.com/pages/Link.html");
		
		driver.findElement(By.xpath("//a[contains(text(),'Go to Home Page')]/following ::div[9]/a")).click(); // clicks 2nd link -- go to home page
		System.out.println(driver.findElement(By.xpath("//h1[contains(text(),'Locators')]")).isDisplayed());
		driver.findElement(By.xpath("//h5[contains(text(),'HyperLink')]/following-sibling::img")).click(); //click button --HyperLink
		
		
		List<WebElement>  elements = driver.findElements(By.cssSelector("a"));
		int index = elements.size();
		System.out.println("Total links available in the page is " + index);

	}

}
