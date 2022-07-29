package com.Velocity.Velocity12MarchDmaven.Mandatoryclasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass 
{
	//Base class contains all mandatory code needed for each and 
	//every test class present in your project
	public WebDriver driver;
	public void configureBrowser()
	{
		//configure browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shree\\Velocity 12MarchD batch\\Velocity12MarchDmaven\\Browserdrivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
		//open application in browser
		//driver.navigate().to("");
		driver.get("https://www.flipkart.com/");
		
		//open application in browser
		//driver.navigate().to("");
		driver.get("https://www.flipkart.com/");
	}
}
