package com.icecrm_automation;


import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.icecrm_automation.utility.BaseClass;

public class OrangeHrmTesting extends BaseClass {

	String firstName = "Rohan";
	String middleName = "Ashok";
	String lastName = "More";
	String empId = "001"; // 0342001

	@BeforeClass
	public void beforeClass() {
		System.out.println("This is before class method");
		System.out.println("Launching broweser by Before method");
		launchBrowser("chrome");
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("This is after class method");
		driver.close();
	}
	
	@BeforeMethod
	public void beforeMethod() {
		
		driver.manage().window().maximize();
		enterText(By.name("username"), "Admin");
		enterText(By.name("password"), "admin123");
		click(By.xpath("//button[@type='submit']"));
	}

	@Test
	public void createEmp() {
		click(By.xpath("//span[text()='PIM']"));
		scroll(500);
		click(By.xpath("//button[text()=' Add ']"));
		enterText(By.name("firstName"), firstName);
		enterText(By.name("middleName"), middleName);
		enterText(By.name("lastName"), lastName);
		enterText(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input"), empId);
		click(By.xpath("//div[@class='oxd-form-actions']/button[2]"));
	}
	@Test
	public void verifyEmp() throws Exception {
		click(By.xpath("//span[text()='PIM']"));
		enterText(By.xpath("//label[contains(text(),'Employee Name')]/parent::div/following-sibling::div"), lastName);
		click(By.xpath("//button[@type='reset']/following-sibling::button"));
		scroll(500);
		String sirName = driver.findElement(By.xpath("//div[@class='oxd-table-header']/following-sibling::div/div/div/div[4]")).getText();
		if(sirName.equals(lastName)) {
			System.out.println("Emp verified successfully");
		}else {
			throw new Exception();
		}
	}
	
	@AfterMethod
	public void afterMethod() {

		click(By.xpath("//span[@class='oxd-userdropdown-tab']/i"));
	}
}
