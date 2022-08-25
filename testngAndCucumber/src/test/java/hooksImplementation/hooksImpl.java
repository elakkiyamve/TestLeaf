package hooksImplementation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import stepPages.ProjectSpecificMethods;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class hooksImpl extends ProjectSpecificMethods {
			
			@After
			public void afterStep() throws IOException {
				System.out.println("take screenshot");
				File source= driver.getScreenshotAs(OutputType.FILE); 
				File dest = new File("C:\\Testleaf\\Cucumber\\Screenshots\\screen"+i+".png");
				FileUtils.copyFile(source, dest);
				i++;
			}
			
			
}
