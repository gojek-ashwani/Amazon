package com.gojek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

public class Browser {

	public static void waitForPageLoadToComplete(WebDriver driver) {
		new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
				.executeScript("return document.readyState").equals("complete"));
	}

	public static void waitForElementToBeVisible(WebDriver driver, By obj) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj));
	}

	public static void waitClick(WebDriver driver, By obj) {
		waitForPageLoadToComplete(driver);
		driver.findElement(obj).click();
		waitForPageLoadToComplete(driver);
	}

	public static void waitAndFillTextField(WebDriver driver, By obj, String value) {
		waitForElementToBeVisible(driver, obj);
		driver.findElement(obj).sendKeys(value);
	}

	public static void waitMoveToElement(WebDriver driver, By obj) {
		waitForPageLoadToComplete(driver);
		waitForElementToBeVisible(driver, obj);
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(obj);
		action.moveToElement(element).perform();
	}

	public static void waitAndSelectFromDropdown(WebDriver driver, By obj, String textToSelect) {
		waitForElementToBeVisible(driver, obj);
		Select all = new Select(driver.findElement(obj));
		all.selectByVisibleText(textToSelect);
	}
}
