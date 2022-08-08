package Marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws IOException, InterruptedException {

		/*
		 * Testcase 3 (BookMyShow)
01) Launch Edge / Chrome
02) Load https://in.bookmyshow.com/
03) Type the city as "Hyderabad" in Select City
04) Confirm the URL has got loaded with Hyderabad 
05) Search for your favorite movie 
06) Click Book Tickets
07) Print the name of the theater displayed first
08) Click on the info of the theater
09) Confirm if there is a parking facility in the theater
10) Close the theater popup
11) Click on the first green (available) timing
12) Click Accept
13) Choose 1 Seat and Click Select Seats
14) Choose any available ticket and Click Pay
15) Print the sub total
16) Take screenshot and close browser
		 * 
		 * 
		 */

		//we have to call wdm for the browser driver
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//navigate to website url
		driver.get("https://www.redbus.in/");

		//maximize
		driver.manage().window().maximize();
		
		driver.findElement(By.id("src")).sendKeys("Chennai");		//search source chennai
		driver.findElement(By.xpath("//li[@class = 'selected']")).click();	//clicks 1st resulting value
		
		driver.findElement(By.id("dest")).sendKeys("Bangalore");	//search dest bangalore
		driver.findElement(By.xpath("//li[@class = 'selected']")).click();	//clicks 1st resulting value
		
		driver.findElement(By.xpath("//label[contains(text(),'Date')]/preceding-sibling::input")).click();	//clicks date 
		String Today = driver.findElement(By.xpath("//td[@class='current day']")).getText();		//get today date
		System.out.println(Today);
		driver.findElement(By.xpath("//td[@class='current day']/following::td[1]")).click();		//clicks next date from tday date
		
		driver.findElement(By.id("search_btn")).click();		//click search buses
		
		String buses = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText(); //no of buses available
		String num = buses.replaceAll("[a-zA-Z]", "");
		System.out.println(num);
		
		driver.findElement(By.xpath("(//label[@for='bt_SEATER'])[2]")).click();  //clicks seater checkbox
		String text = driver.findElement(By.xpath("(//li[@class= 'row-sec clearfix'])[2]/div/div/div/div/div/following-sibling::div")).getText();
		System.out.println(text);
		
		
		driver.findElement(By.xpath("(//div[contains(text(),'View Seats')])[2]")).click(); 	//click view seats
		
		Thread.sleep(2000);
		File source= driver.getScreenshotAs(OutputType.FILE); 
		File dest = new File("C:\\Testleaf\\Selenium\\Screenshots\\screen.png");
		FileUtils.copyFile(source, dest);
	}

}
