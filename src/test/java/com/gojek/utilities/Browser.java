package com.gojek.utilities;

import java.lang.reflect.Array;
import java.util.List;

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
	
	public static Boolean waitVerifyText(WebDriver driver, By obj, String textToMatch) {
		Boolean flag = false;
		waitForPageLoadToComplete(driver);
		waitForElementToBeVisible(driver, obj);
		String fetchedText = driver.findElement(obj).getText();
		if(fetchedText.contains(textToMatch)) {
			flag = true;
		}
		return flag;
	}
	
	public static void selectItemNumber(WebDriver driver, By obj, int number) {
		List<WebElement> result = driver.findElements(obj);
		for (int i = 0; i < result.size(); i++) {
			if(i == number) {
				Actions actions = new Actions(driver);  
			    actions.click(result.get(i)).perform();
			    break;
			}
		}
		
	}
}
