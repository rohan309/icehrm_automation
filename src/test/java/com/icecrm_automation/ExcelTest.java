package com.icecrm_automation;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ice_hrm_automation.pages.EmpDetaials;
import com.icecrm_automation.utility.BaseClass;
import com.icecrm_automation.utility.ExcelUtil1;

public class ExcelTest extends BaseClass{

	@DataProvider
	public Object[][] getTestData() {
		ExcelUtil1 excelUtil = new ExcelUtil1();
		String filePath = "D:\\Documents\\Book1.xlsx";
		// String filePath = "‪C:\\Book1.xlsx"; //Error(NullPointerException)
		String sheetName = "Sheet1";
		return excelUtil.getExcelData(filePath, sheetName);
	}

	@Test(dataProvider = "getTestData")
	public void test(String username, String password) {
		System.out.println(username + " " + password);
	}

	@DataProvider
	public Object[][] getEmpData() {
		ExcelUtil1 excelUtil = new ExcelUtil1();
		String filePath = "‪D:\\Documents\\EmpData.xlsx";
		String sheetName = "Sheet1";
		return excelUtil.getEmpData(filePath, sheetName);
	}

	@BeforeMethod
	public void launchBrowser() {
		launchBrowser("edge");
		driver.navigate().to("https://cybersuccess.icehrm.com/");
		enterText(By.id("username"), "admin");
		enterText(By.id("password"), "2zuzfakn");
		click(By.xpath("//button[text()='Log in ']"));
	}
	
	@Test(dataProvider = "getEmpData")
	public void addEmp(EmpDetaials empDetaials) {
		click(By.xpath("//span[text()='Employees']"));
		click(By.xpath("//a[text()=' Employees ']"));
		click(By.xpath("//span[text()=' Add New']"));
		enterText(By.id("employee_id"), String.valueOf(empDetaials.getEmployeeNumber()));
		enterText(By.id("first_name"), empDetaials.getfirstName());
		enterText(By.id("middle_name"), empDetaials.getmiddleName());
		enterText(By.id("last_name"), empDetaials.getlastName());
		dropDrown(By.id("rc_select_0"), empDetaials.getNationality());
		scroll(500);
		//select date here
		dropDrown(By.id("rc_select_1"), empDetaials.getGender());
		dropDrown(By.id("rc_select_2"), empDetaials.getMarritalStatus());
		click(By.xpath("//span[text()='Save']"));
		
	}
	
	@AfterMethod
	public void afterMethod() {
		click(By.xpath("//span[text()='I ']"));
		click(By.xpath("//a[text()='Sign out']"));
		driver.close();
	}

}
