package com.Practice_Package;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksTest {

	public static void main(String[] args) throws IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		ArrayList<String> list=new ArrayList<String>();
		
		for(int i=0;i<allLinks.size();i++) {
			String link = allLinks.get(i).getAttribute("href");
			URL url=null;
			int responseCode=0;
			
			try {
				url=new URL(link);
				HttpsURLConnection urlConn=(HttpsURLConnection) url.openConnection();
				responseCode = urlConn.getResponseCode();
				if (responseCode>=400) {
					list.add(link);
					System.out.println(link+"--->"+responseCode);
				}
			} catch (MalformedURLException e) {
				
			}
		}
	}

}
