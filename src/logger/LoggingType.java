package logger;

public enum LoggingType {
	
	DEBUG ("DEBUG"), 
	INFO ("INFO"), 
	WARN ("WARN"), 
	ERROR ("ERROR");
	
	private final String type;
	
	private LoggingType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
}
