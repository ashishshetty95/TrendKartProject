package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInSignUpPage {
	@FindBy(id="exampleInputEmail1")
	private WebElement loginEmailTbx;
	
	@FindBy(id="exampleInputPassword1")
	private WebElement loginPasswordTbx;
	
	@FindBy(xpath="//a[text()='Forgot your Password?']")
	private WebElement forgotPasswordLink;
	
	@FindBy(name="login")
	private WebElement loginBtn;
	
	@FindBy(id="fullname")
	private WebElement fullNameTbx;
	
	@FindBy(id="email")
	private WebElement signInEmailTbx;
	
	@FindBy(id="contactno")
	private WebElement contactNoTbx;
	
	@FindBy(id="password")
	private WebElement signInPasswordTbx;
	
	@FindBy(id="confirmpassword")
	private WebElement confirmPasswordTbx;
	
	@FindBy(xpath="//button[text()='Sign Up']")
	private WebElement signUpBtn;
	
	public SignInSignUpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLoginEmailTbx() {
		return loginEmailTbx;
	}

	public WebElement getLoginPasswordTbx() {
		return loginPasswordTbx;
	}

	public WebElement getForgotPasswordLink() {
		return forgotPasswordLink;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getFullNameTbx() {
		return fullNameTbx;
	}

	public WebElement getSignInEmailTbx() {
		return signInEmailTbx;
	}

	public WebElement getContactNoTbx() {
		return contactNoTbx;
	}

	public WebElement getSignInPasswordTbx() {
		return signInPasswordTbx;
	}

	public WebElement getConfirmPasswordTbx() {
		return confirmPasswordTbx;
	}

	public WebElement getSignUpBtn() {
		return signUpBtn;
	}
}
