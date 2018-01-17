package data;

import java.util.ArrayList;
import java.util.Arrays;

public class RulesApplier {
	
	static ArrayList<Term> terms;
	static ArrayList<Double> termsMaximums;
	
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
	
	static void setUp(LingVariable... lingVars) {
		
		terms = new ArrayList<Term>();
		termsMaximums = new ArrayList<Double>();
		
		if(lingVars.length == 1) {
			
			for(Term key : lingVars[0].getTerms()) {
				if(key.getValueFor(lingVars[0].get()) > 0) {
					terms.add(Data.inputRules.get(key));
					termsMaximums.add(key.getValueFor(lingVars[0].get()));
				}
			}
			
			if(lingVars[0].getType() == LingVarType.DAY_TEMPERATURE || lingVars[0].getType() == LingVarType.NIGHT_TEMPERATURE) {

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
				
					Term first = lingVars[0].getTerms().get(i);
					Term second = lingVars[1].getTerms().get(j);
					double value;
					
					if(first.getValueFor(lingVars[0].get()) > 0 && second.getValueFor(lingVars[1].get()) > 0) {
						terms.add(Data.outputRules.get(Arrays.asList(first, second)));
						value = first.getValueFor(lingVars[0].get()) < second.getValueFor(lingVars[1].get()) 
								? first.getValueFor(lingVars[0].get()) : second.getValueFor(lingVars[1].get());
						termsMaximums.add(value);
					}
					
				}
			}
			
			if(lingVars[0].getType() == LingVarType.DAY_TEMPERATURE || lingVars[0].getType() == LingVarType.NIGHT_TEMPERATURE) {

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