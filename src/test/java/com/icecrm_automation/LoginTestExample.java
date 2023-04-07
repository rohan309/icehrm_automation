package com.icecrm_automation;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.icecrm_automation.utility.BaseClass;

public class LoginTestExample extends BaseClass {

	String firstName = "Rohan";
	String lastName = "More";
	String empId = "001";

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This is method to launch the browser by @BeforeMethod");
		launchBrowser("edge");
		driver.navigate().to("https://cybersuccess.icehrm.com/");
		driver.manage().window().maximize();
		enterText(By.id("username"), "admin");
		enterText(By.id("password"), "2zuzfakn");
		click(By.xpath("//button[contains(text(),'Log in')]"));
		click(By.xpath("//span[contains(text(),'Employees')]"));
		click(By.xpath("//ul[@id='admin_Employees']/li[1]/a"));

	}

	@Test
	public void addEmp() {
		System.out.println("This is add Employee method from @Test");
		click(By.xpath("//span[contains(text(),' Add New')]"));
		enterText(By.id("employee_id"), empId);
		enterText(By.id("first_name"), firstName);
		enterText(By.id("last_name"), lastName);
		dropDrown(By.id("rc_select_0"), "American");
		dropDrown(By.xpath("//input[@aria-owns=\"rc_select_0_list\"]"), "American");
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='ant-modal-wrap']]")));
		scroll(500);
		//selectBirthdate(By.xpath(""), 12, "Jun", "2022");  //Method is removed from BaseClass
		dropDrown(By.xpath("//input[@aria-owns='rc_select_1_list']"), "Male");
		dropDrown(By.xpath("//input[@aria-controls='rc_select_2_list']"), "Single");
		click(By.xpath("//span[contains(text(),'Save')]"));

	}

	@Test
	public void verifyEmp() {
		System.out.println("This is verify Employee method from @Test");
		String name = driver.findElement(By.xpath("")).getText();
		if (name == firstName) {
			System.out.println("First name entered in form is present in employee section : Test case is pass");
		} else {
			System.out.println("First name entered in form is not present in employee section : Test case is fail");
		}
	}

	@AfterMethod
	public void tearDown() {
		System.out.println("This is tearDown method from @AfterTest");

		click(By.xpath("//i[@class='glyphicon glyphicon-user']"));
		click(By.xpath("//a[contains(text(),'Sign out')]"));
		driver.quit();

	}

}
