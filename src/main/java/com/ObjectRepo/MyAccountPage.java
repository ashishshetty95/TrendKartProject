package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	@FindBy(xpath="//a[contains(.,'My Profile')]")
	private WebElement myProfileTab;
	
	@FindBy(id="name")
	private WebElement nameTbx;
	
	@FindBy(id="contactno")
	private WebElement contactNoTbx;
	
	@FindBy(name="update")
	private WebElement updataBtn;
	
	@FindBy(xpath="//a[contains(.,'Change Password')]")
	private WebElement changePasswordTab;
	
	@FindBy(id="cpass")
	private WebElement currentPasswordTbx;
	
	@FindBy(id="newpass")
	private WebElement newPasswordTbx;
	
	@FindBy(id="cnfpass")
	private WebElement confirmPasswordTbx;
	
	@FindBy(name="submit")
	private WebElement changePasswordBtn;
	
	@FindBy(xpath="//ul[@class='nav nav-checkout-progress list-unstyled']/descendant::a[text()='My Account']")
	private WebElement myAccountLink;
	
	@FindBy(xpath="//a[text()='Shipping / Billing Address']")
	private WebElement shippingBillingAddressLink;
	
	@FindBy(xpath="//a[text()='Order History']")
	private WebElement orderHistoryLink;
	
	@FindBy(xpath="//a[text()='Payment Pending Order']")
	private WebElement paymentPendingOrderLink;
	
	public MyAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getMyProfileTab() {
		return myProfileTab;
	}

	public WebElement getNameTbx() {
		return nameTbx;
	}

	public WebElement getContactNoTbx() {
		return contactNoTbx;
	}

	public WebElement getUpdataBtn() {
		return updataBtn;
	}

	public WebElement getChangePasswordTab() {
		return changePasswordTab;
	}

	public WebElement getCurrentPasswordTbx() {
		return currentPasswordTbx;
	}

	public WebElement getNewPasswordTbx() {
		return newPasswordTbx;
	}

	public WebElement getConfirmPasswordTbx() {
		return confirmPasswordTbx;
	}

	public WebElement getChangePasswordBtn() {
		return changePasswordBtn;
	}

	public WebElement getMyAccountLink() {
		return myAccountLink;
	}

	public WebElement getShippingBillingAddressLink() {
		return shippingBillingAddressLink;
	}

	public WebElement getOrderHistoryLink() {
		return orderHistoryLink;
	}

	public WebElement getPaymentPendingOrderLink() {
		return paymentPendingOrderLink;
	}
}
