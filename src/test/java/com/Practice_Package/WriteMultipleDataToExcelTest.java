package com.Practice_Package;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteMultipleDataToExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet("MultipleData").createRow(7).createCell(0).setCellValue("Samsung");
		wb.getSheet("MultipleData").getRow(7).createCell(1).setCellValue("Mangalore");
		FileOutputStream fos1=new FileOutputStream(".\\src\\test\\resources\\testscriptdata.xlsx");
		wb.write(fos1);
		int rowCount = wb.getSheet("MultipleData").getLastRowNum();
		int cellCount = wb.getSheet("MultipleData").getRow(0).getLastCellNum();
		for(int i=0;i<=rowCount;i++) {
			for(int j=0;j<cellCount;j++) {
				String value = wb.getSheet("MultipleData").getRow(i).getCell(j).getStringCellValue();
				System.out.print(value+" ");
			}
			System.out.println();
		}
		wb.close();
	}

}
