package com.gojek.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

	public String takeScreenShotOnFailure(WebDriver driver, String name) throws Throwable {
		TakesScreenshot screenshot = (TakesScreenshot) driver;

		String date = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		String finalDestination = System.getProperty("user.dir") + "/test-output/screenshots/" + name + "-" + date
				+ ".png";
		File destination = new File(finalDestination);
		FileUtils.copyFile(source, destination);
		return finalDestination;
	}
}
