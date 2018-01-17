package logger;

import java.text.SimpleDateFormat;
import java.util.Date;

import app.Time;
import data.Data;

public class Log {
	
	public static LoggingType shown;
	
	private static void say(LoggingType type, String message) {
		
		String currentTime;

		if((boolean) Data.config.get("logSimulatedTime")) {
			currentTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			currentTime += " " + Time.getTimeWithSeconds();
		} else {
			currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		}
		
		System.out.println(currentTime + " [" + type.getType() + "] : " + message);
		
	}
	
	public static void debug(String message) {
		if(shown == LoggingType.DEBUG)
			say(LoggingType.DEBUG, message);
	}
	
	public static void info(String message) {
		if(shown == LoggingType.DEBUG || shown == LoggingType.INFO)
			say(LoggingType.INFO, message);
	}
	
	public static void warn(String message) {
		if(shown != LoggingType.ERROR)
			say(LoggingType.WARN, message);
	}
	
	public static void error(String message) {
		say(LoggingType.ERROR, message);
	}
}