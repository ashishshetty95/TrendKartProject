package com.Practice_Package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class REDBUS_CalendarPopupTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.findElement(By.id("onwardCal")).click();
		driver.findElement(By.xpath("//div[@class='sc-jzJRlG dPBSOp']/descendant::span[text()='12']")).click();
		driver.quit();
	}

}
