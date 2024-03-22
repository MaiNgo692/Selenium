package automation.pageLocator;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Rise_Login_Page {

	public WebDriver driver;
	public WebDriverWait wait;

	// Constructor
	public Rise_Login_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	//WebElements Locators+identification	
	@FindBy(xpath="//button[normalize-space()='Sign in']")
	WebElement btn_submit;
	
	// Action methods
	public void clickSubmit() {
		btn_submit.click();
	}

}
