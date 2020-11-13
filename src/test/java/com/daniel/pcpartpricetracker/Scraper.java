package com.daniel.pcpartpricetracker;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class Scraper {
	@Test
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
}
