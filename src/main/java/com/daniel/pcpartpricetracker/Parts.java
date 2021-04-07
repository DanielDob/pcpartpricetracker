package com.daniel.pcpartpricetracker;

import java.awt.Desktop;
import java.net.URI;
import java.util.ArrayList;
import com.daniel.pcpartpricetracker.objects.PCPart;
import com.daniel.pcpartpricetracker.objects.Shop;
import com.daniel.pcpartpricetracker.objects.Type;
import com.daniel.pcpartpricetracker.sql.logic.DatabaseManager;
import com.daniel.pcpartpricetracker.sql.logic.ScrapManager;

public class Parts {
	
	public void executePart(String name, String[] args) {
		switch(name) {
			case "add":
				add(args);
				break;
			case "open":
				open(args);
				break;
			case "show":
				show(args);
				break;
			case "xlsx":
				xlsx(args);
				break;
			case "help":
				Help.printPartFullHelp(false);;
				break;
		}
		
	}
	Shop shopClass;
	private void add(String[] args) {
		//TODO name scratch
		int part=-1,type=-1,shop=-1;
		try {  
		   part = Integer.parseInt(args[2]);  
		 } catch(NumberFormatException e){  
		   System.out.println("[ERROR] Wrong part id.\n"+e.getMessage()); 
		 }  
		try {  
		   type = Integer.parseInt(args[3]);  
		 } catch(NumberFormatException e){  
			 new Type();
			 type=Type.stringToId.get(args[3]);
		 }  
		try {  
		   shop = Integer.parseInt(args[4]);  
		 } catch(NumberFormatException e){  
			shop = new Shop(args[4]).getId();
		 }  
		DatabaseManager dm = new DatabaseManager();
		int partFinal=part, typeFinal=type,shopFinal=shop;
		ScrapManager sm = new ScrapManager(shopFinal);
		sm.getItem(partFinal);
		double price = sm.getPrice();
		String name = sm.getName();
		dm.run(() -> {
			//dm.getSession().save(new Price(partFinal,shopFinal,price, new Date().getTime())); //TODO one time for all parts at one measure
			dm.getSession().save(new PCPart(partFinal,typeFinal,shopFinal,name));
		});
 	}

	private void open(String[] args) {
		Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
	    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
	        try {
	            desktop.browse(new URI("https://www.x-kom.pl/p/"+args[2]));
	        }catch(Exception e) {
	        	e.printStackTrace();
	        }
	    }
		
	}

	private void show(String[] args) {
		if(args.length<3) {
			System.out.println("Missing third word");
			return;
		}
		DatabaseManager dm = new DatabaseManager();
		ArrayList<PCPart> partsList=new ArrayList<PCPart>() {};
		partsList=dm.collector(() ->(ArrayList<PCPart>)dm.getSession().createQuery("from PCPart", PCPart.class)
												.getResultList()
		);
		if(args[2].equals("-all")) {
			partsList.forEach(e->System.out.println(e));
		}
		
		
	}

	private void xlsx(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
