package com.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CreateCategoryPage {
	@FindBy(name="category")
	private WebElement categoryNameTbx;
	
	@FindBy(name="description")
	private WebElement categoryDescriptionTbx;
	
	@FindBy(name="submit")
	private WebElement createCategoryBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement categoryCreatedSuccessText;
	
	@FindBy(name="close")
	private WebElement closeCategoryCreatedSuccessText;
	
	@FindBy(xpath="//select[contains(@name,'DataTables_Table')]")
	private WebElement showEntriesDD;
	
	@FindBy(xpath="//input[@aria-controls='DataTables_Table_0']")
	private WebElement searchTbx;
	
	public void editCategory(WebDriver driver, String categoryName) {
		driver.findElement(By.xpath("//tbody[@role='alert']/descendant::td[text()='"+categoryName+"']/parent::tr/descendant::i[@class='icon-edit']")).click();
	}
	
	@FindBy(xpath="//button[text()='Update']")
	private WebElement updateCategoryBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement categoryUpdateSuccessText;
	
	@FindBy(name="close")
	private WebElement closeCategoryUpdateSuccessText;
	
	public void deleteCategory(WebDriver driver, String categoryName) {
		driver.findElement(By.xpath("//tbody[@role='alert']/descendant::td[text()='"+categoryName+"']/parent::tr/descendant::i[@class='icon-remove-sign']")).click();
	}
	
	@FindBy(xpath="//div[@class='alert alert-error']")
	private WebElement deleteCategoryConfirmationText;
	
	@FindBy(name="close")
	private WebElement closeDeleteCategoryConfirmationText;
	

	public CreateCategoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void createCategoryBtn() {
		createCategoryBtn.click();
	}

	public void updateCategoryBtn() {
		updateCategoryBtn.click();
	}

	public WebElement getCategoryNameTbx() {
		return categoryNameTbx;
	}

	public WebElement getCategoryDescriptionTbx() {
		return categoryDescriptionTbx;
	}

	public WebElement getCreateCategoryBtn() {
		return createCategoryBtn;
	}

	public WebElement getCategoryCreatedSuccessText() {
		return categoryCreatedSuccessText;
	}

	public WebElement getCloseCategoryCreatedSuccessText() {
		return closeCategoryCreatedSuccessText;
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

	public WebElement getCategoryUpdateSuccessText() {
		return categoryUpdateSuccessText;
	}

	public WebElement getCloseCategoryUpdateSuccessText() {
		return closeCategoryUpdateSuccessText;
	}

	public WebElement getDeleteCategoryConfirmationText() {
		return deleteCategoryConfirmationText;
	}

	public WebElement getCloseDeleteCategoryConfirmationText() {
		return closeDeleteCategoryConfirmationText;
	}
	
	public void categoryCreateConfirmation(String aText) {
		boolean res=categoryCreatedSuccessText.getText().contains(aText);
		Assert.assertTrue(res);
	}
	
	public void categoryDeleteConfirmation(String aText) {
		boolean res = deleteCategoryConfirmationText.getText().contains(aText);
		Assert.assertTrue(res);
	}
	
	public void createCategory(String categoryName, String categoryDescription) {
		categoryNameTbx.sendKeys(categoryName);
		categoryDescriptionTbx.sendKeys(categoryDescription);
		createCategoryBtn.click();
	}
}
