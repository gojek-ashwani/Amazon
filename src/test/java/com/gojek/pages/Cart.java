package com.gojek.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.gojek.utilities.Browser;

public class Cart {

	private String delete = "//input[@value='Delete']";
	private String proceedToBuy = "//input[@value='Proceed to checkout']";
	
	public By getDeleteButton() {
		return By.xpath(delete);
	}
	
	public By getProceedToBuy() {
		return By.xpath(proceedToBuy);
	}
	
	public void deleteItems(WebDriver driver, int position) {
		Browser.waitForPageLoadToComplete(driver);
		Browser.waitForElementToBeVisible(driver, getDeleteButton());
		Browser.performClickOnItemAtPosition(driver, getDeleteButton(), position);
		Browser.waitForPageLoadToComplete(driver);
	}
	
	public void proceedToCheckout(WebDriver driver) {
		Browser.waitForElementToBeVisible(driver, getProceedToBuy());
		Browser.waitClick(driver, getProceedToBuy());
		Browser.waitForPageLoadToComplete(driver);
	}
}
