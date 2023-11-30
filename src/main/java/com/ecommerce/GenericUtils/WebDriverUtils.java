package com.ecommerce.GenericUtils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {
	/**
	 * This method is used to maximize the browser
	 * @param driver
	 */
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void minimize(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	public void implicitWait(WebDriver driver, int time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	
	public void waitUntilElementIsVisible(WebDriver driver, WebElement ele, int time) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	public void expectedConditionsAlertIsPresent(WebDriver driver, int time) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public void dropdown(WebElement element, int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	public void dropdown(String text, WebElement ele) {
		Select sel=new Select(ele);
		sel.selectByVisibleText(text);
	}
	
	public void dropdown(WebElement ele, String value) {
		Select sel=new Select(ele);
		sel.selectByValue(value);
	}
	
	public void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
		Actions a=new Actions(driver);
		a.dragAndDrop(source, target).perform();
	}
	
	public void doubleClickOnElement(WebDriver driver, WebElement target) {
		Actions a=new Actions(driver);
		a.doubleClick(target).perform();
	}
	
	public void doubleClick(WebDriver driver) {
		Actions a=new Actions(driver);
		a.doubleClick().perform();
	}
	
	public void righClick(WebDriver driver) {
		Actions a =new Actions(driver);
		a.contextClick().perform();
	}
	public void rightClickOnElement(WebDriver driver, WebElement target) {
		Actions a=new Actions(driver);
		a.contextClick(target).perform();
	}
	
	public void mouseHover(WebDriver driver, WebElement target) {
		Actions a=new Actions(driver);
		a.moveToElement(target).perform();
	}
	
	public void sendKeysActionClass(WebDriver driver) {
		Actions a=new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();
	}
	
	public void keyPressEnter() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}
	
	public void keyReleaseEnter() throws AWTException {
		Robot r=new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	public void switchToFrame(WebDriver driver, WebElement address) {
		driver.switchTo().frame(address);
	}
	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method is used to switch between windows
	 * @param driver
	 * @param partialTitle
	 * @return 
	 */
	public String switchToWindow(WebDriver driver, String partialTitle) {
		Set<String> awh = driver.getWindowHandles();
		Iterator<String> it=awh.iterator();
		while (it.hasNext()) {
			String windowId=it.next();
			String currentWindowTitle=driver.switchTo().window(windowId).getTitle();
			if (currentWindowTitle.contains(partialTitle)) {
				return currentWindowTitle;
			}
		}
		return "";
	}
	
	public String takesScreenShot(WebDriver driver, String screenShotName) throws IOException {
		TakesScreenshot t=(TakesScreenshot)driver;
			File src = t.getScreenshotAs(OutputType.FILE);
			String path=".\\screenshot\\"+screenShotName+".png";
			File dest=new File(path);
			FileUtils.copyFile(src, dest);
			return dest.getAbsolutePath();		
	}
	
	public String fileUpload(String path) {
		File f=new File(path);
		String absPath=f.getAbsolutePath();
		return absPath;
	}
	//switchToWindows
	//switchToFrames
	//handlingAlertPopup
	//scrollBar
	//scrollUntilElementToBeVisible
	//actionClassUsingSendkeys
}
