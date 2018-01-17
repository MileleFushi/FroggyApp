package app;

public class Time {

	static int hour;
	static int minute;
	static int second;
	
	public static String stringFor(int hour) {
		
		if(hour < 10) {
			return "    0" + hour + ":00";
		}
		else
			return "    " + hour + ":00";
	}
	
	public static int getHour() {
		return hour;
	}
	
	public static int getMinute() {
		return minute;
	}
	
	public static int getSecond() {
		return second;
	}
	
	public static String getTime() {
		
		String time = "";
		
		if(hour < 10)
			time += "0";

		time += hour + ":";
		
		if(minute < 10)
			time += "0";
		
		time += minute;
		
		return time;		
	}
	
	public static String getTimeWithSeconds() {
		
		String time = getTime() + ":";
		
		if(second < 10)
			time += "0";

		time += second + ":";
		
		return time;		
	}
	
	public static void setTime(int h, int m, int s) {
		hour = h;
		minute = m;
		second = s;
	}
	
	public static void nextSecond() {
		
		if(second == 59) {
			second = 0;
			if(minute == 59) {
				minute = 0;
				if(hour == 23) {
					hour = 0;
				}
				else {
					hour++;
				}
			}
			else {
				minute++;
			}
		}
		else {
			second++;
		}
	}
	
	public static void setTimeFromString(String text) {
		
		String hourText = text.substring(4, 6);
		hour = Integer.parseInt(hourText);
		minute = 0;
		second = 0;
		
	}
	
	public static boolean isDay() {
		return (hour < 22 && hour > 6);
	}
	
}