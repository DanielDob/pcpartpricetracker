package com.daniel.pcpartpricetracker;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        @SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
        while (true)
        	new ExecuteInput(s.next());
    }
}
