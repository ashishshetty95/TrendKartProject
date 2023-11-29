package com.trendkart.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.ObjectRepo.AdminDashboardPage;
import com.ObjectRepo.AdminSignInPage;
import com.ObjectRepo.HomePage;
import com.ObjectRepo.ManageUsersPage;
import com.ObjectRepo.SignInSignUpPage;
import com.ecommerce.GenericUtils.BaseClassSS;
import com.ecommerce.GenericUtils.ExcelUtils;
import com.ecommerce.GenericUtils.FileUtils;
import com.ecommerce.GenericUtils.WebDriverUtils;
@Listeners (com.ecommerce.GenericUtils.ListenerImplementationSS.class)
public class VerifyUserAccountCreationTest extends BaseClassSS {
	@Test
	public void verifyUserAccountCreationTest() throws Throwable {
		String url=futil.readDataFromPropertyFile("url");
		String adminurl=futil.readDataFromPropertyFile("adminurl");
		String adminun=futil.readDataFromPropertyFile("adminun");
		String adminpw=futil.readDataFromPropertyFile("adminpw");
		wutil.maximize(driver);
		driver.get(url);
		HomePage hp=new HomePage(driver);
		hp.getLoginLink().click();
		eutil.readTwoColumnDataFromExcelId(driver, "CreateAccountIdAttr");
		String mailid=eutil.readDataFromExcel("CreateAccountIdAttr", 1, 1);
		SignInSignUpPage si=new SignInSignUpPage(driver);
		si.getSignUpBtn().click();
		wutil.acceptAlert(driver);
		driver.get(adminurl);
		AdminSignInPage ad=new AdminSignInPage(driver);
		ad.getUserNametbx().sendKeys(adminun);
		ad.getPasswordtbx().sendKeys(adminpw);
		ad.getLoginBtn().click();
		AdminDashboardPage adp=new AdminDashboardPage(driver);
		adp.getManageUsersTab().click();
		ManageUsersPage mup=new ManageUsersPage(driver);
		mup.getSearchTbx().sendKeys(mailid);
		String email = mup.checkUserEmail(driver);
		System.out.println(email);
		System.out.println(mailid);
		if (mailid.equalsIgnoreCase(email)) {
			System.out.println("Profile created successfully");
		}
		else {
			System.out.println("Profile not created");
		}
		adp.getLogoutBtn().click();
		driver.quit();
	}
}