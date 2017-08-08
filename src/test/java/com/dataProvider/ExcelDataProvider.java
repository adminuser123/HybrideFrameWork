package com.dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;
	
	public ExcelDataProvider(){	
		File src = new File("./ApplicationtestData/AppData.xlsx");
		
		try {
			FileInputStream file = new FileInputStream(src);
			 wb = new XSSFWorkbook(file);
		} catch (Exception e) {
			
			System.out.println("The exception is" + e.getMessage());
		}		
	}
	
	public String getData(int sheetindex,int row,int coloum){
		
		String data= wb.getSheetAt(sheetindex).getRow(row).getCell(coloum).getStringCellValue();
		return data;
	
		
	}
public String getData(String sheetName,int row,int coloum){
		
		String data= wb.getSheet(sheetName).getRow(row).getCell(coloum).getStringCellValue();
		return data;

}
}
