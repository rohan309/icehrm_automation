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
		driver.get("https://ssc.nic.in/");
		driver.findElement(By.xpath("//a[text()='The Commission ']")).click();
		List<WebElement> theComission = driver.findElements(By.xpath("//li[@class='dropdown open']/ul"));
		for (int i = 0; i < theComission.size(); i++) {
			WebElement element = theComission.get(i);
			String text = element.getText();
			if(text.equals("Background of Commission")) {
				element.click();
				break;
			}
		}
	}

}
