package com.icecrm_automation.utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil1 {

	private Workbook workbook;
	private Sheet sheet;

	public Object[][] getExcelData(String filePath, String sheetName) {
		// C:/data/excel.xlsx
		try {
			FileInputStream inputStream = new FileInputStream(filePath);
			String extension = filePath.substring(filePath.indexOf(".") + 1);
			System.out.println(extension);
			if (extension.equals("xlsx")) {
				workbook = new XSSFWorkbook(inputStream);
			} else {
				workbook = new HSSFWorkbook(inputStream);
			}
			sheet = workbook.getSheet(sheetName);
			int totalRows = sheet.getPhysicalNumberOfRows();
			int totalColumns = sheet.getRow(0).getPhysicalNumberOfCells();
			// create 2 dimensional object with total rows and columns
			Object[][] object = new Object[totalRows - 1][totalColumns];

			for (int i = 1; i < totalRows; i++) { // to iterate through rows
				for (int j = 0; j < totalColumns; j++) {
					Cell cell = sheet.getRow(i).getCell(j);
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

	public Object[][] getEmpData(String filePath, String sheetName) {
		try {
			FileInputStream inputStream = new FileInputStream(filePath);
			String extension = filePath.substring(filePath.indexOf(".") + 1);
			System.out.println(extension);
			if (extension.equals("xlsx")) {
				workbook = new XSSFWorkbook();
			} else {
				workbook = new HSSFWorkbook();
			}
			sheet = workbook.getSheet(sheetName);
			int totalRows = sheet.getPhysicalNumberOfRows();
			int totalCoulumns = sheet.getRow(0).getPhysicalNumberOfCells();

			Object[][] object = new Object[totalRows - 1][totalCoulumns];

			for (int i = 1; i < totalRows; i++) {
				for (int j = 0; j < totalCoulumns; j++) {
					Cell cell = sheet.getRow(i).getCell(j);
					if (cell.getCellType().equals(CellType.STRING)) {
						object[i - 1][j] = cell.getStringCellValue();
					} else if (cell.getCellType().equals(CellType.NUMERIC)) {
						object[i - 1][j] = cell.getNumericCellValue();
					} else if (cell.getCellType().equals(CellType.BLANK)) {
						System.out.println("Blank");
						object[i - 1][j] = null;
					}
				}
			}
			workbook.close();
			inputStream.close();
			return object;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
