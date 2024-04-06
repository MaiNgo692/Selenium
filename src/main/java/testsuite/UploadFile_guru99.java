package testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Account;

public class UploadFile_guru99 extends CommonBase{
	@BeforeMethod
	public void openChorme() {
		driver = initChromeDriver("https://demo.guru99.com/test/upload/");
//		LoginPageFactory login = new LoginPageFactory(driver);
//		login.LoginFunction("admin@demo.com", "riseDemo");
//		this.events = new EventsPage(driver);
	}
	
	@Test
	public void testUploadFile() {
		WebElement upload = driver.findElement(By.id("uploadfile_0"));
		upload.sendKeys("E:\\NGO THI MAI.docx");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.name("send")).click();
		pause(3000);
	}
	@AfterMethod
	  public void closeBrowser() {
		 quitDriver(driver);
	 }
}
