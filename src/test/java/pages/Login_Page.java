package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import static java.util.concurrent.TimeUnit.SECONDS;
import utility.Log;

public class Login_Page extends Abstract_Page {
	private static WebElement element = null;

	public Login_Page(WebDriver driver) throws Exception {
		super(driver);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(
				30, SECONDS).pollingEvery(2, SECONDS);

		wait.until(ExpectedConditions.titleIs("STP Lexolution.BI"));
	}

	public Login_Page() throws Exception {
		
		super(rwdriver);
		Log.info("try to create login_page object");
		Wait<RemoteWebDriver> wait = new FluentWait<RemoteWebDriver>(rwdriver).withTimeout(
				30, SECONDS).pollingEvery(2, SECONDS);

		wait.until(ExpectedConditions.elementToBeClickable(btn_LogIn()));
		Log.info("created login_page object");
	}
	


	public static WebElement textbox_password() throws Exception {
		try {
			element = rwdriver.findElementById("submitButton");
			Log.info("Password text box is found on the Login Page");
		} catch (Exception e) {
			Log.error("Password text box is not found on the Login Page");
			throw (e);
		}
		return element;

	}

	public static WebElement txtbx_UserName() throws Exception {
		try {
			element = driver.findElement(By.id("log"));
			Log.info("Username text box is found on the Login Page");
		} catch (Exception e) {
			Log.error("UserName text box is not found on the Login Page");
			throw (e);
		}
		return element;
	}

	public static WebElement txtbx_Password() throws Exception {
		try {
			element = driver.findElement(By.id("pwd"));
			Log.info("Password text box is found on the Login page");
		} catch (Exception e) {
			Log.error("Password text box is not found on the Login Page");
			throw (e);
		}
		return element;
	}

	public static WebElement btn_LogIn() throws Exception {
		try {
			element = driver.findElement(By.id("submitButton"));
			Log.info("Submit button is found on the Login page");
		} catch (Exception e) {
			Log.error("Submit button is not found on the Login Page");
			throw (e);
		}
		return element;
	}
}
