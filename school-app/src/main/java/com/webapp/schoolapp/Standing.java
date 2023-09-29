package com.webapp.schoolapp;

public enum Standing {
	EXCEEDS("Exceeds Expectations"),
	MEETS("Meets Expectations"),
	FEW("Meets Few Expectations"),
	FAILS("Fails to Meet Expectations");	
	
	private final String description;
	
	Standing(String description){
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
