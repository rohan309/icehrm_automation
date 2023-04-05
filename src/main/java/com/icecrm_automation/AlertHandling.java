package com.icecrm_automation;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://cybersuccess.icehrm.com/");
		//driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		/*
		 * js.executeScript("window.scrollBy(0,500)");
		 * js.executeScript("window.scrollBy(0,-500)");
		 * js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
		 * 
		 * js.executeScript("alert('Please login to application');");
		 */

		
		  WebElement usernameText =
		  driver.findElement(By.xpath("//input[@id='username']/preceding::label"));
		  Object value =
		  js.executeScript("return document.getElementById('placeholder').value",
		  usernameText); String text = (String) value; System.out.println(text);
		  
		  String s = (String) js.executeScript("return argument[0].value",
		  usernameText); System.out.println(s);
		  
		  WebElement username = driver.findElement(By.id("username"));
		  js.executeScript("arguments[0].value='admin'", username);
		  
		  WebElement password = driver.findElement(By.id("password"));
		  js.executeScript("arguments[0].value='2zuzfakn'", password);
		  
		  WebElement loginButton =
		  driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
		  js.executeScript("arguments[0].click();", loginButton);
		  
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  wait.until(ExpectedConditions.alertIsPresent());
		 
		  Alert alert = driver.switchTo().alert();
		  alert.sendKeys("Please accept alert");
		  
		  //alert.accept();
		  //alert.dismiss();
	}

}
