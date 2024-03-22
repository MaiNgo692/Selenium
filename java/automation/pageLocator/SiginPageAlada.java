package automation.pageLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SiginPageAlada {
	private WebDriver driver;
	
	@FindBy(id="txtFirstname")
	private WebElement txtFirstname;
	
	@FindBy(id="txtEmail")
	private WebElement txtEmail;
	
	@FindBy(id="txtCEmail")
	private WebElement txtCEmail;
	
	@FindBy(id="txtPassword")
	private WebElement txtPassword;
	
	@FindBy(id="txtCPassword")
	private WebElement txtCPassword;
	
	@FindBy(id="txtPhone")
	private WebElement txtPhone;
	
	@FindBy(xpath="//button[@type = 'submit']")
	private WebElement btnSigIn;
	

	
	
	
	
	
	public SiginPageAlada(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(driver, this);
	}
	public void SigInFunction(String firstName, String email , String cEmail , String password, String cPassword , String phone) {
		txtFirstname.clear();
		txtFirstname.sendKeys(firstName);
		txtEmail.clear();
		txtEmail.sendKeys(email);
		txtCEmail.clear();
		txtCEmail.sendKeys(cEmail);
		txtPassword.clear();
		txtPassword.sendKeys(password);
		txtCPassword.clear();
		txtCPassword.sendKeys(cPassword);
		txtPhone.clear();
		txtPhone.sendKeys(phone);
		btnSigIn.click();
	}
	
	
	
	
	
}
