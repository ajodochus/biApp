package tests.basic;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import pages.Abstract_Page;
import pages.Login_Page;
import pages.Login_Landing_Page;
import utility.Log;
import utility.Utils;

public class BiBaseTests {
	public RemoteWebDriver rwdriver = null;
	
	
	@Test(groups={"bi"})
	public void verifyProductSearchListResult() throws Exception {

		String sTestCaseName;
		try {
			Log.addLogger();
			sTestCaseName = this.toString();
			Log.info("TC name raw: " + sTestCaseName);
			sTestCaseName = Utils.getTestCaseName(this.toString());
			Log.info("TC name no @...: " + sTestCaseName);
			
			rwdriver = Utils.openBrowserInDocker();
			new Abstract_Page(rwdriver);
			
			
			Login_Page login_Page = new Login_Page();
			login_Page.login_with_valid_user();
			Login_Landing_Page login_Landing_Page = new Login_Landing_Page();
			
			

			Log.closeLogger();
			
		} catch (Exception e) {

			//Utils.takeScreenshot(driver, sTestCaseName);
			// This will print the error log message
			Log.error(e.getMessage());
			Log.closeLogger();
			// Again throwing the exception to fail the test completely in the
			// TestNG results
			throw (e);
		}
	}
}
