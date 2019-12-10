package com.rubikloud.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rubikloud.qa.base.TestBase;

public class CarbonImpactPage extends TestBase {
	
	@FindBy(xpath="//li[@class='nav-world ']")
	WebElement worldTab;
	
	@FindBy(xpath="//span[@class='col col-rank' and text()='2']/following-sibling::span[1]/span")
	WebElement secondRanking;
	
	@FindBy(xpath="//span[@class='country-name' and text()='Canada']/parent::span/preceding-sibling::span[@class='col col-rank']")
	WebElement rankOfCanada;
	
	@FindBy(xpath="(//span[@class=' sort col col-total'])[2]/span/span[contains(text(),'CO')]/following-sibling::span")
	WebElement ArrowDownBesidesSavedByOwners;
	
	public CarbonImpactPage()
	{
		PageFactory.initElements(driver, this); // the login page will be initialized by the driver
	}
	
	public String validateCo2SavedRanking()
	{
		worldTab.click();
		
		//If the order is NOT descending, make the sort as descending by clicking the arrow element
		String byClass = ArrowDownBesidesSavedByOwners.getAttribute("class");
		if(!byClass.equalsIgnoreCase("arrow  desc"))
		{
			ArrowDownBesidesSavedByOwners.click();
		}
		
		String countryName =  secondRanking.getText();
		System.out.println("Country Name of '#2 CO2 saved by owners' is -->" + countryName);
		String rankofCa = rankOfCanada.getText();
		System.out.println("Canada’s ranking is -->" + rankofCa);
		return countryName;
	}

}
