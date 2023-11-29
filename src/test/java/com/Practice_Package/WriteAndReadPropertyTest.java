package com.Practice_Package;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WriteAndReadPropertyTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		//create object of properties class
		Properties p=new Properties();
		p.setProperty("Browser", "Chrome");
		p.setProperty("url", "http://rmgtestingserver/domain/Online_Shopping_Application/");
		p.setProperty("Username", "anuj.lpu1@gmail.com");
		p.setProperty("Password", "Test@123");
		
		//create object of fileoutputstream
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\commondata.property");
		p.store(fos, "Write data");
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commondata.property");
		p.load(fis);
		
		String browser = p.getProperty("Browser");
		String url = p.getProperty("url");
		String un = p.getProperty("Username");
		String pw = p.getProperty("Password");
		
		WebDriver driver=new ChromeDriver();
		Thread.sleep(10000);
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//a[.='Login']")).click();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(un);
		driver.findElement(By.id("exampleInputPassword1")).sendKeys(pw);
		driver.findElement(By.name("login")).click();
		
	}

}
