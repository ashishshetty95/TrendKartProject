package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentMethodPage {
	
	@FindBy(xpath="//input[@value='COD']")
	private WebElement CODradiobtn;
	
	@FindBy(xpath="//input[@value='Internet Banking']")
	private WebElement internetBankingRadioBtn;
	
	@FindBy(xpath="//input[@value='Debit / Credit card']")
	private WebElement cardRadioBtn;
	
	@FindBy(xpath="//input[@value='submit']")
	private WebElement submitBtn;
	
	public PaymentMethodPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCODradiobtn() {
		return CODradiobtn;
	}

	public WebElement getInternetBankingRadioBtn() {
		return internetBankingRadioBtn;
	}

	public WebElement getCardRadioBtn() {
		return cardRadioBtn;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	

}
