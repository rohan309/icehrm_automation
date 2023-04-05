package com.icecrm_automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.edge.EdgeDriver;

public class Practice {

	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://cybersuccess.icehrm.com/");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("2zuzfakn");
		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
		driver.findElement(By.xpath("//span[text()='Employees']")).click();
		driver.findElement(By.xpath("//ul[@id='admin_Employees']/li[1]/a")).click();
		driver.findElement(By.xpath("//span[text()=' Add New']")).click();

		List<WebElement> nationality = driver.findElements(By.xpath("//span[text()='Select Nationality']"));
		for (int i=0; i<nationality.size(); i++) {
			
		}
	}

}
