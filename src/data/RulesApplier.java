package data;

import java.util.ArrayList;

public class RulesApplier {
	
	static ArrayList<Category> categories;
	static ArrayList<Double> categoryMaximums;
	double value = 20;
	final static int MINIMAL_HEATER_POWER = 15;
	final static int MAXIMAL_HEATER_POWER = 36;
	final static int MINIMAL_FOGGER_POWER = 0;
	final static int MAXIMAL_FOGGER_POWER = 84;
	static int left;
	static int right;
	
	static void setUp(String dataType, int value) throws NoCategoryFoundException {
		
		categories = new ArrayList<Category>();
		categoryMaximums = new ArrayList<Double>();
		
		if(dataType.equals("DayTemperature")) {
			
				if(DayTemperature.getCategory("Za niska").getValueFor(value) > 0) {
					categories.add(HeaterPower.getCategory("Duże"));
					categoryMaximums.add(DayTemperature.getCategory("Za niska").getValueFor(value));
				}
				if(DayTemperature.getCategory("Optymalna").getValueFor(value) > 0) {
					categories.add(HeaterPower.getCategory("Niewielkie"));
					categoryMaximums.add(DayTemperature.getCategory("Optymalna").getValueFor(value));
				}
				if(DayTemperature.getCategory("Za wysoka").getValueFor(value) > 0) {
					categories.add(HeaterPower.getCategory("Brak"));
					categoryMaximums.add(DayTemperature.getCategory("Za wysoka").getValueFor(value));
				}
			
			left = MINIMAL_HEATER_POWER;
			right = MAXIMAL_HEATER_POWER;	
			
		}	
		else if(dataType.equals("NightTemperature")) {
			
			if(NightTemperature.getCategory("Za niska").getValueFor(value) > 0) {
				categories.add(HeaterPower.getCategory("Duże"));
				categoryMaximums.add(NightTemperature.getCategory("Za niska").getValueFor(value));
			}
			if(NightTemperature.getCategory("Optymalna").getValueFor(value) > 0) {
				categories.add(HeaterPower.getCategory("Niewielkie"));
				categoryMaximums.add(NightTemperature.getCategory("Optymalna").getValueFor(value));
			}
			if(NightTemperature.getCategory("Za wysoka").getValueFor(value) > 0) {
				categories.add(HeaterPower.getCategory("Brak"));
				categoryMaximums.add(NightTemperature.getCategory("Za wysoka").getValueFor(value));
			}
		
			left = MINIMAL_HEATER_POWER;
			right = MAXIMAL_HEATER_POWER;
			
		}
		else if(dataType.equals("DayHumidity")) {
			
			if(DayHumidity.getCategory("Za niska").getValueFor(value) > 0) {
				categories.add(FoggerPower.getCategory("Duża"));
				categoryMaximums.add(DayHumidity.getCategory("Za niska").getValueFor(value));
			}
			if(DayHumidity.getCategory("Optymalna").getValueFor(value) > 0) {
				categories.add(FoggerPower.getCategory("Średnia"));
				categoryMaximums.add(DayHumidity.getCategory("Optymalna").getValueFor(value));
			}
			if(DayHumidity.getCategory("Za wysoka").getValueFor(value) > 0) {
				categories.add(FoggerPower.getCategory("Mała"));
				categoryMaximums.add(DayHumidity.getCategory("Za wysoka").getValueFor(value));
			}
		
			left = MINIMAL_FOGGER_POWER;
			right = MAXIMAL_FOGGER_POWER;		
		}
		else if(dataType.equals("NightHumidity")) {
			
			if(NightHumidity.getCategory("Za niska").getValueFor(value) > 0) {
				categories.add(FoggerPower.getCategory("Duża"));
				categoryMaximums.add(NightHumidity.getCategory("Za niska").getValueFor(value));
			}
			if(NightHumidity.getCategory("Optymalna").getValueFor(value) > 0) {
				categories.add(FoggerPower.getCategory("Średnia"));
				categoryMaximums.add(NightHumidity.getCategory("Optymalna").getValueFor(value));
			}
			if(NightHumidity.getCategory("Za wysoka").getValueFor(value) > 0) {
				categories.add(FoggerPower.getCategory("Mała"));
				categoryMaximums.add(NightHumidity.getCategory("Za wysoka").getValueFor(value));
			}
		
			left = MINIMAL_FOGGER_POWER;
			right = MAXIMAL_FOGGER_POWER;		
		}
	}	
}