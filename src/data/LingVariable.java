package data;

import java.util.ArrayList;

import logger.Log;

public class LingVariable {
	
	private ArrayList<Term> terms;
	private LingVarType type;
	private double value;
	
	LingVariable(LingVarType type) {
		this.type = type;
	}
	
	public void set(double value) {
		Log.debug(type + " - wartość zmieniono na " + value);
		this.value = value;
	}
	
	void addTerm(Term term) {
		
		try {
			terms.add(term);
		} catch (NullPointerException e) {
			terms = new ArrayList<Term>();
			terms.add(term);
		}
	}
	
	public LingVarType getType() {
		return type;
	}
	
	public double get() {
		return value;
	}
	
	public Term getTerm(String name) {
		
		for(Term term : terms) {
			if(term.getName().equals(name))
				return term;
		}
		
		return null;
	}	
	
	public ArrayList<Term> getTerms() {		
		return terms;
	}
}