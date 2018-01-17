package data;

import java.util.ArrayList;

public class DataSensitizer {
	
	static ArrayList<Term> terms;
	static ArrayList<Double> termsMaximums;
	static int left;
	static int right;
	
	public static void setUp(LingVariable... lingVars) {
		
		RulesApplier.setUp(lingVars);
		terms = RulesApplier.terms;
		termsMaximums = RulesApplier.termsMaximums;
		left = RulesApplier.left;
		right = RulesApplier.right;
		
	}
	
	static double getValueFor(int arg) {
		
		if(terms.size() > 1)
		{
			if(terms.get(0).getValueFor(arg) > terms.get(1).getValueFor(arg)) {
				if(terms.get(0).getValueFor(arg) > termsMaximums.get(0))
					return termsMaximums.get(0);
				else 
					return terms.get(0).getValueFor(arg);
			}
			else {
				if(terms.get(1).getValueFor(arg) > termsMaximums.get(1))
					return termsMaximums.get(1);
				else 
					return terms.get(1).getValueFor(arg);
			}				
		}
		else {
			if(terms.get(0).getValueFor(arg) > termsMaximums.get(0))
				return termsMaximums.get(0);
			else 
				return terms.get(0).getValueFor(arg);
		}
	}
	
	public static double getResult() {
		
		double numerator = 0;
		double denominator = 0;
		
		for(int i = left; i <= right; i++ ) {
			numerator +=  (double) i * getValueFor(i);
			denominator += getValueFor(i);
		}
		
		return numerator/denominator;	
	}	
}