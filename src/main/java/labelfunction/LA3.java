package labelfunction;

import org.testng.annotations.Test;

import automation.pageLocator.Rise_Dashboard_Page;
import automation.pageLocator.Rise_Login_Page;
import automation.pageLocator.Rise_Projects_Page;
import automation.common.CommonBase;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class LA3 extends CommonBase {
	Rise_Login_Page lp;
	Rise_Dashboard_Page dp;
	Rise_Projects_Page pp;
	String labelName = "TC3 LA3 " + randomString();

	@BeforeClass
	@Parameters({"browserTest"})
	void openSite(@Optional("browserTest")String br) {
		setupDriver(br);
		openWebsite("https://rise.fairsketch.com/signin");
		lp = new Rise_Login_Page(driver);
		dp = new Rise_Dashboard_Page(driver);
		pp = new Rise_Projects_Page(driver);
		lp.clickSubmit();
		dp.clickProject();
	}

	@Test
	public void TC3_createLabel() throws InterruptedException {
		pp.clickLabelButton();
		pp.typeLabelName(labelName);
		pp.saveLabel();
		Thread.sleep(2000);
		Assert.assertEquals(pp.verifyLabelAndColor(labelName,"#4a8af4"), true);
	}
	
	@Test
	public void TC3_deleteLabel() throws InterruptedException {
		pp.clickCreatedLabel();
		pp.clickDeleteButton();
		Thread.sleep(2000);
		Assert.assertEquals(pp.checkSelectedLabelDeleted(labelName), false);
	}

	@AfterClass
	void quitWebdriver() {
		driver.quit();
	}

}
