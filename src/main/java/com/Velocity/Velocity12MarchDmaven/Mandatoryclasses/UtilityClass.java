package com.Velocity.Velocity12MarchDmaven.Mandatoryclasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass 
{
	//Utility class has the methods for fetching data from Excel, Screenshot
	
	public static String FetchData(int rowIndex, int cellIndex) throws IOException
	{
		//opened excel sheet to fetch data
		FileInputStream file= new FileInputStream("C:\\Users\\shree\\Velocity 12MarchD batch\\Velocity12MarchDmaven\\Exceldata\\demo.xlsx");
		XSSFWorkbook book= new XSSFWorkbook(file);
		XSSFSheet sh=book.getSheet("Sheet5");
		String data=sh.getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		return data;
	}
	
	public static void screenShot(WebDriver driver,String filename) throws IOException
	{
		TakesScreenshot s=(TakesScreenshot)driver;
		File src=s.getScreenshotAs(OutputType.FILE);
		File des=new File("C:\\Users\\shree\\Velocity 12MarchD batch\\Velocity12MarchDmaven\\Screenshot\\"+filename+".jpg");
		FileHandler.copy(src, des);
	}
}
