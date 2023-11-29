package com.Practice_Package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MAKEMYTRIP_CalendarPopupTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		String dateandyear="November 2023";
		int day=15;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.makemytrip.com/");
		/*Thread.sleep(20000);
		WebElement close = driver.findElement(By.id("webklipper-publisher-widget-container-notification-close-div"));
		Actions a=new Actions(driver);
		a.doubleClick(close).perform();*/
		
		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		System.out.println(driver.findElement(By.xpath("div[@class='DayPicker-Caption']/div")).getText());
		//if()
			//driver.findElement(By.xpath("//div[text()='"+dateandyear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+day+"']")).click();
	}

}
