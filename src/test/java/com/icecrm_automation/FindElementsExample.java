package com.icecrm_automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FindElementsExample {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		Thread.sleep(3000);
		
		WebElement searchDropDown = driver.findElement(By.xpath("//select[@title=\"Search in\"]"));
		Select select = new Select(searchDropDown);
		select.selectByValue("search-alias=electronics");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys("washing machine");
		driver.findElement(By.xpath("//span[@id=\"nav-search-submit-text\"]/input")).click();
		Thread.sleep(3000);
		
		List<WebElement> washingMachineResults = driver.findElements(By.xpath("//span[@data-component-type=\"s-search-results\"]"));
		int totalResults = washingMachineResults.size();
		System.out.println("Total results "+totalResults);
/*		
		for( int i = 0; i <= totalResults; i++) {
			try {
				String nameXpath = "";
				System.out.println(nameXpath);
				String priceXpath = "";
				String washingMachineName = driver.findElement(By.xpath(nameXpath)).getText();
				String washingMachinePrice = driver.findElement(By.xpath(priceXpath)).getText();
				System.out.println("Price: "+washingMachinePrice + " Washing Machine Name "+washingMachineName);	
			}
			catch(NoSuchElementException e) {
				System.out.println(e.getMessage());
			}
		}
		
		Thread.sleep(10000);
		driver.close();
*/
	} 

}
