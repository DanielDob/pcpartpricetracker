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
		switch(name) {
			case "add":
				add(args);
				break;
			case "create":
				create(args);
				break;
			case "delete":
				delete(args);
				break;
			case "remove":
				remove(args);
				break;
			case "xlsx":
				xlsx(args);
				break;
		}
		return false;
	}
	private void add(String[] args) {
		// TODO Auto-generated method stub
		
	}
	private void create(String[] args) {
		// TODO Auto-generated method stub
		
	}
	private void delete(String[] args) {
		// TODO Auto-generated method stub
		
	}
	private void remove(String[] args) {
		// TODO Auto-generated method stub
		
	}
	private void xlsx(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
