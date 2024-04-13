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

public class filterProject extends CommonBase{
	By btnEdit = By.xpath(
			"//a[contains(text(),'new added project')]//ancestor:: td//following-sibling::td[7]/a[@title='Edit project']");
	By btnSave = By.xpath("//button[text()=' Save']");
	
	@BeforeMethod
	@Parameters("browserTest")
	public void openBrowser(@Optional("browserTest") String browserName) {
		setupDriver(browserName);
		driver.get(CT_Account.webURL);
	}
	
	@Test(priority = 1)
	public void filterCompletedProductBySelectBox() {
		LoginPageFactory login = new LoginPageFactory(driver);
		login.LoginFunction1("admin@demo.com", "riseDemo");
		click(By.linkText("Projects"));
		
		ProjectPageFactory projectFactory = new ProjectPageFactory(driver);
		projectFactory.AddProjectFunction("Test Filter Completed");
		pause(2000);
		projectFactory.searchProject("Test Filter Completed");
		click(By.xpath("//a[contains(text(),'Test Filter Completed')]//ancestor:: td//following-sibling::td[7]/a[@title='Edit project']"));
		String[] listLabels = new String[] { "Urgent", "Upcoming" };
		projectFactory.editProject("Test Filter Completed 1", "Client Project", "Demo Client", "abc", "27-11-2023", "30-11-2023",
				"36000", listLabels, "Completed");
		click(btnSave);
		projectFactory.filterCompletedProductBySelectBox();
		projectFactory.searchProject("Test Filter Completed 1");
		assertTrue(getElementPresentDOM(By.xpath("//a[contains(text(),'Test Filter Completed 1')]")).isDisplayed());
		projectFactory.deleteProject("Test Filter Completed 1");
	}
	
	@Test(priority = 2)
	public void filterLableHighPriorityProductBySelectBox() {
		LoginPageFactory login = new LoginPageFactory(driver);
		login.LoginFunction1("admin@demo.com	", "riseDemo");
		click(By.linkText("Projects"));
		
		ProjectPageFactory projectFactory = new ProjectPageFactory(driver);
		projectFactory.AddProjectFunction("Test Filter High Priority");
		pause(2000);
		projectFactory.searchProject("Test Filter High Priority");
		click(By.xpath("//a[contains(text(),'Test Filter High Priority')]//ancestor:: td//following-sibling::td[7]/a[@title='Edit project']"));
		String[] listLabels = new String[] { "Urgent", "Upcoming","High Priority" };
		projectFactory.editProject("Test Filter High Priority 1", "Client Project", "Demo Client", "abc", "27-11-2023", "30-11-2023",
				"36000", listLabels, "Completed");
		click(btnSave);
		projectFactory.filterLableHighPriorityProductBySelectBox();
		projectFactory.searchProject("Test Filter High Priority 1");
		assertTrue(getElementPresentDOM(By.xpath("//a[contains(text(),'Test Filter High Priority 1')]")).isDisplayed());
		projectFactory.deleteProject("Test Filter High Priority 1");
	}
	
	@Test(priority = 3)
	public void filterOpenProductBySelectBox() {
		LoginPageFactory login = new LoginPageFactory(driver);
		login.LoginFunction1("admin@demo.com	", "riseDemo");
		click(By.linkText("Projects"));
		
		ProjectPageFactory projectFactory = new ProjectPageFactory(driver);
		projectFactory.AddProjectFunction("Test Filter Open");
		pause(2000);
		projectFactory.searchProject("Test Filter Open");
		click(By.xpath("//a[contains(text(),'Test Filter Open')]//ancestor:: td//following-sibling::td[7]/a[@title='Edit project']"));
		String[] listLabels = new String[] { "Urgent", "Upcoming","High Priority" };
		projectFactory.editProject("Test Filter Open 1", "Client Project", "Demo Client", "abc", "27-11-2023", "30-11-2023",
				"36000", listLabels, "Open");
		click(btnSave);
		projectFactory.filterOpenProductBySelectBox();
		projectFactory.searchProject("Test Filter Open 1");
		assertTrue(getElementPresentDOM(By.xpath("//a[contains(text(),'Test Filter Open 1')]")).isDisplayed());
		projectFactory.deleteProject("Test Filter Open 1");
	}
	
