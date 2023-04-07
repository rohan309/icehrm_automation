package com.icecrm_automation.utility;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
//	public WebDriver driver;
	public ExtentTest log;
	
	String reportPath;
	ExtentReports extentReporter;

	public void launchBrowser(String browser) {

		switch (browser) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(setChromeOptions());
			// System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			//driver = new ChromeDriver();
			
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			// System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
			driver = new EdgeDriver(setEdgeOptions());
			break;

		case "firefox":
			System.setProperty("wedriver.gecko.driver", "firefoxdriver.exe");
			driver = new FirefoxDriver();
			break;

		default:
			// System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
			driver = new EdgeDriver(setEdgeOptions());
			break;
		}
	}

	public ChromeOptions setChromeOptions() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("incognito");
		// option.setHeadless(false);
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-clocking"));
		Map<String, String> prefs = new HashMap<>();
		prefs.put("download.default.directory", "c:/newfolder/download/");
		option.setExperimentalOption("prefs", prefs);
		option.setAcceptInsecureCerts(true);
		return option;
	}

	public FirefoxOptions setFirefoxOptions() {
		FirefoxOptions option = new FirefoxOptions();
		option.addArguments("start-maximized");
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("incognito");
		// option.setHeadless(true);
		option.addPreference("excludeSwitches", Arrays.asList("disable-popup-clocking"));
		Map<String, String> prefs = new HashMap<>();
		prefs.put("download.default.directory", "c:/newfolder/download/");
		option.addPreference("prefs", prefs);
		option.setAcceptInsecureCerts(true);
		return option;
	}

	public EdgeOptions setEdgeOptions() {
		EdgeOptions option = new EdgeOptions();
		option.addArguments("start-maximized");
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("incognito");
		// option.setHeadless(true);
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-clocking"));
		Map<String, String> prefs = new HashMap<>();
		prefs.put("download.default.directory", "c:/newfolder/download/");
		option.setExperimentalOption("prefs", prefs);
		option.setAcceptInsecureCerts(true);
		return option;
	}

	public void enterText(By by, String text) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			driver.findElement(by).sendKeys(text);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void click(By by) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(by));
			driver.findElement(by).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void waitForElementToClick(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public void dropDrown(By by, String text) {
		WebElement selectFromDd = driver.findElement(by);
		selectFromDd.click();
		List<WebElement> listOfDropDown = driver.findElements(by);
		for (int i = 0; i < listOfDropDown.size(); i++) {
			WebElement element = listOfDropDown.get(i);
			String value = element.getText();
			if (value.equals(text)) {
				element.click();
				break;
			}
		}
	}

	public void scroll(int scrollBy) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, scrollBy)");
	}

//	public void captureScreenShot(ITestResult result) {
//		
//		LocalDateTime dateTime = LocalDateTime.now();
//		String currentDateTime = dateTime.format(DateTimeFormatter.ofPattern("dd_mm_yyyy_hh_mm"));
//		reportPath = System.getProperty("user.dir") + "/reports/" + "report_" + currentDateTime;
//		System.out.println("ReportPath is "+ reportPath);
//		File file = new File(reportPath);
//		if (!file.exists()) {
//			file.mkdir();
//		}
//		
//		String screenShot = reportPath + "/" + result.getMethod().getMethodName() + ".jpg";
//		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
//		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
//		File destinationFile = new File(screenShot);
//
//		try {
//			FileUtils.copyFile(sourceFile, destinationFile);
//		} catch (IOException e) {
//			// e.printStackTrace();
//			throw new RuntimeException(e);
//		}
//	}

	
	
	public void fileUpload(String filePath) {
		try {
			PropertyHandling handling= new PropertyHandling();
			String autoItScript = handling.getProperties("autoItScript");
			Thread.sleep(1000);
			Runtime.getRuntime().exec(autoItScript+" "+filePath);
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
