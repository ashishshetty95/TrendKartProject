package com.trendkart.admin;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.ObjectRepo.AdminDashboardPage;
import com.ObjectRepo.AdminSignInPage;
import com.ObjectRepo.CreateCategoryPage;
import com.ObjectRepo.HomePage;
import com.ObjectRepo.InsertProductPage;
import com.ObjectRepo.ManageProductsPage;
import com.ObjectRepo.ProductPage;
import com.ObjectRepo.SubCatergoryPage;
import com.ecommerce.GenericUtils.ExcelUtils;
import com.ecommerce.GenericUtils.FileUtils;
import com.ecommerce.GenericUtils.WebDriverUtils;
@Listeners (com.ecommerce.GenericUtils.ListenenerImplementation.class)
public class VerifyDeleteProductTest {
	@Test(groups="regression")
	public void verifyDeleteProductTest() throws EncryptedDocumentException, IOException, InterruptedException {
		FileUtils futil=new FileUtils();
		ExcelUtils eutil=new ExcelUtils();
		WebDriverUtils wutil=new WebDriverUtils();
		String adminurl=futil.readDataFromPropertyFile("adminurl");
		String adminun=futil.readDataFromPropertyFile("adminun");
		String adminpw=futil.readDataFromPropertyFile("adminpw");
		String url=futil.readDataFromPropertyFile("url");
		WebDriver driver=new ChromeDriver();
		wutil.implicitWait(driver, 10);
		wutil.maximize(driver);
		driver.get(adminurl);
		AdminSignInPage asip=new AdminSignInPage(driver);
		asip.getUserNametbx().sendKeys(adminun);
		asip.getPasswordtbx().sendKeys(adminpw);
		asip.getLoginBtn().click();
		AdminDashboardPage adp=new AdminDashboardPage(driver);
		adp.getCreateCategoryTab().click();
		CreateCategoryPage ccp=new CreateCategoryPage(driver);
		String categoryName=eutil.readDataFromExcelRandom("CreateCategory", 1, 0);
		String categoryDescription=eutil.readDataFromExcel("CreateCategory", 1, 1);
		ccp.getCategoryNameTbx().sendKeys(categoryName);
		ccp.getCategoryDescriptionTbx().sendKeys(categoryDescription);
		ccp.createCategoryBtn();
		String categoryConfirmText=eutil.readDataFromExcel("CreateCategory", 1, 3);
		ccp.categoryCreateConfirmation(categoryConfirmText);
		adp.getSubCategoryTab().click();
		SubCatergoryPage scp=new SubCatergoryPage(driver);
		wutil.dropdown(categoryName, scp.getCategoryDD());		
		String subCategoryName =eutil.readDataFromExcelRandom("SubCategory", 1, 0);
		scp.getSubCategoryNameTbx().sendKeys(subCategoryName);
		scp.getCreateSubCategoryBtn().click();
		String subCategoryConfirmText =eutil.readDataFromExcel("SubCategory", 1, 2);
		scp.subCategoryCreatedConfirmation(subCategoryConfirmText);
		adp.getInsertProductTab().click();
		InsertProductPage ipp=new InsertProductPage(driver);		
		wutil.dropdown(categoryName, ipp.getCategoryDD());
		wutil.dropdown(subCategoryName, ipp.getSubCategoryDD());
		eutil.readTwoColumnDataFromExcelName(driver, "InsertProductNameAttr");
		String productAvailability=eutil.readDataFromExcel("ProductAvailabilityDD", 1, 0);
		wutil.dropdown(productAvailability, ipp.getProductAvailabilityDD());
		ipp.getProductImage1UploadBtn().sendKeys(wutil.fileUpload(".\\\\src\\\\test\\\\resources\\\\MOTO_BACKCASE1.jpg"));
		ipp.getProductImage2UploadBtn().sendKeys(wutil.fileUpload(".\\\\src\\\\test\\\\resources\\\\MOTO_BACKCASE2.jpg"));
		ipp.getProductImage3UploadBtn().sendKeys(wutil.fileUpload(".\\\\src\\\\test\\\\resources\\\\MOTO_BACKCASE3.jpg"));
		ipp.insertProductBtn();
		String insertProductConfirmationText="Product Inserted Successfully";
		ipp.productInsertedConfirmation(insertProductConfirmationText);
		adp.LogoutBtn();
		driver.get(url);
		String productName = eutil.readDataFromExcel("InsertProductNameAttr", 0, 1);
		HomePage hp=new HomePage(driver);
		hp.getSearchTextField().sendKeys(productName+Keys.ENTER);
		ProductPage pp=new ProductPage(driver);
		String expProduct=pp.productName(driver, productName).getText();
		pp.productConfirmation(productName, expProduct);
		driver.get(adminurl);
		asip.getUserNametbx().sendKeys(adminun);
		asip.getPasswordtbx().sendKeys(adminpw);
		asip.getLoginBtn().click();
		adp.manageProductsTab();
		ManageProductsPage mpp=new ManageProductsPage(driver);
		mpp.getSearchTbx().sendKeys(productName);
		if (mpp.productName(driver, productName).getText().equalsIgnoreCase(productName)) {
			System.out.println(productName+" details are displayed");
		}
		mpp.deleteProduct(driver, productName);
		wutil.acceptAlert(driver);
		String deleteProductConfirmationText="Product deleted";
		if (mpp.getProductDeletedConfirmationText().getText().contains(deleteProductConfirmationText)) {
			System.out.println("Product deleted successfully");
		}
		else {
			System.out.println("Product not deleted");
		}
		adp.LogoutBtn();
		driver.get(url);
		hp.getSearchTextField().sendKeys(productName+Keys.ENTER);
		if (pp.noProductFound(driver).isDisplayed()) {
			System.out.println(productName+" is deleted");
		}
		driver.quit();
	}
}