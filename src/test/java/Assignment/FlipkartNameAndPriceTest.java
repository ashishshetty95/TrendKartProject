package Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartNameAndPriceTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[text()='✕']")).click();
		driver.findElement(By.name("q")).sendKeys("Apple iPhone"+Keys.ENTER);
		List<WebElement> productName = driver.findElements(By.xpath("//div[contains(text(),'APPLE iPhone') and @class='_4rR01T']"));
		List<WebElement> productPrice = driver.findElements(By.xpath("//div[contains(text(),'APPLE iPhone') and @class='_4rR01T']/ancestor::div[@class='_3pLy-c row']/descendant::div[@class='_30jeq3 _1_WHN1']"));
		for(int i=0;i<productName.size();i++) {
			String name=productName.get(i).getText();
			String price=productPrice.get(i).getText();
			System.out.println(name+"---"+price);
		}
		
	}

}
