package app;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import data.Data;
import data.DataSensitizer;

public class ClockThread implements Runnable {

	public static int speedUp = 1;
	public static boolean toStop = false;
	public static boolean running = false;
	private static int delay;
	private static int i;
	private static int f;
	
	private static double temperatureToAdd;
	private static double humidityToAdd;
	
	public static JLabel labelClock;
	public static JLabel labelClockImage;
	public static JLabel labelThermometerImage;		
	public static JLabel labelFoggerImage;		
	public static JLabel labelHeatingMatImage;		
	public static JLabel labelLampImage;
	
	public static JPanel terraPanel;
	
	public static JTextField textFieldTerraTemperature;
	public static JTextField textFieldTerraHumidity;
	public static JTextField textFieldSimulatingTemperatureOut;
	public static JTextField textFieldSimulatingHumidityOut;
	
	private static final Color DAY_COLOR = new Color(240, 255, 240);
	private static final Color EVENING_COLOR = new Color(205, 135, 31);
	private static final Color NIGHT_COLOR = new Color(65, 86, 97);
	private static final Color MORNING_COLOR = new Color(183, 206, 185);
	
    public void run() {
    	
    		delay = (int)Data.config.get("delay");
    		i = delay;
    		f = 0;
    		presetBackground();
    	
    		while(true) {

    			if(toStop) {
    				running = false;
    				i = delay;
    				f = 0;
    				break;
    			}
    			
    			checkImages();
    			running = true;

    			try {
    				Thread.sleep(1000/speedUp);
    			} catch (InterruptedException e) {
    				System.out.println("BLAAAAAAAAAD");
    			}
        	    
    			setOutputs();
    			
    			if( f == 0) {
    				f = 1;
    				breathe();
    			} else {
    				f = 0;
    			}
    			
    			if( i != delay) {
    				i++;
    			}
    			else {
    				i = 0;    
    				countToSetValues();
    			}
    			
    			setInputs(Data.DayTemperature.get() + temperatureToAdd, Data.DayHumidity.get() + humidityToAdd);
    			Time.nextSecond();
    			
    			labelClock.setText(Time.getTime());
    		}
    }
    
    private static void setOutputs() {
    	
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
    
    private static void countToSetValues() {
    	
		if(Time.isDay()) {
			
			DataSensitizer.setUp(Data.DayTemperature, Data.HeaterPower);
			temperatureToAdd = (DataSensitizer.getResult() - Data.DayTemperature.get())/(double)delay;
			
			DataSensitizer.setUp(Data.DayHumidity, Data.FoggerPower);
			humidityToAdd = (DataSensitizer.getResult() - Data.DayHumidity.get())/(double)delay;

		} else {
			
			DataSensitizer.setUp(Data.NightTemperature, Data.HeaterPower);
			temperatureToAdd = (DataSensitizer.getResult() - Data.NightTemperature.get())/(double)delay;
			
			DataSensitizer.setUp(Data.NightHumidity, Data.FoggerPower);
			humidityToAdd = (DataSensitizer.getResult() - Data.NightHumidity.get())/(double)delay;
			
		}
    }
    
    private static void setInputs(double temperature, double humidity) {
			
    	Data.DayTemperature.set(temperature);
    	Data.NightTemperature.set(temperature);

    	Data.DayHumidity.set(humidity);
    	Data.NightHumidity.set(humidity);
			
    	textFieldTerraTemperature.setText(new Integer((int) temperature).toString());
    	textFieldTerraHumidity.setText(new Integer((int) humidity).toString());

    }
    
    private static void setColors(Color from, Color to) {
    	
    	int red, green, blue;
    	int backgroundChangeSpeed = (int) Data.config.get("backgroundChangeSpeed");
    	
		if(terraPanel.getBackground() != to) {
			try {
				red = terraPanel.getBackground().getRed() + (to.getRed() - from.getRed())/backgroundChangeSpeed;
				green = terraPanel.getBackground().getGreen() + (to.getGreen() - from.getGreen())/backgroundChangeSpeed;
				blue = terraPanel.getBackground().getBlue() + (to.getBlue() - from.getBlue())/backgroundChangeSpeed;
				terraPanel.setBackground(new Color(red, green, blue));
			} catch (IllegalArgumentException e) {
				terraPanel.setBackground(to);
			}
		}
    }
    
    private static void presetBackground() {
    	
    	if(Time.getHour() > 9 && Time.getHour() < 20) {
    		terraPanel.setBackground(DAY_COLOR);
    	} else if (Time.getHour() >= 20 && Time.getHour() < 22) {
    		terraPanel.setBackground(EVENING_COLOR);
    	} else if (Time.getHour() > 6 && Time.getHour() <= 9) {
    		terraPanel.setBackground(MORNING_COLOR);
    	} else {
    		terraPanel.setBackground(NIGHT_COLOR);
    	}
    }
    
    private static void checkImages() {
    	   	
    	if(Time.isDay()) {
    		labelLampImage.setIcon(new ImageIcon("img/lamp/LampState0.png"));   
    	} else {
    		labelLampImage.setIcon(new ImageIcon("img/lamp/LampState1.png"));
    	}
    	
    	if(Time.getHour() > 9 && Time.getHour() < 20) {
    		
    		labelClockImage.setIcon(new ImageIcon("img/clock/clockDay.png")); // day
    		setColors(MORNING_COLOR, DAY_COLOR);
    		
    	} else if (Time.getHour() >= 20 && Time.getHour() < 22) {
    		
    		labelClockImage.setIcon(new ImageIcon("img/clock/clockMorning&Evening.png")); // evening
    		setColors(DAY_COLOR, EVENING_COLOR);
    		
    	} else if (Time.getHour() > 6 && Time.getHour() <= 9) {
    		
    		labelClockImage.setIcon(new ImageIcon("img/clock/clockMorning&Evening.png")); // morning
    		setColors(NIGHT_COLOR, MORNING_COLOR);
    		
    	} else {
    		
    		labelClockImage.setIcon(new ImageIcon("img/clock/clockNight.png")); // night
    		setColors(EVENING_COLOR, NIGHT_COLOR);
    		
    	}

    	if(Data.DayTemperature.get() > 33) {
    		labelThermometerImage.setIcon(new ImageIcon("img/thermometer/ThermometerStateHigh.png"));
    	} else if (Data.DayTemperature.get() > 20) {
    		labelThermometerImage.setIcon(new ImageIcon("img/thermometer/ThermometerStateMedium.png"));
    	} else {
    		labelThermometerImage.setIcon(new ImageIcon("img/thermometer/ThermometerStateLow.png"));
    	}
    	
    	if(Data.FoggerPower.get() > 68) {
    		labelFoggerImage.setIcon(new ImageIcon("img/fogger/FoggerStateHigh.png"));
    	} else if (Data.FoggerPower.get() > 32) {
    		labelFoggerImage.setIcon(new ImageIcon("img/fogger/FoggerStateMedium.png"));
    	} else {
    		labelFoggerImage.setIcon(new ImageIcon("img/fogger/FoggerStateLow.png"));
    	}
    	
    	if(Data.HeaterPower.get() > 31) {
    		labelHeatingMatImage.setIcon(new ImageIcon("img/heatingMat/HeatingMatStateHigh.png"));
    	} else if (Data.HeaterPower.get() > 17) {
    		labelHeatingMatImage.setIcon(new ImageIcon("img/heatingMat/HeatingMatStateLow.png"));
    	} else {
    		labelHeatingMatImage.setIcon(new ImageIcon("img/heatingMat/HeatingMatStateNull.png"));
    	}  	
    }
    
    private static void breathe() {
    	
    }
}