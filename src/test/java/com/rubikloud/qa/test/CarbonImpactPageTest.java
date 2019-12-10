package com.rubikloud.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rubikloud.qa.base.TestBase;
import com.rubikloud.qa.pages.CarbonImpactPage;

public class CarbonImpactPageTest extends TestBase {
	
	CarbonImpactPage carbonIpmactPage;
	
	@BeforeMethod
	public void setUp()
	{
		//call parent method here
		initializaion();
		driver.get(prop.getProperty("carbonimpactUrl"));
		carbonIpmactPage = new CarbonImpactPage();
	}
	
	@Test(priority=1)
	public void co2SavedRankingTest()
	{
		String expectedCountryName= prop.getProperty("targetCountryName");
		String countryName = carbonIpmactPage.validateCo2SavedRanking();
		Assert.assertEquals(countryName.equalsIgnoreCase(expectedCountryName),true, expectedCountryName + " is not #2 in terms of 'CO2 saved by owners'");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
