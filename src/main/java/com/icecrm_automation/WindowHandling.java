package com.icecrm_automation;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
//Opening one tab, clicking on random link, gathering all links on it and printing them.

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.amazon.in/");

		String firstTabTitle = driver.getTitle();
		System.out.println(firstTabTitle); // 1st page title

		String parentWindowId = driver.getWindowHandle(); // gives Id for single tab
		System.out.println(parentWindowId); // 1st page id

		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@id='navSwmHoliday']/a")).click();
		Set<String> allIds = driver.getWindowHandles(); // gives Id for all tab. getWindowHandles()--> return type-->Set<String>
		System.out.println("Print all window ids " + allIds);

		for (String id : allIds) { // iterating Id using for loop
			// System.out.println(id);
			if (!id.equals(parentWindowId)) { // ignoring 1st id and printing 2nd id---> not equals
				System.out.println("Second tab id "+ id); // getting 2nd id only
				driver.switchTo().window(id);
				String secondTabTitle = driver.getTitle(); // getTitle()--> return type-->String
				System.out.println("Second Tab title "+ secondTabTitle); // 2nd page title
				List<WebElement> alllinks = driver.findElements(By.tagName("a")); //findElements()--> return type-->List<WebElement>
				for (WebElement element : alllinks) {
					System.out.println(element.getAttribute("href"));
				}
				driver.close(); // closing second tab
			}
		}

		driver.switchTo().window(parentWindowId); // going to 1st tab
		Thread.sleep(3000);
		driver.close(); // closing second tab

//		  List<WebElement> links = driver.findElements(By.tagName("img"));
//		  System.out.println(links);

//		for (int i = 0; i < links.size(); i++) {     //logic for for loop
//			WebElement element = links.get(i);
//			String url = element.getAttribute("src");
//			System.out.println(url);
//
//		}

		driver.quit();
	}

}
