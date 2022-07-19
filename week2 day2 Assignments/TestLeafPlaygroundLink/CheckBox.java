package week2.day2;



import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {

	public static void main(String[] args) {
		/***
		 * 1. load url http://leafground.com/pages/checkbox.html

		 * 2. select languages that you know
		 * 3.confirm selenium is checked
		 * 4. deselect only checked checkbox
		 * 5. select all checkbox
		*/
		
		
		//we have to call wdm for the browser driver
				WebDriverManager.chromedriver().setup();
				//launch the browser
				ChromeDriver driver=new ChromeDriver();
				//navigate to website url
				driver.get("http://leafground.com/pages/checkbox.html");
				//maximize
				driver.manage().window().maximize();
				
				driver.findElement(By.xpath("//label[contains(text(),'languages')]/following::input[1]")).click();
				driver.findElement(By.xpath("//label[contains(text(),'languages')]/following::input[3]")).click();
				
				boolean selected = driver.findElement(By.xpath("//label[contains(text(),'Confirm Selenium')]/following-sibling::input")).isSelected();
				System.out.println(selected);
				
				boolean Cb1 = driver.findElement(By.xpath("//label[contains(text(),'DeSelect')]/following-sibling::input[1]")).isSelected();
				if (Cb1 == true) {
					driver.findElement(By.xpath("//label[contains(text(),'DeSelect')]/following-sibling::input[1]")).click();
				}
				boolean Cb2 = driver.findElement(By.xpath("//label[contains(text(),'DeSelect')]/following-sibling::input[2]")).isSelected();
				if(Cb2 == true) {
					driver.findElement(By.xpath("//label[contains(text(),'DeSelect')]/following-sibling::input[2]")).click();
				}
				driver.findElement(By.xpath("//label[contains(text(),'checkboxes')]/following::input[1]")).click();
				driver.findElement(By.xpath("//label[contains(text(),'checkboxes')]/following::input[2]")).click();
				driver.findElement(By.xpath("//label[contains(text(),'checkboxes')]/following::input[3]")).click();
				driver.findElement(By.xpath("//label[contains(text(),'checkboxes')]/following::input[4]")).click();
				driver.findElement(By.xpath("//label[contains(text(),'checkboxes')]/following::input[5]")).click();
				driver.findElement(By.xpath("//label[contains(text(),'checkboxes')]/following::input[6]")).click();
				

				
				
				
	}

}
