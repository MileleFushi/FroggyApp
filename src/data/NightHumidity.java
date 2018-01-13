package data;

import java.util.ArrayList;

public class NightHumidity {
	
	private static ArrayList<Category> categories;
	
	public static Category getCategory(String name) throws NoCategoryFoundException {
		
		for(Category cat : categories) {
			if(cat.getName().equals(name))
				return cat;
		}
		
		throw new NoCategoryFoundException(name);
	}	
	
	public static ArrayList<Category> getCategories() {		
		return categories;
	}
	
	public static void prepare() {
		
		categories = new ArrayList<Category>();
		
		categories.add(new Category("Za niska") {
			
			public double getValueFor(int arg) {
				return ShapeCreator.trapeze(true, arg, 68, 76);
			}
		});
		
		categories.add(new Category("Optymalna") {
			
			public double getValueFor(int arg) {
				return ShapeCreator.trapeze(false, arg, 68, 76, 80, 88);
			}
		});
		
		categories.add(new Category("Za wysoka") {
			
			public double getValueFor(int arg) {
				return ShapeCreator.trapeze(false, arg, 80, 88);
			}
		});
	}
}