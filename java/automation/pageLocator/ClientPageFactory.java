package automation.pageLocator;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientPageFactory {
	private WebDriver driver;
	
	@FindBy(xpath="//span[text()='Clients']")
	private WebElement clientsMenu;
	
	@FindBy(xpath="//a[@title='Add client']")
	private WebElement btnAddClient;
	
	@FindBy(id="company_name")
	private WebElement textCompanyName;
	
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement btnSave;
	
	@FindBy(xpath="//a[text()='Clients']")
	private WebElement clientsList;
	
	@FindBy(xpath="//input[@type='search']")
	private WebElement textsearch;
	
	@FindBy(xpath="//a[text()='AutomationTest2']")
	private WebElement addedCompany;
	
	public ClientPageFactory(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(driver, this);
	}
	public void AddNewClientFunction(String companyName) throws InterruptedException {
		clientsMenu.click();
//		btnAddClient.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", btnAddClient);
		Thread.sleep(3000);
//		textCompanyName.sendKeys(companyName);
		js.executeScript("arguments[0].value = '" + companyName + "'", textCompanyName);
		btnSave.click();
		textsearch.sendKeys(companyName);
	}
	
	public void searchClient(String companyName) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", clientsList);
		js.executeScript("arguments[0].value = '" + companyName + "'", textsearch);
	}
}
