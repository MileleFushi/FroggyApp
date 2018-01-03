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
		// TODO Auto-generated method stub
		return 0;
	}
	
}