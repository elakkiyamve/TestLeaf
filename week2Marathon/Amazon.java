package Marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		/*//Testcase 1 (Amazon)
		01) Launch Chome
	02) Load https://www.amazon.in/
	03) Type "Bags" in the Search box
	04) Choose the third displayed item in the result (bags for boys)
	05) Print the total number of results (like 30000)
	    1-48 of over 30,000 results for "bags for boys"
	06) Select the first 2 brands in the left menu
	    (like American Tourister, Generic)
	07) Confirm the results have got reduced (use step 05 for compare)
	08) Choose New Arrivals (Sort)
	09) Print the first resulting bag info (name, discounted price)
	10) Confirm the color of the 'Deal of the day' is in kind of Red
	11) Click on the First Deal of the day
	12) Confirm the price on previous and this page are same 
	13) Take screenshot and close
*/

		//we have to call wdm for the browser driver
		WebDriverManager.chromedriver().setup();
		//launch the browser
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//navigate to website url
		driver.get("https://www.amazon.in/");

		//maximize
		driver.manage().window().maximize();
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bags");			// search bags
		driver.findElement(By.xpath("//span[contains(text(),'for boys')]")).click();			//search bags for boys
		String text = driver.findElement(By.xpath("//div[@class = 'a-section a-spacing-small a-spacing-top-small']/span")).getText();	// result 1
		System.out.println(text);
		String[] reslt = text.split(" ");
		System.out.println(reslt[3].toString());
		
		driver.findElement(By.xpath("(//ul[@class = 'a-unordered-list a-nostyle a-vertical a-spacing-medium'])[4]/li[1]")).click(); //select brand1
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//ul[@class = 'a-unordered-list a-nostyle a-vertical a-spacing-medium'])[3]/li[4]")).click();	//select brand2
		String result = driver.findElement(By.xpath("//div[@class = 'a-section a-spacing-small a-spacing-top-small']/span")).getText(); // result 2
		System.out.println(result);
		String[] reslt2 = text.split(" ");
		System.out.println(reslt2[3].toString());
		if(reslt.equals(reslt2)) {
			System.out.println("no filter applied");
		}
		else {
			System.out.println("filtered");
		}
			
		driver.findElement(By.xpath("(//span[@class ='a-button-inner'])[1]")).click();    //sort by
		driver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();	//newest
	
		String cssValue = driver.findElement(By.xpath("//span[@id='DEAL_OF_THE_DAY_B0B3J2R6VP']")).getCssValue("rgb"); 	//rgb color od deal of the day
		System.out.println(cssValue);
		
		Thread.sleep(2000);
		String price = driver.findElement(By.xpath("//span[contains(text(),'Price and other details')]/following::div[@class='a-row a-size-base a-color-base']/a/span/span")).getText();
		System.out.println(price);		// price of 1st resulting element
		driver.findElement(By.xpath("//span[@class='a-price-whole']")).click();		//click price
		String cprice = driver.findElement(By.xpath("//span[@class='a-badge-label']/following::span[@class ='a-price']/span")).getText(); 	//get confirmed price value
		System.out.println(cprice);
		
		if(price.equals(cprice)) {
			System.out.println("confirmed price value is" + cprice);
		}
		
		Thread.sleep(3000);
		File source= driver.getScreenshotAs(OutputType.FILE); 
		File dest = new File("C:\\Testleaf\\Selenium\\Screenshots\\screen.png");
		FileUtils.copyFile(source, dest);

		
		
		
		
		
	}

}
