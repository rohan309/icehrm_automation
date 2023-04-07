package com.icecrm_automation.utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestListners implements ITestListener, ISuiteListener {

//	String reportPath;
//	ExtentReports extentReporter;

	@Override
	public void onStart(ISuite suite) { // ISuiteListener
		System.out.println("This is onStart of ISuite from TestListners");
		/*
		 * LocalDateTime dateTime = LocalDateTime.now(); String currentDateTime =
		 * dateTime.format(DateTimeFormatter.ofPattern("dd_mm_yyyy_hh_mm")); reportPath
		 * = System.getProperty("user.dir") + "/reports/" + "report_" + currentDateTime;
		 * System.out.println("ReportPath is "+ reportPath); File file = new
		 * File(reportPath); if (!file.exists()) { file.mkdir(); }
		 */
		/*
		 * String htmlReport = reportPath + "/AutomationReport.html";
		 * ExtentSparkReporter sparkReporter = new ExtentSparkReporter(htmlReport);
		 * extentReporter = new ExtentReports();
		 * extentReporter.attachReporter(sparkReporter);
		 */
		/*
		 * extentReporter.setSystemInfo("user", "Rohan More");
		 * extentReporter.setSystemInfo("os", "windows");
		 * extentReporter.setSystemInfo("environment", "QA");
		 */
//		String suiteName = suite.getName();
//		System.out.println(suiteName);
	}

	@Override
	public void onFinish(ISuite suite) { // ISuiteListener
		System.out.println("This is onFinish of ISuite from TestListners");
		//extentReporter.flush();
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("This is onStart of ITestContext from TestListners");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("This is onFinish of ITestContest from TestListners");
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("This is onTestStart of ITestResult from TestListners");
		String methodName = result.getMethod().getMethodName();
//		String methodName = result.getName();
		//log = extentReporter.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("This is onTestSuccess of ITestResult from TestListners");
//		captureScreenShot(result);
		
		/*
		 * System.out.println("ReportPath is "+ reportPath); String screenShotPath =
		 * reportPath + "/" + result.getMethod().getMethodName() + ".jpg";
		 * System.out.println("ScreenShot file name "+screenShot);
		 * 
		 * TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		 * System.out.println("Take screenShot "+takesScreenshot); File sourceFile =
		 * takesScreenshot.getScreenshotAs(OutputType.FILE); File destinationFile = new
		 * File(screenShot);
		 * 
		 * try { FileUtils.copyFile(sourceFile, destinationFile); } catch (IOException
		 * e) { // e.printStackTrace(); throw new RuntimeException(e); }
		 */
		//log.fail(result.getThrowable().getMessage());
		//log.addScreenCaptureFromPath(screenShotPath, "Failed screenshot");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("This is onTestFailure of ITestResult from TestListners");
//		captureScreenShot(result);
		/*
		 * String screenShot = reportPath + "/" + result.getMethod().getMethodName() +
		 * ".jpg"; TakesScreenshot takesScreenshot = (TakesScreenshot) driver; File
		 * sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE); File
		 * destinationFile = new File(screenShot);
		 * 
		 * try { FileUtils.copyFile(sourceFile, destinationFile); } catch (IOException
		 * e) { // e.printStackTrace(); throw new RuntimeException(e); }
		 */
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("This is onTestSkipped of ITestResult from TestListners");
	}
}
