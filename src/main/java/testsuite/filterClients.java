package testsuite;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Account;
import automation.constant.DataProviderRise;
import automation.pageLocator.ClientsPage;
import automation.pageLocator.EventsPage;
import automation.pageLocator.LoginPageFactory;

public class filterClients extends CommonBase{
	private ClientsPage client;
	
	@BeforeMethod
	public void openPage() throws InterruptedException {
		driver = initChromeDriver(CT_Account.webURL);
		LoginPageFactory login = new LoginPageFactory(driver);
		login.LoginFunction("admin@demo.com", "riseDemo","");
		this.client = new ClientsPage(driver);
	}
	@Test(dataProvider = "data_Rise_Filter_Client",dataProviderClass= DataProviderRise.class)
	public void filterClientGroupAndLable(String clientGroup, String lable) {
		client.filterClientGroupAndLable(clientGroup, lable);
	}
	
	@AfterMethod
	  public void closeBrowser() {
		 quitDriver(driver);
	 }
}
