package automation.constant;

import org.testng.annotations.DataProvider;

public class DataProviderRise {
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
}
