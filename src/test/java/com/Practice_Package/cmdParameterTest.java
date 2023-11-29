package com.Practice_Package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class cmdParameterTest {
	@Test
	public void cmdParameterTest() throws InterruptedException {
		String browser=System.getProperty("browser");
		String url=System.getProperty("url");
		String username=System.getProperty("username");
		String password=System.getProperty("password");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(url);
		driver.findElement(By.xpath("//a[.='Login']")).click();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(username);
		driver.findElement(By.id("exampleInputPassword1")).sendKeys(password);
		driver.findElement(By.name("login")).click();
		
	}

}
