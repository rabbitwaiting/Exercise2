package com.rubikloud.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rubikloud.qa.base.TestBase;
import com.rubikloud.qa.pages.AutopilotPage;
import com.rubikloud.qa.pages.HomePage;

public class AutopilotPageTest extends TestBase{
	
	AutopilotPage autopilotPage;
	HomePage homePage;
	
	public AutopilotPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		//call parent method here
		initializaion();
		driver.get(prop.getProperty("url"));
		autopilotPage = new AutopilotPage();
		homePage = new HomePage();
	}
	
	@Test(priority=1)
	public void priceIncrementTest()
	{
		//Make sure the current page is Autopilot
		String url = homePage.validateDirectToAutopilot();
		Assert.assertEquals(url, "https://www.tesla.com/en_ca/models/design#autopilot");
		
		//Verify if the price increment is correct.
		boolean result =autopilotPage.validatePurchasePriceIncrement();
		Assert.assertTrue(result, "'Purchase price' is not adjusted correctly.");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
