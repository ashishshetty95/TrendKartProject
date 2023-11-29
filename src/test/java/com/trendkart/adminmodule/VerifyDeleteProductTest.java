package com.trendkart.adminmodule;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyDeleteProductTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//fetch commondata from property file
		Properties p=new Properties();
		FileInputStream pfis=new FileInputStream(".\\src\\test\\resources\\commondata.property");
		p.load(pfis);
		String adminurl = p.getProperty("adminurl");
		String adminun=p.getProperty("adminun");
		String adminpw=p.getProperty("adminpw");
		String url=p.getProperty("url");
		
		//Login
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(adminurl);
		driver.findElement(By.id("inputEmail")).sendKeys(adminun);
		driver.findElement(By.id("inputPassword")).sendKeys(adminpw);
		driver.findElement(By.name("submit")).click();
		
		//Create Category
		driver.findElement(By.xpath("//a[.=' Create Category ']")).click();
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String categoryName = wb.getSheet("CreateCategory").getRow(1).getCell(0).getStringCellValue();
		String categoryDescription=wb.getSheet("CreateCategory").getRow(1).getCell(1).getStringCellValue();
		driver.findElement(By.name("category")).sendKeys(categoryName);
		driver.findElement(By.name("description")).sendKeys(categoryDescription);
		driver.findElement(By.name("submit")).click();
		String categoryConfirm = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		String categoryConfirmText = wb.getSheet("CreateCategory").getRow(1).getCell(3).getStringCellValue();
		if (categoryConfirm.contains(categoryConfirmText)) {
			System.out.println("Category creation successful");
		}
		
		//Create SubCategory
		driver.findElement(By.xpath("//a[.='Sub Category ']")).click();
		WebElement Category = driver.findElement(By.name("category"));
		Select s=new Select(Category);
		s.selectByVisibleText(categoryName);
		String subCategoryName = wb.getSheet("SubCategory").getRow(1).getCell(0).getStringCellValue();
		driver.findElement(By.xpath("//input[@name='subcategory']")).sendKeys(subCategoryName);
		driver.findElement(By.name("submit")).click();
		String subCategoryConfirm = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		String subCategoryConfirmText = wb.getSheet("SubCategory").getRow(1).getCell(2).getStringCellValue();
		if (subCategoryConfirm.contains(subCategoryConfirmText)) {
			System.out.println("Sub Category creation successful");
		}
		
		//Insert product
		driver.findElement(By.xpath("//a[.='Insert Product ']")).click();
		WebElement CategoryDD = driver.findElement(By.name("category"));
		Select s1=new Select(CategoryDD);
		s1.selectByVisibleText(categoryName);
		WebElement subCategoryDD=driver.findElement(By.name("subcategory"));
		Select s2=new Select(subCategoryDD);
		s2.selectByVisibleText(subCategoryName);
		
		Sheet sheet = wb.getSheet("InsertProduct");
		int rowCount = sheet.getLastRowNum();
		HashMap<String, String> map = new HashMap<String, String>();
		for(int i=0;i<=rowCount;i++) {
			String key = sheet.getRow(i).getCell(0).getStringCellValue();
			String value = sheet.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		
		for(Entry<String, String> set:map.entrySet()) {
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
		
		WebElement productAvailabilityDD = driver.findElement(By.name("productAvailability"));
		Select s3=new Select(productAvailabilityDD);
		String productAvailability = wb.getSheet("InsertProduct").getRow(1).getCell(3).getStringCellValue();
		s3.selectByVisibleText(productAvailability);
		
		File f1 = new File(".\\src\\test\\resources\\MOTO_BACKCASE1.jpg");
		String path1=f1.getAbsolutePath();
		driver.findElement(By.name("productimage1")).sendKeys(path1);
		File f2 = new File(".\\src\\test\\resources\\MOTO_BACKCASE2.jpg");
		String path2 = f2.getAbsolutePath();
		driver.findElement(By.name("productimage2")).sendKeys(path2);
		File f3 = new File(".\\src\\test\\resources\\MOTO_BACKCASE3.jpg");
		String path3 = f3.getAbsolutePath();
		driver.findElement(By.name("productimage3")).sendKeys(path3);
		driver.findElement(By.name("submit")).click();
		String insertProductText=driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		String insertProductConfirmationText="Product Inserted Successfully";
		if (insertProductText.contains(insertProductConfirmationText)) {
			System.out.println("Product inserted successfully");
		}
		
		//Logout
		driver.findElement(By.xpath("//i[@class='menu-icon icon-signout']/parent::a[@href='logout.php']")).click();
		
		//Login as user
		driver.get(url);
		String productName = wb.getSheet("InsertProduct").getRow(0).getCell(1).getStringCellValue();
		driver.findElement(By.name("product")).sendKeys(productName+Keys.ENTER);
		if (driver.findElement(By.xpath("//a[text()='"+productName+"']")).isDisplayed()) {
			System.out.println(productName+" is displayed");
		}
		
		//Login as admin and delete the added product
		driver.get(adminurl);
		driver.findElement(By.id("inputEmail")).sendKeys(adminun);
		driver.findElement(By.id("inputPassword")).sendKeys(adminpw);
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//a[.='Manage Products ']")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(productName);
		if (driver.findElement(By.xpath("//td[text()='"+productName+"']")).isDisplayed()) {
			System.out.println(productName+" details are displayed");
		}
		driver.findElement(By.xpath("//i[@class='icon-remove-sign']")).click();
		Alert a=driver.switchTo().alert();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		a.accept();
		String deleteProductConfirmation = driver.findElement(By.xpath("//div[@class='alert alert-error']")).getText();
		if (deleteProductConfirmation.contains(insertProductText)) {
			System.out.println("Product deleted successfully");
		}
		
		//Logout
		driver.findElement(By.xpath("//i[@class='menu-icon icon-signout']/parent::a[@href='logout.php']")).click();
		
		//Login as user
				driver.get(url);
				driver.findElement(By.name("product")).sendKeys(productName+Keys.ENTER);
				if (driver.findElement(By.xpath("//div[@class='col-sm-6 col-md-4 wow fadeInUp animated']")).isDisplayed()) {
					System.out.println(productName+" is deleted");
				}	
	}

}
