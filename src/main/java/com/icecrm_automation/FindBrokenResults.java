package com.icecrm_automation;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindBrokenResults {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.amazon.in/");
		Thread.sleep(3000);

		List<WebElement> links = driver.findElements(By.tagName("a"));
		 System.out.println(links);

		for (int i = 0; i < links.size(); i++) {
			WebElement element = links.get(i);
			String url = element.getAttribute("href");
			if (url != null && !url.equals("javascript: void(0)")) {
				try {
					URL uri = new URL(url);
					URLConnection urlConnection = uri.openConnection();
					HttpURLConnection httpURLconnection = (HttpURLConnection) urlConnection;
					httpURLconnection.connect();
					int statusCode = httpURLconnection.getResponseCode();
					if (statusCode >= 300) {
						System.out.println("Broken URL " + statusCode + " url: " + url);
					}
					httpURLconnection.disconnect();
				} catch (Exception ignored) {

				}
			}
		}

		Thread.sleep(10000);
		driver.close();
	}

}

