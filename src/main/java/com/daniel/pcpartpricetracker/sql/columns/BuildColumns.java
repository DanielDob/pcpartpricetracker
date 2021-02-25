package com.daniel.pcpartpricetracker.sql.columns;

import com.daniel.pcpartpricetracker.objects.PCBuild;

public interface BuildColumns extends BaseColumns<PCBuild>{
	
	public static final String BUILD_TABLE="build";
	
	public static final String PC_BUILD_ID="pc_build_id";
	public static final String PC_PART_ID="pc_part_id";
	
	
	
	
}
