package com.training.MavenTestNgSelenium.tesngExample;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class GoogleTest {
	
	private WebElement searchbox;
	private WebDriver driver;
	private List<WebElement> suggestionslist;
	private WebElement searchbutton;
	
	@BeforeTest //Only runs Once before ALL the tests
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Selenium\\chromedriver.exe"); //Windows OS
	
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	//1. Searching Google
	@Test
	public void testGoogleSearch() throws InterruptedException {
		//Enter string in searchbox
		String searchstring = "Selenium";
		searchbox.sendKeys(searchstring);
		
		//Submit the search
		searchbox.submit();
		
		WebDriverWait myWait = new WebDriverWait(driver,5);
		myWait.until(ExpectedConditions.titleContains(searchstring));
		
		//Verify that the title of new page contains the searchstring
		String expected = searchstring + " - Google Search";
		String actual = driver.getTitle();
		
		System.out.println(actual);
		
		//Assert.assertTrue(actual.contains(expected), "Titles do not match. Actual title is: "+actual+ " expected is :"+expected);
		//Assert.assertTrue(actual.contains(expected));
		Assert.assertEquals(actual, expected);
	}
	
	//2. Suggestions List
	@Test
	public void testSuggestions() {
		
		String searchstring = "maven";
		searchbox.sendKeys(searchstring);
		
		WebDriverWait myWait = new WebDriverWait(driver, 5);
		myWait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//li[@data-view-type='1']//div[@role='option']"), searchstring));
		
		suggestionslist = driver.findElements(By.xpath("//li[@class='sbct' and not(@id='YMXe')]"));
		
		suggestionslist.forEach(suggestion -> {
			System.out.println(suggestion.getText());
			Assert.assertTrue(suggestion.getText().contains(searchstring));
		});		
	}
	
	//3. Results Page
	//2 time its run follow alphabetic process
	@Test
	public void testResultsPage() {
		String searchstring = "maven";
		
		searchbox.sendKeys(searchstring);
		
		WebDriverWait myWait = new WebDriverWait(driver, 5);
		myWait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//li[@data-view-type='1']//div[@role='option']"), searchstring));
		
		searchbutton.click();
		
		String firstlink = driver.findElement(By.tagName("h3")).getText();
		
		System.out.println("firstlink"+firstlink);
		
		Assert.assertTrue(firstlink.toLowerCase().contains(searchstring));
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	@BeforeMethod
	public void resetBrowser() {
		driver.navigate().to("https://www.google.com");
		searchbox = driver.findElement(By.name("q"));
		searchbutton = driver.findElement(By.name("btnK"));
	}

}