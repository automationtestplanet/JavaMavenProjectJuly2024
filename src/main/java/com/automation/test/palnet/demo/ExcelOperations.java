package com.automation.test.palnet.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperations {
	
	public void readDataFromExcel(String flePath) throws Exception {
		File excelFile = new File(flePath);
		FileInputStream excelFis = new FileInputStream(excelFile);
		XSSFWorkbook workbook = new XSSFWorkbook(excelFis);
		XSSFSheet languagesSheet = workbook.getSheet("Languages");
		Iterator<Row> allROws = languagesSheet.rowIterator();

		while (allROws.hasNext()) {
			Row eachRow = allROws.next();
			Iterator<Cell> allCells = eachRow.cellIterator();
			while (allCells.hasNext()) {
				Cell eachCell = allCells.next();
				if (CellType.STRING == eachCell.getCellType()) {
					String cellData = eachCell.getStringCellValue();
					System.out.print(cellData+ " ");
				} else if (CellType.NUMERIC == eachCell.getCellType()) {
					double cellData = eachCell.getNumericCellValue();
					System.out.print(cellData+ " ");
				} else if (eachCell.getCellType() == CellType.BLANK) {
					String cellData = "";
					System.out.print(cellData+ " ");
				}
			}
			System.out.println();
		}		
		excelFis.close();
	}
	
	public void writeDataToExcel(String filePath,String sheetName, String cellValue) throws Exception {
		File excelFile = new File(filePath);
		FileInputStream excelFis = new FileInputStream(excelFile);
		XSSFWorkbook workbook = new XSSFWorkbook(excelFis);
		XSSFSheet newSheet = workbook.createSheet(sheetName);
		Row newRow = newSheet.createRow(0);
		Cell newCell = newRow.createCell(0);
		newCell.setCellValue(cellValue);		
		FileOutputStream fos = new FileOutputStream(excelFile);
		workbook.write(fos);
		fos.close();
	}

}
