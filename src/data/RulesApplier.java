package data;

import java.util.ArrayList;

public class RulesApplier {
	
	static ArrayList<Category> categories;
	static ArrayList<Double> categoryMaximums;
	final static int MINIMAL_HEATER_POWER = 15;
	final static int MAXIMAL_HEATER_POWER = 36;
	final static int MINIMAL_FOGGER_POWER = 0;
	final static int MAXIMAL_FOGGER_POWER = 84;
	static int left;
	static int right;
	
	static void setUp(Term term) throws NoCategoryFoundException {
		
		categories = new ArrayList<Category>();
		categoryMaximums = new ArrayList<Double>();
		
		for(Category key : term.getCategories()) {
			if(key.getValueFor(term.get()) > 0) {
				categories.add(Data.simpleRules.get(key));
				categoryMaximums.add(key.getValueFor(term.get()));
			}
		}
		
		if(term.getType() == TermType.DAY_TEMPERATURE || term.getType() == TermType.NIGHT_TEMPERATURE) {

			left = MINIMAL_HEATER_POWER;
			right = MAXIMAL_HEATER_POWER;	
			
		}	
		else {
			
			left = MINIMAL_FOGGER_POWER;
			right = MAXIMAL_FOGGER_POWER;	
		}
	}	
}