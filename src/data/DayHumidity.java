package data;

import java.util.ArrayList;

public class DayHumidity {

	private static ArrayList<Category> categories;
	
	public static void prepare() {
		
		categories = new ArrayList<Category>();
		
		categories.add(new Category("Za niska") {
			
			public double getValueFor(int arg) {
				return ShapeCreator.trapeze(true, arg, 52, 60);
			}
		});
		
		categories.add(new Category("Optymalna") {
			
			public double getValueFor(int arg) {
				return ShapeCreator.trapeze(false, arg, 52, 60, 68, 76);
			}
		});
		
		categories.add(new Category("Za wysoka") {
			
			public double getValueFor(int arg) {
				return ShapeCreator.trapeze(false, arg, 68, 76);
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