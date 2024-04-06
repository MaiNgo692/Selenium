package testsuite;

import static org.testng.Assert.assertTrue;

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


public class editProject extends CommonBase {
	By btnEdit = By.xpath(
			"//a[contains(text(),'new added project')]//ancestor:: td//following-sibling::td[7]/a[@title='Edit project']");
	By btnSave = By.xpath("//button[text()=' Save']");

	@BeforeMethod
	@Parameters("browserTest")
	public void openBrowser(@Optional("browserTest") String browserName) {
		setupDriver(browserName);
		driver.get(CT_Account.webURL);
	}

	@Test
	public void editProjectSuccessfully() throws InterruptedException {
		String oldProjectName = "new added project 2";
		String newProjectName = "new added project 1";
		LoginPageFactory login = new LoginPageFactory(driver);
		login.LoginFunction("admin@demo.com	", "riseDemo","");
		click(By.linkText("Projects"));
		// click button all projects
		click(By.xpath("//button[text()='All projects']"));
		// find new added project by title
		ProjectPageFactory projPage = new ProjectPageFactory(driver);
		projPage.searchProject(oldProjectName);
		// click button edit
		click(btnEdit);
		// edit
		String[] listLabels = new String[] { "Urgent", "Upcoming" };
		projPage.editProject(newProjectName, "Client Project", "Demo Client", "abc", "27-11-2023", "1-12-2023",
				"36000", listLabels, "Completed");
		// click Save
		click(btnSave);
		pause(5000);
		// check
		projPage.searchProject(newProjectName);
		assertTrue(getElementPresentDOM(By.xpath("//a[contains(text(),'"+newProjectName+"')]")).isDisplayed());
		assertTrue(getElementPresentDOM(By.xpath("//a[contains(text(),'"+newProjectName+"')]//following-sibling::span[text()='Upcoming']")).isDisplayed());
		assertTrue(getElementPresentDOM(By.xpath("//a[contains(text(),'"+newProjectName+"')]//following-sibling::span[text()='Urgent']")).isDisplayed());
		assertTrue(getElementPresentDOM(By.xpath("//a[contains(text(),'"+newProjectName+"')]//ancestor::td//following-sibling::td/a[text()='Demo Client']")).isDisplayed());
		assertTrue(getElementPresentDOM(By.xpath("//a[contains(text(),'"+newProjectName+"')]//ancestor::td//following-sibling::td[contains(text(),'36,000')]")).isDisplayed());
		assertTrue(getElementPresentDOM(By.xpath("//a[contains(text(),'"+newProjectName+"')]//ancestor::td//following-sibling::td[contains(text(),'27-11-2023')]")).isDisplayed());
		assertTrue(getElementPresentDOM(By.xpath("//a[contains(text(),'"+newProjectName+"')]//ancestor::td//following-sibling::td[contains(text(),'1-12-2023')]")).isDisplayed());
		assertTrue(getElementPresentDOM(By.xpath("//a[contains(text(),'"+newProjectName+"')]//ancestor::td//following-sibling::td[contains(text(),'Completed')]")).isDisplayed());
		pause(5000);
		
	}
	

	@AfterMethod
	  public void closeBrowser() {
		 quitDriver(driver) ;
	 }
}
