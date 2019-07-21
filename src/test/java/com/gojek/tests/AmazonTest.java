package com.gojek.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gojek.pages.Cart;
import com.gojek.pages.Home;
import com.gojek.pages.Login;
import com.gojek.utilities.Browser;

import junit.framework.Assert;

public class AmazonTest {
	
	public static WebDriver driver;
	String amazonURL = "https://www.amazon.in/";
	String hiMessage = "Hi, Ashwani";
	private static String pathOfChromeDriver = "C:\\Users\\ashwani.raj\\Documents\\gojek\\assignment\\amazon\\driver\\chromedriver.exe";
	private String[] products = { "Wrist Watches", "Macbook Pro", "Mobile Phones" };

	Home homePage = new Home();
	Cart shoppingCartPage = new Cart();

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", pathOfChromeDriver);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(description = "Test to login into amazon application", priority = 0, enabled = true)
	public void loginAmazonAccount() {
		Login loginPage = new Login(driver, amazonURL);
		loginPage.loginIntoAmazon(driver);
		Boolean result = homePage.verifyLoggedInUser(driver, homePage.getHiMessage(), hiMessage);
		Assert.assertTrue(result);
	}

	@Test(description = "Test to select headphone and add to cart", priority = 1, enabled = true)
	public void selectHeadphoneAndAddToCart() {
		homePage.selectHeadphoneAfterSearch(driver);
		driver.navigate().refresh();
		Browser.waitForElementToBeVisible(driver, homePage.getCartCount());
		int cartCount = Integer.parseInt(driver.findElement(homePage.getCartCount()).getText());
		Assert.assertEquals(1, cartCount);
	}

	@Test(description = "Test to select macbook quantity 2", priority = 2, enabled = true)
	public void selectMacbook() {
		driver.navigate().refresh();
		homePage.selectAfterSearch(driver, products[1]);
		String parentWinHandle = driver.getWindowHandle();
		Browser.selectItemNumber(driver, homePage.getSearchResults(), 2);
		Browser.waitForPageLoadToComplete(driver);
		for(String newWindowHandle : driver.getWindowHandles()){
			if(!newWindowHandle.equals(parentWinHandle)) {
				driver.switchTo().window(newWindowHandle);
			}
		}
		Browser.waitAndSelectFromDropdown(driver, homePage.getQuantity(), "2");
		Browser.waitClick(driver, homePage.getAddToCartButton());
		Browser.waitForPageLoadToComplete(driver);
		driver.switchTo().window(parentWinHandle);
	}

	@Test(description = "Test to search multiple products", priority = 3, enabled = true)
	public void selectMultipleProducts() {
		for (String searchValue : products) {
			driver.findElement(homePage.getSearchBar()).clear();
			homePage.selectAfterSearch(driver, searchValue);
		}
	}
	
	@Test(description = "Test to delete items in cart", priority = 4, enabled = true)
	public void deleteItemsInCart() {
		Browser.waitClick(driver, homePage.getCartCount());
		shoppingCartPage.deleteItems(driver);
	}

	@Test(description = "Test to logout from amazon application", priority = 5, enabled = true)
	public void logoutAmazonAccount() {
		Browser.waitForPageLoadToComplete(driver);
		homePage.logoutAmazon(driver);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
