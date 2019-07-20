package com.gojek.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gojek.pages.Login;


public class AmazonTest
{
	WebDriver driver;
	String amazonURL = "https://www.amazon.in/";
	
	@BeforeClass
    public void preCondition()
    {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ashwani.raj\\Documents\\gojek\\assignment\\amazon\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
    }

    @Test
	public void loginAmazonAccount()
    {
       Login loginPage = new Login(driver, amazonURL);
       loginPage.loginIntoAmazon();
       
    }
    
	@AfterClass
    public void tearDown()
    {
		driver.quit();
    }
}
