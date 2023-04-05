package com.icecrm_automation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ice_hrm_automation.pages.LoginPage;
import com.icecrm_automation.utility.BaseClass;
import com.icecrm_automation.utility.PropertyHandling;

public class LoginTest extends BaseClass {
	PropertyHandling properties;
	LoginPage loginPage;

	@BeforeClass
	public void start() {
		properties = new PropertyHandling();
		launchBrowser(properties.getProperties("browser"));
		driver.get(properties.getProperties("icehrmurl"));
		loginPage = new LoginPage(driver);
		System.out.println("This is valaue "+driver);
	}
	


	@Test(dataProvider = "getLoginData")
	public void verifyLogin(String username, String password, String errorMsg) {
		loginPage.login(username, password);
		if (!username.isEmpty() && !password.isEmpty()) {
			String errorMessage = driver.findElement(loginPage.errorMsg).getText();
			//String winText = driver.findElement(loginPage.homeText).getText();
			Assert.assertEquals(errorMessage, errorMsg);
			
			/*
			 * if (errorMessage.equals("Login failed")) { //error at this line
			 * Assert.assertEquals(errorMessage, errorMsg); } else {
			 * Assert.assertEquals(winText, homeText); }
			 */
			
			
			
		}
	}

	@DataProvider
	public Object[][] getLoginData() {
		Object[][] data = new Object[][] { 
			    { "admin123", "admin", "Login failed" },
				/*
				 * { "admin", "admin124", "Login failed" }, { "admin123", "2zuzfakn",
				 * "Login failed" }, { "", "", "" }, { "", "2zuzfakn", "" }, { "admin", "", ""
				 * },
				 */
				 /* { "admin", "2zuzfakn", "ICE Hrm" }*/
				};
		return data;
	}

	@AfterClass
	public void afterClass() {
//		String text = driver.findElement(By.xpath("//div[contains(text(),'ICE Hrm')]")).getText();
//		if (text.equals("ICE Hrm")) {
//			click(By.xpath("//i[@class='glyphicon glyphicon-user']/following-sibling::span"));
//			click(By.xpath("//a[text()='Sign out']"));
//		} 
//		driver.close();
//		
	}
}
