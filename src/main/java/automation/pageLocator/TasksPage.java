package automation.pageLocator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automation.common.CommonBase;

public class TasksPage extends CommonBase{
	private String sidebarTasks = "//span[text()='Tasks']";
	private String aTagList = "//a[text()='List']";
	//filter element
		private String buttonPlus = "//button[@class='btn btn-default show-filter-form-button']";
		private String dropdownRelateTo = "//div[@id='s2id_autogen5']";
		private String inputRelateTo = "(//input[@type='text' and @autocomplete='off'])[8]";
		private String dropdownProject = "//div[@id='s2id_autogen7']";
		private String inputProject= "(//input[@type='text' and @autocomplete='off'])[8]";
		private String listFilteredRelatedTo = "//table[@id='task-table']//tbody//tr/child::td[6]/a";
		private String dropdownMilestone = "//div[@id='select2-chosen-10']";
		private String inputMilestone= "//input[@id='s2id_autogen10_search']";
		private String listFilteredMilestone = "//table[@id='task-table']//tbody//tr/child::td[5]";
		private String dropdownTeamMember = "//span[@id='select2-chosen-12']";
		private String inputTeamMember= "//input[@id='s2id_autogen12_search']";
		private String listFilteredTeamMember = "//table[@id='task-table']//tbody//tr/child::td[7]//a";
		private String dropdownPriority = "//div[@id='s2id_autogen13']";
		private String inputPriority= "//input[@id='s2id_autogen14_search']";
		private String listFilteredPriority = "//table[@id='task-table']//tbody//tr/child::td[2]//span[@class='float-end']";
		private String dropdownLabel = "//div[@id='s2id_autogen15']";
		private String inputLabel= "//input[@id='s2id_autogen16_search']";
		private String listFilteredLabel = "//table[@id='task-table']//tbody//tr/child::td[2]//span[@title='Label']";
		private String buttonDeadline = "//button[text()='- Deadline -']";
		private String deadlineSelect= "//div[text()='- Deadline -']";
		private String deadlineExprired= "//div[text()='Expired']";
		private String deadlineToday= "//div[text()='Today']";
		private String deadlineTomorrow= "//div[text()='Tomorrow']";
		private String deadlineIn7Days= "//div[text()='In 7 days']";
		private String deadlineIn15Days= "//div[text()='In 15 days']";
		private String deadlineCustom = "//div[text()='Custom']";
		private String listFilteredDeadline = "//table[@id='task-table']//tbody//tr/child::td[4]/span";
		private String buttonStatus = "//button[text()='Status ']";
		private String statusToDo= "//ul//li[text()='To do']";
		private String statusInProgress= "//ul//li[text()='In progress']";
		private String statusReview= "//ul//li[text()='Review']";
		private String statusDone= "//ul//li[text()='Done']";
		private String statusActive1= "//ul[@data-act='multiselect']/li[@class='list-group-item clickable  active']";
		private String statusActive2= "//ul[@data-act='multiselect']/li[@class='list-group-item clickable active']";
		private String listFilteredStatus = "//table[@id='task-table']//tbody//tr/child::td[9]/a";
	// add task
		private String addTask="//a[text()=' Add task']";
		private String inputTitle="//input[@id='title']";
		private String textareaDescription = "//div[@role='textbox']";////textarea[@name='description']
		private String inputDescription="//div[@role='textbox']/p";
		private String selectRelatedTo="//span[@id='select2-chosen-27']";
		private String inputRelatedTo="//input[@id='s2id_autogen27_search']";
		private String selectProject="//span[@id='select2-chosen-28']";
		private String inputProjectAdd="//input[@id='s2id_autogen28_search']";
		private String selectPoint="//div[@id='s2id_autogen66']";
		private String inputPointAdd="//input[@id='s2id_autogen67_search']";
		private String selectMilestone="//span[@id='select2-chosen-88']";
		private String inputMilestoneAdd="//input[@id='s2id_autogen88_search']";
		private String selectAssignTo="//div[@id='s2id_assigned_to']";
		private String inputAssignTo="//input[@id='s2id_autogen190_search']";
		private String selectStatus="//span[@id='select2-chosen-92']";
		private String inputStatusAdd="//input[@id='s2id_autogen92_search']";
		private String selectPriority="//span[@id='select2-chosen-93']";
		private String inputPriorityAdd="//input[@id='s2id_autogen93_search']";
		private String inputLabelAdd="//input[@id='s2id_autogen91']";
		private String inputStartDate="//input[@id='start_date']";
		private String inputDeadline="//input[@id='deadline']";
		
		private String buttonSave="//button[text()=' Save']";
	// delet task
		private String inputSearch="//input[@type='search']";
		private String deleteTask="//a[@title='Delete task']";
	private WebDriver driver;
	public TasksPage(WebDriver _driver) {
		// TODO Auto-generated constructor stub
		this.driver = _driver;
	}
	public void deleteTask(String title, String description,String relatedTo,String project,String point,String milestone,
			String assignTo,String status,String priority,String label,String startDate,String deadline) {
		doFilter();
		type(By.xpath(inputSearch), title);
		pause(1000);
		List<WebElement> listTask = driver.findElements(By.xpath(deleteTask));
		if(listTask.size()!=0) {
			for(WebElement item : listTask) {
				click(item);
			}
		}
		click(By.xpath(deleteTask));
	}
	
