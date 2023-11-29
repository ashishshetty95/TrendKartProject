package com.trendkart.adminmodule;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyUserLoginTest {

	public static void main(String[] args) throws IOException {
		Properties p=new Properties();
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commondata.property");
		p.load(fis);
		String url=p.getProperty("url");
		String un=p.getProperty("Username");
		String pw=p.getProperty("Password");
		
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		driver.findElement(By.xpath("//a[.='Login']")).click();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(un);
		driver.findElement(By.id("exampleInputPassword1")).sendKeys(pw);
		driver.findElement(By.name("login")).click();
	}

}
