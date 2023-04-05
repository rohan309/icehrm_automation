package com.icecrm_automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DropDownOperation {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
		WebDriver driver = new EdgeDriver();

		driver.navigate().to("https://cybersuccess.icehrm.com/");

		WebElement username = driver.findElement(By.xpath("//input[@id=\"username\"]"));
		username.sendKeys("admin");

		WebElement password = driver.findElement(By.xpath("//input[@id=\"password\"]"));
		password.sendKeys("2zuzfakn");

		driver.findElement(By.xpath("//button[contains(text(),'Log in ')]")).click();
		Thread.sleep(3000);

		String homeText = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
		System.out.println(homeText);

		if (homeText.equals(homeText)) {
			System.out.println("Succefully loged in: Home text is displayed");
		} else {
			System.out.println("Unable to log in: Home text is not displayed");
		}

		/*
		 * WebElement ieButton =
		 * driver.findElement(By.xpath("//a[contains(text(),'I E')]=IE xpath "));
		 * 
		 * if(ieButton.isDisplayed()) { System.out.println("IE button is displayed");
		 * }else { System.out.println("IE button is not displayed"); }
		 */

		driver.findElement(By.xpath("//span[text()='Employees']")).click(); // employee button
		driver.findElement(By.xpath("//ul[@id='admin_Employees']/li[1]/a")).click(); // employees
		Thread.sleep(5000);
		String addNew = driver.findElement(By.xpath("//span[text()=\" Add New\"]")).getText(); // add new
		{
			System.out.println(addNew);

			if (addNew.equals("Add New")) {
				System.out.println("Add new page is displayed");
			} else {
				System.out.println("Add new page is not displayed");
			}

			driver.findElement(By.xpath("//span[text()=\" Add New\"]")).click();
			driver.findElement(By.xpath("//input[@id=\"employee_id\"]")).sendKeys("001");
			driver.findElement(By.xpath("//input[@id=\"first_name\"]")).sendKeys("Rohan");
			driver.findElement(By.xpath("//input[@id=\"middle_name\"]")).sendKeys("Ashok");
			driver.findElement(By.xpath("//input[@id=\"last_name\"]")).sendKeys("More");
			Thread.sleep(3000);

			WebElement selectNationality = driver.findElement(By.xpath("//input[@id\"rc_select_0\"]"));
			selectNationality.click();
			Thread.sleep(3000);

			List<WebElement> nationalityDropDown = driver
					.findElements(By.xpath("//div[@id='rc_select_0_list']/following-sibling::div/div/div/div/div/div"));
			for (int i = 0; i < nationalityDropDown.size(); i++) {
				WebElement element = nationalityDropDown.get(i);
				String value = element.getText();
				if (value.equals("American")) {
					System.out.println(value);
					break;
				}
			}

			String selectedCountry = driver.findElement(By.xpath("//span[@title='American']")).getText();

			if (selectedCountry.equals("American")) {
				System.out.println("American nationality is selected");
			} else {
				System.out.println("American nationality is not selected");
			}
			Thread.sleep(3000);

			driver.findElement(By.xpath("//input[@class=\"ant-select-selection-search-input\"rc_select_1_list\"]"))
					.click();

			List<WebElement> genderValues = driver.findElements(
					By.xpath("//div[@id=\"rc_select_33_list\"]/following-sibling::div/div/div/div/div/div"));
			for (int i = 0; i < genderValues.size(); i++) {
				WebElement element = genderValues.get(i);
				String value = element.getText();
				if (value.equals("Male")) {

					System.out.println("Gender is selected: Male");
				} else {
					System.out.println("Gender is not selected");
				}
			}

		}
	}
}
