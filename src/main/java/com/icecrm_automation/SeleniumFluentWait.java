package com.icecrm_automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class SeleniumFluentWait {

	public void fluentWait(WebDriver driver, By by) {
		Wait<WebDriver> wait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);}
//		wait.until((d) -> {	
//		System.out.println("Verifying element is available for cick or not");
//		return d.findElement(by)
//	});

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/login/");
		driver.manage().window().maximize();

		SeleniumFluentWait obj = new SeleniumFluentWait();
		obj.fluentWait(driver, By.id("loginbutton"));

	}

}
