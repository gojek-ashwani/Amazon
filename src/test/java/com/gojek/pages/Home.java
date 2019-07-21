package com.gojek.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.gojek.utilities.Browser;

public class Home {

	private String hiMessage = "//div[@class='a-section a-spacing-none hud-profile-greeting']";
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
	private String items = "//div[@id='100_dealView_%d']//a[@id='dealImage']";
	private String cartCount = "//span[@id='nav-cart-count']";
	private String addToCart = "//*[@title='Add to Shopping Cart']";
	private String quantity = "//select[@name='quantity']";
	private String searchResults = "//div[@class='a-section aok-relative s-image-fixed-height']";
	
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
	
	public By getCart() {
		return By.xpath(cartCount);
	}
	
	public By getHiMessage() {
		return By.xpath(hiMessage);
	}
	
	public By getAddToCartButton() {
		return By.xpath(addToCart);
	}
	
	public By getItemNumber(int count) {
		return By.xpath(item(count));
	}
	
	public By getQuantity() {
		return By.xpath(quantity);
	}
	
	public By getSearchResults() {
		return By.xpath(searchResults);
	}
	
	public String item(int count) {
		String itemLocator = items;
		String xpathItemLocator = String.format(itemLocator, count);
		return xpathItemLocator;
		
	}
	public Boolean verifyLoggedInUser(WebDriver driver, By obj, String textToVerify) {
		Browser.waitForPageLoadToComplete(driver);
		Browser.waitForElementToBeVisible(driver, obj);
		return Browser.waitVerifyText(driver, obj, textToVerify);
	}
	
	public void logoutAmazon(WebDriver driver) {
		Browser.waitMoveToElement(driver, getHelloMenu());
		Browser.waitForElementToBeVisible(driver, getHelloMenu());
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
		String parentWinHandle = driver.getWindowHandle();
		Browser.waitClick(driver, getFirstItem());
		for(String newWindowHandle : driver.getWindowHandles()){
			if(!newWindowHandle.equals(parentWinHandle)) {
				driver.switchTo().window(newWindowHandle);
				Browser.waitClick(driver, getAddToCartButton());
				Browser.waitForPageLoadToComplete(driver);
				driver.close();
				break;
			}
		}
		driver.switchTo().window(parentWinHandle);
	}
}
