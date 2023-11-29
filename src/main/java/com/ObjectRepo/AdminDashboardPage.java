package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashboardPage {
	@FindBy(xpath="//a[contains(.,'Order Management')]")
	private WebElement orderManagementTab;
	
	@FindBy(xpath="//a[contains(.,'Manage users')]")
	private WebElement manageUsersTab;
	
	@FindBy(xpath="//a[contains(.,'Create Category')]")
	private WebElement createCategoryTab;
	
	@FindBy(xpath="//a[contains(.,'Sub Category ')]")
	private WebElement subCategoryTab;
	
	@FindBy(xpath="//a[contains(.,'Insert Product ')]")
	private WebElement insertProductTab;
	
	@FindBy(xpath="//a[contains(.,'Manage Products ')]")
	private WebElement manageProductsTab;
	
	@FindBy(xpath="//a[contains(.,'User Login Log')]")
	private WebElement userLoginLogTab;
	
	@FindBy(xpath="//i[@class='menu-icon icon-signout']/parent::a[@href='logout.php']")
	private WebElement logoutBtn;
	
	public AdminDashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrderManagementTab() {
		return orderManagementTab;
	}

	public WebElement getManageUsersTab() {
		return manageUsersTab;
	}

	public WebElement getCreateCategoryTab() {
		return createCategoryTab;
	}

	public WebElement getSubCategoryTab() {
		return subCategoryTab;
	}

	public WebElement getInsertProductTab() {
		return insertProductTab;
	}

	public WebElement getManageProductsTab() {
		return manageProductsTab;
	}

	public WebElement getUserLoginLogTab() {
		return userLoginLogTab;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public void OrderManagementTab() {
		orderManagementTab.click();
	}

	public void ManageUsersTab() {
		manageUsersTab.click();;
	}

	public void CreateCategoryTab() {
		createCategoryTab.click();
	}

	public void SubCategoryTab() {
		subCategoryTab.click();
	}

	public void InsertProductTab() {
		insertProductTab.click();
	}

	public void manageProductsTab() {
		manageProductsTab.click();
	}

	public void userLoginLogTab() {
		userLoginLogTab.click();
	}

	public void LogoutBtn() {
		logoutBtn.click();
	}
	
	
	
}
