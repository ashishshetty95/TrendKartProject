package Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CricbuzzLiveScoreTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.cricbuzz.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		List<WebElement> matchName = driver.findElements(By.xpath("//div[@class='cb-col-50 cb-ovr-flo']/ancestor::div[@class='cb-hmscg-bwl-txt']/parent::div/preceding-sibling::div[@class='cb-mtch-crd-hdr cb-font-10']/div[@class='cb-col-90 cb-color-light-sec cb-ovr-flo']"));
		List<WebElement> team1 = driver.findElements(By.xpath("//div[@class='cb-hmscg-tm-bat-scr cb-font-14']/descendant::span[@class='text-normal']"));
		List<WebElement> team1Score = driver.findElements(By.xpath("//div[@class='cb-hmscg-tm-bat-scr cb-font-14']/descendant::div[@class='cb-col-50 cb-ovr-flo']"));
		List<WebElement> team2 = driver.findElements(By.xpath("//div[@class='cb-hmscg-tm-bwl-scr cb-font-14']/descendant::span[@class='text-normal']"));
		List<WebElement> team2Score = driver.findElements(By.xpath("//div[@class='cb-hmscg-tm-bwl-scr cb-font-14']/descendant::div[@class='cb-col-50 cb-ovr-flo']"));
		List<WebElement> matchResult = driver.findElements(By.xpath("//div[@class='cb-mtch-crd-state cb-ovr-flo cb-font-12 cb-text-complete']"));
		for(int i=0;i<team1.size();i++) {
			String match=matchName.get(i).getText();
			String team1Name=team1.get(i).getText();
			String score1=team1Score.get(i).getText();
			String team2Name=team2.get(i).getText();
			String score2=team2Score.get(i).getText();
			String result=matchResult.get(i).getText();
			System.out.println(match);
			System.out.print(team1Name+"   "+score1);
			System.out.println();
			System.out.print(team2Name+"   "+score2);
			System.out.println();
			System.out.println(result);
			System.out.println();
		}
		
	}

}
