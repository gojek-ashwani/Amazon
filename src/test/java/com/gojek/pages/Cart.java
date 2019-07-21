package com.gojek.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.gojek.utilities.Browser;

public class Cart {

	private String delete = "//input[@value='Delete']";
	
	public By getDeleteButton() {
		return By.xpath(delete);
	}
	
	public void deleteItems(WebDriver driver) {
		Browser.waitForPageLoadToComplete(driver);
		Browser.waitClick(driver, getDeleteButton());
		Browser.waitForPageLoadToComplete(driver);
	}
}
