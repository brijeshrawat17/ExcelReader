package com.training.MavenTestNgSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.training.MavenTestNgSelenium.common.browser;

public class jquery extends browser 
{

	private static void jquery() 
	{
		 driver.get("https://jqueryui.com/slider/");
		 
		 driver.switchTo().frame(0);
			
		  
		  WebElement slider=driver.findElement(By.xpath("//div[@id='slider']"));
	     
		  
		  int maxlength=slider.getSize().width;
		  
		  WebElement handler=driver.findElement(By.xpath("//div[@id='slider']//span"));
		
		  Actions myactions=new Actions(driver);
		  
		  
		  myactions.dragAndDropBy(handler,maxlength/2, 0);
		
		 Action myaction=myactions.build();
			
		  myaction.perform();
		
	}
	
	

	private static void globalspa() 
	{
		
		driver.get("https://jqueryui.com/slider/");
		 
		 driver.switchTo().frame(0);
			
		  
		  WebElement slider=driver.findElement(By.id("slider"));
	     WebElement handle=slider.findElement(By.tagName("span"));
	     
	     
	     Actions myactions=new Actions(driver);
	     
	     myactions.clickAndHold(handle);
	     myactions.moveByOffset(200,0);
	     myactions.release();
	     
	     Action action=myactions.build();
	     action.perform();

	}

	
	
	public static void main(String[] args) {
		 openBrowser("chrome");
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			jquery();
			
			globalspa();
		 
		  
   
		 

	}





}
