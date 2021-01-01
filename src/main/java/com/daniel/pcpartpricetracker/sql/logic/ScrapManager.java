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
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import antlr.StringUtils;

public class ScrapManager {

	private int shopID;
	private Document doc =null;
	String name;
	double price;
	
	/*private Session session=null;
	public void run(Submitter s) {
		submit(s);
	}
	private void  submit(Submitter s){
		s.submit();
	}*/
	public ScrapManager(int shopID) {
		this.shopID=shopID;
	}
	private Document open(int id) {
		String path = "";
		switch(shopID) {
			case 1:
				path ="https://x-kom.pl/p/"+id;
				break;
			case 2:
				path="https://morele.net/";
				break;
		}
		switch(shopID) {
			case 1:
				try {
					doc = Jsoup.connect(path)
								  .timeout(3000)
								  .followRedirects(true)
								  .post();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		break;
			case 2:
				WebClient client = new WebClient();
				HtmlPage page;
				try {
					client.getOptions().setThrowExceptionOnScriptError(false);
					page = client.getPage(path);
					((HtmlInput ) page.getFirstByXPath("//input[@class='form-control quick-search-autocomplete']")).setValueAttribute(id+"");
				// create a submit button - it doesn't work with 'input'
				HtmlElement button = (HtmlElement) page.getFirstByXPath("//button[@class='btn btn-blue h-quick-search-submit']");

				page = button.click();
				path = page.getBaseURI();
				} catch (/*FailingHttpStatusCodeException | IOException |*/ Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//Element elb = doc.selectFirst("button.btn.btn-blue.h-quick-search-submit");
			try {
				doc = Jsoup.connect(path)
						  // and other fields which are being passed in post request.
						  .userAgent("Mozilla")
						  .post();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
		}
		return doc;
	}

	private String[] getSitesPaths() {
		switch(shopID) {
			case 1:
				return new String[] {"div.u7xnnm-4","h1.sc-1x6crnh-5"}; 
			case 2:
				return new String[] {"div#product_price_brutto","h1.prod-name"};
			default:
				return null;
		}
	}
	
	public void getItem(int id) {
		doc  = open(id);
		String[] xpaths = getSitesPaths();
		//it class search does not work
		//Elements newsHeadlines = doc.select("/html/body/div[2]/div[2]/div/div/div[1]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div/div");
		//Elements newsHeadlines = doc.select("div:eq(2)/div:eq(2)/div/div/div:eq(1)/div:eq(3)/div:eq(2)/div:eq(2)/div:has(2)/div/div:eq(1)/div/div".replace("/", ">"));
		String priceString="";
		Elements newsHeadlines = doc.select(xpaths[0]);
		 for (Element headline : newsHeadlines) {
			 switch(shopID) {
				 case 1:
					 priceString = headline.ownText();
					 break;
				 case 2 :
					 priceString = headline.attr("data-default");
					 break;
			 }
			price=Double.valueOf(priceString.replace(',','.').replaceAll(" ","").substring(0,priceString.replaceAll(" ","").length()-2));
		}

		newsHeadlines = doc.select(xpaths[1]);
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
