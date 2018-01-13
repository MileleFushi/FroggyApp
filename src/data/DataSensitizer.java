package data;

import java.util.ArrayList;

public class DataSensitizer {
	
	static ArrayList<Category> categories;
	static ArrayList<Double> categoryMaximums;
	double value;
	static int left;
	static int right;
	
	static void setUp(String dataType, int value) throws NoCategoryFoundException {
		
		RulesApplier.setUp(dataType, value);
		categories = RulesApplier.categories;
		categoryMaximums = RulesApplier.categoryMaximums;
		left = RulesApplier.left;
		right = RulesApplier.right;
		
	}
	
	static double getValueFor(int arg) {
		
		if(categories.size() > 1)
		{
			if(categories.get(0).getValueFor(arg) > categories.get(1).getValueFor(arg)) {
				if(categories.get(0).getValueFor(arg) > categoryMaximums.get(0))
					return categoryMaximums.get(0);
				else 
					return categories.get(0).getValueFor(arg);
			}
			else {
				if(categories.get(1).getValueFor(arg) > categoryMaximums.get(1))
					return categoryMaximums.get(1);
				else 
					return categories.get(1).getValueFor(arg);
			}				
		}
		else {
			if(categories.get(0).getValueFor(arg) > categoryMaximums.get(0))
				return categoryMaximums.get(0);
			else 
				return categories.get(0).getValueFor(arg);
		}
	}
	
	static double getResult() {
		
		double numerator = 0;
		double denominator = 0;
		
		for(int i = left; i <= right; i++ ) {
			numerator +=  (double) i * getValueFor(i);
			denominator += getValueFor(i);
		}
		
		return numerator/denominator;	
	}	
	
	public static void main(String[] args) throws NoCategoryFoundException {
		
		DayTemperature.prepare();
		HeaterPower.prepare();
		int value = 0;
		DataSensitizer.setUp("DayTemperature", value);
		System.out.println("wynik: " + DataSensitizer.getResult());
	}
}
