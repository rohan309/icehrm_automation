package com.orangehrm_automation.pages;

import org.openqa.selenium.By;

import com.icecrm_automation.utility.BaseClass;

public class MyInfoPage extends BaseClass {

	public By myInfoMenu = By.xpath("//span[text()='My Info']");
	public By profileImg = By.xpath("//img[@class='employee-image']");
	public By addImg = By.xpath("//i[@class='oxd-icon bi-plus']");
	public By saveButton = By.xpath("//button[@type='submit']");

}
