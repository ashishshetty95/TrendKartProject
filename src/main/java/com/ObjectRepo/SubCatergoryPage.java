package com.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SubCatergoryPage {
	@FindBy(name="category")
	private WebElement categoryDD;
	
	@FindBy(xpath="//input[@name='subcategory']")
	private WebElement subCategoryNameTbx;
	
	@FindBy(name="submit")
	private WebElement createSubCategoryBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement subCategoryCreatedSuccessText;
	
	@FindBy(name="close")
	private WebElement closesubCategoryCreatedSuccessText;
	
	@FindBy(xpath="//select[contains(@name,'DataTables_Table')]")
	private WebElement showEntriesDD;
	
	@FindBy(xpath="//input[@aria-controls='DataTables_Table_0']")
	private WebElement searchTbx;
	
	public void editCategory(WebDriver driver, String subCategoryName) {
		driver.findElement(By.xpath("//tbody[@role='alert']/descendant::td[text()='"+subCategoryName+"']/parent::tr/descendant::i[@class='icon-edit']")).click();
	}
	
	@FindBy(xpath="//button[text()='Update']")
	private WebElement updateCategoryBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement subCategoryUpdatedSuccessText;
	
	@FindBy(name="close")
	private WebElement closeSubCategoryUpdatedSuccessText;
	
	public void deleteCategory(WebDriver driver, String subCategoryName) {
		driver.findElement(By.xpath("//tbody[@role='alert']/descendant::td[text()='"+subCategoryName+"']/parent::tr/descendant::i[@class='icon-remove-sign']")).click();
	}
	
	@FindBy(xpath="//div[@class='alert alert-error']")
	private WebElement deleteSubCategoryConfirmationText;
	
	@FindBy(name="close")
	private WebElement closeDeleteSubCategoryConfirmationText;
	
	public SubCatergoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void createSubCategoryBtn() {
		createSubCategoryBtn.click();
	}

	public void updateCategoryBtn() {
		updateCategoryBtn.click();
	}

	public WebElement getCategoryDD() {
		return categoryDD;
	}

	public WebElement getSubCategoryNameTbx() {
		return subCategoryNameTbx;
	}

	public WebElement getCreateSubCategoryBtn() {
		return createSubCategoryBtn;
	}

	public WebElement getSubCategoryCreatedSuccessText() {
		return subCategoryCreatedSuccessText;
	}

	public WebElement getClosesubCategoryCreatedSuccessText() {
		return closesubCategoryCreatedSuccessText;
	}

	public WebElement getShowEntriesDD() {
		return showEntriesDD;
	}

	public WebElement getSearchTbx() {
		return searchTbx;
	}

	public WebElement getUpdateCategoryBtn() {
		return updateCategoryBtn;
	}

	public WebElement getSubCategoryUpdatedSuccessText() {
		return subCategoryUpdatedSuccessText;
	}

	public WebElement getCloseSubCategoryUpdatedSuccessText() {
		return closeSubCategoryUpdatedSuccessText;
	}

	public WebElement getDeleteSubCategoryConfirmationText() {
		return deleteSubCategoryConfirmationText;
	}

	public WebElement getCloseDeleteSubCategoryConfirmationText() {
		return closeDeleteSubCategoryConfirmationText;
	}
	
	public void subCategoryCreatedConfirmation(String aText) {
		boolean res=subCategoryCreatedSuccessText.getText().contains(aText);
		Assert.assertTrue(res);
	}
}
