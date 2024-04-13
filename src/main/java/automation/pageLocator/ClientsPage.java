package automation.pageLocator;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automation.common.CommonBase;

public class ClientsPage extends CommonBase{
	private String sidebarClients = "//span[text()='Clients']";
	private String tabClients = "//a[text()='Clients']";
	private String buttonPlus = "//button[@class=\"btn btn-default show-filter-form-button\"]";
	private String dropdownClientGroups = "//div[@id='s2id_autogen7']";
	private String inputClientGroups = "//input[@id='s2id_autogen8_search']";
	private String dropdownLabel = "//div[@id='s2id_autogen9']";
	private String inputLabel= "//input[@id='s2id_autogen10_search']";
	private WebDriver driver;

	public ClientsPage(WebDriver _driver) {
		// TODO Auto-generated constructor stub
		this.driver = _driver;
	}
	
	public void filterClientGroupAndLable(String clientGroup, String lable) {
		click(By.xpath(sidebarClients));
		click(By.xpath(tabClients));
		click(By.xpath(buttonPlus));
		click(By.xpath(dropdownClientGroups));
		type(By.xpath(inputClientGroups),clientGroup);
		typeKeyTabs(By.xpath(inputClientGroups));
		click(By.xpath(dropdownLabel));
		type(By.xpath(inputLabel),lable);
		typeKeyTabs(By.xpath(inputLabel));
		pause(3000);
		assertListfilterClientGroupAndLable(clientGroup,lable);
	}
	private void assertListfilterClientGroupAndLable(String clientGroup, String lable) {
		List<WebElement> listfilterClientGroup = driver.findElements(By.xpath("//table[@id='client-table']//tbody//tr/child::td[5]//li"));
		for(WebElement item : listfilterClientGroup) {
			assertEquals(item.getText(),clientGroup);
		}
		List<WebElement> listfilterLable = driver.findElements(By.xpath("//table[@id='client-table']//tbody//tr/child::td[6]/span"));
		for(WebElement item : listfilterLable) {
			assertEquals(item.getText(),lable);
		}
	}
}
