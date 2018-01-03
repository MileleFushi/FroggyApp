package data;

import java.util.ArrayList;

public class NightTemperature {

	private static ArrayList<Category> categories;
	
	public static void prepare() {
		
		categories = new ArrayList<Category>();
		
		categories.add(new Category("Za niska") {
			
			public double getValueFor(int arg) {
				return ShapeCreator.trapeze(true, arg, 19, 20);
			}
		});
		
		categories.add(new Category("Optymalna") {
			
			public double getValueFor(int arg) {
				return ShapeCreator.trapeze(false, arg, 19, 20, 22, 24);
			}
		});
		
		categories.add(new Category("Za wysoka") {
			
			public double getValueFor(int arg) {
				return ShapeCreator.trapeze(false, arg, 22, 24);
			}
		});
	}
	
	public static Category getCategory(String name) {
		
		for(Category cat : categories) {
			if(cat.getName().equals(name))
				return cat;
		}
		
		return null;
	}
}