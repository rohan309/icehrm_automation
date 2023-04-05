package com.icecrm_automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerExample3 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://cybersuccess.icehrm.com/");
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("2zuzfakn");
		WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
		loginButton.click();
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//span[text()='Employees']")).click();
		driver.findElement(By.xpath("//ul[@id='admin_Employees']/li[1]/a")).click();
		driver.findElement(By.xpath("//span[text()=\" Add New\"]")).click();

		driver.findElement(By.id("birthday")).click();

		selectBirthdateFromCalender(12, "Jun", "2022");
	}

	public static void selectBirthdateFromCalender(int day, String month, String year) {
		while (true) { // for year
			if (year.equals(driver.findElement(By.xpath("//button[@class='ant-picker-year-btn']")).getText())) {
				while (true) { // for month
					if (month.equals(
							driver.findElement(By.xpath("//button[@class='ant-picker-month-btn']")).getText())) {
						while (true) {
							String day1 = String.valueOf(day);
							List<WebElement> element = driver
									.findElements(By.xpath("//div[@class='ant-picker-cell-inner']"));
							for (WebElement dates : element) {
								String birthDate = dates.getText();
								if (day1.equals(birthDate)) {
									dates.click();
									break;
								}
							}

						}

					} else {
						// driver.findElement(By.xpath("//button[@class='ant-picker-header-next-btn']")).click();
						driver.findElement(By.xpath("//span[@class='ant-picker-prev-icon']")).click();

					}
				}

			} else {
				driver.findElement(By.xpath("//span[@class='ant-picker-super-prev-icon']")).click();
			}

		}
	}
	
	
	public void selectDate(By by, int day, String month, String year) {
		if(year.equals(String.valueOf(driver.findElement(by)))){
			
		}
	}
	
}
