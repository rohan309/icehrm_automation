package com.icecrm_automation;

import java.time.LocalDateTime;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerExample2 {

	static WebDriver driver;

	public static void selectDayFromCalender() {
		driver.findElement(By.id("onward_cal")).click();
		int currentDay = LocalDateTime.now().getDayOfMonth();
		List<WebElement> allDates = driver.findElements(By.xpath("//td[@class='tdy day' or @class='current day']"));
		/*
		 * int dayToSelect = currentDay;
		 * 
		 * for (WebElement element : allDates) { String day = element.getText(); 
		 * String today = String.valueOf(dayToSelect); if (day.equals(today)) {
		 * element.click(); break; } }
		 */ 
		for(WebElement element: allDates) {
			if(!element.equals(valueOf(currentDay))) {
				element.click();
			}
		}

	}

	private static Object valueOf(int currentDay) {
		
		return null;
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://www.redbus.in/");
		selectDayFromCalender();
	}

}
