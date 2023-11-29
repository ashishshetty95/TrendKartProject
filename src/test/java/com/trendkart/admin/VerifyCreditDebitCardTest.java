package com.trendkart.admin;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.ObjectRepo.CartPage;
import com.ObjectRepo.HomePage;
import com.ObjectRepo.OrderHistoryPage;
import com.ObjectRepo.PaymentMethodPage;
import com.ObjectRepo.ProductDetailsPage;
import com.ObjectRepo.ProductPage;
import com.ObjectRepo.WishlistPage;
import com.ecommerce.GenericUtils.BaseClass;
import com.ecommerce.GenericUtils.ExcelUtils;
import com.ecommerce.GenericUtils.WebDriverUtils;
@Listeners (com.ecommerce.GenericUtils.ListenenerImplementation.class)
public class VerifyCreditDebitCardTest extends BaseClass {
	@Test
	public void verifyCreditDebitCardTest() throws EncryptedDocumentException, IOException {
		ExcelUtils eutil=new ExcelUtils();
		WebDriverUtils wutil=new WebDriverUtils();
		HomePage hp=new HomePage(driver);
		hp.clickOnCategoryFromTab(driver, eutil.readDataFromExcel("CreateCategory", 1, 0));
		ProductPage pp=new ProductPage(driver);
		pp.getFirstProduct().click();
		ProductDetailsPage pdp=new ProductDetailsPage(driver);
		String pName=pdp.getProductNameTxt().getText();
		pdp.getAddProductToWishlistBtn().click();
		WishlistPage wp=new WishlistPage(driver);
		wp.getAddToCartBtn().click();
		hp.getMyCartLink().click();
		CartPage cp=new CartPage(driver);
		cp.getProceedToCheckOutBtn().click();
		PaymentMethodPage pmp=new PaymentMethodPage(driver);
		pmp.getCardRadioBtn().click();
		pmp.getSubmitBtn().click();
		OrderHistoryPage ohp=new OrderHistoryPage(driver);
		String aName=ohp.lastProductName(driver);
		ohp.compareProduct(aName, pName);
		
		ohp.getTrackLastProduct().click();
		String pwh = driver.getWindowHandle();
		String aTitle=wutil.switchToWindow(driver, eutil.readDataFromExcel("TrackingPage", 0, 0));
		String eTitle=eutil.readDataFromExcel("TrackingPage", 0, 0);
		ohp.compareTitle(aTitle, eTitle); 
		driver.switchTo().window(pwh);
	}
}