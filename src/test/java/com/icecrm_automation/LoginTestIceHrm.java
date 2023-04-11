package com.icecrm_automation;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ice_hrm_automation.pages.LoginPage;
import com.icecrm_automation.utility.BaseClass;

public class LoginTestIceHrm extends BaseClass {
	LoginPage loginPage;

	@BeforeClass
	public void beforeClass() {
		System.out.println("This is before class method");
		launchBrowser("chrome");
		driver.navigate().to("https://icehrm.com/app/cybersuccess/login.php");
		loginPage = new LoginPage(driver);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void afterClass() {
		System.out.println("This is  after class method");
		driver.quit();
	}

	@Test
	public void verifyWithValidCredentials() {
		System.out.println("This is method to login");
		loginPage.login("admin", "2zuzfakn");
		if (driver.getTitle().equals("ICE Hrm")) {
			System.out.println("Loged in successfully by valid credentials");
		} else {
			System.out.println("Log in is unsuccessfully by valid credentials");
		}
		click(By.xpath("//i[@class='caret']"));
		click(By.xpath("//a[contains(text(),'Sign out')]"));
	}

	@Test(enabled = false)
	public void verifyWithValidUsername1() throws Exception {
		System.out.println("This is method to login with valid username");
		enterText(By.id("username"), "admin");
		enterText(By.id("password"), "2zuzfaknn"); // invalid password
		click(By.xpath("//button[(text()='Log in ')]"));
		String errorMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
		System.out.println(errorMsg);
		if (errorMsg.equals("Login failed")) {
			System.out.println("Loged in with valid username and invalid password");
		} else {
			throw new Exception("Login failed with valid usename and invalid password");
		}
	}

	@Test(enabled = false)
	public void verifyWithValidUsername2() throws Exception {
		System.out.println("This is method to login with valid username");
		enterText(By.id("username"), "admin"); // invalid username
		enterText(By.id("password"), "123");
		click(By.xpath("//button[(text()='Log in ')]"));
		String errorMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
		System.out.println(errorMsg);
		if (errorMsg.equals("Login failed")) {
			System.out.println("Loged in with invalid username and valid password");
		} else {
			throw new Exception("Login failed with invalid usename and valid password");
		}
	}

	@Test(enabled = false)
	public void verifyWithValidUsername3() throws Exception {
		System.out.println("This is method to login with valid username");
		enterText(By.id("username"), "admin"); // invalid username
		enterText(By.id("password"), "$%#@&*");
		click(By.xpath("//button[(text()='Log in ')]"));
		String errorMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
		System.out.println(errorMsg);
		if (errorMsg.equals("Login failed")) {
			System.out.println("Loged in with invalid username and valid password");
		} else {
			throw new Exception("Login failed with invalid usename and valid password");
		}
	}

	@Test(enabled = false)
	public void verifyWithValidUsername4() throws Exception {
		System.out.println("This is method to login with valid username");
		enterText(By.id("username"), "admin"); // invalid username
		enterText(By.id("password"), "12345536xyzer"); // invalid password
		click(By.xpath("//button[(text()='Log in ')]"));
		String errorMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
		System.out.println(errorMsg);
		if (errorMsg.equals("Login failed")) {
			System.out.println("Loged in with invalid username and password");
		} else {
			throw new Exception("Login failed with invalid usename and password");
		}
	}

	@Test(enabled = false)
	public void verifyWithValidUsername5() throws Exception {
		System.out.println("This is method to login with valid username");
		enterText(By.id("username"), "admin"); // invalid username
		enterText(By.id("password"), "asf123@#$%"); // invalid password
		click(By.xpath("//button[(text()='Log in ')]"));
		String errorMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
		System.out.println(errorMsg);
		if (errorMsg.equals("Login failed")) {
			System.out.println("Loged in with invalid username and password");
		} else {
			throw new Exception("Login failed with invalid usename and password");
		}

	}

	/*
	 * @Test public void verifyWithBlankUsernameAndPassword() throws Exception {
	 * System.out.println("This is method to login with valid username");
	 * 
	 * enterText(By.id("username"), ""); //blank username
	 * enterText(By.id("password"), ""); //blank password
	 * 
	 * click(By.xpath("//button[(text()='Log in ')]")); String errorMsg =
	 * driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
	 * System.out.println(errorMsg); if(errorMsg.equals("Login failed")){
	 * System.out.println("Loged in with invalid username and password"); }else {
	 * throw new Exception("Login failed with invalid usename and password"); } }
	 */

	@Test(enabled = false)
	public void verifyWithInvalidUsername1() throws Exception {
		System.out.println("This is method to login with valid username");
		enterText(By.id("username"), "ad123"); // invalid username
		enterText(By.id("password"), "2zuzfakn"); // invalid password
		click(By.xpath("//button[(text()='Log in ')]"));
		String errorMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
		System.out.println(errorMsg);
		if (errorMsg.equals("Login failed")) {
			System.out.println("Loged in with invalid username and password");
		} else {
			throw new Exception("Login failed with invalid usename and password");
		}

	}

	@Test(enabled = false)
	public void verifyWithInvalidUsername2() throws Exception {
		System.out.println("This is method to login with valid username");
		enterText(By.id("username"), "#$%asd"); // invalid username
		enterText(By.id("password"), "2zuzfakn"); // invalid password
		click(By.xpath("//button[(text()='Log in ')]"));
		String errorMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
		System.out.println(errorMsg);
		if (errorMsg.equals("Login failed")) {
			System.out.println("Loged in with invalid username and password");
		} else {
			throw new Exception("Login failed with invalid usename and password");
		}

	}

	@Test(enabled = false)
	public void resetPassword() {
		enterText(By.id("username"), "admin");
		click(By.xpath("//a[text()='Reset Password']"));
		// button[contains(text(),'Request Password Change')]
		String resetPassword = driver.findElement(By.xpath("//button[contains(text(),'Request Password Change')]"))
				.getText();
		if (resetPassword.equals("Request Password Change")) {
			System.out.println("Reset password page is displayed");
		} else {
			System.out.println("Reset password page is not displayed");
		}
		driver.close();
	}

	@Test(enabled = false)
	public void resetPassword1() {
		enterText(By.id("username"), "1234");
		click(By.xpath("//a[text()='Reset Password']"));
		// button[contains(text(),'Request Password Change')]
		String resetPassword = driver.findElement(By.xpath("//button[contains(text(),'Request Password Change')]"))
				.getText();
		if (resetPassword.equals("Request Password Change&nbsp;&nbsp;")) {
			System.out.println("Reset password page is displayed");
		} else {
			System.out.println("Reset password page is not displayed");
		}
		driver.close();
	}

	@Test(enabled = false)
	public void resetPassword2() {
		enterText(By.id("username"), "1234");
		enterText(By.id("password"), "ddf@#");
		click(By.xpath("//a[text()='Reset Password']"));
		// button[contains(text(),'Request Password Change')]
		String resetPassword = driver.findElement(By.xpath("//button[contains(text(),'Request Password Change')]"))
				.getText();
		if (resetPassword.equals("Request Password Change&nbsp;&nbsp;")) {
			System.out.println("Reset password page is displayed");
		} else {
			System.out.println("Reset password page is not displayed");
		}
		driver.close();
	}

	@Test(enabled = false)
	public void resetPassword3() {
		enterText(By.id("username"), "1234");
		enterText(By.id("password"), "2zuzfakn");
		click(By.xpath("//a[text()='Reset Password']"));
		// button[contains(text(),'Request Password Change')]
		String resetPassword = driver.findElement(By.xpath("//button[contains(text(),'Request Password Change')]"))
				.getText();
		if (resetPassword.equals("Request Password Change&nbsp;&nbsp;")) {
			System.out.println("Reset password page is displayed");
		} else {
			System.out.println("Reset password page is not displayed");
		}
		driver.close();
	}

	@Test(enabled = false)
	public void verifyResetPasswordLink() {
		enterText(By.id("username"), "admin");
		click(By.xpath("//a[text()='Reset Password']"));
		enterText(By.id("username"), "admin");
		click(By.xpath("//button[@onclick='requestPasswordChange();return false;']"));
		/*
		 * String resetPwdText = driver.findElement(By.xpath("")).getText();
		 * if(resetPwdText.equals("Request Password Change&nbsp;&nbsp;")) {
		 * System.out.println("Reset password page is displayed"); }else {
		 * System.out.println("Reset password page is not displayed"); }
		 */
		driver.close();
	}

	@Test(enabled = false)
	public void verifyResetPasswordLink2() {
		enterText(By.id("username"), "admin");
		click(By.xpath("//a[text()='Reset Password']"));
		enterText(By.id("username"), "admin");
		click(By.xpath("//div[@id='requestPasswordChangeFormAlert']/following-sibling::div[2]"));
		if (driver.getTitle().equals("IceHrm Login")) {
			System.out.println("Returned on login page successfully");
		} else {
			System.out.println("Not return on login page");
		}
		driver.close();
	}

}
