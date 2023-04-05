package com.icecrm_automation.utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil0 {

	private Workbook workbook;
	private Sheet sheet1;
	
	public Object[][] getExcelData(String filePath, String sheetName) {
		try {
			FileInputStream inputStream = new FileInputStream(filePath);
			System.out.println(filePath);
			String fileExtension = filePath.substring(filePath.indexOf(".") + 1);
			System.out.println("Excel file extension is " + fileExtension);
			if (fileExtension.equals("xlsx")) {
				//System.out.println("I am here xssf");
				workbook = new XSSFWorkbook();
			} else {
				workbook = new HSSFWorkbook();
				System.out.println("I am here hssf");
			}
			System.out.println(sheetName);
			System.out.println(workbook.getNumberOfSheets());
			sheet1 = workbook.getSheet("Sheet1");
			System.out.println("hi "+sheet1);   
			int totalRows = sheet1.getPhysicalNumberOfRows(); // Showing error at this line
			System.out.println(totalRows);
			int totalCulumns = sheet1.getRow(0).getPhysicalNumberOfCells();
			System.out.println(totalCulumns);

			Object[][] object = new Object[totalRows - 1][totalCulumns];

			for (int i = 1; i < totalRows; i++) {
				for (int j = 0; j < totalCulumns; j++) {
					Cell cell = sheet1.getRow(i).getCell(j);
					if (cell.getCellType().equals(CellType.STRING)) {
						object[i - 1][j] = cell.getStringCellValue();
					} else if (cell.getCellType().equals(CellType.NUMERIC)) {
						object[i - 1][j] = cell.getNumericCellValue();
					} else if (cell.getCellType().equals(CellType.BLANK)) {
						System.out.println("Blank Value");
						object[i - 1][j] = null;
					}
				}
			}
			workbook.close();
			inputStream.close();

			return object;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}

//This program has NullPointerException Error
