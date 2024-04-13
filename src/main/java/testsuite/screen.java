package testsuite;
import static org.testng.Assert.assertFalse;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Account;
import automation.pageLocator.LoginPageFactory;


public class screen extends CommonBase {
	By filterHideBox = By.xpath("//div[@class='filter-item-box'][1]/button");
	@BeforeMethod
	@Parameters("browserTest")
	public void openBrowser(@Optional("browserTest") String browserName) {
		setupDriver(browserName);
		driver.get(CT_Account.webURL);
	}
	
	@Test
	public void hideClient() {
		//go to project screen
		LoginPageFactory login = new LoginPageFactory(driver);
		login.LoginFunction1("admin@demo.com", "riseDemo");
		click(By.linkText("Projects"));
		//
		click(filterHideBox);
		pause(5000);
		click(By.xpath("//ul[@class='list-group']/li[text()='Client']"));
		//check if successfull
		pause(5000);
		assertFalse(isElementPresent(By.xpath("//th[text()='Client']")));
		pause(5000);
	}
	@Test
	public void hideClientPriceStartdate() {
		//go to project screen
		LoginPageFactory login = new LoginPageFactory(driver);
		login.LoginFunction1("admin@demo.com", "riseDemo");
		click(By.linkText("Projects"));
		//
		click(filterHideBox);
		pause(5000);
		click(By.xpath("//ul[@class='list-group']/li[text()='Client']"));
		pause(5000);
		click(filterHideBox);
		pause(5000);
		click(By.xpath("//ul[@class='list-group']/li[text()='Price']"));
		pause(5000);
		click(filterHideBox);
		pause(5000);
		click(By.xpath("//ul[@class='list-group']/li[text()='Start date']"));
		//check if successfull
		pause(5000);
		assertFalse(isElementPresent(By.xpath("//th[text()='Client']")));
		assertFalse(isElementPresent(By.xpath("//th[text()='Price']")));
		assertFalse(isElementPresent(By.xpath("//th[text()='Start date']")));
		
		pause(5000);
	}
	
	@AfterMethod
	  public void closeBrowser() {
		 quitDriver(driver) ;
	 }
}
