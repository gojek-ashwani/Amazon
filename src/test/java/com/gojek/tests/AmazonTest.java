package com.gojek.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gojek.pages.Home;
import com.gojek.pages.Login;
import com.gojek.utilities.Browser;

public class AmazonTest {
	public static WebDriver driver;
	String amazonURL = "https://www.amazon.in/";
	private static String pathOfChromeDriver = "C:\\Users\\ashwani.raj\\Documents\\gojek\\assignment\\amazon\\driver\\chromedriver.exe";
	private String[] products = { "Macbook Pro", "Wrist Watches", "Mobile Phones" };

	Home homePage = new Home();

	@BeforeClass
	public void preCondition() {
		System.setProperty("webdriver.chrome.driver", pathOfChromeDriver);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(description = "Test to login into amazon application", priority = 0, enabled = true)
	public void loginAmazonAccount() {
		Login loginPage = new Login(driver, amazonURL);
		loginPage.loginIntoAmazon(driver);
	}

	@Test(description = "Test to select headphone and add to cart", priority = 1, enabled = true)
	public void selectHeadphoneAndAddToCart() {
		homePage.selectHeadphoneAfterSearch(driver);
	}

	@Test(description = "Test to select macbook quantity 2", priority = 2, enabled = true)
	public void selectMacbook() {
		homePage.selectAfterSearch(driver, products[0]);
	}

	@Test(description = "Test to search multiple products", priority = 3, enabled = true)
	public void selectMultipleProducts() {
		for (String searchValue : products) {
			driver.findElement(homePage.getSearchBar()).clear();
			homePage.selectAfterSearch(driver, searchValue);
		}
	}

	@Test(description = "Test to logout from amazon application", priority = 4, enabled = true)
	public void logoutAmazonAccount() {
		Browser.waitForPageLoadToComplete(driver);
		homePage.logoutAmazon(driver);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
