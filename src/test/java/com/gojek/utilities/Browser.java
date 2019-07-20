package com.gojek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser {
	static WebDriver driver;
	
	Browser(WebDriver driver) {
		Browser.driver = driver;
	}
	public static void waitForPageLoadToComplete(WebDriver driver) {
		new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
				.executeScript("return document.readyState").equals("complete"));
	}

	public static boolean waitForElementToBeVisible(WebDriver driver, By obj) {
		boolean flag = false;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		if (wait.until(ExpectedConditions.visibilityOfElementLocated(obj)) != null) {
			flag = true;
		}
		return flag;
	}
	public static void waitClick(WebDriver driver, By obj) {
		waitForPageLoadToComplete(driver);
		driver.findElement(obj).click();
		waitForPageLoadToComplete(driver);
	}
}
