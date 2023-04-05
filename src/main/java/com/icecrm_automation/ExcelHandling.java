package com.icecrm_automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;

import javax.management.RuntimeErrorException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelHandling {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();

		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.findElement(By.xpath("//a[text()='Employee List']")).click();

		String filePath = "C:\\Rohan\\TestData.xlsx";
		String extension = filePath.substring(filePath.indexOf(".") + 1);
		System.out.println(extension);

		Workbook workbook = null;
		try {
			FileInputStream inputStream = new FileInputStream(filePath);
			if (extension.equals("xlsx")) {
				workbook = new XSSFWorkbook(inputStream);
			} else if (extension.equals("xlx")) {
				workbook = new HSSFWorkbook(inputStream);
			}

			org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet("TestData");
			if (sheet == null) {
				sheet = workbook.createSheet("TestData");
			}

			Cell cell = sheet.createRow(0).createCell(0);
			cell.setCellValue("Cyber Success");
			FileOutputStream outputStream = new FileOutputStream(filePath);
			workbook.write(outputStream);
			workbook.close();

		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
