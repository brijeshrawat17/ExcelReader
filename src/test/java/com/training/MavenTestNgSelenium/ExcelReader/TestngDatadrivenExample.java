package com.training.MavenTestNgSelenium.ExcelReader;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestngDatadrivenExample 
{

	
	@Test(dataProvider="getDatafromExcel")
	public void myTest(String firstname,String lastname,String city)
	{
		System.out.print(firstname);
		System.out.println(" ");
       System.out.print(lastname);	
       
       System.out.println(" ");
       System.out.print(city);	
	}
	
	
	
	
	
	@DataProvider
	public Object[] getData()
	{
		String [][] names=new String[5][3];
		names[0][0]="Ameya";
		names[0][1]="Naik";
		names[0][2]="pune";
		
		names[1][0]="Rohit";
		names[1][1]="Bhargava";
		names[1][2]="Haridwar";
		
		names[2][0]="Brijesh";
		names[2][1]="Rawat";
		names[2][2]="pune";
		
		names[3][0]="Tanya";
		names[3][1]="Vadhva";
		names[3][2]="pune";
		
		
		names[4][0]="Nitin";
		names[4][1]="Goel";
		names[4][2]="pune";
		return names;
		
	}
	
	
	@DataProvider
	public Object[] getDatafromExcel() throws IOException
	{
		return ReadFromExcel.readFromExcel("resources/testdata.xlsx");
		
	}
	
	
		
	
}
