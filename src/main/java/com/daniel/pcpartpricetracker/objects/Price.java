package com.daniel.pcpartpricetracker.objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name="price")
public class Price {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	int partId;
	int shopId;
	double price;
	long time;
	public Price(int partID, int shopID, double price,long time) {
		this.partId=partID;
		this.shopId=shopID;
		this.price=price;
		this.time=time;
	}
}
