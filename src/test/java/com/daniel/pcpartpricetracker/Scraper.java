package com.daniel.pcpartpricetracker;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import com.daniel.pcpartpricetracker.sql.logic.ScrapManager;

public class Scraper {
	//@Test
	public void scrap() {
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
		assertTrue(true);
	}
	@Test
	public void scrapXKom() {
		ScrapManager cm = new ScrapManager(1);
		cm.getItem(597348);
		System.out.println("Xkom"+cm.getName()+"  "+cm.getPrice());
	}
	@Test
	public void scrapMorele() {
		ScrapManager cm = new ScrapManager(2);
		cm.getItem(6409532);
		System.out.println("morele"+cm.getName()+"  "+cm.getPrice());
	}
}
