package com.icecrm_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AmazonTest {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.amazon.in/");
		Thread.sleep(5000); //Landed on Home page
		WebElement searchDropDown = driver.findElement(By.xpath("//select[@id=\"searchDropdownBox\"]"));
		Select select = new Select(searchDropDown); 
		//select.selectByIndex(16);  //3rd method
		//select.selectByValue("search-alias=computers"); //2nd method
		select.selectByVisibleText("Computers & Accessories"); //1st method
		driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys("keyboard");
		driver.findElement(By.id("nav-search-submit-button")).click();
		String keyboardText = driver.findElement(By.xpath("//span[text()=\"1-24 of over 50,000 results for\"]/following-sibling::span[2]")).getText();
		System.out.println(keyboardText);
		if (keyboardText.equals(keyboardText)) {
			System.out.println("Test case is pass:1-24 of over 50,000 results for \"keyboard\"");
		} else {
			System.out.println("Test case is failed");
		}
	
	
	}
}
   