package com.icecrm_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandlingExample1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://omayo.blogspot.com/");
		System.out.println(driver.getTitle());
		
		String input = "Selenium";
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='navbar-iframe']")));  //Locate iframe and switch control
		driver.switchTo().frame("navbar-iframe");
		driver.findElement(By.xpath("//input[@id='b-query']")).sendKeys(input);
		driver.findElement(By.xpath("//a[@id='b-query-icon']")).click();
		System.out.println(driver.getTitle());
		
		driver.switchTo().defaultContent();
		System.out.println(driver.getTitle());
		
		String output = driver.findElement(By.xpath("//div[@class='status-msg-body']/b")).getText();
		System.out.println(output);
		
		Thread.sleep(3000);
		if(output.equals(input)) {
			System.out.println("Successfully able to verify Selenium text in search result");
		}else {
			System.out.println("Unable to verify Selenium text in search result");
		}
		driver.quit();
	}

}
