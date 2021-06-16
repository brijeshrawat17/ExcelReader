package com.training.MavenTestNgSelenium.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.training.MavenTestNgSelenium.common.browser;

public class Rediff extends browser
{
	static String Fullname="Brijesh Singh Rawat";
	static String emailid="rawatbrijesh17@rediffmail.com";
	
	 static String password="brijesh";
   
	
	
	private static void fillDetail() 
	
	{
		 driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
		WebElement name=driver.findElement(By.xpath("//input[contains(@maxlength,'61')]"));
		name.sendKeys(Fullname);
		
		driver.findElement(By.xpath("//input[starts-with(@name,'login')]")).sendKeys(emailid);
		
		driver.findElement(By.xpath("//input[starts-with(@name,'passwd')]")).sendKeys(password);
		
		driver.findElement(By.xpath("//input[starts-with(@name,'confirm')]")).sendKeys(password);
		
		driver.findElement(By.xpath("//input[starts-with(@name,'altemail')]")).sendKeys(emailid);
		
		driver.findElement(By.xpath("//input[starts-with(@name,'mob')]")).sendKeys("7409310811");
		
		driver.findElement(By.xpath("//*[starts-with(@name, 'gender') and @value='m']")).click();
		
		
		new Select(driver.findElement(By.xpath("//select[starts-with(@name,'DOB_Day')]"))).selectByVisibleText("17");
		new Select(driver.findElement(By.xpath("//select[starts-with(@name,'DOB_Month')]"))).selectByVisibleText("JUL");
		new Select(driver.findElement(By.xpath("//select[starts-with(@name,'DOB_Year')]"))).selectByVisibleText("1996");
		
		
	    new Select(driver.findElement(By.id("country"))).selectByVisibleText("India");
		
		new Select(driver.findElement(By.xpath("//select[starts-with(@name,'city')]"))).selectByVisibleText("Pune");
		
		
		
		WebElement altemail = driver.findElement(By.xpath("//*[starts-with(@name, 'altemail')]"));
		
		WebElement checkbox = driver.findElement(By.xpath("//*[starts-with(@name, 'chk_altemail')]"));
		
		checkbox.click();
		
		if(!checkbox.isSelected()) 
		{
			checkbox.click();
		} 
		else 
		{
			System.out.println("Checkbox already selected");
		}
		
		
		if(!altemail.isDisplayed()) 
		{
			System.out.println("Alt Email Disappeared");
		}
		
		
		
		
		driver.findElement(By.id("Register")).click();
		
		String expected="The ID field  accepts letters,numbers & underscore.";
	   
		Alert myalert=driver.switchTo().alert();
		String actual=myalert.getText();


		if(actual.contains(expected))
		{
			System.out.println("test passed");
			myalert.accept();
		
			
		}
		else
		{
			System.out.println("test fail");
			
		}
		
		driver.close();
		
	}


	public static void main(String[] args) 
	{
		openBrowser("chrome");
		  
		  driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
		  
		  driver.navigate().to("https://register.rediff.com/register/register.php");
		  
		fillDetail();

	}




}
