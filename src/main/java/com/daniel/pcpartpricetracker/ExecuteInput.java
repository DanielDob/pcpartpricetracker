package com.daniel.pcpartpricetracker;

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
			Scrap.executeCrap();
			break;
		case "part":
			parts.executePart(next.split(" ")[1],next.split(" "));
			break;
		case "q":
		case "quit":
			System.exit(0);
		default:
			Help.printFullHelp();
			break;
		}
	}
}
