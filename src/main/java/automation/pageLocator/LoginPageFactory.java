package automation.pageLocator;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.common.CommonBase;

public class LoginPageFactory extends CommonBase{
private WebDriver driver;

@FindBy(id="email")
private WebElement txtEmail;

@FindBy(id="password")
private WebElement txtPass;

@FindBy(xpath="//button[@type='submit' and text()='Sign in']")
private WebElement btnLogin;
@FindBy(xpath="//iframe[@title='reCAPTCHA']")
private WebElement checkCaptchaIframe;

@FindBy(xpath="//div[@class='recaptcha-checkbox-border']")
private WebElement checkCaptcha;


public LoginPageFactory(WebDriver _driver)  {
	this.driver = _driver;
	PageFactory.initElements(driver, this);
}


public void LoginFunction(String email , String password, String role) {
	txtEmail.clear();
	txtEmail.sendKeys(email);
	txtPass.clear();
	txtPass.sendKeys(password);
	driver.switchTo().frame(checkCaptchaIframe);
	pause(5000);
	checkCaptcha.click();
	driver.switchTo().defaultContent();
	pause(5000);
	btnLogin.click();
}
public void LoginFunction1(String email , String password) {
	txtEmail.clear();
	txtEmail.sendKeys(email);
	txtPass.clear();
	txtPass.sendKeys(password);
	driver.switchTo().frame(checkCaptchaIframe);
	pause(5000);
	checkCaptcha.click();
	driver.switchTo().defaultContent();
	pause(5000);
	btnLogin.click();
	
}

}
