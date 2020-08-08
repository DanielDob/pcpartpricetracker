package com.daniel.pcpartpricetracker.sql.columns;

import java.util.ArrayList;

import com.daniel.pcpartpricetracker.Build;
import com.daniel.pcpartpricetracker.objects.PCBuild;

public interface PCBuildColumns  extends BaseColumns<PCBuild>{
	
	public static final String PC_BUILD_TABLE="pc_build";
	
	public static final String NAME = "name";

}
