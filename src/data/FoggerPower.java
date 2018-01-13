package data;

import java.util.ArrayList;

public class FoggerPower {

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
		
		categories.add(new Category("Mała") {
			
			public double getValueFor(int arg) {
				return ShapeCreator.trapeze(true, arg, 24, 40);
			}
		});
		
		categories.add(new Category("Średnia") {
			
			public double getValueFor(int arg) {
				return ShapeCreator.trapeze(false, arg, 24, 40, 60, 76);
			}
		});
		
		categories.add(new Category("Duża") {
			
			public double getValueFor(int arg) {
				return ShapeCreator.trapeze(false, arg, 60, 76);
			}
		});
	}
}