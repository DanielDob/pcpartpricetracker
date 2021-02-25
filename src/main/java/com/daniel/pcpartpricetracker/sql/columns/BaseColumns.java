package com.daniel.pcpartpricetracker.sql.columns;

import java.util.ArrayList;

public interface BaseColumns <P> {
	public static final String _ID ="id";

	public void connect();
	
	public void insert(P b);
	public void insert(ArrayList<P> listB);
	public void update(int id,P b);
	public void delete(int id);
	public void deleteAll();
}
