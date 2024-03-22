package automation.pageLocator;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrizenFlightFactory {
	

	WebDriver driver;
	
	public TrizenFlightFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="(//input[@name ='daterange-single'])[1]")
	WebElement departingDate;
	
	@FindBy(xpath="(//input[@placeholder='City or airport'])[1]")
	WebElement flyingFrom;
	
	@FindBy(xpath="(//input[@placeholder='City or airport'])[2]")
	WebElement flyingTo;
	
	@FindBy(xpath="((//span[@class='adult'])[1]//ancestor::div)[12]")
	WebElement pasengersDrop;
	
	@FindBy(xpath="//div[@class='qtyInc'][1]")
	WebElement adultPlus;
	
	@FindBy(xpath="(//button[@title ='Economy'])[1]")
	WebElement coachDrop;
	
	@FindBy(xpath="//span[text()='Business']")
	WebElement businessCoach;
	
	@FindBy(xpath="//div[text()='Economy']")
	WebElement economyCoach;
	
	@FindBy(xpath="//div[text()='First class']")
	WebElement firstCLassCoach;
	
	@FindBy(xpath="(//a[text()='Search Now'])[1]")
	WebElement btnSearch;
	
	public void chooseDateTime(String dateTime) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('readonly','readonly')", departingDate);
		departingDate.clear();
		departingDate.sendKeys(dateTime);
		departingDate.sendKeys(Keys.TAB);
		
	}
	
	public void fillFlightFrom(String locator) {
		flyingFrom.clear();
		flyingFrom.sendKeys(locator);
	}
	
	public void fillFlightTo(String locator) {
		flyingTo.clear();
		flyingTo.sendKeys(locator);
	}
	
	public void plusPassengersAdult() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", pasengersDrop);
		js.executeScript("arguments[0].click()", adultPlus);
	}
	
	public void selectCoach(String coach) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", coachDrop);
		if(coach == "Business") {
			js.executeScript("arguments[0].click()", businessCoach);
		}else if(coach == "Economy") {
			js.executeScript("arguments[0].click()", economyCoach);
		}else {
			js.executeScript("arguments[0].click()", firstCLassCoach);
		}
	}
	
	public void clickSearch() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", btnSearch);
	}
	
}
