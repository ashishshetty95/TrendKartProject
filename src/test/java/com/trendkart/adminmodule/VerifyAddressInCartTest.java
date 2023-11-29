package com.trendkart.adminmodule;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyAddressInCartTest {

	public static void main(String[] args) throws IOException {
		Properties p=new Properties();
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commondata.property");
		p.load(fis);
		String url = p.getProperty("url");
		String un=p.getProperty("Username");
		String pw=p.getProperty("Password");
		
		//Login as admin
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(un);
		driver.findElement(By.id("exampleInputPassword1")).sendKeys(pw);
		driver.findElement(By.name("login")).click();
		
		//Update Billing address
		driver.findElement(By.xpath("//a[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Shipping / Billing Address']")).click();
		HashMap<String, String> map = new HashMap<String, String>();
		FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sheet = wb.getSheet("BillingAddress");
		int billingRowCount = sheet.getLastRowNum();
		for(int i=0;i<=billingRowCount;i++) {
			String key = sheet.getRow(i).getCell(0).getStringCellValue();
			String value=sheet.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);		
		}
		for(Entry<String, String> set:map.entrySet()) {
			driver.findElement(By.name(set.getKey())).clear();
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
		driver.findElement(By.name("update")).click();
		Alert a=driver.switchTo().alert();
		a.accept();
		driver.findElement(By.xpath("//a[contains(.,'Shipping Address')]")).click();
		
		//Update Shipping Address
		
	    HashMap<String, String> map1 = new HashMap<String, String>();
	    Sheet sheet1=wb.getSheet("ShippingAddress");
	    int shippingRowCount = sheet1.getLastRowNum();
	    for(int i=0;i<=shippingRowCount;i++) {
	    	String key=sheet1.getRow(i).getCell(0).getStringCellValue();
	    	String value=sheet1.getRow(i).getCell(1).getStringCellValue();
	    	map1.put(key, value);
	    }
	    for(Entry<String, String> set:map1.entrySet()) {
	    	driver.findElement(By.name(set.getKey())).clear();
	    	driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
	    }
	    driver.findElement(By.name("shipupdate")).click();
	    driver.switchTo().alert().accept();
	    
	    //Add Product to Cart
	    driver.findElement(By.xpath("//a[@class='dropdown-toggle' and text()='Home']")).click();
	    driver.findElement(By.xpath("//li[@class='dropdown menu-item']/a[@class='dropdown-toggle'][1]")).click();
	    driver.findElement(By.xpath("//div[@class='row']/descendant::div[@class='product'][1]/descendant::a[contains(@href,'product')][2]")).click();
	    String productName=driver.findElement(By.xpath("//h1[@class='name']")).getText();
	    driver.findElement(By.xpath("//a[.=' ADD TO CART']")).click();
	    driver.switchTo().alert().accept();
	    
	    //Verify address
	    ArrayList<String> al=new ArrayList<String>();
	    int cartBillCount=wb.getSheet("CartBilling").getLastRowNum();
	    for(int i=0;i<=cartBillCount;i++) {
	    	String name=wb.getSheet("CartBilling").getRow(i).getCell(0).getStringCellValue();
	    	al.add(name);
	    }
	    int count1=0;
	    for(int i=0;i<al.size();i++) {
	    	
	    	String t=al.get(i);
	    	String t1=driver.findElement(By.name(t)).getAttribute("value");
	    	String t2=wb.getSheet("BillingAddress").getRow(i).getCell(1).getStringCellValue();
	    	if (t2.equals(t1)) {
				count1++;
			}
	    	if (count1==4) {
				System.out.println("Billing address is matching");
			}
	    }
	    
	    ArrayList<String> al2=new ArrayList<String>();
	    int cartShipCount=wb.getSheet("CartShipping").getLastRowNum();
	    for(int i=0;i<=cartShipCount;i++) {
	    	String name=wb.getSheet("CartShipping").getRow(i).getCell(0).getStringCellValue();
	    	al2.add(name);
	    }
	    int count=0;
	    for(int i=0;i<al2.size();i++) {
	    	
	    	String t=al2.get(i);
	    	String t1=driver.findElement(By.name(t)).getAttribute("value");
	    	String t2=wb.getSheet("ShippingAddress").getRow(i).getCell(1).getStringCellValue();
	    	if (t2.equals(t1)) {
				count++;
			}
	    	if (count==4) {
				System.out.println("Shipping address is matching");
			}
	    }
	    
	    driver.findElement(By.name("ordersubmit")).click();
	    
	    //Payment
	    //driver.findElement(By.xpath("//input[@value='COD']")).click();
	    driver.findElement(By.name("submit")).click();
	    String lastProduct=driver.findElement(By.xpath("(//h4[@class='cart-product-description'])[last()]/a")).getText();
	    System.out.println(lastProduct);
	    System.out.println(productName);
	    if (lastProduct.equalsIgnoreCase(productName)) {
			System.out.println("Order placed successfully");
		}
		}

}
