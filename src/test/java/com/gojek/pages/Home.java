package com.gojek.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.gojek.utilities.Browser;

public class Home {

	private String signOut = "//a[@id='nav-item-signout']";
	private String helloMenu = "//a[@id='nav-link-accountList']";
	private String allDropDown = "//select[@id='searchDropdownBox']";
	private String searchBar = "//input[@id='twotabsearchtextbox']";
	private String searchButton = "//input[@type='submit']";
	private String shopByCategory = "//div[@id='nav-shop']";
	private String shopAll = "//a[@id='nav-link-shopall']";
	private String tvAppliancesElectronics = "//span[text()='TV, Appliances, Electronics']";
	private String headphones = "//span[text()='Headphones']";
	private String firstItem = "//div[@id='100_dealView_0']//a[@id='dealImage']";
	
	public By getSignOutButton() {
		return By.xpath(signOut);
	}
	
	public By getHelloMenu() {
		return By.xpath(helloMenu);
	}
	
	public By getAllMenu() {
		return By.xpath(allDropDown);
	}
	
	public By getSearchBar() {
		return By.xpath(searchBar);
	}
	
	public By getSearchButton() {
		return By.xpath(searchButton);
	}
	
	public By getShopByCategoryMenu() {
		return By.xpath(shopByCategory);
	}
	public By getShopAll() {
		return By.xpath(shopAll);
	}
	
	public By getTvAppliancesElectronics() {
		return By.xpath(tvAppliancesElectronics);
	}
	
	public By getHeaphones() {
		return By.xpath(headphones);
	}
	
	public By getFirstItem() {
		return By.xpath(firstItem);
	}
	
	public void logoutAmazon(WebDriver driver) {
		Browser.waitMoveToElement(driver, getHelloMenu());
		Browser.waitClick(driver, getSignOutButton());
	}
	
	public void selectAfterSearch(WebDriver driver, String value) {
		Browser.waitForPageLoadToComplete(driver);
		Browser.waitForElementToBeVisible(driver, getSearchBar());
		Browser.waitAndFillTextField(driver, getSearchBar(), value);
		Browser.waitClick(driver, getSearchButton());
	}
	
	public void selectHeadphoneAfterSearch(WebDriver driver) {
		Browser.waitMoveToElement(driver,getShopAll());
		Browser.waitForElementToBeVisible(driver, getTvAppliancesElectronics());
		Browser.waitMoveToElement(driver,getTvAppliancesElectronics());
		Browser.waitForElementToBeVisible(driver, getHeaphones());
		Browser.waitMoveToElement(driver,getHeaphones());
		Browser.waitClick(driver, getHeaphones());
		Browser.waitClick(driver, getFirstItem());
	}
}
