package testsuite;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Account;
import automation.pageLocator.EventsPage;
import automation.pageLocator.LoginPageFactory;

public class taskPage extends CommonBase{
	@BeforeMethod
	public void openPage() {
		driver = initChromeDriver(CT_Account.webURL);
		LoginPageFactory login = new LoginPageFactory(driver);
		login.LoginFunction("admin@demo.com", "riseDemo","");
	}
	private void assertListRelatedTo(String valueFilter) {
		List<WebElement> listRelatedTo = driver.findElements(By.xpath("//table[@id='task-table']//tbody//tr/child::td[6]/a"));
		for(WebElement item : listRelatedTo) {
			assertEquals(item.getText(),valueFilter);
		}
	}
	@Test
	public void filterTaskByRelatedTo() {
		String valueFilter = "Data Analysis and Insights";
		click(By.xpath("//span[text()='Tasks']"));
		click(By.xpath("//button[@class='btn btn-default show-filter-form-button']"));
		click(By.xpath("//div[@id='s2id_autogen5']"));
		// nhap dropdown list 
		type(By.xpath("(//input[@type='text' and @autocomplete='off'])[8]"), "Project");
		typeKeyTabs(By.xpath("(//input[@type='text' and @autocomplete='off'])[8]"));
		click(By.xpath("//div[@id='s2id_autogen7']"));
		type(By.xpath("(//input[@type='text' and @autocomplete='off'])[8]"), valueFilter);
		typeKeyTabs(By.xpath("(//input[@type='text' and @autocomplete='off'])[8]"));
		pause(3000);
		assertListRelatedTo(valueFilter);
	}
	
	@AfterMethod
	  public void closeBrowser() {
		 quitDriver(driver);
	 }
	
}
