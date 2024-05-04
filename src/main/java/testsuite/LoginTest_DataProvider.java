package testsuite;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Account;
import automation.constant.DataProviderRise;
import automation.pageLocator.EventsPage;
import automation.pageLocator.LoginPageFactory;

public class LoginTest_DataProvider extends CommonBase {
	@BeforeMethod
	public void openChorme() {
		driver = initChromeDriver(CT_Account.webURL);
//		LoginPageFactory login = new LoginPageFactory(driver);
//		login.LoginFunction("admin@demo.com", "riseDemo","");
//		this.events = new EventsPage(driver);
	}
	
	@Test(dataProvider = "data_Rise_Login",dataProviderClass= DataProviderRise.class)
	public void loginSuccessFully(String username, String password, String role) throws InterruptedException {
		LoginPageFactory login = new LoginPageFactory(driver);
		login.LoginFunction(username, password, role);
		assertTrue(isElementPresent(CT_Account.TEXT_DASHBOARD));
		System.out.println("Login sucessfully with role: "+ role);
	}
	@AfterMethod
	  public void closeBrowser() {
		 quitDriver(driver) ;
	 }
}
