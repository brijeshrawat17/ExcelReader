package com.training.MavenTestNgSelenium.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.training.MavenTestNgSelenium.common.browser;




public class GoogleSearchResult extends browser
{

	

	private static void searchGoogle(String string) {
		
		 openBrowser("chrome");
	      
	      driver.navigate().to("https://www.google.com");
	      
	      WebElement searchbox=driver.findElement(By.name("q"));
	      
	      //searchbox.sendKeys("Selenium");
	     
	     
	   
	      //searchbox.sendKeys(Keys.ENTER);
	   
	     driver.findElement(By.name("btnK")).submit();
		
	}
	public static void main(String[] args) 
	{
		 searchGoogle("Selenium");
		
		String firstLink=driver.findElement(By.tagName("h3")).getText();
		System.out.println(firstLink);
	
		List<WebElement> alllinks= driver.findElements(By.tagName("h3"));
		
		alllinks.forEach(l->{
			if(!l.getText().equalsIgnoreCase(""))
			{
				System.out.println(l.getText());
			}
		});
   

		for(int i=0; i<alllinks.size(); i++){
			WebElement webelement =alllinks.get(i);
	           if(webelement.getText().contentEquals(""))
	           {
	              
	               alllinks.remove(i);
	           }
	       }
		
		
	   
	   
		
		driver.quit();
		
	}


}
