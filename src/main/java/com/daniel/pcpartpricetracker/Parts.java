package com.daniel.pcpartpricetracker;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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
		Document doc =null;
		try {
			File f = new File("xkom.html");
			doc = Jsoup.parse(f, "UTF-8");
			//"//https://www.x-kom.pl/p/"+args[2]
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Elements newsHeadlines = doc.select("div.u7xnnm-4.dtpmby");
		for (Element headline : newsHeadlines) {
			System.out.println(headline.ownText());
		}
		newsHeadlines = doc.select("h1.sc-1x6crnh-5.gJXkXi");
		for (Element headline : newsHeadlines) {
			System.out.println(headline.ownText());
		}
	}

	private void open(String[] args) {
		// TODO Auto-generated method stub
		
	}

	private void show(String[] args) {
		// TODO Auto-generated method stub
		
	}

	private void xlsx(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
