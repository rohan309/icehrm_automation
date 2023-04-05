package com.ice_hrm_automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.icecrm_automation.utility.BaseClass;

public class LoginPage extends BaseClass {
	// Declare all the locators
	//WebDriver driver;
	By username = By.name("username");
	By password = By.name("password");
	By loginButton = By.xpath("//button[contains(text(), 'Log in')]"); // this variable is local
	By restPasswordLink = By.xpath("//a[contains(text(),'Reset Password')]"); // this variable is local

	public By errorMsg = By.xpath("//div[contains(@class, 'alert-danger')]"); // this variable is not used in login
																				// method but used in another method of
	
	public By homeText = By.xpath("//div[contains(text(),'ICE Hrm')]");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	
	
	/*
	 * @FindBy(name = "username") public WebElement username;
	 * 
	 * @FindBy(name = "password") public WebElement password;
	 * 
	 * @FindBy(xpath = "//button[contains(text(), 'Log in')]") public WebElement
	 * loginButton;
	 * 
	 * @FindBy(xpath = "//i[@class='caret']") public WebElement
	 * logoutButtonDropDown;
	 */

	/*
	 * public LoginPage(WebDriver driver) { PageFactory.initElements(driver,this); }
	 */

	public void login(String username, String password) {
		enterText(this.username, username);
		enterText(this.password, password);
		click(loginButton);

		/*
		 * this.username.sendKeys(username); this.password.sendKeys(password);
		 * this.loginButton.click();
		 */
	}
	// Reusable methods for login module
}
