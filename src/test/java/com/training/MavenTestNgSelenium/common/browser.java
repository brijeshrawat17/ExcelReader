package com.training.MavenTestNgSelenium.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class browser 
{
	public static WebDriver driver;
	protected static void setProperties()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Tools\\Selenium\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","C:\\Tools\\\\Selenium\\geckodriver.exe");
	}
	protected static void openBrowser(String browser)
	{
		setProperties();
	if(browser.equalsIgnoreCase("Chrome"))
	{
	 driver=new ChromeDriver();//open Browser
	 driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
	
	}
	
	else
	{
		setProperties();
		 driver=new FirefoxDriver();
		 driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
	}
	
	}
}
