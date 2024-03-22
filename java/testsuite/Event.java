package automation.testsuite;

import automation.common.CommonBase;
import automation.pagelocator.LoginPage;

public class Event extends CommonBase{
	
	@BeforeMethod
	public void openPage() {
		driver = initChromeDriver(CT_Acount.webURL);
	}
	@Test
	public void AddEventSuccessfully() {
		LoginPage login = new LoginPage();
	}
}
