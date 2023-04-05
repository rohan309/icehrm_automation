package com.icecrm_automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.edge.EdgeDriver;

import com.icecrm_automation.utility.BaseClass;

public class Sample4 extends BaseClass {
	public static <WebElement> void main(String[] args) throws InterruptedException {
		/*
		 * System.setProperty("webdriver.edge.driver", "msedgedriver.exe"); WebDriver
		 * driver = new EdgeDriver(); System.out.println("Launching Browser");
		 * driver.navigate().to("https://www.amazon.in/");
		 * System.out.println("Navigated to amazon"); Thread.sleep(3000);
		 * 
		 * System.out.println(driver.getTitle());
		 * driver.findElement(By.id("twotabsearchtextbox")).click();
		 * System.out.println("Clicked on search tab"); List<WebElement> dropDown =
		 * driver .findElements(By.xpath(
		 * "//select[@aria-describedby='searchDropdownDescription']"));
		 * System.out.println(dropDown.size()); System.out.println("Categories are " +
		 * dropDown);
		 * 
		 * Thread.sleep(5000); for (int i = 0; i < dropDown.size(); i++) { WebElement
		 * element = dropDown.get(i); //String value = element.getText(); //error at th
		 * System.out.println(value);
		 * 
		 * }
		 */

		driver.close();

	}
}
