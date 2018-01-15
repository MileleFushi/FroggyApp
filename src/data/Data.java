package data;

import java.util.HashMap;

public class Data {

	public static Term DayTemperature;
	public static Term NightTemperature;
	public static Term DayHumidity;
	public static Term NightHumidity;
	public static Term HeaterPower;
	public static Term FoggerPower;
	
	public static HashMap<String, Object> config;
	public static HashMap<Category, Category> simpleRules;
	
	public static void init() throws NoCategoryFoundException {
		
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
		simpleRules = new HashMap<>();
		
		simpleRules.put(DayTemperature.getCategory("Za niska"), HeaterPower.getCategory("Duże"));
		simpleRules.put(DayTemperature.getCategory("Optymalna"), HeaterPower.getCategory("Niewielkie"));
		simpleRules.put(DayTemperature.getCategory("Za wysoka"), HeaterPower.getCategory("Brak"));
		simpleRules.put(NightTemperature.getCategory("Za niska"), HeaterPower.getCategory("Duże"));
		simpleRules.put(NightTemperature.getCategory("Optymalna"), HeaterPower.getCategory("Niewielkie"));
		simpleRules.put(NightTemperature.getCategory("Za wysoka"), HeaterPower.getCategory("Brak"));
		simpleRules.put(DayHumidity.getCategory("Za niska"), FoggerPower.getCategory("Duża"));
		simpleRules.put(DayHumidity.getCategory("Optymalna"), FoggerPower.getCategory("Średnia"));
		simpleRules.put(DayHumidity.getCategory("Za wysoka"), FoggerPower.getCategory("Mała"));
		simpleRules.put(NightHumidity.getCategory("Za niska"), FoggerPower.getCategory("Duża"));
		simpleRules.put(NightHumidity.getCategory("Optymalna"), FoggerPower.getCategory("Średnia"));
		simpleRules.put(NightHumidity.getCategory("Za wysoka"), FoggerPower.getCategory("Mała"));
	}	
}