	@Test(priority = 4)
	public void filterUpcomingProductBySelectBox() {
		LoginPageFactory login = new LoginPageFactory(driver);
		login.LoginFunction1("admin@demo.com	", "riseDemo");
		click(By.linkText("Projects"));
		
		ProjectPageFactory projectFactory = new ProjectPageFactory(driver);
		projectFactory.AddProjectFunction("Test Filter Upcoming");
		pause(2000);
		projectFactory.searchProject("Test Filter Upcoming");
		click(By.xpath("//a[contains(text(),'Test Filter Upcoming')]//ancestor:: td//following-sibling::td[7]/a[@title='Edit project']"));
		String[] listLabels = new String[] { "Urgent", "Upcoming","High Priority" };
		projectFactory.editProject("Test Filter Upcoming 1", "Client Project", "Demo Client", "abc", "27-11-2023", "30-11-2023",
				"36000", listLabels, "Open");
		click(btnSave);
		projectFactory.filterUpcomingProductBySelectBox();
		projectFactory.searchProject("Test Filter Upcoming 1");
		assertTrue(getElementPresentDOM(By.xpath("//a[contains(text(),'Test Filter Upcoming 1')]")).isDisplayed());
		projectFactory.deleteProject("Test Filter Upcoming 1");
	}
	
	@Test(priority = 5)
	public void filterCompletedProductByButton() {
		LoginPageFactory login = new LoginPageFactory(driver);
		login.LoginFunction1("admin@demo.com	", "riseDemo");
		click(By.linkText("Projects"));
		
		ProjectPageFactory projectFactory = new ProjectPageFactory(driver);
		projectFactory.AddProjectFunction("Test Filter Completed by button");
		pause(2000);
		projectFactory.searchProject("Test Filter Completed by button");
		click(By.xpath("//a[contains(text(),'Test Filter Completed by button')]//ancestor:: td//following-sibling::td[7]/a[@title='Edit project']"));
		String[] listLabels = new String[] { "Urgent", "Upcoming","High Priority" };
		projectFactory.editProject("Test Filter Completed by button 1", "Client Project", "Demo Client", "abc", "27-11-2023", "30-11-2023",
				"36000", listLabels, "Completed");
		click(btnSave);
		projectFactory.filterCompletedProductByButton();
		projectFactory.searchProject("Test Filter Completed by button 1");
		assertTrue(getElementPresentDOM(By.xpath("//a[contains(text(),'Test Filter Completed by button 1')]")).isDisplayed());
		projectFactory.deleteProject("Test Filter Completed by button 1");
	}
	
	@Test(priority = 6)
	public void filterHighPriorityProductByButton() {
		LoginPageFactory login = new LoginPageFactory(driver);
		login.LoginFunction1("admin@demo.com	", "riseDemo");
		click(By.linkText("Projects"));
		
		ProjectPageFactory projectFactory = new ProjectPageFactory(driver);
		projectFactory.AddProjectFunction("Test Filter High Priority by button");
		pause(2000);
		projectFactory.searchProject("Test Filter High Priority by button");
		click(By.xpath("//a[contains(text(),'Test Filter High Priority by button')]//ancestor:: td//following-sibling::td[7]/a[@title='Edit project']"));
		String[] listLabels = new String[] { "Urgent", "Upcoming","High Priority" };
		projectFactory.editProject("Test Filter High Priority by button 1", "Client Project", "Demo Client", "abc", "27-11-2023", "30-11-2023",
				"36000", listLabels, "Completed");
		click(btnSave);
		projectFactory.filterHighPriorityProductByButton();
		projectFactory.searchProject("Test Filter High Priority by button 1");
		assertTrue(getElementPresentDOM(By.xpath("//a[contains(text(),'Test Filter High Priority by button 1')]")).isDisplayed());
		projectFactory.deleteProject("Test Filter High Priority by button 1");
	}
	
	@Test(priority = 7)
	public void filterOpenProductByButton() {
		LoginPageFactory login = new LoginPageFactory(driver);
		login.LoginFunction1("admin@demo.com	", "riseDemo");
		click(By.linkText("Projects"));
		
		ProjectPageFactory projectFactory = new ProjectPageFactory(driver);
		projectFactory.AddProjectFunction("Test Filter Open by button");
		pause(2000);
		projectFactory.searchProject("Test Filter Open by button");
		click(By.xpath("//a[contains(text(),'Test Filter Open by button')]//ancestor:: td//following-sibling::td[7]/a[@title='Edit project']"));
		String[] listLabels = new String[] { "Urgent", "Upcoming","High Priority" };
		projectFactory.editProject("Test Filter Open by button 1", "Client Project", "Demo Client", "abc", "27-11-2023", "30-11-2023",
				"36000", listLabels, "Open");
		click(btnSave);
		projectFactory.filterOpenProductByButton();
		projectFactory.searchProject("Test Filter Open by button 1");
		assertTrue(getElementPresentDOM(By.xpath("//a[contains(text(),'Test Filter Open by button 1')]")).isDisplayed());
		projectFactory.deleteProject("Test Filter Open by button 1");
	}
	@Test(priority = 8)
	public void filterUpcomingProductByButton() {
		LoginPageFactory login = new LoginPageFactory(driver);
		login.LoginFunction1("admin@demo.com	", "riseDemo");
		click(By.linkText("Projects"));
		
		ProjectPageFactory projectFactory = new ProjectPageFactory(driver);
		projectFactory.AddProjectFunction("Test Filter Upcoming by button");
		pause(2000);
		projectFactory.searchProject("Test Filter Upcoming by button");
		click(By.xpath("//a[contains(text(),'Test Filter Upcoming by button')]//ancestor:: td//following-sibling::td[7]/a[@title='Edit project']"));
		String[] listLabels = new String[] { "Urgent", "Upcoming","High Priority" };
		projectFactory.editProject("Test Filter Upcoming by button 1", "Client Project", "Demo Client", "abc", "27-11-2023", "30-11-2023",
				"36000", listLabels, "Open");
		click(btnSave);
		projectFactory.filterUpcomingProductByButton();
		projectFactory.searchProject("Test Filter Upcoming by button 1");
		assertTrue(getElementPresentDOM(By.xpath("//a[contains(text(),'Test Filter Upcoming by button 1')]")).isDisplayed());
		projectFactory.deleteProject("Test Filter Upcoming by button 1");
	}
	
