package com.daniel.pcpartpricetracker.objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.daniel.pcpartpricetracker.sql.logic.DatabaseManager;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table (name="shop")
@NoArgsConstructor
public class Shop{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;

	public Shop(int id) {
		this.id=id;	
		getNameFromDB(id);
	}
	public Shop(String name) {
		this.name=name;	
		getIDFromDB(name);
	}
	
	public void getIDFromDB(String name) {
		DatabaseManager dmShop = new DatabaseManager();
		dmShop.run(()->this.id = dmShop.getSession().createQuery("from Shop",Shop.class).getResultList().stream().filter((Shop x)->x.getName().equals(name)).findFirst().get().getId());
	}
	public void getNameFromDB(int id) {
		DatabaseManager dmShop = new DatabaseManager();
		dmShop.run(()->this.name = dmShop.getSession().createQuery("from Shop",Shop.class).getResultList().stream().filter((Shop x)->x.getId()==id).findFirst().get().getName());
	}
}
