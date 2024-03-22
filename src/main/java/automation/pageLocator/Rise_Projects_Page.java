package automation.pageLocator;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Rise_Projects_Page {

	public WebDriver driver;
	public WebDriverWait wait;

	// Constructor
	public Rise_Projects_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	// WebElements Locators+identification
	@FindBy(xpath = "//a[@title='Manage labels']")
	WebElement btn_label;

	@FindBy(xpath = "//input[@id='title']")
	WebElement txt_labelName;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement btn_saveLabel;

	@FindBy(xpath = "//div[@id='label-show-area']/child::span[1]")
	WebElement txt_createdLabel;

	@FindBy(xpath = "//span[@data-color='#34495e']")
	WebElement color_black;

	@FindBy(xpath = "//button[@id='label-delete-btn']")
	WebElement btn_delete;

	@FindBy(xpath = "//button[@id='cancel-edit-btn']")
	WebElement btn_cancel;

	@FindBy(xpath = "//input[@id='label_id']")
	WebElement hidden_input_check;

	@FindBy(xpath = "//span[@id='title-error']")
	WebElement error_title;

	@FindBy(xpath = "//form[@role='form']//button[@type='button'][normalize-space()='Close']")
	WebElement btn_close;

//	@FindBy(xpath = "//form[@id='labels-form']")
//	WebElement manage_label_form;  first way
	
	@FindBy(xpath = "//form[@id='labels-form']")
	List<WebElement> manage_label_form;
	
	@FindBy(xpath = "//a[@title='Add project']")
	WebElement btn_add_project;
	
	@FindBy(xpath = "//input[@id='title']")
	WebElement txt_project_or_task_title;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement btn_save_prject;
	
	@FindBy(xpath = "//input[@type='search']")
	WebElement input_search;
	
	@FindBy(xpath = "//button[@id='save-and-continue-button']")
	WebElement btn_save_and_continue_addProject;
	
	@FindBy(xpath = "//button[@id='next-button']")
	WebElement btn_next_addProjectMember;
	
	@FindBy(xpath = "//button[@id='save-and-add-button']")
	WebElement btn_save_and_add_addMultipleTasks;
	
	@FindBy(xpath = "(//button[@type='button'][normalize-space()='Close'])[1]")
	WebElement btn_close_addTasks;
	
	@FindBy(xpath = "(//button[@type='button'][normalize-space()='Close'])[1]")
	WebElement btn_close_addProject;
	
	@FindBy(xpath = "//form[@id='project-form']")
	List<WebElement> add_project_form;

	// Action methods
	public void clickLabelButton() {
		btn_label.click();
	}

	public void typeLabelName(String name) {
		txt_labelName.sendKeys(name);
	}

	public void saveLabel() {
		btn_saveLabel.click();
	}

	public void clickBlack() {
		color_black.click();
	}

	public void clickDeleteButton() {
		btn_delete.click();
	}

	public void clickCancelButton() {
		btn_cancel.click();
	}

	public void clickCreatedLabel() {
		txt_createdLabel.click();
	}

	public void clickCloseButton() {
		btn_close.click();
	}

	public boolean verifyLabelAndColor(String name, String colorHex) {
		String labelText = txt_createdLabel.getText();
		String labelColor = txt_createdLabel.getCssValue("background-color");
		String hexColor = Color.fromString(labelColor).asHex();
		return labelText.contains(name) && hexColor.equals(colorHex);
	}

	public boolean checkSelectedLabelDeleted(String labelNameToBeDeleted) {
		try {
			String labelText = txt_createdLabel.getText();
			return (labelText.contains(labelNameToBeDeleted));
		} catch (Exception e) {
			return (true);
		}
	}

//	public boolean elementHasClass(WebElement element, String active) {
//	    return element.getAttribute("class").contains(active);
//	}  //original to check any element

	// check cancel button specifically
	public boolean elementHasClass(String classAttribute) {
		return btn_cancel.getAttribute("class").contains(classAttribute);
	}

	public boolean inputIsEmpty() {
		String textInsideInputBox = hidden_input_check.getAttribute("value");

		if (textInsideInputBox.isEmpty()) {
			return true;
		} else
			return false;
	}

	public boolean isErrorShow() {

		if (error_title.isDisplayed()) {
			return true;
		} else
			return false;
	}
	
//	public boolean checkModal() {
//		try {
//			return manage_label_form.isDisplayed();
//		} catch (Exception e) {
//			return (false);
//		}
//	}   use with first way findby
	
	public boolean checkModal () {
		try {
			Boolean isPresent = manage_label_form.size()>0;  //true if modal exist
			return isPresent;
		} catch (NoSuchElementException e) {
		    return false;
		}
	
	}
	
	public void clickAddProject() {
		btn_add_project.click();
	}
	
	public void typeProjectTitleOrTasks(String title) {
		txt_project_or_task_title.sendKeys(title);
	}
	
	public void clickSaveProject() {
		btn_save_prject.click();
	}
	
	public boolean isCreatedProjectFound(String title) {
		input_search.sendKeys(title);
		if (driver.findElement(By.xpath("//a[contains(text(),'"+title+"')]")).isDisplayed()) {
			return true;
		} else
			return false;
	}
	
	public void clickSaveAndContinueProject() {
		btn_save_and_continue_addProject.click();
	}
	
	public void clickNextAddProjectMember() {
		btn_next_addProjectMember.click();
	}
	
	public void clickAddMoreTasks() {
		btn_save_and_add_addMultipleTasks.click();
	}
	
	public void clickCloseAddTasks() {
		btn_close_addTasks.click();
	}
	
	public boolean checkCreatedProjectAndTaks(String projectTitle, String taskTitle) {
		input_search.sendKeys(projectTitle);
		if (driver.findElement(By.xpath("//a[contains(text(),'"+projectTitle+"')]")).isDisplayed()) {
			driver.findElement(By.xpath("//a[contains(text(),'"+projectTitle+"')]")).click();
			if (driver.findElement(By.xpath("//a[contains(text(),'"+taskTitle+"')]")).isDisplayed()) {
				return true;
			}
			else return false;
		} else
			return false;
	}
	
	public void clickCloseAddProject() {
		btn_close_addProject.click();
	}
	
	public boolean checkAddProjectModal () {
		try {
			Boolean isPresent = add_project_form.size()>0;  //true if modal exist
			return isPresent;
		} catch (NoSuchElementException e) {
		    return false;
		}
	
	}
}
