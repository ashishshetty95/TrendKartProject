package com.trendkart.adminmodule;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyCreditDebitCardTest {

	public static void main(String[] args) throws IOException {
		Properties p=new Properties();
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commondata.property");
		p.load(fis);
		String url=p.getProperty("url");
		String un=p.getProperty("Username");
		String pw=p.getProperty("Password");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.xpath("//a[.='Login']")).click();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(un);
		driver.findElement(By.id("exampleInputPassword1")).sendKeys(pw);
		driver.findElement(By.name("login")).click();
		driver.findElement(By.xpath("//a[text()=' Electronics']")).click();
		driver.findElement(By.xpath("(//div[@class='product'])[1]/descendant::h3[@class='name']/a")).click();
		String expectedProduct=driver.findElement(By.xpath("//h1[@class='name']")).getText();
		driver.findElement(By.xpath("//i[@class='fa fa-heart']")).click();
		driver.findElement(By.xpath("//a[text()='Add to cart']")).click();
		driver.findElement(By.xpath("//li/a[.='My Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCCED TO CHEKOUT']")).click();
		driver.findElement(By.xpath("//input[@value='Debit / Credit card']")).click();
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		String actualProduct=driver.findElement(By.xpath("(//h4[@class='cart-product-description'])[last()]/a")).getText();
		if (expectedProduct.equalsIgnoreCase(actualProduct)) {
			System.out.println("Product is ordered successfully");			
		}
		else {
			System.out.println("Product not ordered");
		}
		driver.findElement(By.xpath("//table[@class='table table-bordered']/descendant::tr[last()]/descendant::a[@title='Track order']")).click();
		
		String pwh = driver.getWindowHandle();
		Set<String> awh = driver.getWindowHandles();
		String expectedTitle="Order Tracking Details";
		int count=0;
		for(String wh:awh) {
			driver.switchTo().window(wh);
			String actualTitle = driver.getTitle();
			if (actualTitle.contains(expectedTitle)) {
				System.out.println("Order tracking page is displayed");
				count++;
				break;
			}
			
		}
		if (count==0) {
			System.out.println("Order tracking page is not displayed");
	}
	driver.switchTo().window(pwh);
	driver.findElement(By.xpath("//a[.='Logout']")).click();	
	}

}
