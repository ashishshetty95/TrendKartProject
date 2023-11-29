package Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v113.performance.Performance;
import org.openqa.selenium.interactions.Actions;

public class SpiceJetTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//div[text()='round trip']")).click();
		driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']/descendant::input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu']")).sendKeys("BLR");
		driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']/descendant::input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu']")).sendKeys("AMD");
		driver.findElement(By.xpath("//div[text()='November ' and text()='2023']/ancestor::div[@class='css-1dbjc4n r-1mdbw0j r-ymttw5 r-b2dl2 r-mzjzbw r-wk8lta r-tvv088']/descendant::div[text()='18']")).click();
		Actions a=new Actions(driver);
		a.scrollByAmount(0, 237).perform();
		WebElement toDate = driver.findElement(By.xpath("//div[text()='January ' and text()='2024']/ancestor::div[@class='css-1dbjc4n r-1mdbw0j r-ymttw5 r-b2dl2 r-mzjzbw r-wk8lta r-tvv088']/descendant::div[text()='24']"));
		WebElement scroll = driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1loqt21 r-u8s1d r-11xbo3g r-1v2oles r-1otgn73 r-16zfatd r-eafdt9 r-1i6wzkk r-lrvibr r-184en5c']"));
		for(;;) {
			if (toDate.isDisplayed()) {
				toDate.click();
				break;
			} else {
				scroll.click();
			}
		}
		driver.findElement(By.xpath("//div[text()='Passengers']")).click();
		driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
		driver.findElement(By.xpath("//div[@data-testid='Children-testID-plus-one-cta']")).click();
		WebElement done = driver.findElement(By.xpath("//div[text()='Done']/.."));
		a.moveToElement(done).perform();
		done.click();
		driver.findElement(By.xpath("//div[text()='Currency']")).click();
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-14lw9ot r-z2wwpe r-1rjd0u6 r-1g94qm0 r-h3f8nf r-u8s1d r-8fdsdq']/descendant::div[text()='AED']")).click();
		driver.findElement(By.xpath("//div[text()='Family & Friends']")).click();
		driver.findElement(By.xpath("//div[text()='Search Flight']/..")).click();
	
	}

}
