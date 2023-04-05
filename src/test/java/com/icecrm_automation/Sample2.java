package com.icecrm_automation;

import org.testng.annotations.Test;

import com.icecrm_automation.utility.BaseClass;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class Sample2 extends BaseClass{
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {
		System.out.println("This is before class method");
	launchBrowser(browser);
		driver.get("https/:cybersuccess.icehrm.com");
		System.out.println("Launching " + browser + " broser");
	}
	@AfterClass
	public void afterClass(String browser) {
		driver.close();
	}

	@Parameters({ "username", "password" })
	@Test
	public void sample2Test1(String username, String password) {
		System.out.println("This is sample2 test1 method");
		System.out.println("UN: " + username + " PWD: " + password);
		enterText(By.id("username"),"username");
		enterText(By.id("pasword"),"password");
		click(By.xpath("//button[contains(text(),'Log in' )]"));
		
	}
}
