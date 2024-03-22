package automation.pageLocator;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Rise_Dashboard_Page {

	public WebDriver driver;
	public WebDriverWait wait;

	// Constructor
	public Rise_Dashboard_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	//WebElements Locators+identification	
	@FindBy(xpath="//a[@href='https://rise.fairsketch.com/clients']")
	WebElement btn_client;
	
	@FindBy(xpath="//a[@href='https://rise.fairsketch.com/projects/all_projects']")
	WebElement btn_project;
	
	// Action methods
	public void clickClient() {
		btn_client.click();
	}
	
	public void clickProject() {
		btn_project.click();
	}

}
