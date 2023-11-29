package com.trendkart.admin;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.ObjectRepo.CartPage;
import com.ObjectRepo.HomePage;
import com.ObjectRepo.OrderHistoryPage;
import com.ObjectRepo.PaymentMethodPage;
import com.ObjectRepo.ProductDetailsPage;
import com.ObjectRepo.ProductPage;
import com.ecommerce.GenericUtils.BaseClass;
@Listeners (com.ecommerce.GenericUtils.ListenenerImplementation.class)
public class TrackOrderTest extends BaseClass {
	@Test
	public void trackOrderTest() throws IOException {
		HomePage hp=new HomePage(driver);
		String category = eutil.readDataFromExcel("CreateCategory", 1, 0);
		hp.clickOnCategoryFromTab(driver, category);
		ProductPage pp=new ProductPage(driver);
		pp.getFirstProduct().click();
		ProductDetailsPage pdp=new ProductDetailsPage(driver);
		String expectedProduct=pdp.getProductNameTxt().getText();
		pdp.getAddToCartBtn().click();
		driver.switchTo().alert().accept();
		eutil.readTwoColumnDataFromExcelName(driver, "BillingAddress");
		CartPage cp=new CartPage(driver);
		cp.getUpdateBillingAddressBtn().click();
		driver.switchTo().alert().accept();
		eutil.readTwoColumnDataFromExcelName(driver, "ShippingAddress");
		cp.getUpdateShippingAddressBtn().click();
		driver.switchTo().alert().accept();
		cp.getProceedToCheckOutBtn().click();
		PaymentMethodPage pmp=new PaymentMethodPage(driver);
		pmp.getCODradiobtn().click();
		pmp.getSubmitBtn().click();
		OrderHistoryPage ohp=new OrderHistoryPage(driver);
		String actualProduct=ohp.lastProductName(driver);
		ohp.compareProduct(actualProduct, expectedProduct);
		ohp.getTrackLastProduct().click();
		String pwh = driver.getWindowHandle();
		String aTitle = wutil.switchToWindow(driver, eutil.readDataFromExcel("TrackingPage", 0, 0));
		String eTitle=eutil.readDataFromExcel("TrackingPage", 0, 0);
		ohp.compareProduct(aTitle, eTitle);
		driver.switchTo().window(pwh);
	}
}