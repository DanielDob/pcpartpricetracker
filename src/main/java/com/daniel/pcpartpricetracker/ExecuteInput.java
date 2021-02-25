package com.daniel.pcpartpricetracker;

import java.util.Date;

public class ExecuteInput {

	Build build = new Build();
	Parts parts = new Parts();
	public ExecuteInput(String next) {
			execute(next);			
		
	}
	private void execute(String next) {
		switch(next.split(" ")[0]) {
		case "help":
			Help.printFullHelp();
			break;
		case "build":
			build.executeBuild(next.split(" ")[1],next.split(" "));
		case "scrap":
			Scrap.executeCrap(new Date().getTime());
			break;
		case "part":
			parts.executePart(next.split(" ")[1],next.split(" "));
			break;
		case "version":
		case "v":
			System.out.println("0.1");
		case "q":
		case "quit":
			System.exit(0);
		default:
			Help.printFullHelp();
			break;
		}
	}
}
