package data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Data {

	public static Term DayTemperature;
	public static Term NightTemperature;
	public static Term DayHumidity;
	public static Term NightHumidity;
	public static Term HeaterPower;
	public static Term FoggerPower;
	
	public static HashMap<String, Object> config;
	public static HashMap<Category, Category> inputRules;
	public static HashMap<ArrayList<Category>, Category> outputRules;
	
	public static void init() {
		
		DayTemperature = new Term(TermType.DAY_TEMPERATURE);
		
		DayTemperature.addCategory(new Category("Za niska") {
			
			public double getValueFor(double arg) {
				return ShapeCreator.trapeze(true, arg, 22, 24);
			}
		});
		
		DayTemperature.addCategory(new Category("Optymalna") {
			
			public double getValueFor(double arg) {
				return ShapeCreator.trapeze(false, arg, 22, 24, 30, 34);
			}
		});
		
		DayTemperature.addCategory(new Category("Za wysoka") {
			
			public double getValueFor(double arg) {
				return ShapeCreator.trapeze(false, arg, 30, 34);
			}
		});
		
		
		NightTemperature = new Term(TermType.NIGHT_TEMPERATURE);
		
		NightTemperature.addCategory(new Category("Za niska") {
			
			public double getValueFor(double arg) {
				return ShapeCreator.trapeze(true, arg, 19, 20);
			}
		});
		
		NightTemperature.addCategory(new Category("Optymalna") {
			
			public double getValueFor(double arg) {
				return ShapeCreator.trapeze(false, arg, 19, 20, 22, 24);
			}
		});
		
		NightTemperature.addCategory(new Category("Za wysoka") {
			
			public double getValueFor(double arg) {
				return ShapeCreator.trapeze(false, arg, 22, 24);
			}
		});
		
		
		DayHumidity = new Term(TermType.DAY_HUMIDITY);
		
		DayHumidity.addCategory(new Category("Za niska") {
			
			public double getValueFor(double arg) {
				return ShapeCreator.trapeze(true, arg, 52, 60);
			}
		});
		
		DayHumidity.addCategory(new Category("Optymalna") {
			
			public double getValueFor(double arg) {
				return ShapeCreator.trapeze(false, arg, 52, 60, 68, 76);
			}
		});
		
		DayHumidity.addCategory(new Category("Za wysoka") {
			
			public double getValueFor(double arg) {
				return ShapeCreator.trapeze(false, arg, 68, 76);
			}
		});
		
		
		NightHumidity = new Term(TermType.NIGHT_HUMIDITY);
		
		NightHumidity.addCategory(new Category("Za niska") {
			
			public double getValueFor(double arg) {
				return ShapeCreator.trapeze(true, arg, 68, 76);
			}
		});
		
		NightHumidity.addCategory(new Category("Optymalna") {
			
			public double getValueFor(double arg) {
				return ShapeCreator.trapeze(false, arg, 68, 76, 80, 88);
			}
		});
		
		NightHumidity.addCategory(new Category("Za wysoka") {
			
			public double getValueFor(double arg) {
				return ShapeCreator.trapeze(false, arg, 80, 88);
			}
		});
		
		
		HeaterPower = new Term(TermType.HEATER_POWER);
		
		HeaterPower.addCategory(new Category("Brak") {
			
			public double getValueFor(double arg) {
				return ShapeCreator.trapeze(true, arg, 17, 18);
			}
		});
		
		HeaterPower.addCategory(new Category("Niewielkie") {
			
			public double getValueFor(double arg) {
				return ShapeCreator.trapeze(false, arg, 17, 21, 29, 31);
			}
		});
		
		HeaterPower.addCategory(new Category("Duże") {
			
			public double getValueFor(double arg) {
				return ShapeCreator.trapeze(false, arg, 29, 33);
			}
		});
		
		
		FoggerPower = new Term(TermType.FOGGER_POWER);
		
		FoggerPower.addCategory(new Category("Mała") {
			
			public double getValueFor(double arg) {
				return ShapeCreator.trapeze(true, arg, 24, 40);
			}
		});
		
		FoggerPower.addCategory(new Category("Średnia") {
			
			public double getValueFor(double arg) {
				return ShapeCreator.trapeze(false, arg, 24, 40, 60, 76);
			}
		});
		
		FoggerPower.addCategory(new Category("Duża") {
			
			public double getValueFor(double arg) {
				return ShapeCreator.trapeze(false, arg, 60, 76);
			}
		});		
		
		config = new HashMap<>();
		inputRules = new HashMap<>();
		outputRules = new HashMap<>();
		
		inputRules.put(DayTemperature.getCategory("Za niska"), HeaterPower.getCategory("Duże"));
		inputRules.put(DayTemperature.getCategory("Optymalna"), HeaterPower.getCategory("Niewielkie"));
		inputRules.put(DayTemperature.getCategory("Za wysoka"), HeaterPower.getCategory("Brak"));
		inputRules.put(NightTemperature.getCategory("Za niska"), HeaterPower.getCategory("Duże"));
		inputRules.put(NightTemperature.getCategory("Optymalna"), HeaterPower.getCategory("Niewielkie"));
		inputRules.put(NightTemperature.getCategory("Za wysoka"), HeaterPower.getCategory("Brak"));
		inputRules.put(DayHumidity.getCategory("Za niska"), FoggerPower.getCategory("Duża"));
		inputRules.put(DayHumidity.getCategory("Optymalna"), FoggerPower.getCategory("Średnia"));
		inputRules.put(DayHumidity.getCategory("Za wysoka"), FoggerPower.getCategory("Mała"));
		inputRules.put(NightHumidity.getCategory("Za niska"), FoggerPower.getCategory("Duża"));
		inputRules.put(NightHumidity.getCategory("Optymalna"), FoggerPower.getCategory("Średnia"));
		inputRules.put(NightHumidity.getCategory("Za wysoka"), FoggerPower.getCategory("Mała"));
		
		outputRules.put(new ArrayList<Category>(Arrays.asList(DayTemperature.getCategory("Za niska"), 
				HeaterPower.getCategory("Duże"))), DayTemperature.getCategory("Optymalna"));
		outputRules.put(new ArrayList<Category>(Arrays.asList(DayTemperature.getCategory("Za niska"), 
				HeaterPower.getCategory("Niewielkie"))), DayTemperature.getCategory("Optymalna"));
		outputRules.put(new ArrayList<Category>(Arrays.asList(DayTemperature.getCategory("Za niska"), 
				HeaterPower.getCategory("Brak"))), DayTemperature.getCategory("Za niska"));
		
		outputRules.put(new ArrayList<Category>(Arrays.asList(DayTemperature.getCategory("Optymalna"), 
				HeaterPower.getCategory("Duże"))), DayTemperature.getCategory("Za wysoka"));
		outputRules.put(new ArrayList<Category>(Arrays.asList(DayTemperature.getCategory("Optymalna"), 
				HeaterPower.getCategory("Niewielkie"))), DayTemperature.getCategory("Optymalna"));
		outputRules.put(new ArrayList<Category>(Arrays.asList(DayTemperature.getCategory("Optymalna"), 
				HeaterPower.getCategory("Brak"))), DayTemperature.getCategory("Optymalna"));
		
		outputRules.put(new ArrayList<Category>(Arrays.asList(DayTemperature.getCategory("Za wysoka"), 
				HeaterPower.getCategory("Duże"))), DayTemperature.getCategory("Za wysoka"));
		outputRules.put(new ArrayList<Category>(Arrays.asList(DayTemperature.getCategory("Za wysoka"), 
				HeaterPower.getCategory("Niewielkie"))), DayTemperature.getCategory("Za wysoka"));
		outputRules.put(new ArrayList<Category>(Arrays.asList(DayTemperature.getCategory("Za wysoka"), 
				HeaterPower.getCategory("Brak"))), DayTemperature.getCategory("Optymalna"));
		
		outputRules.put(new ArrayList<Category>(Arrays.asList(NightTemperature.getCategory("Za niska"), 
				HeaterPower.getCategory("Duże"))), NightTemperature.getCategory("Optymalna"));
		outputRules.put(new ArrayList<Category>(Arrays.asList(NightTemperature.getCategory("Za niska"), 
				HeaterPower.getCategory("Niewielkie"))), NightTemperature.getCategory("Optymalna"));
		outputRules.put(new ArrayList<Category>(Arrays.asList(NightTemperature.getCategory("Za niska"), 
				HeaterPower.getCategory("Brak"))), NightTemperature.getCategory("Za niska"));
		
		outputRules.put(new ArrayList<Category>(Arrays.asList(NightTemperature.getCategory("Optymalna"), 
				HeaterPower.getCategory("Duże"))), NightTemperature.getCategory("Za wysoka"));
		outputRules.put(new ArrayList<Category>(Arrays.asList(NightTemperature.getCategory("Optymalna"), 
				HeaterPower.getCategory("Niewielkie"))), NightTemperature.getCategory("Optymalna"));
		outputRules.put(new ArrayList<Category>(Arrays.asList(NightTemperature.getCategory("Optymalna"), 
				HeaterPower.getCategory("Brak"))), NightTemperature.getCategory("Optymalna"));
		
		outputRules.put(new ArrayList<Category>(Arrays.asList(NightTemperature.getCategory("Za wysoka"), 
				HeaterPower.getCategory("Duże"))), NightTemperature.getCategory("Za wysoka"));
		outputRules.put(new ArrayList<Category>(Arrays.asList(NightTemperature.getCategory("Za wysoka"), 
				HeaterPower.getCategory("Niewielkie"))), NightTemperature.getCategory("Za wysoka"));
		outputRules.put(new ArrayList<Category>(Arrays.asList(NightTemperature.getCategory("Za wysoka"), 
				HeaterPower.getCategory("Brak"))), NightTemperature.getCategory("Optymalna"));
		
		
		outputRules.put(new ArrayList<Category>(Arrays.asList(DayHumidity.getCategory("Za niska"), 
				FoggerPower.getCategory("Duża"))), DayHumidity.getCategory("Optymalna"));
		outputRules.put(new ArrayList<Category>(Arrays.asList(DayHumidity.getCategory("Za niska"), 
				FoggerPower.getCategory("Średnia"))), DayHumidity.getCategory("Optymalna"));
		outputRules.put(new ArrayList<Category>(Arrays.asList(DayHumidity.getCategory("Za niska"), 
				FoggerPower.getCategory("Mała"))), DayHumidity.getCategory("Za niska"));
		
		outputRules.put(new ArrayList<Category>(Arrays.asList(DayHumidity.getCategory("Optymalna"), 
				FoggerPower.getCategory("Duża"))), DayHumidity.getCategory("Za wysoka"));
		outputRules.put(new ArrayList<Category>(Arrays.asList(DayHumidity.getCategory("Optymalna"), 
				FoggerPower.getCategory("Średnia"))), DayHumidity.getCategory("Optymalna"));
		outputRules.put(new ArrayList<Category>(Arrays.asList(DayHumidity.getCategory("Optymalna"), 
				FoggerPower.getCategory("Mała"))), DayHumidity.getCategory("Optymalna"));
		
		outputRules.put(new ArrayList<Category>(Arrays.asList(DayHumidity.getCategory("Za wysoka"), 
				FoggerPower.getCategory("Duża"))), DayHumidity.getCategory("Za wysoka"));
		outputRules.put(new ArrayList<Category>(Arrays.asList(DayHumidity.getCategory("Za wysoka"), 
				FoggerPower.getCategory("Średnia"))), DayHumidity.getCategory("Za wysoka"));
		outputRules.put(new ArrayList<Category>(Arrays.asList(DayHumidity.getCategory("Za wysoka"), 
				FoggerPower.getCategory("Mała"))), DayHumidity.getCategory("Optymalna"));
		
		outputRules.put(new ArrayList<Category>(Arrays.asList(NightHumidity.getCategory("Za niska"), 
				FoggerPower.getCategory("Duża"))), NightHumidity.getCategory("Optymalna"));
		outputRules.put(new ArrayList<Category>(Arrays.asList(NightHumidity.getCategory("Za niska"), 
				FoggerPower.getCategory("Średnia"))), NightHumidity.getCategory("Optymalna"));
		outputRules.put(new ArrayList<Category>(Arrays.asList(NightHumidity.getCategory("Za niska"), 
				FoggerPower.getCategory("Mała"))), NightHumidity.getCategory("Za niska"));
		
		outputRules.put(new ArrayList<Category>(Arrays.asList(NightHumidity.getCategory("Optymalna"), 
				FoggerPower.getCategory("Duża"))), NightHumidity.getCategory("Za wysoka"));
		outputRules.put(new ArrayList<Category>(Arrays.asList(NightHumidity.getCategory("Optymalna"), 
				FoggerPower.getCategory("Średnia"))), NightHumidity.getCategory("Optymalna"));
		outputRules.put(new ArrayList<Category>(Arrays.asList(NightHumidity.getCategory("Optymalna"), 
				FoggerPower.getCategory("Mała"))), NightHumidity.getCategory("Optymalna"));
		
		outputRules.put(new ArrayList<Category>(Arrays.asList(NightHumidity.getCategory("Za wysoka"), 
				FoggerPower.getCategory("Duża"))), NightHumidity.getCategory("Za wysoka"));
		outputRules.put(new ArrayList<Category>(Arrays.asList(NightHumidity.getCategory("Za wysoka"), 
				FoggerPower.getCategory("Średnia"))), NightHumidity.getCategory("Za wysoka"));
		outputRules.put(new ArrayList<Category>(Arrays.asList(NightHumidity.getCategory("Za wysoka"), 
				FoggerPower.getCategory("Mała"))), NightHumidity.getCategory("Optymalna"));
	}	
}