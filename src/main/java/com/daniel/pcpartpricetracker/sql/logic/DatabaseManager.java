package com.daniel.pcpartpricetracker.sql.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.daniel.pcpartpricetracker.sql.columns.*;

public class DatabaseManager {
	private Connection conn = null;
	
	public DatabaseManager() {
		connect();
	}
	public void initFirstRun() {
		createTables();
	}
	
	private void connect() {
	    try {
	        // db parameters
	        String url = "jdbc:sqlite:pcpartpickerdatabase.db";
	        // create a connection to the database
	        conn = DriverManager.getConnection(url);
	        
	        System.out.println("Connection to SQLite has been established.");
	        
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    } finally {
	       
	    }
	}
	public void createTables() {
		Statement st;
		try {
			st = conn.createStatement();
			
			String[] tables = {"CREATE TABLE IF NOT EXISTS "+BuildColumns.BUILD_TABLE+" ( "+BuildColumns._ID+" integer PRIMARY KEY, "+BuildColumns.PC_BUILD_ID+" integer NOT NULL,"+BuildColumns.PC_PART_ID+" integer NOT NULL)",
					"CREATE TABLE IF NOT EXISTS "+PCBuildColumns.PC_BUILD_TABLE+" ( "+PCBuildColumns._ID+" integer PRIMARY KEY, "+PCBuildColumns.NAME+" text NOT NULL)",
					"CREATE TABLE IF NOT EXISTS "+PCPartColumns.PC_PART_TABLE+" ( "+PCPartColumns._ID+" integer PRIMARY KEY, "+PCPartColumns.NAME+" text NOT NULL,"+PCPartColumns.TYPE+" integer NOT NULL)",
					"CREATE TABLE IF NOT EXISTS "+ShopColumns.PRICE_TABLE+" ( "+ShopColumns._ID+" integer PRIMARY KEY, "+ShopColumns.PC_PART_ID+" integer NOT NULL,"+ ShopColumns.PRICE+" real NOT NULL)"};
			for(String s : tables)
				st.execute(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection  isConnected() {
		return conn;
	}
}
