package com.qc.ndtv.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

public class ReadData {

	Properties prop;
	
	public Properties getCommonData() throws IOException {	
		FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		return prop;
	}
	
	public Object[][] getMenuData(String sheetNumber) throws IOException {
		prop = getCommonData();
		FileInputStream fis = new FileInputStream(prop.getProperty("dataFile"));
		DataFormatter formatter = new DataFormatter();
		HSSFWorkbook book = new HSSFWorkbook(fis);
		HSSFSheet sheet = book.getSheet(sheetNumber);
		HSSFRow hrow = sheet.getRow(0);
		int rows = sheet.getPhysicalNumberOfRows();
		int columns = hrow.getLastCellNum();
		
		Object testData[][] = new Object[rows][columns];
		
		for(int i=0; i<rows; i++) {
			HSSFRow row = sheet.getRow(i + 1);
			for(int j =0; j<columns; j++) {
				if(row == null) {
					testData[i][j] = "";
				}else {
					HSSFCell cell = row.getCell(j);
					if(cell == null) {
						testData[i][j] = "";
					}else {
						String value = formatter.formatCellValue(cell);
						testData[i][j] = value;
					}
				}
			}
		}
		
		return testData;
		
	}
}
