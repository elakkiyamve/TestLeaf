package week4.Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) {
		/*
		 * Assignment 4:Nykaa
		=============
		1) Go to https://www.nykaa.com/
		2) Mouseover on Brands and Search L'Oreal Paris
		3) Click L'Oreal Paris
		4) Check the title contains L'Oreal Paris(Hint-GetTitle)
		5) Click sort By and select customer top rated
		6) Click Category and click Hair->Click haircare->Shampoo
		7) Click->Concern->Color Protection
		8)check whether the Filter is applied with Shampoo
		9) Click on L'Oreal Paris Colour Protect Shampoo
		10) GO to the new window and select size as 175ml
		11) Print the MRP of the product
		12) Click on ADD to BAG
		13) Go to Shopping Bag 
		14) Print the Grand Total amount
		15) Click Proceed
		16) Click on Continue as Guest
		17) Check if this grand total is the same in step 14
		18) Close all windows
		 */

		//we have to call wdm for the browser driver
		WebDriverManager.chromedriver().setup();
		//launch the browser
		ChromeDriver driver=new ChromeDriver();
		//HAndle browser notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//explicit wait
		WebDriverWait wait = new  WebDriverWait(driver,Duration.ofSeconds(5));

		//navigate to website url
		driver.get("https://www.nykaa.com/");

		//maximize
		driver.manage().window().maximize();
		
		//mouse hover brands and search LP
		Actions action = new Actions(driver);
		WebElement brands = driver.findElement(By.xpath("//ul[@class='HeaderNav css-f7ogli'][2]"));
		wait.until(ExpectedConditions.visibilityOf(brands));
		action.moveToElement(brands).perform();
		
		//wait and click LP
		WebElement element = driver.findElement(By.linkText("L'Oreal Paris"));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		String titleLP = driver.getTitle();
		System.out.println(titleLP);
		
		//sort by - customer top rated
		driver.findElement(By.xpath("//span[@class='sort-name']")).click();		
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();		//clicks customer top rated
		
		//Click Category and click Hair->Click haircare->Shampoo
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		WebElement hair = driver.findElement(By.xpath("//span[text()='Hair']"));
		wait.until(ExpectedConditions.elementToBeClickable(hair)).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		
		//click ->concern-> color protection-> verify shampoo product
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		String prodName = driver.findElement(By.xpath("//div[@class='css-1rd7vky']/div")).getText();
		System.out.println(prodName);
		
		//Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElement(By.xpath("//div[@class='css-1rd7vky']/div")).click();
		
		//get new window handles
		String primary = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
		
		//GO to the new window and select size as 175ml
		WebElement dropDown = driver.findElement(By.tagName("select")); 
		Select select = new Select(dropDown);
		select.selectByIndex(1); 
		
		//Print the MRP of the product
		String price = driver.findElement(By.xpath("//span[@class='css-1jczs19']")).getText();
		String bagPrice = price.replace('?',' ');
		System.out.println(bagPrice);
		
		//Click on ADD to BAG & Go to Shopping Bag
		driver.findElement(By.xpath("//span[@class='btn-text']")).click();		//clicks add to bag
		driver.findElement(By.xpath("//button[@class='css-g4vs13']")).click();		//clicks shopping bag icon
		
		//switch to iframe
		driver.switchTo().frame(0);
		
		//Print the Grand Total amount and click proceed
		String grandTotal = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
		String grandPrice = grandTotal.replace('?',' ');
		System.out.println(grandPrice);
		driver.findElement(By.xpath("//span[contains(text(),'Proceed')]")).click();			//clicks proceed

		//get window handle
		driver.switchTo().window(list.get(1));
		
		//Click on Continue as Guest and check the grand total
		driver.findElement(By.xpath("//button[@class='btn full big']")).click(); 	//clicks continue as guest
		String total = driver.findElement(By.xpath("(//div[@class='value'])[2]")).getText();
		String priceTotal = total.replace('?',' ');
		System.out.println(priceTotal);
		
		if(priceTotal.equalsIgnoreCase(grandPrice)) {
			System.out.println("TC (price) passed");
		}
		
		//close all active windows
		driver.close();
		driver.switchTo().window(primary).close();
	}

}
