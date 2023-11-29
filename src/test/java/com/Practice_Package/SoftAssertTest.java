package com.Practice_Package;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ObjectRepo.HomePage;
import com.ObjectRepo.SignInSignUpPage;
import com.ecommerce.GenericUtils.FileUtils;

public class SoftAssertTest {

	SoftAssert sa=new SoftAssert();
	
	@Test
	public void demo() throws IOException {
		WebDriver driver=new ChromeDriver();
		FileUtils futil=new FileUtils();
		String url=futil.readDataFromPropertyFile("url");
		String un=futil.readDataFromPropertyFile("Username");
		String pw=futil.readDataFromPropertyFile("Password");
		
		HomePage hp=new HomePage(driver);
		driver.get(url);
		hp.getLoginLink().click();
		SignInSignUpPage ssu=new SignInSignUpPage(driver);
		ssu.getLoginEmailTbx().sendKeys(un);
		ssu.getLoginPasswordTbx().sendKeys(pw);
		
		String act=driver.getTitle();
		String exp="Shopping Portal Home";
		
		sa.assertEquals(act, exp);
		System.out.println("Title");
	}
}
