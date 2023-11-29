package com.trendkart.admin;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.ObjectRepo.AdminDashboardPage;
import com.ObjectRepo.AdminSignInPage;
import com.ObjectRepo.CreateCategoryPage;
import com.ObjectRepo.HomePage;
import com.ecommerce.GenericUtils.ExcelUtils;
import com.ecommerce.GenericUtils.FileUtils;
import com.ecommerce.GenericUtils.WebDriverUtils;
public class VerifyDeleteCategoryTest {
	
	@Test(groups="regression")
	public void verifyDeleteCategoryTest() throws IOException {
		FileUtils futil=new FileUtils();
		ExcelUtils eutil=new ExcelUtils();
		WebDriverUtils wutil=new WebDriverUtils();
		String adminurl=futil.readDataFromPropertyFile("adminurl");
		WebDriver driver=new ChromeDriver();
		wutil.implicitWait(driver, 10);
		AdminSignInPage asip=new AdminSignInPage(driver);
		driver.get(adminurl);
		String adminun=futil.readDataFromPropertyFile("adminun");
		String adminpw=futil.readDataFromPropertyFile("adminpw");
		asip.getUserNametbx().sendKeys(adminun);
		asip.getPasswordtbx().sendKeys(adminpw);
		asip.getLoginBtn().click();
		AdminDashboardPage adp=new AdminDashboardPage(driver);
		adp.CreateCategoryTab();
		String categoryName=eutil.readDataFromExcelRandom("CreateCategory", 1, 0);
		String categoryDescription=eutil.readDataFromExcel("CreateCategory", 1, 1);
		CreateCategoryPage ccp=new CreateCategoryPage(driver);
		ccp.getCategoryNameTbx().sendKeys(categoryName);
		ccp.getCategoryDescriptionTbx().sendKeys(categoryDescription);
		ccp.createCategoryBtn();
		adp.LogoutBtn();
		String url=futil.readDataFromPropertyFile("url");		
		driver.get(url);
		HomePage hp=new HomePage(driver);
		List<WebElement> categories = hp.categoriesList(driver);
		int size=categories.size();
		boolean flag=true;
		for(int i=0;i<size;i++) {
			String category=categories.get(i).getText();
			if (category.equalsIgnoreCase(categoryName)) {
				System.out.println("Category is present");
				flag=false;
				break;
			}
		}
		if (flag) {
			Assert.fail();
		}
		driver.get(adminurl);
		asip.getUserNametbx().sendKeys(adminun);
		asip.getPasswordtbx().sendKeys(adminpw);
		asip.getLoginBtn().click();
		adp.CreateCategoryTab();
		ccp.getSearchTbx().sendKeys(categoryName);
		ccp.deleteCategory(driver, categoryName);
		driver.switchTo().alert().accept();
		adp.LogoutBtn();
		driver.get(url);
		List<WebElement> categories1 = hp.categoriesList(driver);
		int size1=categories1.size();
		boolean var=true;
		for(int i=0;i<size1;i++) {
			String category=categories1.get(i).getText();
			if (category.equalsIgnoreCase(categoryName)) {
				var=false;
			}
		}
		if (var==false) {
			Assert.fail();
		}
		driver.quit();
	}
}