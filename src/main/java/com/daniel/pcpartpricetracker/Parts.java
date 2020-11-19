package com.daniel.pcpartpricetracker;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.daniel.pcpartpricetracker.objects.PCPart;
import com.daniel.pcpartpricetracker.objects.Shop;
import com.daniel.pcpartpricetracker.objects.Type;
import com.daniel.pcpartpricetracker.sql.logic.DatabaseManager;

import antlr.StringUtils;

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
		}
		
	}
	Shop shopClass;
	private void add(String[] args) {
		
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
		dm.run(() -> dm.getSession().save(new PCPart(partFinal,typeFinal,shopFinal)));
 	}

	private void open(String[] args) {
		// TODO Auto-generated method stub
		
	}

	private void show(String[] args) {
		DatabaseManager dm = new DatabaseManager();
		dm.run(() ->{
			
			dm.getSession().createQuery("from PCPart", PCPart.class)
		      .getResultList().forEach((e)->System.out.println(e.toString()));;
		});
		
	}

	private void xlsx(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
