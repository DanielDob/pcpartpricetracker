package com.daniel.pcpartpricetracker.objects;

import java.util.HashMap;

public class PCBuild {
	
	private String name; 
	
	
	private HashMap<Type,PCPart> components;

	
	
	public PCBuild(HashMap<Type, PCPart> components) {
		super();
		this.components = components;
	}

	public PCPart getComnonent(PCPart part) {
		return components.get(part);
	}
	public HashMap<Type, PCPart> getComponents() {
		return components;
	}

	public void setComponents(HashMap<Type, PCPart> components) {
		this.components = components;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
