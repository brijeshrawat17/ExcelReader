package com.training.MavenTestNgSelenium.ExcelReader;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class TestNGBrowser 
{
	
	protected WebDriver driver;
	protected WebElement searchbox;
	protected WebElement searchbutton;
	protected String browser;
	
	@BeforeTest
	protected void openBrowser() 
	{
		browser = "Chrome";
		//Windows OS
	
		switch (browser) {
			case "Firefox":
				System.setProperty("webdriver.gecko.driver","C:\\Tools\\\\Selenium\\geckodriver.exe");
				driver = new FirefoxDriver();
				break;
			case "Chrome":
				System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Selenium\\chromedriver.exe"); 
				driver = new ChromeDriver();
				break;
			default:
				System.out.println("You requested for another browser which is not available. Hence running this script on Google Chrome");
				driver = new ChromeDriver();
				break;
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterTest
	protected void tearDown() {
		driver.quit();
	}

	@BeforeMethod
	protected void resetBrowser() 
	{
		driver.navigate().to("https://www.google.com");
		searchbox = driver.findElement(By.name("q"));
		searchbutton = driver.findElement(By.name("btnK"));
	}
	
	
	
	protected void waitForTitleToContain(String searchString) {
		WebDriverWait myWait = new WebDriverWait(driver, 5);
		myWait.until(ExpectedConditions.titleContains(searchString));
	}

}