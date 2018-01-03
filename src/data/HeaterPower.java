package data;

import java.util.ArrayList;

public class HeaterPower {
	
	private static ArrayList<Category> categories;
	
	public static void prepare() {
		
		categories = new ArrayList<Category>();
		
		categories.add(new Category("Brak") {
			
			public double getValueFor(int arg) {
				return ShapeCreator.trapeze(true, arg, 17, 18);
			}
		});
		
		categories.add(new Category("Niewielkie") {
			
			public double getValueFor(int arg) {
				return ShapeCreator.trapeze(false, arg, 17, 21, 29, 31);
			}
		});
		
		categories.add(new Category("Duże") {
			
			public double getValueFor(int arg) {
				return ShapeCreator.trapeze(false, arg, 29, 33);
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