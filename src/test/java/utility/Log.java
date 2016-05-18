package utility;

import java.io.File;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import utility.Constant;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

public class Log {
	// Initialize Log4j logs
	private static Logger Log = Logger.getLogger(Log.class.getName());
	public static FileAppender appender = null;

	public static void addLogger() {

		try {
			PatternLayout layout = new PatternLayout("%-5p %C{1} %d{yyyy-MM-dd HH:mm:ss} : %m%n");
			appender = new FileAppender(layout, Constant.File_LOGGERinit, false);
		} catch (Exception e) {
			Log.error("Error initializing logger", e);
		}
		Log.addAppender(appender);

		Log.setLevel(Level.INFO);
	}

	public static void closeLogger() {
		appender.close();
		File logOld = new File(Constant.File_LOGGERinit);

		File logNew = new File(Constant.File_LOGGERwithTimestamp);
		System.out.println("timestampfile: " + logNew);
		boolean bool = true;
		bool = logOld.renameTo(logNew);
		System.out.println("rename: " + bool);
	}

	// This is to print log for the beginning of the test case, as we usually
	// run so many test cases as a test suite
	public static void startTestCase(String sTestCaseName) {
		Log.info("****************************************************************************************");
		Log.info("****************************************************************************************");
		Log.info("$$$$$$$$$$$$$$$$$$$$$                 " + sTestCaseName + "       $$$$$$$$$$$$$$$$$$$$$$$$$");
		Log.info("****************************************************************************************");
		Log.info("****************************************************************************************");
	}

	// This is to print log for the ending of the test case
	public static void endTestCase(String sTestCaseName) {
		Log.info("XXXXXXXXXXXXXXXXXXXXXXX             " + sTestCaseName + "-E---N---D-"
				+ "             XXXXXXXXXXXXXXXXXXXXXX");
		Log.info("X");
		Log.info("X");
		Log.info("X");
		Log.info("X");
	}

	// Need to create these methods, so that they can be called
	public static void info(String message) {
		Log.info(message);
	}

	public static void warn(String message) {
		Log.warn(message);
	}

	public static void error(String message) {
		Log.error(message);
	}

	public static void fatal(String message) {
		Log.fatal(message);
	}

	public static void debug(String message) {
		Log.debug(message);
	}
}