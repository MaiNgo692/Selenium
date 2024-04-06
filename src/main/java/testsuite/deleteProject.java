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
import automation.pageLocator.ProjectPageFactory;

public class deleteProject extends CommonBase {
	@BeforeMethod
	@Parameters("browserTest")
	public void openBrowser(@Optional("browserTest")String browserName) {
		setupDriver(browserName);
		driver.get(CT_Account.webURL);
	}
	@Test
	public void deleteProjectSuccessfully() throws InterruptedException {
		LoginPageFactory login = new LoginPageFactory(driver);
		login.LoginFunction("admin@demo.com", "riseDemo","");
		click(By.linkText("Projects"));
		//find new added project by title
		ProjectPageFactory projPage = new ProjectPageFactory(driver);
//		projPage.AddProjectFunction("new added project");
//		pause(5000);
		projPage.searchProject("new added project");
		//click delete icon
		click(By.xpath("//a[contains(text(),'new added project')]//ancestor:: td//following-sibling::td[7]/a[@title='Delete project']"));
		//click delete
		click(By.xpath("//button[text()=' Delete']"));
		//Check if delete successfully
		projPage.searchProject("new added project");
		pause(3000);
		assertFalse(isElementPresent(By.xpath("//a[contains(text(),'new added project')]")));
		
	}
	
	@AfterMethod
	  public void closeBrowser() {
		 quitDriver(driver) ;
	 }
}
