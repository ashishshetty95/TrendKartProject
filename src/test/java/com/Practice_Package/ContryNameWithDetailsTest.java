package com.Practice_Package;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContryNameWithDetailsTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		List<WebElement> countrynames = driver.findElements(By.xpath("//table/tbody/tr/td[2]/span[2]"));
		List<WebElement> pos = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		List<WebElement> matches = driver.findElements(By.xpath("//table/tbody/tr/td[3]"));
		for(int i=0;i<pos.size();i++) {
			String name = countrynames.get(i).getText();
			String position=pos.get(i).getText();
			String match=matches.get(i).getText();
			System.out.println(position+"---"+name+"---"+match);
		}
	}

}
