package com.icecrm_automation;

import java.time.LocalDateTime;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerExample {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Project\\icecrm_automation\\chromedriver1.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.redbus.in/");
		driver.findElement(By.xpath("//label[contains(text(),'Date')]")).click();

		int currentDay = LocalDateTime.now().getDayOfMonth();
		List<WebElement> allDates = driver.findElements(By.xpath("//td[@class='tdy day' or @class='current day']"));
		for (WebElement element : allDates) {
			String day = element.getText();
			String today = String.valueOf(currentDay);
			if (day.equals(today)) {
				element.click();
			}
		}
	}
}
