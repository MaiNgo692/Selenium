package automation.constant;

import org.testng.annotations.DataProvider;

import automation.common.CommonBase;

public class DataProviderRise extends CommonBase {
		@DataProvider(name ="data_Rise_Login")
		public Object[][] dataRise(){
			return new Object[][]{
				{"admin@demo.com","riseDemo","Admin"},
				{"client@demo.com","riseDemo","Client"}
			};
		}
		@DataProvider(name ="data_Rise_LoginFail")
		public Object[][] dataRiseFail(){
			return new Object[][]{
				{"admin@demo.com","riseDemo1"},
				{"client@demo.com","riseDemo1"}
			};
		}
		@DataProvider(name ="data_Rise_Filter_Client")
		public Object[][] dataFilterClient(){
			return new Object[][]{
				{"Gold","Inactive"},
				{"VIP","Referral"},
				{"Silver","Satisfied"}
			};
		}
		@DataProvider(name ="data_Rise_Filter_Tasks_RelatedTo")
		public Object[] dataFilterTasks(){
			return new Object[]{"Project","Client","Contract","Estimate","Expense","Invoice","Lead","Order","Proposal","Subscription","Ticket"};
		}
		@DataProvider(name ="data_Rise_Filter_Tasks_Team member")
		public Object[] dataFilterTasks5(){
			return new Object[]{"John Doe ","Mark Thomas ","Michael Wood ","Richard Gray ","Sara Ann "};
		}
		@DataProvider(name ="data_Rise_Filter_Tasks_Priority")
		public Object[] dataFilterTasks1(){
			return new Object[]{"Minor","Major","Critical ","Blocker "};
		}
		@DataProvider(name ="data_Rise_Filter_Tasks_Label")
		public Object[] dataFilterTasks2(){
			return new Object[]{"Feedback","Bug","Enhancement","Design"};
		}
		@DataProvider(name ="data_Rise_Filter_Tasks_Deadline")
		public Object[] dataFilterTasks3(){
			return new Object[]{"Expired","Today","Tomorrow","In 7 days","In 15 days","Custom"};//
		}
		@DataProvider(name ="data_Rise_Filter_Tasks_Status")
		public Object[] dataFilterTasks4(){
			return new Object[]{"To do","In progress","Review","Done"};//
		}
		@DataProvider(name ="data_add_Tasks")
		public Object[][] dataAddTasks(){
			String today = getCurrentDateTime("dd-MM-yyyy");
			String todayBefor1Day = getPrevious1DaysOfCurrentDateTime("dd-MM-yyyy");
			String todayBefor7Day = getPrevious7DaysOfCurrentDateTime("dd-MM-yyyy");
			String todayAfter7Day = getNext7DaysOfCurrentDateTime("dd-MM-yyyy");
			String todayAfter15Day = getNext7DaysOfCurrentDateTime("dd-MM-yyyy");
			return new Object[][]{
				{"Test Add Task1","Description","Project","Online Course Creation and Launch","2 Points","Beta Release","John Doe","To do","Minor","Feedback",today,todayAfter7Day},
//				{"Test Add Task2","Description","Project","Online Course Creation and Launch","2 Points","Beta Release","John Doe","To do","Minor","Feedback",today,todayAfter15Day},
//				{"Test Add Task3","Description","Project","Online Course Creation and Launch","2 Points","Beta Release","John Doe","In progress","Minor","Feedback",todayBefor1Day,todayAfter7Day},
//				{"Test Add Task4","Description","Project","Online Course Creation and Launch","2 Points","Beta Release","Mark Thomas","In progress","Major","Bug",todayBefor1Day,todayAfter15Day},
//				{"Test Add Task5","Description","Project","Online Course Creation and Launch","2 Points","Beta Release","Mark Thomas","In progress","Major","Bug",todayBefor7Day,today},
//				{"Test Add Task6","Description","Project","Online Course Creation and Launch","2 Points","Beta Release","Mark Thomas","Review","Major","Bug",todayBefor7Day,todayAfter15Day},
//				{"Test Add Task7","Description","Project","Online Course Creation and Launch","2 Points","Beta Release","Michael Wood","Review","Critical","Enhancement",todayBefor7Day,todayBefor1Day},
//				{"Test Add Task8","Description","Project","Online Course Creation and Launch","2 Points","Beta Release","Michael Wood","Review","Critical","Enhancement",todayBefor7Day,todayAfter7Day},
//				{"Test Add Task9","Description","Project","Online Course Creation and Launch","2 Points","Beta Release","Richard Gray","To do","Critical","Enhancement",todayAfter7Day,todayAfter15Day},
//				{"Test Add Task10","Description","Project","Online Course Creation and Launch","2 Points","Beta Release","Richard Gray","Done","Blocker","Design",today,todayAfter7Day},
//				{"Test Add Task11","Description","Project","Online Course Creation and Launch","2 Points","Beta Release","Sara Ann","Done","Blocker","Design",today,todayAfter7Day},
//				{"Test Add Task12","Description","Project","Online Course Creation and Launch","2 Points","Beta Release","Sara Ann","Done","Blocker","Design",today,todayAfter7Day},
			};
		}
		
}
