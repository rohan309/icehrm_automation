package com.icecrm_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlingExample2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
//Opening one tab, from that opening 2nd tab, getting id and title for both tab
		
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://www.google.in/");
		System.out.println(driver.getTitle());   //1st title
		
		//open tab in same window and switch control automatically
		
		String firstTabId = driver.getWindowHandle(); //getWindowHandle() gives id 
		System.out.println("This Id of 1st tab "+firstTabId);  //Printing google Id
		
		driver.switchTo().newWindow(WindowType.TAB);  //switching window 1 to another and control also
		driver.navigate().to("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();  //close button
		Thread.sleep(2000);
		System.out.println("Went to another tab");
		
		String secondTabId = driver.getWindowHandle();  //gives id for 2nd tab
		System.out.println("This Id of 2nd tab "+secondTabId); 
		System.out.println(driver.getTitle());  //2nd tab title
		
		driver.close();  //closing 1st browser
		
		driver.switchTo().window(firstTabId);  //switch back to 1st tab by passing previous id
		System.out.println("Switch control to 1st tab and title: Id is "+firstTabId); //checking going to 1st tab or not by Id
		
		driver.close();  //closing current or 2nd tab
		
		
	}

}
