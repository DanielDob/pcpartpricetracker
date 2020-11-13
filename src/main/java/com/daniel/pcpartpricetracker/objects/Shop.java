package com.daniel.pcpartpricetracker.objects;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name="shop")
public class Shop{
	int id;
	String name;

	
}
