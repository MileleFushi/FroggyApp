package app;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import data.Data;
import data.DataSensitizer;

public class ClockThread implements Runnable {

	public static int speedUp = 1;
	public static boolean toStop = false;
	public static boolean running = false;
	private static int i = 0;
	
	public static JLabel labelClock;
	public static JSpinner spinnerSimulatingTime;
	public static JTextField textFieldTerraTemperature;
	public static JTextField textFieldTerraHumidity;
	public static JTextField textFieldSimulatingTemperatureOut;
	public static JTextField textFieldSimulatingHumidityOut;
	
    public void run() {
    	
    		while(true) {

    			if(toStop) {
    				running = false;
    				i = 0;
    				break;
    			}
    			
    			running = true;
    			
    			try {
    				Thread.sleep(1000/speedUp);
    			} catch (InterruptedException e) {
    				System.out.println("BLAAAAAAAAAD");
    			}
        	       	
    			Time.nextSecond();
    			
    			//if(i != (int)Data.config.get("delay")) {
    			if( i != 5) {
    				i++;
    			}
    			else {
    				i = 0;    
    				setOutputs();
    				setInputs();
    			}
    			
    			labelClock.setText(Time.getTime());
    		}
    }
    
    public static void setOutputs() {
    	
		if(Time.isDay()) {
			DataSensitizer.setUp(Data.DayTemperature);
			Data.HeaterPower.set(DataSensitizer.getResult());
			DataSensitizer.setUp(Data.DayHumidity);
			Data.FoggerPower.set(DataSensitizer.getResult());
		} else {
			DataSensitizer.setUp(Data.NightTemperature);
			Data.HeaterPower.set(DataSensitizer.getResult());
			DataSensitizer.setUp(Data.NightHumidity);
			Data.FoggerPower.set(DataSensitizer.getResult());
		}
		
		textFieldSimulatingTemperatureOut.setText(new Integer((int)Data.HeaterPower.get()).toString());
		textFieldSimulatingHumidityOut.setText(new Integer((int)Data.FoggerPower.get()).toString());
    }
    
    public static void setInputs() {
    	
		if(Time.isDay()) {
			
			DataSensitizer.setUp(Data.DayTemperature, Data.HeaterPower);
			Data.DayTemperature.set(DataSensitizer.getResult());
			Data.NightTemperature.set(DataSensitizer.getResult());
			
			DataSensitizer.setUp(Data.DayHumidity, Data.FoggerPower);
			Data.DayHumidity.set(DataSensitizer.getResult());
			Data.NightHumidity.set(DataSensitizer.getResult());
			
			textFieldTerraTemperature.setText(new Integer((int)Data.DayTemperature.get()).toString());
			textFieldTerraHumidity.setText(new Integer((int)Data.DayHumidity.get()).toString());
			
		} else {
			
			DataSensitizer.setUp(Data.NightTemperature, Data.HeaterPower);
			Data.DayTemperature.set(DataSensitizer.getResult());
			Data.NightTemperature.set(DataSensitizer.getResult());
			
			DataSensitizer.setUp(Data.NightHumidity, Data.FoggerPower);
			Data.DayHumidity.set(DataSensitizer.getResult());
			Data.NightHumidity.set(DataSensitizer.getResult());
			
			textFieldTerraTemperature.setText(new Integer((int)Data.NightTemperature.get()).toString());
			textFieldTerraHumidity.setText(new Integer((int)Data.NightHumidity.get()).toString());
			
		}
    }
}