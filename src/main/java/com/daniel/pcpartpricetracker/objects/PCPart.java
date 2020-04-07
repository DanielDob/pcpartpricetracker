package com.daniel.pcpartpricetracker.objects;

import java.util.ArrayList;

public class PCPart {

	int id;
	Type type;
	String name;
	ArrayList<Shop> price;
	
	public PCPart(int id,Type type, String name, ArrayList<Shop> price) {
		super();
		this.id = id;
		this.type=type;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Shop> getPrice() {
		return price;
	}

	public void setPrice(ArrayList<Shop> price) {
		this.price = price;
	}
	
	class Shop{
		int id,idShop;
		double price;
		String name;
		
		public Shop(int id, int idShop, double price, String name) {
			super();
			this.id = id;
			this.idShop = idShop;
			this.price = price;
			this.name = name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getIdShop() {
			return idShop;
		}
		public void setIdShop(int idShop) {
			this.idShop = idShop;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	}
}
