package com.daniel.pcpartpricetracker;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.daniel.pcpartpricetracker.objects.PCPart;
import com.daniel.pcpartpricetracker.sql.logic.DatabaseManager;

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

	private void add(String[] args) {
		DatabaseManager dm = new DatabaseManager();
		dm.run(() -> dm.getSession().save(new PCPart(Integer.valueOf(args[2]),Integer.valueOf(args[3]),Integer.valueOf(args[4]))));
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
