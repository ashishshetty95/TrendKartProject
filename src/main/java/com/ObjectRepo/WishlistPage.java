package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishlistPage {
	@FindBy(xpath="//a[text()='Add to cart']")
	private WebElement addToCartBtn;
	
	public WishlistPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}
}
