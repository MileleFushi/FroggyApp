package app;

import java.util.ArrayList;

public class HoursList {
	
	public static ArrayList<String> get() {
		
		ArrayList<String> list = new ArrayList<String>();	
		
		for(int i = 0; i < 24; i++) {
			list.add(Time.stringFor(i));
		}
		
		return list;
	}
	
}
