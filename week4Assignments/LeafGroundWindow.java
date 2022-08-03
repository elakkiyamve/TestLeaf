package week4.Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundWindow {

	public static void main(String[] args) throws InterruptedException {
		//we have to call wdm for the browser driver
		WebDriverManager.chromedriver().setup();
		//launch the browser
		ChromeDriver driver=new ChromeDriver();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//explicit wait
		WebDriverWait wait = new  WebDriverWait(driver,Duration.ofSeconds(5));

		//primary window handle
		String primary = driver.getWindowHandle();

		//navigate to website url
		driver.get("https://leafground.com/pages/Window.html");

		//maximize
		driver.manage().window().maximize();

		//clicks open home page
		driver.findElement(By.id("home")).click();

		//wait for windows to open
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		//get window handles
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("Window handles size: " + windowHandles.size());

		List<String> window = new ArrayList<String>(windowHandles);
		String secWindow = window.get(1);

		driver.switchTo().window(secWindow);
		driver.close();
		//switch to primary window
		driver.switchTo().window(primary);
		
		//clicks open multiple windows
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		
				//get window handles
				Set<String> windHandles = driver.getWindowHandles();
				wait.until(ExpectedConditions.numberOfWindowsToBe(windHandles.size()));
				System.out.println("Window handles size: " + windHandles.size());
								
		//clicks button Do not close me 
		driver.findElement(By.xpath("//button[contains(text(),'Do not close me')]")).click();
				
				//get window handles
				Set<String> windHand = driver.getWindowHandles();
				System.out.println("Window handles size: " + windHand.size());
				wait.until(ExpectedConditions.numberOfWindowsToBe(5));
				List<String> w = new ArrayList<String>(windHand);
				
				System.out.println(w);
				driver.switchTo().window(w.get(1));
				driver.close();
				driver.switchTo().window(w.get(2));
				driver.close();
				driver.switchTo().window(w.get(3));
				driver.close();
				driver.switchTo().window(w.get(4));
				driver.close();
				System.out.println("drivers closed");
				
				//switch to primary
				driver.switchTo().window(primary);
				
				System.out.println(driver.getTitle());
				
			//clicks wait for 5 seconds button
				driver.findElement(By.xpath("//button[contains(text(),'Wait for 5 seconds')]")).click();
				//get window handles
				Set<String> wiHand = driver.getWindowHandles();
				System.out.println("Window handles size: " + wiHand.size());
				
				driver.quit();
				

	}

}