	public void addTask(String title, String description,String relatedTo,String project,String point,String milestone,
			String assignTo,String status,String priority,String label,String startDate,String deadline) {
		doFilter();
		click(By.xpath(addTask));
		// fill title
		fillAddTask(inputTitle,inputTitle,title);
		// fill description
		fillAddTaskDescription(textareaDescription,inputDescription,description);
		// fill relatedTo
		fillAddTask(selectRelatedTo,inputRelatedTo,relatedTo);
		// fill project
		fillAddTask(selectProject,inputProjectAdd,project);
		// fill point
//		fillAddTask(selectPoint,inputPointAdd,point);
		//fill milestone
		fillAddTask(selectMilestone,inputMilestoneAdd,milestone);
		// fill assignTo
		fillAddTask(selectAssignTo,inputAssignTo,assignTo);
		// fill status
		fillAddTask(selectStatus,inputStatusAdd,status);
		// fill priority
		fillAddTask(selectPriority,inputPriorityAdd,priority);
		// fill label
		fillAddTask(inputLabelAdd,inputLabelAdd,label);
		// fill startDate
		fillAddTask(inputStartDate,inputStartDate,startDate);
		// fill deadline
		fillAddTask(inputDeadline,inputDeadline,deadline);
		click(By.xpath(buttonSave));
	}
	public void fillAddTaskDescription(String xpath,String inputLocator,String value) {
//		click(By.xpath(xpath));
		type(By.xpath(inputLocator), value);
		typeKeyTabs(By.xpath(xpath));
//		typeKeyTabs(By.xpath(xpath));
	}
	public void fillAddTask(String xpath,String inputLocator,String value) {
		click(By.xpath(xpath));
		type(By.xpath(inputLocator), value);
		typeKeyTabs(By.xpath(inputLocator));
	}
	public void doFilter() {
		click(By.xpath(sidebarTasks));
		click(By.xpath(aTagList));
		click(By.xpath(buttonPlus));
	}
	public void filterTaskByRelatedToAndProject(String relatedValue,String projectValue) {
		doFilter();
		click(By.xpath(dropdownRelateTo));
		// nhap dropdownRelateTo 
		type(By.xpath(inputRelateTo), relatedValue);
		typeKeyTabs(By.xpath(inputRelateTo));
		click(By.xpath(dropdownProject));
		// nhap dropdownProject 
		type(By.xpath(inputProject), projectValue);
		typeKeyTabs(By.xpath(inputProject));
		pause(1000);
		assertListFilter(listFilteredRelatedTo,projectValue);
//		assertListRelatedTo(projectValue);
	}
	public void filterTaskByMilestone(String milestone) {
		doFilter();
		click(By.xpath(dropdownMilestone));
		// nhap dropdownMilestone 
		type(By.xpath(inputMilestone), milestone);
		typeKeyTabs(By.xpath(inputMilestone));
		pause(2000);
		assertListFilter(listFilteredMilestone,milestone);
	}
	public void filterTaskBydropdownTeamMember(String teamMember) {
		doFilter();
		click(By.xpath(dropdownTeamMember));
		// nhap dropdownMilestone 
		type(By.xpath(inputTeamMember), teamMember);
		typeKeyTabs(By.xpath(inputTeamMember));
		pause(2000);
		assertListFilterTeamMember(listFilteredTeamMember,teamMember);
	}
	public void filterTaskByPriority(String priority) {
		doFilter();
		click(By.xpath(dropdownPriority));
		// nhap dropdownMilestone 
		type(By.xpath(inputPriority), priority);
		typeKeyTabs(By.xpath(inputPriority));
		pause(2000);
		assertListFilterPriority(listFilteredPriority,priority);
	}
	public void filterTaskByLabel(String label) {
		doFilter();
		click(By.xpath(dropdownLabel));
		// nhap dropdownMilestone 
		type(By.xpath(inputLabel), label);
		typeKeyTabs(By.xpath(inputLabel));
		pause(2000);
		assertListFilter(listFilteredLabel,label);
	}
	public void filterTaskByDeadline(String deadlineType) {
		doFilter();
		click(By.xpath(buttonDeadline));
		Calendar calendar = Calendar.getInstance();
		Date deadlineDate;
		// nhap dropdownMilestone 
		switch(deadlineType) {
			case "Expired":
				click(By.xpath(deadlineExprired));
				pause(1000);
				deadlineDate=calendar.getTime();
				System.out.println("dealine:"+ deadlineDate);
				assertListFilterDeadline(deadlineDate);
				break;
			case "Today":
				click(By.xpath(deadlineToday));
				pause(3000);
				deadlineDate=calendar.getTime();
				System.out.println("dealine:"+ deadlineDate);
				assertListFilterDeadline(deadlineDate);
				break;
			case "Tomorrow":
				click(By.xpath(deadlineTomorrow));
				pause(1000);
				calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH)  +1);
				deadlineDate=calendar.getTime();
				System.out.println("dealine:"+ deadlineDate);
				assertListFilterDeadline(deadlineDate);
				break;
			case "In 7 days":
				click(By.xpath(deadlineIn7Days));
				pause(1000);
				calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH)  +7);
				deadlineDate=calendar.getTime();
				System.out.println("dealine:"+ deadlineDate);
				assertListFilterDeadline(deadlineDate);
				break;
			case "In 15 days":
				click(By.xpath(deadlineIn15Days));
				pause(1000);
				calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH)  +15);
				deadlineDate=calendar.getTime();
				System.out.println("dealine:"+ deadlineDate);
				assertListFilterDeadline(deadlineDate);
				break;
			case "Custom":
				click(By.xpath(deadlineCustom));
				break;
			default:
				click(By.xpath(deadlineSelect));
				break;
		}
		
	}
	public void changeStatus(String statusInActive) {
		doFilter();
		click(By.xpath(buttonStatus));
		switch(statusInActive) {
		case "To do":
			click(By.xpath(statusToDo));
			break;
		case "In progress":
			click(By.xpath(statusInProgress));
			break;
		case "Review":
			click(By.xpath(statusReview));
			break;
		case "Done":
			click(By.xpath(statusDone));
			break;
		}
		pause(3000);
		filterTaskByStatus();
		}
	public void filterTaskByStatus() {
		List<String> statusActiveList = new ArrayList();
		//get all active Status in filter dropdown
		List<WebElement> listFilterStatus = driver.findElements(By.xpath(statusActive1));
		List<WebElement> listFilterStatus1 = driver.findElements(By.xpath(statusActive2));
		if(listFilterStatus.size()!=0) {
			for(WebElement item : listFilterStatus) {
				statusActiveList.add(item.getText().trim());
			}
		}
		if(listFilterStatus1.size()!=0) {
			for(WebElement item : listFilterStatus1) {
				statusActiveList.add(item.getText().trim());
			}
		}
		//get all element status in table
		List<WebElement> listFilterParam = driver.findElements(By.xpath(listFilteredStatus));
		if(listFilterParam.size()!=0) {
			for(WebElement item : listFilterParam) {
				//check status in table with active status list
				System.out.println("status of table: "+item.getText().trim());
				assertTrue(statusActiveList.contains(item.getText().trim()));
			}
		}
	}
	private void assertListFilterDeadline(Date deadline) {
		List<WebElement> listDeadline = driver.findElements(By.xpath(listFilteredDeadline));
		if(listDeadline.size()!=0) {
			for(WebElement item : listDeadline) {
				System.out.println("deadline of table befor paste:"+ item.getText());
				System.out.println("deadline of table: "+ pasteStringToDate("dd-MM-yyyy",item.getText()));
				System.out.println("deadline:"+ deadline);
				assertTrue(pasteStringToDate("dd-MM-yyyy",item.getText()).isBefore(convertToLocalDateViaSqlDate(deadline)));
			}
		}
	}
	private void assertListFilterPriority(String filterParam,String valueFilter) {
		List<WebElement> listPriority = driver.findElements(By.xpath(filterParam));
		if(listPriority.size()!=0) {
			for(WebElement item : listPriority) {
//				System.out.println("text of table: "+item.getAttribute("title").substring(10).trim());
//				System.out.println("text:"+valueFilter.trim());
				assertEquals(item.getAttribute("title").substring(10).trim(),valueFilter.trim());
			}
		}
	}
	private void assertListFilter(String filterParam,String valueFilter) {
		List<WebElement> listFilterParam = driver.findElements(By.xpath(filterParam));
		if(listFilterParam.size()!=0) {
			for(WebElement item : listFilterParam) {
				System.out.println("text of table: "+item.getText());
				System.out.println("text:"+valueFilter);
				assertEquals(item.getText().trim(),valueFilter.trim());
			}
		}
		
	}
	private void assertListFilterTeamMember(String filterAssigned,String valueFilter) {
		List<WebElement> listFilterParam = driver.findElements(By.xpath(filterAssigned));
		if(listFilterParam.size()!=0) {
			for (int i=0; i<listFilterParam.size(); i++) {
				System.out.println("assigned of table: "+listFilterParam.get(i).getText());
				System.out.println("team :"+valueFilter);
				System.out.println("check :"+listFilterParam.get(i).getText().trim().equals(valueFilter.trim()));
				if(!listFilterParam.get(i).getText().trim().equals(valueFilter.trim())) {
					String collaborator ="//table[@id='task-table']//tbody//tr/child::td[7]//a["+ (i+1) +"]/parent::td/following-sibling::td/a";
					System.out.println("team :"+collaborator);
					WebElement Collaborator = driver.findElement(By.xpath(collaborator));
					System.out.println("team :"+Collaborator.getAttribute("title").trim());
					assertEquals(Collaborator.getAttribute("title").trim(),valueFilter.trim());
				}else {
					assertEquals(listFilterParam.get(i).getText().trim(),valueFilter.trim());
				}
			}
		}
		
	}
}
