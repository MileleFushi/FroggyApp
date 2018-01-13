package data;

public class NoCategoryFoundException extends Exception {

	public NoCategoryFoundException(String name) {
		super("No category with name = " + name + " found.");
	}
	
}
