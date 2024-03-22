package automation.pageLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automation.common.CommonBase;

public class EventsPage extends CommonBase {

	private String sidebarEvents = "//span[text()='Events']";
	private String addEvents = "//a[text()=' Add event']";
	private String idAddEventTitle = "title";
	private String idAddEventStartDate = "start_date";
	private String idAddEventEndDate = "end_date";
	private String addEventsSave = "//button[@class='btn btn-primary' and text()=' Save']";
	private String displayMonthBtn = "//button[text()='month']";
	private String displayWeekBtn = "//button[text()='week']";
	private String displayDayBtn = "//button[text()='day']";
	private String displayNextBtn = "//span[@class='fc-icon fc-icon-chevron-right']";
	private String displayPreviousBtn = "//span[@class='fc-icon fc-icon-chevron-left']";

	private WebDriver driver;

	public EventsPage(WebDriver _driver) {
		// TODO Auto-generated constructor stub
		this.driver = _driver;
	}

	public void AddNewEvent(String eventName) {
		click(By.xpath(sidebarEvents));
		click(By.xpath(addEvents));
		type(By.id(idAddEventTitle), eventName);
		type(By.id(idAddEventStartDate), getCurrentDateTime());
		type(By.id(idAddEventEndDate), getCurrentDateTime());
		click(By.xpath(addEventsSave));
	}

	public void deleteNewEvent(String eventName) {
		click(By.xpath(sidebarEvents));
		System.out.println("//span[text()=' " + eventName + "']");
		click(By.xpath("//span[text()=' " + eventName + "']"));
		click(By.xpath("//a[text()=' Delete event']"));
		click(By.xpath("//button[text()=' Yes']"));
	}

	public void displayByCurrentMonth() {
		click(By.xpath(sidebarEvents));
		click(By.xpath(displayMonthBtn));
	}

	public void displayByNextMonth() {
		click(By.xpath(sidebarEvents));
		click(By.xpath(displayMonthBtn));
		click(By.xpath(displayNextBtn));
	}

	public void displayByPreviousMonth() {
		click(By.xpath(sidebarEvents));
		click(By.xpath(displayMonthBtn));
		click(By.xpath(displayPreviousBtn));
	}

	public void displayByCurrentWeek() {
		click(By.xpath(sidebarEvents));
		click(By.xpath(displayWeekBtn));
	}

	public void displayByNextWeek() {
		click(By.xpath(sidebarEvents));
		click(By.xpath(displayWeekBtn));
		click(By.xpath(displayNextBtn));
	}

	public void displayByPreviousWeek() {
		click(By.xpath(sidebarEvents));
		click(By.xpath(displayWeekBtn));
		click(By.xpath(displayPreviousBtn));
	}

	public void displayByCurrentDay() {
		click(By.xpath(sidebarEvents));
		click(By.xpath(displayDayBtn));
	}

	public void displayByNextDay() {
		click(By.xpath(sidebarEvents));
		click(By.xpath(displayDayBtn));
		click(By.xpath(displayNextBtn));
	}

	public void displayByPreviousDay() {
		click(By.xpath(sidebarEvents));
		click(By.xpath(displayDayBtn));
		click(By.xpath(displayPreviousBtn));
	}

}
