package com.daniel.pcpartpricetracker.sql;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.daniel.pcpartpricetracker.sql.logic.DatabaseManager;

public class Init {
	
	@Test
	public void fileExists() {
		DatabaseManager dbm = new DatabaseManager();
		assertNotNull(dbm.isConnected());
	}
	@Test
	public void tablesExists() {
		
	}
	@Test
	public void methodsExists() {
		
	}
}
