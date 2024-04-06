package testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class UploadFileAlada extends CommonBase {
	@BeforeMethod
	public void openChorme() {
		driver = initChromeDriver("https://alada.vn/tai-khoan/dang-nhap.html");
//		LoginPageFactory login = new LoginPageFactory(driver);
//		login.LoginFunction("admin@demo.com", "riseDemo");
//		this.events = new EventsPage(driver);
		WebElement useName = driver.findElement(By.id("txtLoginUsername"));
		useName.sendKeys("ngomai692@gmail.com");
		WebElement pass = driver.findElement(By.id("txtLoginPassword"));
		pass.sendKeys("123456");
		click(By.xpath("//button[text()='ĐĂNG NHẬP' and @type='submit']"));
	}
	
	@Test
	public void testUploadFile() {
		pause(300);
		click(By.xpath("//div[@class ='avatar2']"));
		pause(300);
		click(By.xpath("//a[text()='Chỉnh sửa thông tin']"));
		pause(300);
		WebElement upload = driver.findElement(By.id("hdn_member_avata"));
		upload.sendKeys("D://image/1650267128442tải xuống.jpg");
		pause(3000);
	}
	
	@AfterMethod
	  public void closeBrowser() {
		 quitDriver(driver);
	 }
}
