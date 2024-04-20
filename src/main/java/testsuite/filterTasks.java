package testsuite;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import automation.common.CommonBase;
import automation.constant.CT_Account;
import automation.constant.DataProviderRise;
import automation.pageLocator.LoginPageFactory;
import automation.pageLocator.TasksPage;

public class filterTasks extends CommonBase{
	private TasksPage taskaPage;
	private final String testRelatedTo = "Project";
	private final String testProject = "Online Course Creation and Launch";
	@BeforeMethod
	public void openPage() {
		driver = initChromeDriver(CT_Account.webURL);
		LoginPageFactory login = new LoginPageFactory(driver);
		login.LoginFunction("admin@demo.com", "riseDemo","");
		this.taskaPage = new TasksPage(driver);
	}
	
//	@Test(dataProvider = "data_add_Tasks",dataProviderClass= DataProviderRise.class,priority = 1)
//	public void addTasksToTest(String title, String description,String relatedTo,String project,String point,String milestone,
//			String assignTo,String status,String priority,String label,String startDate,String deadline) {
//		taskaPage.addTask(title, description, relatedTo, project, point, milestone, assignTo, status, priority, label, startDate, deadline);
//		pause(1000);
//	}
	@Test(priority = 2)
	public void filterTaskByRelatedTo() {
		taskaPage.filterTaskByRelatedToAndProject(testRelatedTo, testProject);
	}
	@Test(dataProvider = "data_Rise_Filter_Tasks_Team member",dataProviderClass= DataProviderRise.class,priority = 2)
	public void filterTaskBydropdownTeamMember(String teamMember) {
		taskaPage.filterTaskBydropdownTeamMember(teamMember);
	}
	@Test(dataProvider = "data_Rise_Filter_Tasks_Priority",dataProviderClass= DataProviderRise.class,priority = 2)
	public void filterTaskByPriority(String priority) {
		taskaPage.filterTaskByPriority(priority);
	}
	@Test(dataProvider = "data_Rise_Filter_Tasks_Label",dataProviderClass= DataProviderRise.class,priority = 2)
	public void filterTaskByLabel(String label) {
		taskaPage.filterTaskByLabel(label);
	}
	@Test(dataProvider = "data_Rise_Filter_Tasks_Deadline",dataProviderClass= DataProviderRise.class,priority = 2)
	public void filterTaskByDeadline(String deadline) {
		taskaPage.filterTaskByDeadline(deadline);
	}
	@Test(dataProvider = "data_Rise_Filter_Tasks_Status",dataProviderClass= DataProviderRise.class,priority = 2)
	public void filterTaskByStatus(String statusInActive) {
		taskaPage.changeStatus(statusInActive);
	}
	@Test(dataProvider = "data_add_Tasks",dataProviderClass= DataProviderRise.class,priority = 3)
	public void deleteTasksToTest(String title, String description,String relatedTo,String project,String point,String milestone,
			String assignTo,String status,String priority,String label,String startDate,String deadline) {
		taskaPage.deleteTask(title, description, relatedTo, project, point, milestone, assignTo, status, priority, label, startDate, deadline);
		pause(1000);
	}

	@AfterMethod
	  public void closeBrowser() {
		 quitDriver(driver);
	 }
	
}
