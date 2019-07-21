package com.gojek.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Report {

	public static ExtentHtmlReporter extentHtmlReporter;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	private String reportPath = "/test-output/extent-report.html";
	Screenshot screen = new Screenshot();

	public void initializeReport() {
		extentHtmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + reportPath);
		extentHtmlReporter.config().setDocumentTitle("Go-Jek Amazon Test Automation Report");
		extentHtmlReporter.config().setReportName("Functional Test Cases");
		extentHtmlReporter.config().setTheme(Theme.DARK);
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);
		extentReports.setSystemInfo("Application Name", "Amazon.com");
		extentReports.setSystemInfo("OS", "WINDOWS10");
		extentReports.setSystemInfo("Owner", "Go-Jek");
		extentReports.setSystemInfo("Browser", "Google Chrome");
	}

	public void createTest(ExtentTest extentTest, ExtentReports extentReports) {
		String nameOfCurrentMethod = new Object().getClass().getEnclosingMethod().getName();
		extentTest = extentReports.createTest(nameOfCurrentMethod);
	}

	public void logTestResult(ITestResult result, ExtentTest extentTest, WebDriver driver) throws Throwable {
		if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, "Passed Test Case: " + result.getName());
		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(Status.SKIP, "Skipped Test Case: " + result.getName());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(Status.FAIL, "Failed Test Case: " + result.getName());
			extentTest.log(Status.FAIL, "Failed Test Case: " + result.getThrowable());
			String screenshotPath = screen.takeScreenShotOnFailure(driver, result.getName());
			extentTest.addScreenCaptureFromPath(screenshotPath);
		}
	}

	public void publishReport(ExtentReports extentReports) {
		extentReports.flush();
	}
}
