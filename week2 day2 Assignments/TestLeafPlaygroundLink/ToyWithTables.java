package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToyWithTables {

	public static void main(String[] args) {
		/*
		 *	http://www.leafground.com/pages/table.html
		 * 1. Get the count of number of columns
		 * 2. Get the count of number of rows
		 * 3. Get the progress value of 'Learn to interact with Elements'
		 * 4. Check the vital task for the least completed progress.
		 * 
		 * 
		 */
		

		//we have to call wdm for the browser driver
		WebDriverManager.chromedriver().setup();
		//launch the browser
		ChromeDriver driver=new ChromeDriver();
		//navigate to website url
		driver.get("http://leafground.com/pages/table.html");
		//maximize
		driver.manage().window().maximize();
		
		List<WebElement>  column = driver.findElements(By.xpath("//input[@type ='checkbox']"));	// total column count
		int columnIndex = column.size();
		System.out.println("Total row available in the table is " + columnIndex);
		
		List<WebElement>  row = driver.findElements(By.tagName("tr"));	//total row count
		int rowIndex = row.size();
		System.out.println("Total column available in the table is " + rowIndex);

		//Get the progress value of 'Learn to interact with Elements'
		driver.findElement(By.xpath("//font[contains(text(),'Learn to')]/following::font[contains(text(),'30%')]/following::input[1]")).click();
		
		//tick the vital task for the least completed progress.
		driver.findElement(By.xpath("//font[contains(text(),'Learn to')]/following::font[contains(text(),'20%')]/following::input[1]")).click();
		
		
	}

}
