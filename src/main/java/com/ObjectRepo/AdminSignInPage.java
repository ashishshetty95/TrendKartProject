package com.ObjectRepo;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.GenericUtils.FileUtils;

public class AdminSignInPage extends FileUtils {
	@FindBy(id="inputEmail")
	private WebElement userNametbx;
	
	@FindBy(id="inputPassword")
	private WebElement passwordtbx;
	
	@FindBy(name="submit")
	private WebElement loginBtn;
	
	public AdminSignInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserNametbx() {
		return userNametbx;
	}

	public WebElement getPasswordtbx() {
		return passwordtbx;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void signIn() throws IOException {
		userNametbx.sendKeys(readDataFromPropertyFile("adminun"));
		passwordtbx.sendKeys(readDataFromPropertyFile("adminpw"));
		loginBtn.click();
	}
}
