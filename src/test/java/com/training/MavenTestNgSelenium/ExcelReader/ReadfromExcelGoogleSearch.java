package com.training.MavenTestNgSelenium.ExcelReader;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;





public class ReadfromExcelGoogleSearch extends TestNGBrowser
{
   protected String searchString;
   protected String expectedString;
  
	@Test(dataProvider="getDatafromExcel")
	
	public void googleTest(String searchString,String expectedString)
	{
		
       
       this.searchString = searchString;
       this.expectedString=expectedString;
        
		searchbox.sendKeys(searchString);
		
		
		searchbox.submit();
		
		waitForTitleToContain(searchString);
		
		String actual = driver.getTitle();
		
	     Assert.assertEquals(actual,expectedString);
		
		//Assert.assertTrue(driver.getTitle().contains(searchString));
       
      
	}
	
	
	
	@DataProvider
	public Object[] getDatafromExcel() throws IOException
	{
		return ReadFromExcel.readFromExcel("resources/testdataGoogle.xlsx");
		
	}

}
