package data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Data {

	public static LingVariable DayTemperature;
	public static LingVariable NightTemperature;
	public static LingVariable DayHumidity;
	public static LingVariable NightHumidity;
	public static LingVariable HeaterPower;
	public static LingVariable FoggerPower;
	
	public static HashMap<String, Object> config;
	public static HashMap<Term, Term> inputRules;
	public static HashMap<ArrayList<Term>, Term> outputRules;
	
	public static void init() {
		
		DayTemperature = new LingVariable(LingVarType.DAY_TEMPERATURE);
		
		DayTemperature.addTerm(new Term("Za niska") {
			
			public double getValueFor(double arg) {
				return ShapeCreator.trapeze(true, arg, 22, 24);
			}
		});
		
		DayTemperature.addTerm(new Term("Optymalna") {
			
			public double getValueFor(double arg) {
				return ShapeCreator.trapeze(false, arg, 22, 24, 30, 34);
			}
		});
		
		DayTemperature.addTerm(new Term("Za wysoka") {
			
			public double getValueFor(double arg) {
				return ShapeCreator.trapeze(false, arg, 30, 34);
			}
		});
		
		
		NightTemperature = new LingVariable(LingVarType.NIGHT_TEMPERATURE);
		
		NightTemperature.addTerm(new Term("Za niska") {
			
			public double getValueFor(double arg) {
				return ShapeCreator.trapeze(true, arg, 19, 20);
			}
		});
		
		NightTemperature.addTerm(new Term("Optymalna") {
			
			public double getValueFor(double arg) {
				return ShapeCreator.trapeze(false, arg, 19, 20, 22, 24);
			}
		});
		
		NightTemperature.addTerm(new Term("Za wysoka") {
			
			public double getValueFor(double arg) {
				return ShapeCreator.trapeze(false, arg, 22, 24);
			}
		});
		
		
		DayHumidity = new LingVariable(LingVarType.DAY_HUMIDITY);
		
		DayHumidity.addTerm(new Term("Za niska") {
			
			public double getValueFor(double arg) {
				return ShapeCreator.trapeze(true, arg, 52, 60);
			}
		});
		
		DayHumidity.addTerm(new Term("Optymalna") {
			
			public double getValueFor(double arg) {
				return ShapeCreator.trapeze(false, arg, 52, 60, 68, 76);
			}
		});
		
		DayHumidity.addTerm(new Term("Za wysoka") {
			
			public double getValueFor(double arg) {
				return ShapeCreator.trapeze(false, arg, 68, 76);
			}
		});
		
		
		NightHumidity = new LingVariable(LingVarType.NIGHT_HUMIDITY);
		
		NightHumidity.addTerm(new Term("Za niska") {
			
			public double getValueFor(double arg) {
				return ShapeCreator.trapeze(true, arg, 68, 76);
			}
		});
		
		NightHumidity.addTerm(new Term("Optymalna") {
			
			public double getValueFor(double arg) {
				return ShapeCreator.trapeze(false, arg, 68, 76, 80, 88);
			}
		});
		
		NightHumidity.addTerm(new Term("Za wysoka") {
			
			public double getValueFor(double arg) {
				return ShapeCreator.trapeze(false, arg, 80, 88);
			}
		});
		
		
		HeaterPower = new LingVariable(LingVarType.HEATER_POWER);
		
		HeaterPower.addTerm(new Term("Brak") {
			
			public double getValueFor(double arg) {
				return ShapeCreator.trapeze(true, arg, 17, 18);
			}
		});
		
		HeaterPower.addTerm(new Term("Niewielkie") {
			
			public double getValueFor(double arg) {
				return ShapeCreator.trapeze(false, arg, 17, 21, 29, 31);
			}
		});
		
		HeaterPower.addTerm(new Term("Duże") {
			
			public double getValueFor(double arg) {
				return ShapeCreator.trapeze(false, arg, 29, 33);
			}
		});
		
		
		FoggerPower = new LingVariable(LingVarType.FOGGER_POWER);
		
		FoggerPower.addTerm(new Term("Mała") {
			
			public double getValueFor(double arg) {
				return ShapeCreator.trapeze(true, arg, 24, 40);
			}
		});
		
		FoggerPower.addTerm(new Term("Średnia") {
			
			public double getValueFor(double arg) {
				return ShapeCreator.trapeze(false, arg, 24, 40, 60, 76);
			}
		});
		
		FoggerPower.addTerm(new Term("Duża") {
			
			public double getValueFor(double arg) {
				return ShapeCreator.trapeze(false, arg, 60, 76);
			}
		});		
		
		config = new HashMap<>();
		inputRules = new HashMap<>();
		outputRules = new HashMap<>();
		
		inputRules.put(DayTemperature.getTerm("Za niska"), HeaterPower.getTerm("Duże"));
		inputRules.put(DayTemperature.getTerm("Optymalna"), HeaterPower.getTerm("Niewielkie"));
		inputRules.put(DayTemperature.getTerm("Za wysoka"), HeaterPower.getTerm("Brak"));
		inputRules.put(NightTemperature.getTerm("Za niska"), HeaterPower.getTerm("Duże"));
		inputRules.put(NightTemperature.getTerm("Optymalna"), HeaterPower.getTerm("Niewielkie"));
		inputRules.put(NightTemperature.getTerm("Za wysoka"), HeaterPower.getTerm("Brak"));
		inputRules.put(DayHumidity.getTerm("Za niska"), FoggerPower.getTerm("Duża"));
		inputRules.put(DayHumidity.getTerm("Optymalna"), FoggerPower.getTerm("Średnia"));
		inputRules.put(DayHumidity.getTerm("Za wysoka"), FoggerPower.getTerm("Mała"));
		inputRules.put(NightHumidity.getTerm("Za niska"), FoggerPower.getTerm("Duża"));
		inputRules.put(NightHumidity.getTerm("Optymalna"), FoggerPower.getTerm("Średnia"));
		inputRules.put(NightHumidity.getTerm("Za wysoka"), FoggerPower.getTerm("Mała"));
		
		outputRules.put(new ArrayList<Term>(Arrays.asList(DayTemperature.getTerm("Za niska"), 
				HeaterPower.getTerm("Duże"))), DayTemperature.getTerm("Optymalna"));
		outputRules.put(new ArrayList<Term>(Arrays.asList(DayTemperature.getTerm("Za niska"), 
				HeaterPower.getTerm("Niewielkie"))), DayTemperature.getTerm("Optymalna"));
		outputRules.put(new ArrayList<Term>(Arrays.asList(DayTemperature.getTerm("Za niska"), 
				HeaterPower.getTerm("Brak"))), DayTemperature.getTerm("Za niska"));
		
		outputRules.put(new ArrayList<Term>(Arrays.asList(DayTemperature.getTerm("Optymalna"), 
				HeaterPower.getTerm("Duże"))), DayTemperature.getTerm("Za wysoka"));
		outputRules.put(new ArrayList<Term>(Arrays.asList(DayTemperature.getTerm("Optymalna"), 
				HeaterPower.getTerm("Niewielkie"))), DayTemperature.getTerm("Optymalna"));
		outputRules.put(new ArrayList<Term>(Arrays.asList(DayTemperature.getTerm("Optymalna"), 
				HeaterPower.getTerm("Brak"))), DayTemperature.getTerm("Optymalna"));
		
		outputRules.put(new ArrayList<Term>(Arrays.asList(DayTemperature.getTerm("Za wysoka"), 
				HeaterPower.getTerm("Duże"))), DayTemperature.getTerm("Za wysoka"));
		outputRules.put(new ArrayList<Term>(Arrays.asList(DayTemperature.getTerm("Za wysoka"), 
				HeaterPower.getTerm("Niewielkie"))), DayTemperature.getTerm("Za wysoka"));
		outputRules.put(new ArrayList<Term>(Arrays.asList(DayTemperature.getTerm("Za wysoka"), 
				HeaterPower.getTerm("Brak"))), DayTemperature.getTerm("Optymalna"));
		
		outputRules.put(new ArrayList<Term>(Arrays.asList(NightTemperature.getTerm("Za niska"), 
				HeaterPower.getTerm("Duże"))), NightTemperature.getTerm("Optymalna"));
		outputRules.put(new ArrayList<Term>(Arrays.asList(NightTemperature.getTerm("Za niska"), 
				HeaterPower.getTerm("Niewielkie"))), NightTemperature.getTerm("Optymalna"));
		outputRules.put(new ArrayList<Term>(Arrays.asList(NightTemperature.getTerm("Za niska"), 
				HeaterPower.getTerm("Brak"))), NightTemperature.getTerm("Za niska"));
		
		outputRules.put(new ArrayList<Term>(Arrays.asList(NightTemperature.getTerm("Optymalna"), 
				HeaterPower.getTerm("Duże"))), NightTemperature.getTerm("Za wysoka"));
		outputRules.put(new ArrayList<Term>(Arrays.asList(NightTemperature.getTerm("Optymalna"), 
				HeaterPower.getTerm("Niewielkie"))), NightTemperature.getTerm("Optymalna"));
		outputRules.put(new ArrayList<Term>(Arrays.asList(NightTemperature.getTerm("Optymalna"), 
				HeaterPower.getTerm("Brak"))), NightTemperature.getTerm("Optymalna"));
		
		outputRules.put(new ArrayList<Term>(Arrays.asList(NightTemperature.getTerm("Za wysoka"), 
				HeaterPower.getTerm("Duże"))), NightTemperature.getTerm("Za wysoka"));
		outputRules.put(new ArrayList<Term>(Arrays.asList(NightTemperature.getTerm("Za wysoka"), 
				HeaterPower.getTerm("Niewielkie"))), NightTemperature.getTerm("Za wysoka"));
		outputRules.put(new ArrayList<Term>(Arrays.asList(NightTemperature.getTerm("Za wysoka"), 
				HeaterPower.getTerm("Brak"))), NightTemperature.getTerm("Optymalna"));
		
		
		outputRules.put(new ArrayList<Term>(Arrays.asList(DayHumidity.getTerm("Za niska"), 
				FoggerPower.getTerm("Duża"))), DayHumidity.getTerm("Optymalna"));
		outputRules.put(new ArrayList<Term>(Arrays.asList(DayHumidity.getTerm("Za niska"), 
				FoggerPower.getTerm("Średnia"))), DayHumidity.getTerm("Optymalna"));
		outputRules.put(new ArrayList<Term>(Arrays.asList(DayHumidity.getTerm("Za niska"), 
				FoggerPower.getTerm("Mała"))), DayHumidity.getTerm("Za niska"));
		
		outputRules.put(new ArrayList<Term>(Arrays.asList(DayHumidity.getTerm("Optymalna"), 
				FoggerPower.getTerm("Duża"))), DayHumidity.getTerm("Za wysoka"));
		outputRules.put(new ArrayList<Term>(Arrays.asList(DayHumidity.getTerm("Optymalna"), 
				FoggerPower.getTerm("Średnia"))), DayHumidity.getTerm("Optymalna"));
		outputRules.put(new ArrayList<Term>(Arrays.asList(DayHumidity.getTerm("Optymalna"), 
				FoggerPower.getTerm("Mała"))), DayHumidity.getTerm("Optymalna"));
		
		outputRules.put(new ArrayList<Term>(Arrays.asList(DayHumidity.getTerm("Za wysoka"), 
				FoggerPower.getTerm("Duża"))), DayHumidity.getTerm("Za wysoka"));
		outputRules.put(new ArrayList<Term>(Arrays.asList(DayHumidity.getTerm("Za wysoka"), 
				FoggerPower.getTerm("Średnia"))), DayHumidity.getTerm("Za wysoka"));
		outputRules.put(new ArrayList<Term>(Arrays.asList(DayHumidity.getTerm("Za wysoka"), 
				FoggerPower.getTerm("Mała"))), DayHumidity.getTerm("Optymalna"));
		
		outputRules.put(new ArrayList<Term>(Arrays.asList(NightHumidity.getTerm("Za niska"), 
				FoggerPower.getTerm("Duża"))), NightHumidity.getTerm("Optymalna"));
		outputRules.put(new ArrayList<Term>(Arrays.asList(NightHumidity.getTerm("Za niska"), 
				FoggerPower.getTerm("Średnia"))), NightHumidity.getTerm("Optymalna"));
		outputRules.put(new ArrayList<Term>(Arrays.asList(NightHumidity.getTerm("Za niska"), 
				FoggerPower.getTerm("Mała"))), NightHumidity.getTerm("Za niska"));
		
		outputRules.put(new ArrayList<Term>(Arrays.asList(NightHumidity.getTerm("Optymalna"), 
				FoggerPower.getTerm("Duża"))), NightHumidity.getTerm("Za wysoka"));
		outputRules.put(new ArrayList<Term>(Arrays.asList(NightHumidity.getTerm("Optymalna"), 
				FoggerPower.getTerm("Średnia"))), NightHumidity.getTerm("Optymalna"));
		outputRules.put(new ArrayList<Term>(Arrays.asList(NightHumidity.getTerm("Optymalna"), 
				FoggerPower.getTerm("Mała"))), NightHumidity.getTerm("Optymalna"));
		
		outputRules.put(new ArrayList<Term>(Arrays.asList(NightHumidity.getTerm("Za wysoka"), 
				FoggerPower.getTerm("Duża"))), NightHumidity.getTerm("Za wysoka"));
		outputRules.put(new ArrayList<Term>(Arrays.asList(NightHumidity.getTerm("Za wysoka"), 
				FoggerPower.getTerm("Średnia"))), NightHumidity.getTerm("Za wysoka"));
		outputRules.put(new ArrayList<Term>(Arrays.asList(NightHumidity.getTerm("Za wysoka"), 
				FoggerPower.getTerm("Mała"))), NightHumidity.getTerm("Optymalna"));
	}	
}