package com.daniel.pcpartpricetracker.objects;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
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
	
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	@JoinColumn(name="shop")
	Shop shop;
	
	public PCPart(int code, int type, int shop ) {
		this.code=code;
		this.type=type;
		new Shop(shop);
	}
	public PCPart(int id,int type, String name, List<Price> price,Shop shop) {
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
		return "ID: "+id+" code: "+code+" name: "+ name+" type: "+Type.idToString.get(type)+"("+type+") shop: "+(shop.name==(null) ? "" : shop.name)+"("+shop.id+")" ;
	}
}