	@Test(priority = 9)
	public void filterManyConditionsProductByFilterForm() {
		LoginPageFactory login = new LoginPageFactory(driver);
		login.LoginFunction1("admin@demo.com	", "riseDemo");
		click(By.linkText("Projects"));
		
		ProjectPageFactory projectFactory = new ProjectPageFactory(driver);
		projectFactory.AddProjectFunction("Test Filter Many Condition by filter form");
		pause(2000);
		projectFactory.searchProject("Test Filter Many Condition by filter form");
		click(By.xpath("//a[contains(text(),'Test Filter Many Condition by filter form')]//ancestor:: td//following-sibling::td[7]/a[@title='Edit project']"));
		String[] listLabels = new String[] { "Urgent", "Upcoming","High Priority" };
		projectFactory.editProject("Test Filter Many Condition by filter form 1", "Client Project", "Demo Client", "abc", "27-11-2023", "30-11-2023",
				"36000", listLabels, "Open");
		click(btnSave);
		projectFactory.filterManyConditionsProductByFilterForm("Upcoming","This Month","In 7 days","Open");
		projectFactory.searchProject("Test Filter Many Condition by filter form");
		pause(3000);
		assertTrue(getElementPresentDOM(By.xpath("//a[contains(text(),'Test Filter Many Condition by filter form 1')]")).isDisplayed());
		projectFactory.deleteProject("Test Filter Many Condition by filter form 1");
	}
	
	@Test(priority = 10)
	public void clearFilterProductBy() {
		LoginPageFactory login = new LoginPageFactory(driver);
		login.LoginFunction1("admin@demo.com	", "riseDemo");
		click(By.linkText("Projects"));
		
		ProjectPageFactory projectFactory = new ProjectPageFactory(driver);
		projectFactory.AddProjectFunction("Test clear filter project");
		pause(2000);
		projectFactory.searchProject("Test clear filter project");
		click(By.xpath("//a[contains(text(),'Test clear filter project')]//ancestor:: td//following-sibling::td[7]/a[@title='Edit project']"));
		String[] listLabels = new String[] { "Urgent", "Upcoming","High Priority" };
		projectFactory.editProject("Test clear filter project 1", "Client Project", "Demo Client", "abc", "27-11-2023", "30-11-2023",
				"36000", listLabels, "Open");
		click(btnSave);
		projectFactory.AddProjectFunction("Test clear filter project second");
		pause(2000);
		projectFactory.searchProject("Test clear filter project second");
		click(By.xpath("//a[contains(text(),'Test clear filter project')]//ancestor:: td//following-sibling::td[7]/a[@title='Edit project']"));
		String[] listLabels2 = new String[] { "Urgent","High Priority" };
		projectFactory.editProject("Test clear filter project second 1", "Client Project", "Demo Client", "abc", "27-11-2023", "30-11-2023",
				"36000", listLabels2, "Completed");
		click(btnSave);
		projectFactory.filterOpenProductBySelectBox();
//		projectFactory.searchProject("Test clear filter project 1");
//		pause(3000);
//		assertTrue(getElementPresentDOM(By.xpath("//a[contains(text(),'Test clear filter project 1')]")).isDisplayed());
		
		projectFactory.clearFilter();
		projectFactory.searchProject("Test clear filter project");
		pause(3000);
		assertTrue(getElementPresentDOM(By.xpath("//a[contains(text(),'Test clear filter project 1')]")).isDisplayed());
		assertTrue(getElementPresentDOM(By.xpath("//a[contains(text(),'Test clear filter project second 1')]")).isDisplayed());
		projectFactory.deleteProject("Test clear filter project 1");
		projectFactory.deleteProject("Test clear filter project second 1");
	}
	
	@AfterMethod
	  public void closeBrowser() {
		 quitDriver(driver) ;
	 }
}
