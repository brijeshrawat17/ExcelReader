package com.training.MavenTestNgSelenium.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.training.MavenTestNgSelenium.common.browser;






public class myntramouseAction extends browser{

	public static void main(String[] args) 
	{
		  openBrowser("chrome");
		
		  driver.get("https://www.myntra.com/");
		  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    
		  
		  Actions myactions=new Actions(driver);
		  
		  myactions.moveToElement(driver.findElement(By.xpath("//a[text()='Home & Living' and @class='desktop-main']")));
		  
		  myactions.pause(5000);
		  
		  myactions.moveToElement(driver.findElement(By.xpath("//a[text()='Men' and @class='desktop-main']")));
		  
		  
		  
		  Action myaction=myactions.build();
		
		  myaction.perform();
	}

}
