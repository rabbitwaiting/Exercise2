package com.rubikloud.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rubikloud.qa.base.TestBase;

public class HomePage extends TestBase {
	
	// Page Factory - Object Repository:
	@FindBy(xpath="//*[@id='root']/div/div[1]/div[2]/ul/li[4]")
	WebElement autopilotTab;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//span[contains(text(),'Select Your Car')]")
	WebElement selectYoreCarTxt;
	
	// Initializing the page objects
	public HomePage()
	{
		PageFactory.initElements(driver, this); // the login page will be initialized by the driver
	}
	
	//Actions: validate title
	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public String validateHomePageUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public String validateDirectToAutopilot()
	{
		autopilotTab.click();
		String url = driver.getCurrentUrl();
		//System.out.println(url);
		return url;
	}
}
