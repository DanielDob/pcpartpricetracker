package com.daniel.pcpartpricetracker.sql.logic;

import java.sql.Connection;
import java.util.ArrayList;

import com.daniel.pcpartpricetracker.objects.PCBuild;
import com.daniel.pcpartpricetracker.sql.columns.BuildColumns;
import com.daniel.pcpartpricetracker.sql.columns.PCBuildColumns;

public class PCBuildManager implements BuildColumns,PCBuildColumns{

	Connection conn;
	public PCBuildManager() {
		conn=connect();
	}
	@Override
	public Connection connect() {
		DatabaseManager dbm = new DatabaseManager();
		return dbm.isConnected();
		
	}

	@Override
	public void insert(PCBuild b) {
		// TODO Auto-generated method stub
	}

	@Override
	public void insert(ArrayList<PCBuild> listB) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(int id, PCBuild b) {
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
