package com.daniel.pcpartpricetracker;

import java.util.Scanner;
import java.util.prefs.Preferences;

import com.daniel.pcpartpricetracker.sql.logic.DatabaseManager;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args )
    {
    	Preferences prefs = Preferences.userNodeForPackage(App.class);
    	String FirstRun = "first_run";
        boolean firstRun = prefs.getBoolean(FirstRun, true);
        if(firstRun) {
        	DatabaseManager dbm = new DatabaseManager();
        	dbm.initFirstRun();
        	prefs.putBoolean(FirstRun, false);
        }
        @SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
        while (true)
        	new ExecuteInput(s.nextLine());
    }
}
