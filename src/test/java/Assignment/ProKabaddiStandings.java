package Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProKabaddiStandings {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.prokabaddi.com/standings");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		List<WebElement> teamPosition = driver.findElements(By.xpath("//p[@class='position']"));
		List<WebElement> teamNames = driver.findElements(By.xpath("//p[@class='name']"));
		List<WebElement> matchesPlayed = driver.findElements(By.xpath("//div[@class='table-data matches-play']/p[@class='count']"));
		List<WebElement> matchesWon = driver.findElements(By.xpath("//div[@class='table-data matches-won']/p[@class='count']"));
		List<WebElement> matchesLost = driver.findElements(By.xpath("//div[@class='table-data matches-lost']/p[@class='count']"));
		List<WebElement> matchesDraw = driver.findElements(By.xpath("//div[@class='table-data matches-draw']/p[@class='count']"));
		List<WebElement> scoreDiff = driver.findElements(By.xpath("//div[@class='table-data score-diff']/p[@class='count']"));
		List<WebElement> firstForm = driver.findElements(By.xpath("//ul[@class='form-listing']/descendant::p[last()-4]"));
		List<WebElement> secondForm = driver.findElements(By.xpath("//ul[@class='form-listing']/descendant::p[last()-3]"));
		List<WebElement> thirdForm = driver.findElements(By.xpath("//ul[@class='form-listing']/descendant::p[last()-2]"));
		List<WebElement> fourthForm = driver.findElements(By.xpath("//ul[@class='form-listing']/descendant::p[last()-1]"));
		List<WebElement> fifthForm = driver.findElements(By.xpath("//ul[@class='form-listing']/descendant::p[last()]"));
		List<WebElement> teamPoints = driver.findElements(By.xpath("//div[@class='table-data points']/p[@class='count']"));
		for(int i=0;i<teamPosition.size();i++) {
			String position=teamPosition.get(i).getText();
			String name=teamNames.get(i).getText();
			String played=matchesPlayed.get(i).getText();
			String won=matchesWon.get(i).getText();
			String lost=matchesLost.get(i).getText();
			String draw=matchesDraw.get(i).getText();
			String difference = scoreDiff.get(i).getText();
			String first=firstForm.get(i).getText();
			String second=secondForm.get(i).getText();
			String third=thirdForm.get(i).getText();
			String fourth=fourthForm.get(i).getText();
			String fifth=fifthForm.get(i).getText();
			String points=teamPoints.get(i).getText();
			System.out.println(position+"   "+name+"   "+played+"   "+won+"   "+lost+"   "+draw+"   "+difference+" "+first+" "+second+" "+third+" "+fourth+" "+fifth+"   "+points);
		}
		
	}

}
