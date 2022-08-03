package week4.Assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
//import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws IOException, InterruptedException {
		/*
		 * Assignment 5:SnapDeal
		============
		1. Launch https://www.snapdeal.com/
		2. Go to Mens Fashion
		3. Go to Sports Shoes
		4. Get the count of the sports shoes
		5. Click Training shoes
		6. Sort by Low to High
		7. Check if the items displayed are sorted correctly
		8.Select the price range (900-1200)
		9.Filter with color Navy 
		10 verify the all applied filters 
		11. Mouse Hover on first resulting Training shoes
		12. click QuickView button
		13. Print the cost and the discount percentage
		14. Take the snapshot of the shoes.
		15. Close the current window
		16. Close the main window
		 */

		//we have to call wdm for the browser driver
		WebDriverManager.chromedriver().setup();
		//launch the browser
		ChromeDriver driver=new ChromeDriver();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//explicit wait
		WebDriverWait wait = new  WebDriverWait(driver,Duration.ofSeconds(10));

		//navigate to website url
		driver.get("https://www.snapdeal.com/");
		//HAndle browser notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		//maximize
		driver.manage().window().maximize();
		options.addArguments("--disable-notifications");
		driver.getTitle();
		System.out.println(driver.getTitle());

		//Go to Mens Fashion and Sports Shoes, get the count
		Actions action = new Actions(driver);

		try {
			WebElement	mFashion = driver.findElement(By.xpath("//span[@class='catText']"));
			action.moveToElement(mFashion).perform();
		} catch (NoSuchElementException e) {
			WebElement	mFashion = driver.findElement(By.xpath("//li[@class='navlink']/a"));
			wait.until(ExpectedConditions.visibilityOf(mFashion));
			action.moveToElement(mFashion).perform();
		} 


		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click(); 		//clicks sports shoes
		String items = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
		System.out.println("sports shoes items count : "+items);			//get count

		//Click Training shoes & Sort by Low to High
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();		//clicks training shoes
		driver.findElement(By.className("sort-selected")).click();			//clicks sort by
		driver.findElement(By.xpath("//li[@data-sorttype='plth']")).click();		//clicks price low to high

		//Check if the items displayed are sorted correctly
		List<WebElement> list2 = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//span[@class='lfloat product-price']"), 10));
		System.out.println(list2.size());

		try {
			for (WebElement webElement : list2) {
				String	text2 = webElement.getText();
				System.out.println(text2);
			}
		} catch (StaleElementReferenceException e) {
			wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//span[@class='lfloat product-price']"), 10));
			List<WebElement> li = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
			for (WebElement webElement : li) {
				String	text2 = webElement.getText();
				System.out.println(text2);	
			}
		}

		//Select the price range (900-1200) and filter with color navy
		WebElement to = driver.findElement(By.xpath("(//a[starts-with(@class, 'price-slider-scroll')])[2]"));
		WebElement scroll = driver.findElement(By.xpath("(//div[@class='filter-type-name lfloat'])[2]"));

		//actions class performance of dragAndDropBy
		action.moveToElement(scroll).perform();
		//action.dragAndDropBy(from, 42, 0).perform();		//commenting to get navy product
		action.dragAndDropBy(to, -88, 0).perform();
		System.out.println("done");
		
		//filter color navy
		action.scrollToElement(scroll).perform();
		WebElement navy= driver.findElement(By.xpath("//a[@class='filter-name' and text()='Navy']"));
		driver.executeScript("arguments[0].click();", navy);	// repeated elementclickIntercepted exception

		//verify the all applied filters 
		boolean priceSelected = driver.findElement(By.xpath("//a[@class='clear-filter-pill']")).isDisplayed();		//check price filter
		System.out.println("price filtered : " + priceSelected );
		boolean colorSelected = driver.findElement(By.xpath("(//a[@class='clear-filter-pill'])[2]")).isDisplayed();		//check color filter
		System.out.println("price filtered : " + colorSelected );
		
		List<WebElement> list3 = driver.findElements(By.xpath("//div[@class='top-cat-name 'or @class='sub-cat-name 'or @class='child-cat-name ' or @class='child-cat-name selected']"));
		System.out.println(list3.size());
		for (WebElement webElement : list3) {
			wait.until(ExpectedConditions.visibilityOfAllElements(list3));
			String text3= webElement.getText();
			System.out.println("filter applied in category : " + text3);		//filter under category tab
		}
				
		//Mouse Hover on first resulting Training shoes
		WebElement hover = driver.findElement(By.xpath("//p[text()='Columbus Navy Training Shoes']"));
		WebElement firstResult = driver.findElement(By.xpath("//div[contains(@class,'center quick-view-bar')]"));
		action.moveToElement(hover).moveToElement(firstResult).click(firstResult).build().perform();			//click QuickView button
		
		//print the cost and the discount percentage
		String amount = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();		//get cost
		String disc = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();		//get discount
		System.out.println("price of the show : " + amount + "and the discount% : " + disc);
		
		//take snapshot
		File source= driver.getScreenshotAs(OutputType.FILE); 
		File dest = new File("C:\\Testleaf\\Selenium\\Screenshots\\screen.png");
		FileUtils.copyFile(source, dest);

	}

}
