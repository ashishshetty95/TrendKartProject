package com.ecommerce.GenericUtils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseClassSS {
	public DataBaseUtils dutil=new DataBaseUtils();
	public ExcelUtils eutil=new ExcelUtils();
	public FileUtils futil=new FileUtils();
	public JavaUtils jutil=new JavaUtils();
	public WebDriverUtils wutil=new WebDriverUtils();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	
	@BeforeClass
	public void config_BeforeClass() throws IOException {
		System.out.println("1");
		//String browser = futil.readDataFromPropertyFile("Browser");
		//if (browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			wutil.implicitWait(driver, 10);
		//} else if(browser.equalsIgnoreCase("edge")){
		//	driver=new EdgeDriver();
		//}
		//else {
		//	System.out.println("Invalid browser");
		//}
		sdriver=driver;
	}
	
	@AfterClass
	public void config_AfterClass() {
		System.out.println("--After Class--");
	}
}
