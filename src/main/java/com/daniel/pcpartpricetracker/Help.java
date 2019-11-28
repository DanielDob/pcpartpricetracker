package com.daniel.pcpartpricetracker;

public class Help {
	
	public static void printFullHelp(){
		printBuildFullHelp(false);
		printPartFullHelp(false);
		printScrapFullHelp(false);
		System.out.println();
		printTerminologyUsedInFullHelp();
		
			
	}
	private static void printTerminologyUsedInFullHelp() {
		System.out.println(	"date - dd.MM.yyyy\n"
				+ "number - number in link in ceneo"
				+ "type - cpu|gpu|ps|mobo|hdd|sdd|cooler|case|fan|ram|m2|psu");
		
	}
	private static void printScrapFullHelp(boolean b) {
		System.out.println( "scrap\n"
				+ "\tGo scrap");
		/*
		 * if(b)
		 * 	prints terminology used
		 */
		
	}
	private static void printPartFullHelp(boolean b) {
		System.out.println(
				 "part\n"
					+ "\tadd [number] [type]\n"
					+ "\t\tAdding new part to tracking price\\n"
					+ "\topen [number]|\n"
					+ "\t\tOpens in broser part\n"
					+ "\tshow [[number] | [-all]] [-d] [-h|-h [date][date]] [-sn]\n"
					+ "\t\tDispalying part information by default shows only full name. -d details. -h history. -sn short name."
					+ "\txlsx ['name'] [-a] [-d [date]]\n"
					+ "\t\tSave history to xlsx file. -a all. -d date.\n"
					);
		if(b)
			printTerminologyUsedInFullHelp();
			
		
	}
	public static void printBuildFullHelp(boolean b) {
		System.out.println(
				"build\n"
				+ "\tadd ['name'] [number, number,...]"
				+ "\t\tAdds new parts to build"
				+ "\tcreate ['name'] [number, number,...]"
				+ "\t\tCreates new build"
				+ "\tdelete ['name']"
				+ "\t\tDeletes build"
				+ "\tremove ['name'] [number, number,...]"
				+ "\t\tRemoves parts"
				+ "\txlsx ['name'] [-a] [-d [date]]"
				+ "\t\tSave history to xlsx file. -a all. -d date. "
				);
		if(b)
			printTerminologyUsedInFullHelp();
	}
}
