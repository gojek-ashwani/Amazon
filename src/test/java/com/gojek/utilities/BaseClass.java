package com.gojek.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	public static WebDriver driver;
	public BaseClass() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ashwani.raj\\Documents\\gojek\\assignment\\amazon\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
}
