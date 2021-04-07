package com.daniel.pcpartpricetracker;

import com.daniel.pcpartpricetracker.objects.Type;

public class Help {
	
	public static void printFullHelp(){
		printBuildFullHelp(false);
		printPartFullHelp(false);
		printScrapFullHelp(false);
		System.out.println();
		printTerminologyUsedInFullHelp();
		
			
	}
	public static void printTerminologyUsedInFullHelp() {
		System.out.println(	"date - dd.MM.yyyy\n"
				+ "number - number in link in ceneo\n"
				+ "type - "+(new Type().toString()));
		
	}
	public static void printScrapFullHelp(boolean b) {
		System.out.println( "scrap"
				+ "\n\tGo scrap");
		/*
		 * if(b)
		 * 	prints terminology used
		 */
		
	}
	public static void printPartFullHelp(boolean b) {
		System.out.println(
				 "part"
					+ "\n\tadd [code] [type] [shop]"
					+ "\n\t\tAdding new part to tracking price. Shop can be a number id."
					+ "\n\topen [number]|"
					+ "\n\t\tOpens in broser part"
					+ "\n\tshow [-all] | [ [number] [-h|-h=[[startDate],[endDate]]  [part=[partID | partName] ] ] [-p | -d]"
					+ "\n\t\tDispalying part information by default shows only full name and code. -p,-d shows also prices of part/parts -h history. startDate i endDate shows prices within range od dates."
					+ "\n\txlsx ['name'] [-a] [-d [date]]"
					+ "\n\t\tSave history to xlsx file. -a all. -d date."
					);
		if(b)
			printTerminologyUsedInFullHelp();
			
		
	}
	public static void printBuildFullHelp(boolean b) {
		System.out.println(
				"build"
				+ "\n\tadd ['name'] [number, number,...]"
				+ "\n\t\tAdds new parts to build"
				+ "\n\tcreate ['name'] [number, number,...]"
				+ "\n\t\tCreates new build"
				+ "\n\tdelete ['name']"
				+ "\n\t\tDeletes build"
				+ "\n\tremove ['name'] [number, number,...]"
				+ "\n\t\tRemoves parts"
				+ "\n\txlsx ['name'] [-a] [-d [date]]"
				+ "\n\t\tSave history to xlsx file. -a all. -d date."
				);
		if(b)
			printTerminologyUsedInFullHelp();
	}
}
