package com.daniel.pcpartpricetracker;

public class Build {
	static final boolean PASS=true;
	static final boolean FAIl=false;
	/**
	 * @param name - name of build
	 * @param args - all the line entered in console.<br>[0] should be name of command.<br>[1] should be command for user wants to do.<br>[2..args.lenght-1] rest of commands. {@see com.daniel.pcpartpricetracker.Help#printBuildFullHelp()}  
	 * @return {@value #PASS} when method is fully execute, otherwise {@value #FAIL}  
	 */
	public boolean executeBuild(String name, String[] args) {
		return false;
	}

}
