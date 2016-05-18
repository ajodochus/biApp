package utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.jmx.snmp.Timestamp;

public class Constant {
	    //public static final String URL = "http://www.onlinestore.toolsqa.com";
	    public static final String URL = "http://192.168.16.42/bi/login";
	    public static final String Username = "BICRM\\BIUser";
	    public static final String Password ="stp.L29!##";

		public static final String File_LOGGERinit = "logs/logger.log";
		public static final String File_LOGGERwithTimestamp = "logs/logger_" + getTime() + ".log";
		
		
		public static final String Path_ScreenShot = "bin/screenshots/";
		
	
		
		public static String getTime(){
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
			Date date = new Date();
			System.out.println(dateFormat.format(date));
			return dateFormat.format(date).toString();
		}
		
		
	}



