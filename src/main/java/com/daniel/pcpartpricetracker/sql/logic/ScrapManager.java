package com.daniel.pcpartpricetracker.sql.logic;

import java.io.File;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.daniel.pcpartpricetracker.interfaces.Submitter;

import antlr.StringUtils;

public class ScrapManager {

	String name;
	double price;
	/*private Session session=null;
	public void run(Submitter s) {
		submit(s);
	}
	private void  submit(Submitter s){
		s.submit();
	}*/
	public void getItem(int id) {
		Document doc =null;
		try {
			doc = Jsoup.connect("https://x-kom.pl/p/"+id)
						  .timeout(3000)
						  .followRedirects(true)
						  .post();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//it class search does not work
		//Elements newsHeadlines = doc.select("/html/body/div[2]/div[2]/div/div/div[1]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div/div");
		//Elements newsHeadlines = doc.select("div:eq(2)/div:eq(2)/div/div/div:eq(1)/div:eq(3)/div:eq(2)/div:eq(2)/div:has(2)/div/div:eq(1)/div/div".replace("/", ">"));
		Elements newsHeadlines = doc.select("div.u7xnnm-4");
		 for (Element headline : newsHeadlines) {
			price=Double.valueOf((headline.ownText().replace(',','.').replaceAll(" ","").substring(0,headline.ownText().length()-4)));
		}

		newsHeadlines = doc.select("h1.sc-1x6crnh-5");
		for (Element headline : newsHeadlines) {
			name=(headline.ownText());
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
