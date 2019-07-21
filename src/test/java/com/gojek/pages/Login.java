package com.gojek.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.gojek.resources.User;
import com.gojek.utilities.Browser;

public class Login {
	
	User user;
	private String amazonLogo = "//a[@aria-label='Amazon']";
	private String signIn = "//a[@id='nav-link-accountList']";
	private String email = "//input[@type='email']";
	private String nextButton = "//input[@id='continue']";
	private String password = "//input[@type='password']";
	private String loginButton = "//input[@id='signInSubmit']";

	public Login(WebDriver driver, String url) {
		user = new User();
		waitForPageLoad(driver,url);
	}

	public By getAmazonLogo() {
		return By.xpath(amazonLogo);
	}

	public By getSignIn() {
		return By.xpath(signIn);
	}

	public By getEmail() {
		return By.xpath(email);
	}

	public By getPassword() {
		return By.xpath(password);
	}

	public By getNextButton() {
		return By.xpath(nextButton);
	}

	public By getLoginButton() {
		return By.xpath(loginButton);
	}

	public void loginIntoAmazon(WebDriver driver) {
		Browser.waitForElementToBeVisible(driver, getAmazonLogo());
		Browser.waitForElementToBeVisible(driver, getSignIn());
		Browser.waitClick(driver, getSignIn());
		Browser.waitAndFillTextField(driver, getEmail(), user.getUserName());
		Browser.waitClick(driver, getNextButton());
		Browser.waitAndFillTextField(driver, getPassword(), user.getPassword());
		Browser.waitClick(driver, getLoginButton());
	}

	public void waitForPageLoad(WebDriver driver, String url) {
		driver.get(url);
		Browser.waitForPageLoadToComplete(driver);
	}

}
