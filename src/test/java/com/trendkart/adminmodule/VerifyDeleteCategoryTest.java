package com.trendkart.adminmodule;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyDeleteCategoryTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		Properties p=new Properties();
		FileInputStream pfis=new FileInputStream(".\\src\\test\\resources\\commondata.property");
		p.load(pfis);
		String adminurl=p.getProperty("adminurl");
		String adminun=p.getProperty("adminun");
		String adminpw=p.getProperty("adminpw");
		String url=p.getProperty("url");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(adminurl);
		driver.findElement(By.id("inputEmail")).sendKeys(adminun);
		driver.findElement(By.id("inputPassword")).sendKeys(adminpw);
		driver.findElement(By.name("submit")).click();
		
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
		
		driver.findElement(By.xpath("//i[@class='menu-icon icon-signout']/parent::a[@href='logout.php']")).click();
		
		driver.get(url);
		List<WebElement> categories = driver.findElements(By.xpath("//nav[@class='yamm megamenu-horizontal']/descendant::a[@class='dropdown-toggle']"));
		int size=categories.size();
		for(int i=0;i<size;i++) {
			String category=categories.get(i).getText();
			if (category.equalsIgnoreCase(categoryName)) {
				System.out.println("Category is present");
				break;
			}
		}
		
		driver.get(adminurl);
		driver.findElement(By.id("inputEmail")).sendKeys(adminun);
		driver.findElement(By.id("inputPassword")).sendKeys(adminpw);
		driver.findElement(By.name("submit")).click();
		
		driver.findElement(By.xpath("//a[.=' Create Category ']")).click();
		driver.findElement(By.xpath("//input[@aria-controls='DataTables_Table_0']")).sendKeys(categoryName);
		String actCatName=driver.findElement(By.xpath("//tbody/descendant::td[text()='"+categoryName+"']")).getText();
		if (actCatName.equalsIgnoreCase(categoryName)) {
			driver.findElement(By.xpath("//i[@class='icon-remove-sign']")).click();
			driver.switchTo().alert().accept();
		}
		
		driver.findElement(By.xpath("//i[@class='menu-icon icon-signout']/parent::a[@href='logout.php']")).click();
		
		driver.get(url);
		List<WebElement> categories1 = driver.findElements(By.xpath("//nav[@class='yamm megamenu-horizontal']/descendant::a[@class='dropdown-toggle']"));
		int size1=categories1.size();
		boolean flag=true;
		for(int i=0;i<size1;i++) {
			String category1=categories1.get(i).getText();
			if (category1.equalsIgnoreCase(categoryName)) {
				System.out.println("Category is present");
				flag=false;
			}
		}
		if (flag==true) {
			System.out.println("Category is deleted");
		} else {
			System.out.println("Category is not deleted");
		}
		
	}

}
