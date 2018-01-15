package app;

import javax.swing.JLabel;

public class ClockThread implements Runnable {

	public static int speedUp = 1;
	public static JLabel labelClock;
	public static boolean toStop = false;
	public static boolean running = false;
	
    public void run() {
    	
    		while(true) {

    			if(toStop) {
    				running = false;
    				break;
    			}
    			
    			running = true;
    			
    			try {
    				Thread.sleep(1000/speedUp);
    			} catch (InterruptedException e) {
    				System.out.println("BLAAAAAAAAAD");
    			}
        	       	
    			Time.nextSecond();
    			labelClock.setText(Time.getTime());
    		}
    }
}