package app;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import data.Data;

public class ClockThread implements Runnable {

	public static int speedUp = 1;
	public static boolean toStop = false;
	public static boolean running = false;
	private static int i = 0;
	private static boolean isDay = true;
	
	public static JLabel labelClock;
	public static JSpinner spinnerSimulatingTime;
	public static JSpinner spinnerTerraTemperature;
	public static JSpinner spinnerTerraHumidity;
	public static JTextField textFieldSimulatingTemperatureOut;
	public static JTextField textFieldSimulatingHumidityOut;
		
	private void getValues() {
		if(Time.getHour() < 22 && Time.getHour() > 6) {
			isDay = true;
		}
		else {
			isDay = false;
		}
	}
	
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
    			
    			if(i != (int)Data.config.get("delay")) {
    				i++;
    			}
    			else {
    				i = 0;
    			}
    			
    			labelClock.setText(Time.getTime());
    		}
    }
}