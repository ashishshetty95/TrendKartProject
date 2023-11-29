package Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OlympicsMedalTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		String countryName="India";
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		List<WebElement> countryNames = driver.findElements(By.xpath("//div[@class='styles__CountryWrapper-sc-fehzzg-4 hjfJyH']"));
		List<WebElement> goldMedals = driver.findElements(By.xpath("//div[@title='Gold']/descendant::span[@class='OcsTextstyles__StyledText-sc-1a1i41u-0 cuettq text--sm-body']"));
		List<WebElement> silverMedals = driver.findElements(By.xpath("//div[@title='Silver']/descendant::span[@class='OcsTextstyles__StyledText-sc-1a1i41u-0 cuettq text--sm-body']"));
		List<WebElement> bronzeMedals = driver.findElements(By.xpath("//div[@title='Bronze']/descendant::span[@class='OcsTextstyles__StyledText-sc-1a1i41u-0 cuettq text--sm-body']"));
		List<WebElement> totalMedals = driver.findElements(By.xpath("//div[contains(@data-medal-id,'total-medals-row')]"));
		System.out.println("Country"+"-----"+"Gold"+"-----"+"Silver"+"-----"+"Bronze"+"-----"+"Total");
		for(int i=0;i<goldMedals.size();i++) {
			String country=countryNames.get(i).getText();
			String gold=goldMedals.get(i).getText();
			String silver=silverMedals.get(i).getText();
			String bronze=bronzeMedals.get(i).getText();
			String total=totalMedals.get(i).getText();
			if (countryName.equalsIgnoreCase(country)) {
				System.out.println(country+"-----"+gold+"-----"+silver+"-----"+bronze+"-----"+total);
			}
			
		}
	}

}
