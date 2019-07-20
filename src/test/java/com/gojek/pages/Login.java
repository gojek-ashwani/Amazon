package com.gojek.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.gojek.resources.*;
import com.gojek.utilities.*;

public class Login {
	WebDriver driver;
	User user;

	private final String amazonLogo = "//a[@aria-label='Amazon']";
	private final String signIn = "//a[@id='nav-link-accountList']";
	private final String email = "//input[@type='email']";
	private final String nextButton = "//input[@id='continue']";
	private final String password = "//input[@type='password']";
	private final String loginButton = "//input[@id='signInSubmit']";

	public Login(WebDriver driver, String url) {
		user = new User();
		this.driver = driver;
		waitForPageLoad(url);
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

	public void loginIntoAmazon() {
		Browser.waitForElementToBeVisible(driver, getAmazonLogo());
		Browser.waitClick(driver, getSignIn());
		driver.findElement(getEmail()).sendKeys(user.getUserName());
		Browser.waitClick(driver, getNextButton());
		driver.findElement(getPassword()).sendKeys(user.getPassword());
		Browser.waitClick(driver, getLoginButton());

	}

	public void waitForPageLoad(String url) {
		driver.get(url);
		Browser.waitForPageLoadToComplete(driver);
	}

}
