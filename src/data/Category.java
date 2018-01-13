package data;

public class Category implements CatInterface {
	
	private String name;
	
	Category(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public double getValueFor(int arg) {
		return 0;
	}
	
}