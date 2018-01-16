package data;

import java.util.ArrayList;

public class DataSensitizer {
	
	static ArrayList<Category> categories;
	static ArrayList<Double> categoryMaximums;
	static int left;
	static int right;
	
	static void setUp(Term term) throws NoCategoryFoundException {
		
		RulesApplier.setUp(term);
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
			System.out.println("i=" +i + " y=" + getValueFor(i)); // TODO remove
			denominator += getValueFor(i);
		}
		
		return numerator/denominator;	
	}	
	
	public static void main(String[] args) throws NoCategoryFoundException {
		
		Data.init();
		int value = -10;
		Data.DayTemperature.set(value);
		DataSensitizer.setUp(Data.DayTemperature);
		System.out.println("wynik: " + DataSensitizer.getResult());
	}
}
