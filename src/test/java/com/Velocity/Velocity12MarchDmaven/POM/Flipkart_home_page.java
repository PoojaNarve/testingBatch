package com.Velocity.Velocity12MarchDmaven.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Flipkart_home_page 
{
	//Step1:Data member should be declared globaly with access level private using @findBy Annotation

			@FindBy(xpath="(//div[@class=\"exehdJ\"])[1]")private WebElement username;
			
			//Step2:. Initialize within a constructor with access level public using pagefactory class
			
			public Flipkart_home_page(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}
			
			//Step3:Utilize within a method with access level public
			public String validateUsername() throws InterruptedException
			{
				Thread.sleep(1000);
				String actual=username.getText();
				return actual;
				
			}
}
