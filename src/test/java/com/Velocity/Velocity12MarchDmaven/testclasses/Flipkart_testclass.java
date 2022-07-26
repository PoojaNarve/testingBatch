package com.Velocity.Velocity12MarchDmaven.testclasses;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.Velocity.Velocity12MarchDmaven.Mandatoryclasses.BaseClass;
import com.Velocity.Velocity12MarchDmaven.Mandatoryclasses.UtilityClass;
import com.Velocity.Velocity12MarchDmaven.POM.Flipkart_home_page;
import com.Velocity.Velocity12MarchDmaven.POM.Flipkart_login_page;

public class Flipkart_testclass extends BaseClass
{
	Flipkart_home_page hpage;
	Flipkart_login_page lpage;
	XSSFSheet sh;
	String Testcaseid;
	
	@BeforeClass
	public void openapp() throws IOException
	{
		configureBrowser();
		
		//created and initialized objects of POM classes
		hpage=new Flipkart_home_page(driver);
		lpage=new Flipkart_login_page(driver);
	}
	@BeforeMethod
	public void loginapp() throws IOException
	{
		lpage.enterEmail(UtilityClass.FetchData(0, 0));
		
		String password=UtilityClass.FetchData(0, 1);
		lpage.enterPassword(password);
		
		lpage.loginclick();
		
		//UtilityClass.screenShot(driver, "login");
	}
	@Test
	public void verifyUser() throws InterruptedException, IOException
	{
		Testcaseid="TC_01";
		String actualResult=hpage.validateUsername();
		
		//String expected=UtilityClass.FetchData(0, 2);
		
		String expectedResult="Pooja1";
		Assert.assertEquals(actualResult,expectedResult,"Failed: both values are not same");
		
		//UtilityClass.screenShot(driver, "userVerified");
	}
	@AfterMethod
	public void logoutapp(ITestResult result) throws IOException
	{
		//tearDown()
		//pass: Success  fail: Failure  status
		if(result.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.screenShot(driver,result.getName());
		}	
		System.out.println("logout from application");
	}
	@AfterClass
	public void closeapp()
	{
		driver.quit();
		
		lpage=null;
		hpage=null;
		driver=null;
		sh=null;
	}
}
