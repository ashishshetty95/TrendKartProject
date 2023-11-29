package com.ecommerce.GenericUtils;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.ObjectRepo.HomePage;
import com.ObjectRepo.SignInSignUpPage;

public class BaseClass {
	public DataBaseUtils dutil=new DataBaseUtils();
	public ExcelUtils eutil=new ExcelUtils();
	public FileUtils futil=new FileUtils();
	public JavaUtils jutil=new JavaUtils();
	public WebDriverUtils wutil=new WebDriverUtils();
	public WebDriver driver;
	public static WebDriver sdriver;
	@BeforeSuite(alwaysRun = true)
	public void config_BS() throws SQLException {
		//dutil.connectDB();
		System.out.println("-- DB Connected --");
	}
	/*@BeforeTest(alwaysRun = true)
	public void config_BT() {
		
		
	}*/
	//@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void config_BC() throws IOException {
		String browser = futil.readDataFromPropertyFile("Browser");
		if (browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		} else if(browser.equalsIgnoreCase("edge")){
			driver=new EdgeDriver();
		}
		else {
			System.out.println("Invalid browser");
		}
		sdriver=driver;
		wutil.implicitWait(driver, 10);
		wutil.maximize(driver);
	}
	@BeforeMethod(alwaysRun = true)
	public void config_BM() throws IOException {
		String url = futil.readDataFromPropertyFile("url");
		String un = futil.readDataFromPropertyFile("Username");
		String pw = futil.readDataFromPropertyFile("Password");
		HomePage hp=new HomePage(driver);
		driver.get(url);
		hp.getLoginLink().click();
		SignInSignUpPage sisu=new SignInSignUpPage(driver);
		sisu.getLoginEmailTbx().sendKeys(un);
		sisu.getLoginPasswordTbx().sendKeys(pw);
		sisu.getLoginBtn().click();
	}
	@AfterMethod(alwaysRun = true)
	public void config_AM() {
		HomePage hp=new HomePage(driver);
		hp.getLogoutLink().click();
	}
	@AfterClass(alwaysRun = true)
	public void config_AC() {
		driver.quit();
	}
	
	/*@AfterTest(alwaysRun = true)
	public void config_AT() {
		
	}*/
	
	@AfterSuite(alwaysRun = true)
	public void config_AS() throws SQLException {
		//dutil.closeConnection();
	}
	
}
