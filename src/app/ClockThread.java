package app;

import javax.swing.JLabel;

public class ClockThread implements Runnable {

	public static int speedUp = 1;
	public JLabel clockLabel;
	public static boolean toStop = false;
	public static boolean running = false;
	
	public ClockThread setClockLabel(JLabel cl) {
		clockLabel = cl;
		return this;
	}
	
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
    			clockLabel.setText(Time.getTime());
    		}
    }
    
    public ClockThread stopIt() {
    	toStop = true;
    	return this;
    }
    
    public ClockThread allow() {
    	toStop = false;
    	return this;
    }
}