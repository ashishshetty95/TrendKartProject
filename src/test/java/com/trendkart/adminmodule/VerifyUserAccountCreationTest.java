package com.trendkart.adminmodule;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyUserAccountCreationTest {

	public static void main(String[] args) throws IOException {
		Properties p=new Properties();
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commondata.property");
		p.load(fis);
		String url=p.getProperty("url");
		String adminurl=p.getProperty("adminurl");
		String adminun=p.getProperty("adminun");
		String adminpw=p.getProperty("adminpw");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.xpath("//a[.='Login']")).click();
		HashMap<String, String> map = new HashMap<String, String>();
		FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("CreateAccount");
		int rowCount=sh.getLastRowNum();
		String username=sh.getRow(0).getCell(1).getStringCellValue();
		String mailid=sh.getRow(1).getCell(1).getStringCellValue();
		for(int i=0;i<=rowCount;i++) {
			String key=sh.getRow(i).getCell(0).getStringCellValue();
			String value=sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		for(Entry<String, String> set:map.entrySet()) {
			driver.findElement(By.id(set.getKey())).sendKeys(set.getValue());
		}
		driver.findElement(By.id("submit")).click();
		driver.switchTo().alert().accept();
		driver.get(adminurl);
		driver.findElement(By.name("username")).sendKeys(adminun);
		driver.findElement(By.name("password")).sendKeys(adminpw);
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//a[contains(.,'Manage users')]")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username);
		String name=driver.findElement(By.xpath("//table[@class='datatable-1 table table-bordered table-striped  display dataTable']/descendant::td[2]")).getText();
		String email=driver.findElement(By.xpath("//table[@class='datatable-1 table table-bordered table-striped  display dataTable']/descendant::td[3]")).getText();
		String phone=driver.findElement(By.xpath("//table[@class='datatable-1 table table-bordered table-striped  display dataTable']/descendant::td[4]")).getText();
		System.out.println(mailid+" "+email);
		if (mailid.equals(email)) {
			System.out.println("Profile created successfully");
		}
		else {
			System.out.println("Profile not created");
		}
		driver.findElement(By.xpath("//i[@class='menu-icon icon-signout']/parent::a[@href='logout.php']")).click();
	}

}
