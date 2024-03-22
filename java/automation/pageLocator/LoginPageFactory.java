package automation.pageLocator;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory{
private WebDriver driver;

@FindBy(id="email")
private WebElement txtEmail;

@FindBy(id="password")
private WebElement txtPass;

@FindBy(xpath="//button[@type='submit' and text()='Sign in']")
private WebElement btnLogin;



public LoginPageFactory(WebDriver _driver) {
	this.driver = _driver;
	PageFactory.initElements(driver, this);
}


public void LoginFunction(String email , String password) {
	txtEmail.clear();
	txtEmail.sendKeys(email);
	txtPass.clear();
	txtPass.sendKeys(password);
	btnLogin.click();
}

}
