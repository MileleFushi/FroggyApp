package data;

import java.util.ArrayList;

public class Term {
	
	private ArrayList<Category> categories;
	private TermType type;
	
	Term(TermType type) {
		this.type = type;
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
	
	public Category getCategory(String name) throws NoCategoryFoundException {
		
		for(Category cat : categories) {
			if(cat.getName().equals(name))
				return cat;
		}
		
		throw new NoCategoryFoundException(name);
	}	
	
	public ArrayList<Category> getCategories() {		
		return categories;
	}

}
