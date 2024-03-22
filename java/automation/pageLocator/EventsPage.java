package automation.pagelocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import automation.common.CommonBase;

public class EventsPage extends CommonBase {
	private WebDriver driver;
	public EventPage(WebDriver _driver) {
		this.driver = _driver;
	}
	public void AddNewEvent(String eventName, String startDate, String endDate) 
	{
		click(By.xpath("//span[text()='Events']"));
		click(By.xpath("//a[text()='Add event']"));
		click(By.id("title"));
		type(By.id("start_date"),getCurrentDateTime());
		type(By.id("end_date"),getCurrentDateTime());
		click(By.xpath("//button[@class='btn btn-primary' and text()=' Save']"));
	}
}
