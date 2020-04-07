package com.daniel.pcpartpricetracker.objects;

import java.util.HashMap;

public class PCBuild {
	
	private HashMap<Type,Integer> components;

	
	
	public PCBuild(HashMap<Type, Integer> components) {
		super();
		this.components = components;
	}

	public HashMap<Type, Integer> getComponents() {
		return components;
	}

	public void setComponents(HashMap<Type, Integer> components) {
		this.components = components;
	}
	
	
	
}
