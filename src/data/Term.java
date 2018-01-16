package data;

import java.util.ArrayList;

public class Term {
	
	private ArrayList<Category> categories;
	private TermType type;
	private double value;
	
	Term(TermType type) {
		this.type = type;
	}
	
	public void set(double value) {
		//System.out.println(type + " value has changed to " + value);
		this.value = value;
	}
	
	void addCategory(Category category) {
		
		try {
			categories.add(category);
		} catch (NullPointerException e) {
			categories = new ArrayList<Category>();
			categories.add(category);
		}
	}
	
	public TermType getType() {
		return type;
	}
	
	public double get() {
		return value;
	}
	
	public Category getCategory(String name) {
		
		for(Category cat : categories) {
			if(cat.getName().equals(name))
				return cat;
		}
		
		return null;
	}	
	
	public ArrayList<Category> getCategories() {		
		return categories;
	}

}
