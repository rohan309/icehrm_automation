package com.orangehrm_automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.icecrm_automation.utility.BaseClass;

public class OrageHrmLoginPage extends BaseClass{
	
	By username= By.name("username");
	By password= By.name("password");
	By loginButton= By.xpath("//button[@type='submit']");
	
	public OrageHrmLoginPage(WebDriver driver){
		this.driver= driver;
	}
	
	public void login(String username, String password) {
		enterText(this.username, username);
		enterText(this.password, password);
		click(loginButton);
		
		
	}
	
	

}
