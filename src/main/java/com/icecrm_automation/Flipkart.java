package com.icecrm_automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Flipkart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.flipkart.com/"); // Search\Laptop Accessories
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();

		WebElement searchButton = driver.findElement(By.xpath("//input[@class=\"_3704LK\"]"));
		searchButton.sendKeys("Laptop and Desktop");
		driver.findElement(By.xpath("//button[@class=\"L0Z3Pu\"]")).click();
		Thread.sleep(5000); // Scrolled manually

		WebElement droDownMin = driver.findElement(By.xpath("//div[@class=\"_1YAKP4\"]/select"));
		droDownMin.click();
		Select select = new Select(droDownMin);
		List<WebElement> minVal = select.getOptions();
		// System.out.println(minVal);

		for (int i = 0; i < minVal.size(); i++) {
			WebElement prize = minVal.get(i);
			String prizeText = prize.getAttribute("value");
			System.out.println(prizeText);
		}
		driver.close();
	}

}
