package com.daniel.pcpartpricetracker.sql.logic;

import java.sql.Connection;
import java.util.ArrayList;

import com.daniel.pcpartpricetracker.objects.Shop;
import com.daniel.pcpartpricetracker.sql.columns.ShopColumns;

public class ShopManager implements ShopColumns{

	Connection conn;
	public ShopManager() {
		connect();
	}
	@Override
	public boolean connect() {
		DatabaseManager dbm = new DatabaseManager();
		return dbm.isConnected();
		
	}

	@Override
	public void insert(Shop b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(ArrayList<Shop> listB) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(int id, Shop b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
