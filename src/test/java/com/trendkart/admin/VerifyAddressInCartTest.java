package com.trendkart.admin;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.ObjectRepo.CartPage;
import com.ObjectRepo.HomePage;
import com.ObjectRepo.MyAccountPage;
import com.ObjectRepo.OrderHistoryPage;
import com.ObjectRepo.PaymentMethodPage;
import com.ObjectRepo.ProductDetailsPage;
import com.ObjectRepo.ProductPage;
import com.ObjectRepo.ShippingBillingAddressPage;
import com.ecommerce.GenericUtils.BaseClass;
import com.ecommerce.GenericUtils.ExcelUtils;
import com.ecommerce.GenericUtils.WebDriverUtils;
@Listeners (com.ecommerce.GenericUtils.ListenenerImplementation.class)
public class VerifyAddressInCartTest extends BaseClass {
	@Test
	public void verifyAddressInCartTest() throws IOException, Throwable  {
		ExcelUtils eutil=new ExcelUtils();
		WebDriverUtils wutil=new WebDriverUtils();
		HomePage hp=new HomePage(driver);
		hp.getMyAccountLink().click();
		MyAccountPage map=new MyAccountPage(driver);
		map.getShippingBillingAddressLink().click();
		eutil.readTwoColumnDataFromExcelName(driver, "BillingAddress");
		ShippingBillingAddressPage sbap=new ShippingBillingAddressPage(driver);
		sbap.getUpdateBillingAddressBtn().click();
		wutil.acceptAlert(driver);
		sbap.getShippingAddressTab().click();
		eutil.readTwoColumnDataFromExcelName(driver, "ShippingAddress");
		sbap.getUpdateShippingAddressBtn().click();
		wutil.acceptAlert(driver);
		hp.clickOnCategoryFromTab(driver, eutil.readDataFromExcel("CreateCategory", 1, 0));
		ProductPage pp=new ProductPage(driver);
		pp.getFirstProduct().click();
		ProductDetailsPage pdp=new ProductDetailsPage(driver);
		String productName=pdp.getProductNameTxt().getText();
		pdp.getAddToCartBtn().click();
		wutil.acceptAlert(driver);
		eutil.verifyEnteredData(driver, "CartBilling", "BillingAddress", 4);
		eutil.verifyEnteredData(driver, "CartShipping", "ShippingAddress", 4);
		CartPage cp=new CartPage(driver);
		cp.getProceedToCheckOutBtn().click();
		PaymentMethodPage pmp=new PaymentMethodPage(driver);
		pmp.getCODradiobtn().click();
		pmp.getSubmitBtn().click();
		OrderHistoryPage ohp=new OrderHistoryPage(driver);
		String aName=ohp.lastProductName(driver);
		ohp.compareProduct(aName, productName);
		}
	}