package com.Practice_Package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GOIBIBO_CalendaePopupTest {

	public static void main(String[] args) {
		String dateandyear="January 2024";
		int date=12;
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.goibibo.com/");
		
		driver.findElement(By.xpath("//span[@class='sc-gsFSXq bGTcbn']")).click();
		
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		
		driver.findElement(By.xpath("//p[@class='sc-jlwm9r-1 ewETUe']")).click();
		for(;;) {
			try {
				driver.findElement(By.xpath("//div[text()='"+dateandyear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']")).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			}
		}
		
		driver.findElement(By.xpath("//span[text()='Done']")).click();
	}

}
