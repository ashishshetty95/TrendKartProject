package com.Practice_Package;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountryNameTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		String expName="South Africa";
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		List<WebElement> countrynames = driver.findElements(By.xpath("//table/tbody/tr/td[2]/span[2]"));
		for(int i=0;i<countrynames.size();i++) {
			String actName = countrynames.get(i).getText();
			if (expName.equalsIgnoreCase(actName)) {
				System.out.println("Country name is displayed");
			}
			else {
				System.out.println("Country name is not displayed");
			}
		}
	}

}
