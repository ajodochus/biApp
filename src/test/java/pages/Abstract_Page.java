package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import utility.Log;

public class Abstract_Page {
	
	private static WebElement element = null;
	public static WebDriver driver;
	public static RemoteWebDriver rwdriver;
	public static boolean bResult;
	public  Abstract_Page(WebDriver driver){
		Abstract_Page.driver = driver;
		Abstract_Page.bResult = true;
	}
	public  Abstract_Page(RemoteWebDriver driver){
		Abstract_Page.driver = rwdriver;
		Abstract_Page.bResult = true;
	}
	

	


}
