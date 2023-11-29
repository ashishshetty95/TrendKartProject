package com.Practice_Package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KSRTC_CalendarPopupTest {

	public static void main(String[] args) {
		
		//Launch browser
		WebDriver driver=new ChromeDriver();
		
		//Maximize browser
		driver.manage().window().maximize();
		
		//Enter url
		driver.get("https://www.ksrtc.in/oprs-web/");
		
		//Page loadout
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		//Click on journeydate
		driver.findElement(By.id("txtJourneyDate")).click();
		
		//Select journey date
		driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/descendant::a[text()='10']")).click();
		
		//Click on return date
		driver.findElement(By.id("txtReturnJourneyDate")).click();
		
		//Select return date
		driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/descendant::a[text()='12']")).click();
		
		//Close the browser
		driver.quit();
	}

}
