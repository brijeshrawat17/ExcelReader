package com.training.MavenTestNgSelenium.project;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlipkartClassTest extends FlipkartBaseTest 
{
     @Test
	public void Testflipkart() throws IOException, InterruptedException
	{
    	
		  String searchstring = "fitbit";
		  WebElement searchbox= driver.findElement(By.name("q"));
		  searchbox.sendKeys(searchstring);
		  WebElement search= driver.findElement(By.xpath("//button[@class='L0Z3Pu']"));
		  search.click();
		 
		
	      
	      
	       String text = driver.findElement(By.className("_10Ermr")).getText();
	       System.out.println(text);
	       int startingindex = text.indexOf("of");
	       System.out.println(startingindex);
	       int endingindex = text.indexOf("results");
	       
	       String numberofitems = text.substring(startingindex+3, endingindex-1);
	       System.out.println(numberofitems);
	       Integer searchresult=Integer.parseInt(numberofitems);
	     
	       Assert.assertTrue(searchresult>900);
	    
	       
	      
	        WebElement firstlink= driver.findElement(By.xpath("//a[@class='s1Q9rs']"));
			firstlink.click();
			
			WindowHandles();
		
			
			
			screenshot();
		
        
           
			WebElement finalprice= driver.findElement(By.xpath("//*[@class='_30jeq3 _16Jk6d']"));
			String Finalpric=finalprice.getText();
			System.out.println("Final price is : "+Finalpric);
			
			WebElement actualPrice= driver.findElement(By.xpath("//*[@class='_3I9_wc _2p6lqe']"));
			
			String ActualPrice=actualPrice.getText();
			System.out.println("Actual price is : "+ActualPrice);
			
		    String  Finalprice= Finalpric.replace("₹","");
		    
			Finalprice=Finalprice.replace(",","");
			
			Float Final=Float.parseFloat(Finalprice);
			System.out.println("Final in : "+Final);
			
			ActualPrice= ActualPrice.replace("₹","");
			ActualPrice=ActualPrice.replace(",","");
			
			Float Actual=Float.parseFloat(ActualPrice);
		    System.out.println("Actual in : "+Actual);
		    
		    int discount=Math.round(((Actual-Final)/Actual)*100);
		    
		    System.out.println("Discount Percent is: "+discount+" %");
		    String s=String.valueOf(discount);  
		    

		    String percent = driver.findElement(By.xpath("//div[@class='_3Ay6Sb _31Dcoz']//span[1]")).getText();
		    percent=percent.replace(" %","");
		  
		    if(percent.contains(s))
		    {
		    	System.out.println("Discount that is written in site is correct ");
		    }
		    else 
		    {
		    	System.out.println("Discount that is written in site is not correct ");
	        }
		  
		    driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww' and text()='ADD TO CART']")).click(); 
		    
		    String cartPrice = driver.findElement(By.xpath("//div[@class='Ob17DV _3X7Jj1']//span[1]")).getText();
		      
		    Assert.assertTrue(Finalpric.contains(cartPrice)); 
		 
	
	
	


	}
     
     
     
 	
 	protected void screenshot() throws IOException {
 		File f;
 		f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
 		FileUtils.copyFile(f,new File("screenshot/productimage.jpg"));
 		
 		
 	}
 	

 	protected void WindowHandles()
    {
 		Set<String> handles = driver.getWindowHandles();
 		System.out.println("No. of windows open: "+handles.size());
 		
 		Iterator<String> iter = handles.iterator();
 		
 		while(iter.hasNext()) 
 		{
 			String handle = iter.next();
 			
 			driver.switchTo().window(handle);
 			String title=driver.getTitle();
 			 Assert.assertTrue(driver.getTitle().contains(title)); 
 			 
 	}
 		
 		
 	
        System.out.println("handles successful");
 	}



}
