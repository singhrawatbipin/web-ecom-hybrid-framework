package dataproviders;

import org.testng.annotations.DataProvider;
import utils.excel.ExcelUtil;

public class ExcelDataProviders {

	@DataProvider(name = "signupData")
	public Object[][] signupData() {
		return ExcelUtil.readSheet("src/test/resources/testdata/users.xlsx", "SignUp");
	}

}
