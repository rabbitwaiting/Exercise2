package com.rubikloud.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rubikloud.qa.base.TestBase;
import com.rubikloud.qa.pages.HomePage;

public class HomePageTest extends TestBase {
	
	
	HomePage homePage;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		//call parent method here
		initializaion();
		driver.get(prop.getProperty("url"));
		homePage = new HomePage();
	}
	
	/*@Test(priority=1)
	public void currentUrlTest()
	{
		String url = homePage.validateHomePageUrl();
		Assert.assertEquals(url, "https://www.tesla.com/en_ca/models/design#battery");
	}*/
	
	@Test(priority=2)
	public void changeToPageAutopilotTest()
	{
		String url = homePage.validateDirectToAutopilot();
		Assert.assertEquals(url, "https://www.tesla.com/en_ca/models/design#autopilot");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
