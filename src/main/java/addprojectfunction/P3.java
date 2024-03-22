package addprojectfunction;

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

public class P3 extends CommonBase {
	Rise_Login_Page lp;
	Rise_Dashboard_Page dp;
	Rise_Projects_Page pp;

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
	public void TC10() throws InterruptedException {
		pp.clickAddProject();
		String projectTitle = "P3 Project " + randomString();
		String taskTitle = "P3 Tasks " + randomString();
		pp.typeProjectTitleOrTasks(projectTitle);
		pp.clickSaveAndContinueProject();
		Thread.sleep(2000);
		pp.clickNextAddProjectMember();
		pp.typeProjectTitleOrTasks(taskTitle);
		pp.clickAddMoreTasks();
		Thread.sleep(3000);
		pp.clickCloseAddTasks();
		Assert.assertEquals(pp.checkCreatedProjectAndTaks(projectTitle,taskTitle), true);
	}

	@AfterClass
	void quitWebdriver() {
		driver.quit();
	}

}
