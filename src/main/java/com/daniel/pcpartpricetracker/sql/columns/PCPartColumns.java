package com.daniel.pcpartpricetracker.sql.columns;

import java.util.ArrayList;

import com.daniel.pcpartpricetracker.objects.PCPart;

public interface PCPartColumns extends BaseColumns<PCPart>{
	
	public static final String PC_PART_TABLE="pc_part";
	
	public static final String NAME ="name"; 
	public static final String TYPE = "type";
	
	
}
