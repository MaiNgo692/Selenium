package automation.common;

import static org.testng.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.commons.lang3.RandomStringUtils;


/*
 * Author: Tran Hoan, mobile/zalo: +84-979535822
 * Initiate some common methods to testing purpose using relative wait
 * This class can be use after Day16 of my course to make more effective and stable test script
 * To handle Flaky test appearing due to some other Selenium Exception types
 * feel free contact HoanTran to get more detail strategies.
 */
public class CommonBase {
	public static WebDriver driver;
	public int initWaitTime = 30;

	public WebDriver initChromeDriver(String URL) {
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(URL);
		return driver;
	}

	public void inputTextJavaScriptInnerHTML(By inputElement, String companyName) {
		WebElement element = driver.findElement(inputElement);
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '" + companyName + "'", element);
		} catch (StaleElementReferenceException ex) {
			pause(1000);
			inputTextJavaScriptInnerHTML(inputElement, companyName);
		}
	}

	public void inputTextJavaScriptValue(By locator, String value) {
		WebElement element = getElementPresentDOM(locator);
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].value = '" + value + "'", element);
		} catch (StaleElementReferenceException ex) {
			pause(1000);
			inputTextJavaScriptValue(locator, value);
		}
	}

	public void scrollToElement(By locator) {
		WebElement element = getElementPresentDOM(locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void clickJavaScript(By locator) {
		WebElement element = getElementPresentDOM(locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	public WebElement getElementPresentDOM(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElement(locator);
	}

	public boolean isElementPresent(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
			wait.until(ExpectedConditions.visibilityOf(getElementPresentDOM(locator)));
			return getElementPresentDOM(locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		} catch (org.openqa.selenium.TimeoutException e2) {
			return false;
		}
	}
	public void type(By locator, String value) {
		WebElement element = getElementPresentDOM(locator);
		element.clear();
		element.sendKeys(value);
	}
	
	public void typeKeyTabs(By locator) {
		WebElement element = getElementPresentDOM(locator);
		element.sendKeys(Keys.TAB);
	}
	public void click(By locator) {
		WebElement element = getElementPresentDOM(locator);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}
	public void click(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
//	public void type(By locator, String value) {
//		WebElement element = getElementPresentDOM(locator);
//		element.sendKeys(value);
//	}

	public void type(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
	/**
	 * pause driver in timeInMillis
	 * 
	 * @param timeInMillis
	 */
	public void pause(long timeInMillis) {
		try {
			Thread.sleep(timeInMillis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * get absolute path of file
	 * 
	 * @param relativeFilePath
	 * @return
	 */
	public String getAbsoluteFilePath(String relativeFilePath) {
		String curDir = System.getProperty("user.dir");
		String absolutePath = curDir + relativeFilePath;
		return absolutePath;
	}

	public void quitDriver(WebDriver dr) {
		if (dr.toString().contains("null")) {
			System.out.print("All Browser windows are closed ");
		} else {
			dr.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			dr.manage().deleteAllCookies();
			dr.close();
		}
	}

	public int findIFrame() {
		int indexOfIframe = 0;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("So luong frame: " + size);
		for (int i = 0; i < size; i++) {
			driver.switchTo().frame(i);
			int numberOfIFrame = driver.findElements(By.xpath("//button[text()='Gửi ngay']")).size();
			System.out.println("elementCanTim ở vị trí:" + numberOfIFrame);
			if (numberOfIFrame != 0) {
				indexOfIframe = i;
				driver.switchTo().defaultContent();
				return indexOfIframe;
			}
			// Sau khi in ra element cần tìm phải trở về frame cha để tìm tiếp đến hết
			driver.switchTo().defaultContent();
		}
		System.out.println("indexOfIframe: " + indexOfIframe);
		return indexOfIframe;
	}

	public WebDriver initChromeDriver() {
		System.out.println("Launching Chrome browser...");
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver", 
		System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		return driver;
	}

	private WebDriver initFirefoxDriver() {
		System.out.println("Launching Firefox browser...");
		System.setProperty("webdriver.firefox.driver", 
		System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		return driver;
	}

	private WebDriver initEdgeDriver() {
		System.out.println("Launching Edge browser...");
		System.setProperty("webdriver.edge.driver",
		System.getProperty("user.dir") + "\\driver\\msedgedriver.exe");
		// Creating an object of EdgeDriver
	    driver = new EdgeDriver();
		driver.manage().window().maximize();
		return driver;
	}

	public WebDriver setupDriver(String browserName) {
		switch (browserName.trim().toLowerCase()) {
		case "chrome":
			driver = initChromeDriver();
			break;
		case "firefox":
			driver = initFirefoxDriver();
			break;
		case "edge":
			driver = initEdgeDriver();
			break;
		default:
			System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
			driver = initChromeDriver();
		}
		return driver;
	}

	public WebDriver initFirefoxDriverTest(String URL) {
		System.out.println("Launching Firefox browser...");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		return driver;
	}
	
	public WebDriver initEdgeDriverTest(String URL) {
		System.out.println("Launching Edge browser...");
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\driver\\msedgedriver.exe");
//		System.setProperty("webdriver.edge.driver",
//		System.getProperty("user.dir") + "\\driver\\msedgedriver.exe");
		// Creating an object of EdgeDriver
	    driver = new EdgeDriver();
	    driver.get(URL);
		driver.manage().window().maximize();
		return driver;
	}
	
	public void openWebsite(String url) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		driver.manage().window().maximize();
	}
	
	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}
	public LocalDate pasteStringToDate(String formatDate,String pasteValue) {
		DateTimeFormatter sdf = DateTimeFormatter.ofPattern(formatDate,Locale.ENGLISH);
		return LocalDate.parse(pasteValue,sdf);
	}
	public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
	    return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
	}
	public String getCurrentDateTime(String formatDate) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat(formatDate);//"dd-MM-yyyy"
		// calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
		String currentdateTime = df.format(calendar.getTime());
		System.out.println("Current day - month - year: " + currentdateTime);
		return currentdateTime;
	}
	public String getCurrentMonth(String formatDate) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat(formatDate);//"MMMM yyyy"
		String currentMonth = df.format(calendar.getTime());
		System.out.println("currentMonthAsString: " + currentMonth);
		return currentMonth;
	}
	public String getNext1MonthFromCurrentMonth1(String formatDate) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat(formatDate);//"MMMM yyyy"
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
		String currentMonth = df.format(calendar.getTime());
		System.out.println("current Month: " + currentMonth);

		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
		String nextMonth = df.format(calendar.getTime());
		System.out.println("NextMonth from curent month: " + nextMonth);
		return nextMonth;
	}
	public String getPrevious1MonthFromCurrentMonth1(String formatDate) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("formatDate");//"MMMM yyyy"
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
		String currentMonth = df.format(calendar.getTime());
		System.out.println("current Month: " + currentMonth);

		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
		String nextMonth = df.format(calendar.getTime());
		System.out.println("PreviousMonth from curent month: " + nextMonth);
		return nextMonth;
	}
	public String getPrevious1DaysOfCurrentDateTime(String formatDate) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat(formatDate);//"dd-MM-yyyy"
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH)  -1);
		String next7Days = df.format(calendar.getTime());
		System.out.println("Next 7 days from current day: " + next7Days);
		 return next7Days;
	}
	public String getPrevious7DaysOfCurrentDateTime(String formatDate) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat(formatDate);//"dd-MM-yyyy"
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - 7);
		String next7Days = df.format(calendar.getTime());
		System.out.println("Next 7 days from current day: " + next7Days);
		 return next7Days;
	}
	public String getNextDaysOfCurrentDateTime(String formatDate) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat(formatDate);//"dd-MM-yyyy"
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);
		String next7Days = df.format(calendar.getTime());
		System.out.println("Next 7 days from current day: " + next7Days);
		 return next7Days;
	}
	public String getNext7DaysOfCurrentDateTime(String formatDate) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat(formatDate);//"dd-MM-yyyy"
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 7);
		String next7Days = df.format(calendar.getTime());
		System.out.println("Next 7 days from current day: " + next7Days);
		 return next7Days;
	}
	public String getNext15DaysOfCurrentDateTime(String formatDate) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat(formatDate);//"dd-MM-yyyy"
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 15);
		String next7Days = df.format(calendar.getTime());
		System.out.println("Next 7 days from current day: " + next7Days);
		 return next7Days;
	}
	public String getWeekWithSpecialFormat(String type) {
		// Get calendar set to current date and time
		Calendar c = GregorianCalendar.getInstance();
		// Set the calendar to monday of the current week
		c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		System.out.println("Current week = " + Calendar.DAY_OF_WEEK);
		// Print dates of the current week starting on Monday
		SimpleDateFormat df = new SimpleDateFormat("MMM d, yyyy", Locale.getDefault());
		String startDate = "", endDate = "";
		if(type =="next") {
			c.add(Calendar.DATE, 7);
		}else if(type =="previous"){
			c.add(Calendar.DATE, -7);
		}
		startDate = df.format(c.getTime());
		c.add(Calendar.DATE, 6);
		endDate = df.format(c.getTime());
		System.out.println("Start Date = " + startDate);
		// cắt chuỗi endDate để chỉ lấy ra ngày
		System.out.println("Day of end Date = " + endDate.subSequence(4, 6));
		String expected = new StringBuilder().append(startDate.substring(0, 6)).append(" – ")
				.append(endDate.subSequence(4, 6))
				.append(startDate.substring(6, 12)).toString();
		System.out.println("Expected weekWithSpecialFormat: " + expected);
		return expected;
	}
	
}
