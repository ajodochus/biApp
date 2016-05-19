package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Log;

public class Login_Landing_Page extends Abstract_Page{

	
	
	public Login_Landing_Page() throws Exception {
		
		super(rwdriver);
		WebDriverWait wait = new WebDriverWait(rwdriver, 30);
		wait.until(ExpectedConditions.urlContains("superdashboardlexolution-dashboardmodulelexolutionstandard"));
		Log.info("created login_page object");
	}
}
