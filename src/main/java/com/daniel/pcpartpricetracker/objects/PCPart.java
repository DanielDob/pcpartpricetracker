package com.daniel.pcpartpricetracker.objects;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

@Entity
@Table (name="pc_part")
@NoArgsConstructor
public class PCPart {

	/**
	 *  ID in sql
	 */
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	/**
	 *  IN XKOM: on site: "kod x-kom" also in URL is used
	 */
	int code;
	/**
	 * from class Type
	 *  type of part e.g. GPU(2)
	 */
	int type;
	/**
	 *  name on site
	 */
	String name;
	@OneToMany(cascade = CascadeType.ALL)
	List<Price> price;
	
	int shop;
	
	public PCPart(int code, int type, int shop,String name ) {
		this.code=code;
		this.type=type;
		this.shop=shop;
		this.name=name;
	}
	public PCPart(int id,int type, String name, List<Price> price,int shop) {
		super();
		this.id = id;
		this.type=type;
		this.name = name;
		this.price = price;
		this.shop=shop;
	}

	public int getId() {
		return id;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
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

	public List<Price> getPrice() {
		return price;
	}

	public void setPrice(List<Price> price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		Shop s = new Shop(shop);
		new Type();
		return "ID: "+id+" code: "+code+" name: "+ (name==null ? "" : name)+" type: "+Type.idToString.get(type)+"("+type+") shop: "+(s==null||s.name==(null) ? "none" : s.name+" ("+s.id+")") ;
	}
}
