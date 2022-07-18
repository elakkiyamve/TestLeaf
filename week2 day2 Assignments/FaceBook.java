package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBook {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * FaceBook:
================================
// Step 1: Download and set the path 
// Step 2: Launch the chromebrowser
// Step 3: Load the URL https://en-gb.facebook.com/
// Step 4: Maximise the window
// Step 5: Add implicit wait
// Step 6: Click on Create New Account button
// Step 7: Enter the first name
// Step 8: Enter the last name
// Step 9: Enter the mobile number
// Step 10: Enterthe password
// Step 11: Handle all the three drop downs
// Step 12: Select the radio button "Female" 
            ( A normal click will do for this step) 
		 */
		
		//we have to call wdm for the browser driver
				WebDriverManager.chromedriver().setup();
				//launch the browser
				ChromeDriver driver=new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
				//navigate to website url
				driver.get("https://www.facebook.com/");
				
				//maximize
				driver.manage().window().maximize();
						
				driver.findElement(By.xpath("//a[contains(text(),'Create New Account')]")).click();   ///create new account button
				driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("madhu");			//firstname
				driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("mitha");			//lastname
				driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("madhumitha33@gmail.com");		//email
				driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("d@YU600FFb");		//password
				driver.findElement(By.xpath("//select[@name='birthday_day']")).click();
				
				WebElement day =	driver.findElement(By.xpath("//select[@name='birthday_day']"));		//DOB day
				Select selectday = new Select(day);
				selectday.selectByValue("18");
				driver.findElement(By.xpath("//select[@name='birthday_month']")).click();	//DOB month
				WebElement month =	driver.findElement(By.xpath("//select[@name='birthday_month']"));
				Select selectmonth = new Select(month);
				selectmonth.selectByValue("11");
				driver.findElement(By.xpath("//select[@name='birthday_year']")).click();	//DOB year
				WebElement year = driver.findElement(By.xpath("//select[@name='birthday_year']"));
				Select selectyear = new Select(year);
				selectyear.selectByValue("1999");
				driver.findElement(By.xpath("(//div[@class='mtm _5wa2 _5dbb'][1]/span/span/input)[1]")).click();	//radio : female
				driver.findElement(By.xpath("//input[@aria-label = 'Re-enter email address']")).sendKeys("madhumitha33@gmail.com");		//re-enter email
				
				driver.findElement(By.xpath("//div[@class='_1lch']/button")).click();	// sign up
				//sign up done
	
	}

}
