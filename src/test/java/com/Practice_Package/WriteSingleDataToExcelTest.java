package com.Practice_Package;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteSingleDataToExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet("SingleData").createRow(2).createCell(0).setCellValue("Accenture");
		
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\testscriptdata.xlsx");
		wb.write(fos);
		wb.close();

	}

}
