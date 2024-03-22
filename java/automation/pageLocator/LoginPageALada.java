package automation.pageLocator;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageALada {
	private WebDriver driver;
	
	@FindBy(id="txtLoginUsername")
	private WebElement txtLoginUsername;
	
	@FindBy(id="txtLoginPassword")
	private WebElement txtLoginPassword;
	
	@FindBy(xpath="//button[@type = 'submit']")
	private WebElement btnLogIn;
	
	@FindBy(xpath="//div[@class ='avatar2']")
	private WebElement avatar;

	@FindBy(xpath="//a[text()='Chỉnh sửa thông tin']")
	private WebElement changeInf;

	@FindBy(xpath="//input[@placeholder='Mật khẩu hiện tại']")
	private WebElement currpassword;

	@FindBy(id="txtnewpass")
	private WebElement txtnewpass;

	@FindBy(id="txtrenewpass")
	private WebElement txtrenewpass;

	@FindBy(xpath="//button[text()='Lưu mật khẩu mới']")
	private WebElement btnSaveNewPass;
	public LoginPageALada(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(driver, this);
	}
	public void logInFunction( String email,String password ) {
		txtLoginUsername.clear();
		txtLoginUsername.sendKeys(email);
		txtLoginPassword.clear();
		txtLoginPassword.sendKeys(password);
		btnLogIn.click();
	}
	public void changeAccountInfFunction( String currPassword,String newPassword, String cNewPassword ) {
		avatar.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(changeInf));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",changeInf);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", currpassword);
		currpassword.clear();
		currpassword.sendKeys(currPassword);
		txtnewpass.clear();
		txtnewpass.sendKeys(newPassword);
		txtrenewpass.clear();
		txtrenewpass.sendKeys(cNewPassword);
		btnSaveNewPass.click();
	}
}
