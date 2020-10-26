package com.daniel.pcpartpricetracker.sql.logic;

import java.sql.Connection;
import java.util.ArrayList;

import com.daniel.pcpartpricetracker.objects.PCPart;
import com.daniel.pcpartpricetracker.sql.columns.PCPartColumns;

public class PCPartManager implements PCPartColumns{

	Connection conn;
	public PCPartManager() {
		conn=connect();
	}
	@Override
	public Connection connect() {
		DatabaseManager dbm = new DatabaseManager();
		return dbm.isConnected();
		
	}

	@Override
	public void insert(PCPart b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(ArrayList<PCPart> listB) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(int id, PCPart b) {
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
