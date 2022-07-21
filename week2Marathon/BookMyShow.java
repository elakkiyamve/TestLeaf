package Marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BookMyShow {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		/*//https://in.bookmyshow.com/
		 * 
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
		 */

		//we have to call wdm for the browser driver
		WebDriverManager.chromedriver().setup();
		//launch the browser
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//navigate to website url
		driver.get("https://in.bookmyshow.com/");

		//maximize
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@class='sc-jvEmr elijMA']")).sendKeys("Chennai",Keys.ENTER); 	//search chennai
		
			String url = driver.getCurrentUrl();
			System.out.println(url);
		
		driver.findElement(By.xpath("//span[contains(text(),'Search for Movies')]")).click();		//search movies
		driver.findElement(By.xpath("//input[@class='sc-jvEmr elijMA']")).sendKeys("Rocketry", Keys.ENTER);		//search rocketry and enter
		
		driver.findElement(By.xpath("//div[@class='sc-1vmod7e-2 iBonLL']//span")).click(); 	//click book tickets
		driver.findElement(By.xpath("(//li[@class ='sc-vhz3gb-0 fySqsk'])[2]/section[2]/div")).click();		//click tamil 2d
		
		String theatre = driver.findElement(By.xpath("//div[@class='details']/div/div/a")).getText();	// get theatre name of 1st resulting value 
	System.out.println(theatre);
	
	driver.findElement(By.xpath("//div[@class = 'wzrk-button-container']/button")).click();  // not now personilaized updates
		driver.findElement(By.xpath("(//div[@class='venue-info-text'])[1]")).click();		//clicks info icon
		
		String texts = driver.findElement(By.xpath("//div[@class = 'venue-facilities']")).getText();	//venue facilities-all
		System.out.println(texts);
			
		driver.findElement(By.xpath("//div[@class='cross-container']")).click(); //close the theatre popup
		
	driver.findElement(By.xpath("//div[@class='__details']")).click(); 			//movie timings
	driver.findElement(By.id("btnPopupAccept")).click();	// clicks on accept
	driver.findElement(By.id("pop_1")).click();				//click 1 seat
	driver.findElement(By.id("proceed-Qty")).click();		//click proceed
	driver.findElement(By.xpath("(//a[@class ='_available'])[1]")).click(); // find 1st available seat
	driver.findElement(By.xpath("(//a[@id='btmcntbook'])[1]")).click(); //click pay
	String subTotal = driver.findElement(By.xpath("(//a[@id='btmcntbook'])[1]")).getText();	//get sub total
	System.out.println(subTotal);
	Thread.sleep(3000);
	File source= driver.getScreenshotAs(OutputType.FILE); 
	File dest = new File("C:\\Testleaf\\Selenium\\Screenshots\\screen.png");
	FileUtils.copyFile(source, dest);

	
	}

}
