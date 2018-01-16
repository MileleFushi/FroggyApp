package data;

import java.util.ArrayList;
import java.util.Arrays;

public class RulesApplier {
	
	static ArrayList<Category> categories;
	static ArrayList<Double> categoryMaximums;
	
	final static int MINIMAL_HEATER_POWER = 15;
	final static int MAXIMAL_HEATER_POWER = 36;
	final static int MINIMAL_FOGGER_POWER = 0;
	final static int MAXIMAL_FOGGER_POWER = 84;
	final static int MINIMAL_TEMPERATURE = 12;
	final static int MAXIMAL_TEMPERATURE = 38;
	final static int MINIMAL_HUMIDITY = 0;
	final static int MAXIMAL_HUMIDITY = 100;
	
	static int left;
	static int right;
	
	static void setUp(Term... terms) {
		
		categories = new ArrayList<Category>();
		categoryMaximums = new ArrayList<Double>();
		
		if(terms.length == 1) {
			
			for(Category key : terms[0].getCategories()) {
				if(key.getValueFor(terms[0].get()) > 0) {
					categories.add(Data.inputRules.get(key));
					categoryMaximums.add(key.getValueFor(terms[0].get()));
				}
			}
			
			if(terms[0].getType() == TermType.DAY_TEMPERATURE || terms[0].getType() == TermType.NIGHT_TEMPERATURE) {

				left = MINIMAL_HEATER_POWER;
				right = MAXIMAL_HEATER_POWER;	
				
			}	
			else {
				
				left = MINIMAL_FOGGER_POWER;
				right = MAXIMAL_FOGGER_POWER;	
			}
		}
		else {
			
			
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
				
					Category first = terms[0].getCategories().get(i);
					Category second = terms[1].getCategories().get(j);
					double value;
					
					if(first.getValueFor(terms[0].get()) > 0 && second.getValueFor(terms[1].get()) > 0) {
						categories.add(Data.outputRules.get(Arrays.asList(first, second)));
						value = first.getValueFor(terms[0].get()) < second.getValueFor(terms[1].get()) 
								? first.getValueFor(terms[0].get()) : second.getValueFor(terms[1].get());
						categoryMaximums.add(value);
					}
					
				}
			}
			
			if(terms[0].getType() == TermType.DAY_TEMPERATURE || terms[0].getType() == TermType.NIGHT_TEMPERATURE) {

				left = MINIMAL_TEMPERATURE;
				right = MAXIMAL_TEMPERATURE;	
				
			}	
			else {
				
				left = MINIMAL_HUMIDITY;
				right = MAXIMAL_HUMIDITY;	
			}
		}
	}	
}