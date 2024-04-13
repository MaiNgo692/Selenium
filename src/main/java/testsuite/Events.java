package testsuite;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Account;
import automation.pageLocator.EventsPage;
import automation.pageLocator.LoginPageFactory;

public class Events extends CommonBase{
	private EventsPage events;
	@BeforeMethod
	public void openPage() {
		driver = initChromeDriver(CT_Account.webURL);
		LoginPageFactory login = new LoginPageFactory(driver);
		login.LoginFunction("admin@demo.com", "riseDemo","");
		this.events = new EventsPage(driver);
	}
	
	@Test(priority = 1)
	public void AddEventSuccessfully() {
		events.AddNewEvent("Test Auto Class");
		assertTrue(getElementPresentDOM(By.xpath("//span[text()=' Test Auto Class']/ancestor::td[@data-date='"+getCurrentDateTime1()+"']")).isDisplayed());
	}
	
	@Test(priority = 2)
	public void deleteEventSuccessfully() {
		events.deleteNewEvent("Test Auto Class");
		pause(1000);
		System.out.println("//span[text()=' Test Auto Class']/ancestor::td[@data-date='"+getCurrentDateTime1()+"']");
		assertFalse(isElementPresent(By.xpath("//span[text()=' Test Auto Class']/ancestor::td[@data-date='"+getCurrentDateTime1()+"']")));
	}
	@Test(priority = 3)
	public void displayByCurrentMonth() {
		events.displayByCurrentMonth();
		System.out.println("//h2[@class='fc-toolbar-title' and text()='"+getCurrentMonth()+"']");
		assertTrue(isElementPresent(By.xpath("//h2[@class='fc-toolbar-title' and text()='"+getCurrentMonth()+"']")));
	}
	@Test(priority = 3)
	public void displayByNextMonth() {
		events.displayByNextMonth();
		System.out.println("//h2[@class='fc-toolbar-title' and text()='"+getNext1MonthFromCurrentMonth1()+"']");
		assertTrue(isElementPresent(By.xpath("//h2[@class='fc-toolbar-title' and text()='"+getNext1MonthFromCurrentMonth1()+"']")));
	}
	@Test(priority = 3)
	public void displayByPreviousMonth() {
		events.displayByPreviousMonth();
		System.out.println("//h2[@class='fc-toolbar-title' and text()='"+getPrevious1MonthFromCurrentMonth1()+"']");
		assertTrue(isElementPresent(By.xpath("//h2[@class='fc-toolbar-title' and text()='"+getPrevious1MonthFromCurrentMonth1()+"']")));
	}
	@Test(priority = 3)
	public void displayByCurrentWeek() {
		events.displayByCurrentWeek();
		System.out.println("//h2[@class='fc-toolbar-title' and text()='"+getWeekWithSpecialFormat("")+"']");
		assertTrue(isElementPresent(By.xpath("//h2[@class='fc-toolbar-title' and text()='"+getWeekWithSpecialFormat("")+"']")));
	}
	@Test(priority = 3)
	public void displayByNextWeek() {
		events.displayByNextWeek();
		System.out.println("//h2[@class='fc-toolbar-title' and text()='"+getWeekWithSpecialFormat("next")+"']");
		assertTrue(isElementPresent(By.xpath("//h2[@class='fc-toolbar-title' and text()='"+getWeekWithSpecialFormat("next")+"']")));
	}
	@Test(priority = 3)
	public void displayByPreviousWeek() {
		events.displayByPreviousWeek();
		System.out.println("//h2[@class='fc-toolbar-title' and text()='"+getWeekWithSpecialFormat("previous")+"']");
		assertTrue(isElementPresent(By.xpath("//h2[@class='fc-toolbar-title' and text()='"+getWeekWithSpecialFormat("previous")+"']")));
	}
	@Test(priority = 3)
	public void displayByCurrentDay() {
		events.displayByCurrentDay();
		System.out.println("//h2[@class='fc-toolbar-title' and text()='"+getCurrentDateTime2()+"']");
		assertTrue(isElementPresent(By.xpath("//h2[@class='fc-toolbar-title' and text()='"+getCurrentDateTime2()+"']")));
	}
	@AfterMethod
	  public void closeBrowser() {
		 quitDriver(driver);
	 }
}
