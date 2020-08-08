package com.daniel.pcpartpricetracker.sql.columns;

import java.sql.Connection;
import java.util.ArrayList;

import com.daniel.pcpartpricetracker.objects.PCPart;

public interface BaseColumns <P> {
	public static final String _ID ="id";

	public Connection connect();
	
	public void insert(P b);
	public void insert(ArrayList<P> listB);
	public void update(int id,P b);
	public void delete(int id);
	public void deleteAll();
}
