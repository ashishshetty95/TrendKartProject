package com.Practice_Package;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sheet = wb.getSheet("MultipleData");
		int rowcount = sheet.getLastRowNum();
		int cellCount = sheet.getRow(0).getLastCellNum();
		System.out.println(rowcount);
		System.out.println(cellCount);
		
		for(int i=0;i<=rowcount;i++) {
			for(int j=0;j<cellCount;j++) {
				String value = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.print(value+" ");				
			}
			System.out.println();
		}
	}

}
