package week2.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafTabsGround {

	public static void main(String[] args) throws IOException  {
		//we have to call wdm for the browser driver
		WebDriverManager.chromedriver().setup();
		//launch the browser
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//navigate to website url
		driver.get("https://www.zoomcar.com/in/bangalore");
		
		//maximize
		driver.manage().window().maximize();
			
		driver.findElement(By.xpath("//div[@class='placeholder']")).click();
		// driver.findElement(By.xpath("(//h3[text()='Suggested Pick Up Locations']/following::div[1])/div")) //not valid xpath
		driver.findElement(By.xpath("//h3[text()='Suggested Pick Up Locations']/following::div[@class='pointer'][1]/div")).click();
		driver.findElement(By.className("field-date")).click();
		driver.findElement(By.xpath("//td[contains(text(),'19')]")).click();
		driver.findElement(By.xpath("//td[contains(text(),'19')]")).click();
		driver.findElement(By.xpath("(//button[contains(text(),'Continue')])")).click();
		driver.findElement(By.xpath("(//button[contains(text(),'Find cars')])")).click();
	
		String price = driver.findElement(By.xpath("(//h3[text()='Maruti Swift Dzire']/following::div[@class='price-book-ctr']/div/div)[1]")).getText();
		System.out.println(price.replace("₹ ", ""));
		 
		
		File source= driver.getScreenshotAs(OutputType.FILE); 
		File dest = new File("C:\\Testleaf\\Selenium\\src\\main\\java\\Screenshots\\screen.png");
		FileUtils.copyFile(source, dest);
	}



}