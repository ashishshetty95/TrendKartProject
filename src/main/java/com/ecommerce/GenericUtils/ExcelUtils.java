package com.ecommerce.GenericUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class ExcelUtils {
	/**
	 * This method is used to read the data from excel
	 * @author Ashish Shetty
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return String
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	public String readDataFromExcelRandom(String sheetName, int row, int cell) throws EncryptedDocumentException, IOException {
		JavaUtils j=new JavaUtils();
		int r=j.getRandomNumber(100);
		FileInputStream fis = new FileInputStream(iPathConstants.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		data=data+r;
		return data;
	}
	/**
	 * This method is used to read the data from excel
	 * @author Ashish Shetty
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheetName, int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(iPathConstants.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		return data;
	}
	/**
	 * This method is used to get the total row count
	 * @author Ashish Shetty
	 * @param sheetName
	 * @return
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	public int getLastRowNo(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(iPathConstants.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		int count=wb.getSheet(sheetName).getLastRowNum();
		return count;
	}
	
	/**
	 * This method is used to read single data from excel file
	 * @author Ashish Shetty
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @param data
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	public void writeSingleDataToExcel(String sheetName, int row, int cell, String data) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(iPathConstants.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).createRow(row).createCell(cell).setCellValue(data);
	}
	/**
	 * This method is used to read multiple data from excel
	 * @param driver
	 * @param sheetName
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void readTwoColumnDataFromExcelId(WebDriver driver, String sheetName) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream(iPathConstants.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount=sh.getLastRowNum();
		HashMap<String, String> map = new HashMap<String, String>();
		for(int i=0;i<=rowCount;i++) {
			String key=sh.getRow(i).getCell(0).getStringCellValue();
				String value=sh.getRow(i).getCell(1).getStringCellValue();
				value=sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		for(Entry<String, String> set:map.entrySet()) {
			driver.findElement(By.id(set.getKey())).clear();
			driver.findElement(By.id(set.getKey())).sendKeys(set.getValue());
		}
		}
	
	/**
	 * This method is used to read multiple data from excel
	 * @param driver
	 * @param sheetName
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void readTwoColumnDataFromExcelName(WebDriver driver, String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(iPathConstants.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount=sh.getLastRowNum();
		HashMap<String, String> map = new HashMap<String, String>();
		for(int i=0;i<=rowCount;i++) {
			String key=sh.getRow(i).getCell(0).getStringCellValue();
				String value=sh.getRow(i).getCell(1).getStringCellValue();
				value=sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		for(Entry<String, String> set:map.entrySet()) {
			driver.findElement(By.name(set.getKey())).clear();
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
		}
	/**
	 * This method is used to validate the data
	 * @param driver
	 * @param expSheet
	 * @param resSheet
	 * @param c
	 * @throws Throwable
	 * @throws IOException
	 */
	public void verifyEnteredData(WebDriver driver, String expSheet, String resSheet, int c) throws Throwable, IOException {
		 ArrayList<String> al=new ArrayList<String>();
		 FileInputStream fis=new FileInputStream(iPathConstants.EXCELPATH);
		 Workbook wb = WorkbookFactory.create(fis);
		 Sheet sh = wb.getSheet(expSheet);
		 int rowCount=sh.getLastRowNum();
		    for(int i=0;i<=rowCount;i++) {
		    	String name=wb.getSheet(expSheet).getRow(i).getCell(0).getStringCellValue();
		    	al.add(name);
		    }
		    int count=0;
		    for(int i=0;i<al.size();i++) {
		    	
		    	String t=al.get(i);
		    	String t1=driver.findElement(By.name(t)).getAttribute("value");
		    	String t2=wb.getSheet(resSheet).getRow(i).getCell(1).getStringCellValue();
		    	if (t2.equals(t1)) {
					count++;
				}
		    }
		    if (count!=c) {
				Assert.fail();
			}		   
	}
	
	public Object[][] readDataUsingDataProviderFromExcel(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(iPathConstants.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		int rowCount=sh.getLastRowNum();
		int cellCount=sh.getRow(0).getLastCellNum();
		Object[][] obj = new Object[rowCount+1][cellCount];
		for(int i=0;i<=rowCount;i++) {
			for(int j=0;j<cellCount;j++) {
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
	
	}
	
