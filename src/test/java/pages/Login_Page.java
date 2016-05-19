package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;
import utility.Log;

public class Login_Page extends Abstract_Page {
	private static WebElement element = null;
	
	private static String button_login_xpath = "//paper-button[@id='submitButton']";
	private static String textbox_password_xpath = "//paper-input[@id='inputPassword']";
	private static String textbox_user_xpath = "//paper-input[@id='inputUsername']";

	

	public Login_Page(WebDriver driver) throws Exception {
		super(driver);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(
				30, SECONDS).pollingEvery(2, SECONDS);

		wait.until(ExpectedConditions.titleIs("STP Lexolution.BI"));
	}

	public Login_Page() throws Exception {
		
		super(rwdriver);
		Log.info("try to create login_page object");
		WebDriverWait wait = new WebDriverWait(rwdriver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(button_login_xpath)));
		Log.info("created login_page object");
	}

	
	
	//action
	public static void login_with_invalid_user() throws Exception{
		textbox_user().sendKeys("testuser");
		textbox_password().sendKeys("hello");
		button_login().click();
	}
	public static void login_with_valid_user() throws Exception{
		textbox_user().sendKeys("BICRM\\BIUser");
		textbox_password().sendKeys("stp.L29!##");
		button_login().click();
	}
	
	
	//Repo
	


	public static  WebElement textbox_user() throws Exception {
		try {
			element = rwdriver.findElement(By.xpath(textbox_user_xpath));
			Log.info("Username text box is found on the Login Page");
		} catch (Exception e) {
			Log.error("UserName text box is not found on the Login Page");
			throw (e);
		}
		return element;
	}

	public static WebElement textbox_password() throws Exception {
		try {
			element = rwdriver.findElement(By.xpath(textbox_password_xpath));
			Log.info("Password text box is found on the Login page");
		} catch (Exception e) {
			Log.error("Password text box is not found on the Login Page");
			throw (e);
		}
		return element;
	}

	public static WebElement button_login() throws Exception {
		try {
			Log.info("search element");
			element = rwdriver.findElement(By.xpath(button_login_xpath));
			Log.info("Submit button is found on the Login page");
		} catch (Exception e) {
			Log.error("Submit button is not found on the Login Page");
			throw (e);
		}
		return element;
	}
}
