package com.training.MavenTestNgSelenium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.training.MavenTestNgSelenium.common.browser;

public class Cleartrip  extends browser{

	public static void main(String[] args) throws IOException 
	{
		openBrowser("chrome");
		  
		  driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
		  
		  driver.navigate().to("https://www.cleartrip.com");
    
		  
		  File f;
		  
		f=  ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(f,new File("screenshot/cleartrip.jpg"));
		
	}

}
