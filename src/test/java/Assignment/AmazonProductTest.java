package Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonProductTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Apple iphone"+Keys.ENTER);
		List<WebElement> productNames = driver.findElements(By.xpath("//span[contains(text(),'Apple iPhone')]"));
		List<WebElement> productPrices = driver.findElements(By.xpath("//span[contains(text(),'Apple iPhone')]/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-price-whole']"));
		for(int i=0;i<productNames.size();i++) {
			String name=productNames.get(i).getText();
			String price=productPrices.get(i).getText();
			char[] digits = price.toCharArray();
			if (digits.length<=6 && digits[0]<='5') {
				System.out.println(name+"---"+price);
			}
			
			
				
			
		}
	}

}
