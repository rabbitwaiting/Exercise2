package com.rubikloud.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.rubikloud.qa.base.TestBase;

public class AutopilotPage extends TestBase {

	@FindBy(xpath = "//i[contains(@class,'icon-checkbox option-checkbox--icon icon-checkbox--blue')]")
	WebElement checkBoxForSelectOption;

	@FindBy(xpath = "//p[@class='finance-item--price finance-item--price-before-savings']")
	WebElement price;

	@FindBy(xpath = "//*[@id='root']/div/div[2]/div[2]/div/div/div/div[3]/div[2]/div[2]/div[1]/div/span/span[2]/span")
	WebElement expectedPriceGap;
	
	@FindBy(xpath="//div[@class='financetype-selector--button']")
	WebElement purchseWay;
	
	@FindBy(xpath="//li[@data-label='CASH']")
	WebElement cashElement;
	
	public AutopilotPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validatePurchasePriceIncrement() {
		
		// If the selection is NOT CASH then select CASH
		if(purchseWay.getText()!="CASH")
		{
			purchseWay.click();
			cashElement.click();
		}
		
		Actions builder = new Actions(driver);
		builder.moveToElement(checkBoxForSelectOption).build().perform();

		// Get the originalPrice
		String originalPrice = price.getText();
		//System.out.println("The original price is: " + originalPrice);

		// Click checkbox if it is unchecked
		if(!checkBoxForSelectOption.getAttribute("class").contains("is-selected"))
		{
			checkBoxForSelectOption.click();
		}

		// Get the updated price
		String updatedPrice = price.getText();
		//System.out.println("The updated price is: " + updatedPrice);

		int priceIncrement = stringToInt(updatedPrice) - stringToInt(originalPrice);
		//System.out.println("The price increment is: " + priceIncrement);

		String expectedPrice = expectedPriceGap.getText();
		int expectedPriceIncrement = stringToInt(expectedPrice);
		//System.out.println("Expected Price Increment is: " + expectedPriceIncrement);
		
		return priceIncrement == expectedPriceIncrement;
	}

	private int stringToInt(String price) {
		return Integer.parseInt(price.substring(1).replace(",", ""));
	}

}
