package utility;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
	
	public static WebDriver driver = null;
	public static RemoteWebDriver rwdriver = null;
	static DesiredCapabilities capability = null;
	
	public static WebDriver OpenBrowser(int iTestCaseRow) throws Exception{
		String sBrowserName;
		try{
		//sBrowserName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Browser);
			sBrowserName = "Mozilla";
		if(sBrowserName.equals("Mozilla")){
			driver = new FirefoxDriver();
			Log.info("New driver instantiated");
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    Log.info("Implicit wait applied on the driver for 10 seconds");
		    driver.get(Constant.URL);
		    Log.info("Web application launched successfully");
			}
		}catch (Exception e){
			Log.error("Class Utils | Method OpenBrowser | Exception desc : "+e.getMessage());
		}
		return driver;
	}
	
	public static WebDriver OpenBrowserWithTargetUrl(String browser, String targetUrl) throws Exception {
		
		try{
			if (browser.equalsIgnoreCase("Mozilla")){
				driver = new FirefoxDriver();
				Log.info("New Firefoxdriver instantiated");
			    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			    Log.info("Implicit wait applied on the driver for 10 seconds");
			    driver.get(targetUrl);
			    Log.info("Web application launched at " + targetUrl + " successfully");

			}
		} catch (Exception e) {
			Log.error("Utils/openBrowser(String): " + e.getMessage());
		}
		return driver;
	}
	
	public static RemoteWebDriver openBrowserInDocker() throws Exception {
		String pageUrl ="http://192.168.99.100:32768/wd/hub";
		try{
			DesiredCapabilities capability = getDesiredCapabilities("ff");
			rwdriver = new RemoteWebDriver(new URL(pageUrl), capability);	
			rwdriver.manage().window().maximize();
			rwdriver.get("http://192.168.16.42/bi"); 

			Log.info("OpenBrowser with entry Point: " + pageUrl);
		}catch (Exception e){
			Log.error("OpenBrowserWithEntryPoint not able to launch site: " + pageUrl + " -- " + e.getMessage());
		}
		return rwdriver;
	}
	
	public static DesiredCapabilities getDesiredCapabilities(String environment) {

		if (environment.equalsIgnoreCase("ff")) {
			capability = DesiredCapabilities.firefox();
		//	capability.setJavascriptEnabled(true);
		//	capability.setBrowserName("nodeff");
			capability.setPlatform(Platform.LINUX);

		} else if (environment.equalsIgnoreCase("CHROME_LocalHost_W7")) {

			capability = DesiredCapabilities.chrome();
			capability.setJavascriptEnabled(true);
			capability.setBrowserName("chrome");
			capability.setVersion("CHROME_LocalHost_W7");
			capability.setPlatform(Platform.WINDOWS);

		} else if (environment.equalsIgnoreCase("IE_LocalHost_W7")) {

			capability = DesiredCapabilities.internetExplorer();
			capability.setJavascriptEnabled(true);
			capability.setBrowserName("internet explorer");
			capability.setVersion("IE_LocalHost_W7");
			capability.setPlatform(Platform.WINDOWS);

		}

		return capability;

	}
	
	public static WebDriver OpenFFWithEntryPoint(String pageUrl) throws Exception {
		try{
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(pageUrl);
			Log.info("OpenBrowser with entry Point: " + pageUrl);
		}catch (Exception e){
			Log.error("OpenBrowserWithEntryPoint not able to launch site: " + pageUrl + " -- " + e.getMessage());
		}
		return driver;
	}
	
	public static String getTestCaseName(String sTestCase)throws Exception{
		String value = sTestCase;
		try{
			int posi = value.indexOf("@");
			value = value.substring(0, posi);
			posi = value.lastIndexOf(".");	
			value = value.substring(posi + 1);
			return value;
		}catch (Exception e){
			Log.error("Class Utils | Method getTestCaseName | Exception desc : "+e.getMessage());
			throw (e);
		}
	}
	
	 public static void mouseHoverAction(WebElement mainElement, String subElement){
		
		 Actions action = new Actions(driver);
         action.moveToElement(mainElement).perform();
         if(subElement.equals("Accessories")){
        	 action.moveToElement(driver.findElement(By.linkText("Accessories")));
        	 Log.info("Accessories link is found under Product Category");
         }
         if(subElement.equals("iMacs")){
        	 action.moveToElement(driver.findElement(By.linkText("iMacs")));
        	 Log.info("iMacs link is found under Product Category");
         }
         if(subElement.equals("iPads")){
        	 action.moveToElement(driver.findElement(By.linkText("iPads")));
        	 Log.info("iPads link is found under Product Category");
         }
         if(subElement.equals("iPhones")){
        	 action.moveToElement(driver.findElement(By.linkText("iPhones")));
        	 Log.info("iPhones link is found under Product Category");
         }
         action.click();
         action.perform();
         Log.info("Click action is performed on the selected Product Type");
	 }
	 public static void waitForElement(WebElement element){
		 
		 WebDriverWait wait = new WebDriverWait(driver, 10);
	     wait.until(ExpectedConditions.elementToBeClickable(element));
	 	}
		
	 public static void takeScreenshot(WebDriver driver, String sTestCaseName) throws Exception{
			try{
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(Constant.Path_ScreenShot + sTestCaseName +".jpg"));	
			} catch (Exception e){
				Log.error("Class Utils | Method takeScreenshot | Exception occured while capturing ScreenShot : "+e.getMessage());
				throw new Exception();
			}
		}
	 
	 
	}
