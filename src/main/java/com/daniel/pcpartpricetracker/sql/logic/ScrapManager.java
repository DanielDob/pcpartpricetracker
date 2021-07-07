package com.daniel.pcpartpricetracker.sql.logic;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class ScrapManager {

	private int shopID;
	private Document doc =null;
	String name;
	String[] shops;
	double price;
	double[] prices;
	
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
			case 3:
				path="https://www.ceneo.pl/"+id;
				break;
		}
		switch(shopID) {
			case 1:
			case 3:
				try {
					doc = Jsoup.connect(path)
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
					HtmlElement button = (HtmlElement) page.getFirstByXPath("//button[@class='btn btn-primary h-quick-search-submit']");
					//HtmlElement button = (HtmlElement) page.getFirstByXPath("//button[@class='btn btn-blue h-quick-search-submit']");

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
				return new String[] {"div.u7xnnm-4","h1.sc-1bker4h-4"}; 
			case 2:
				return new String[] {"div#product_price_brutto","h1.prod-name"};
			case 3: 
				//"span.value","span.penny","div.product-top-2020__product-info__tags", "div.product-offer-2020__container.clickable-offer.js_offer-container-click.js_product-offer"
				//"li.product-offers-2020__list__item.js_productOfferGroupItem",
				return new String[] {"span.price","span.value","span.penny","div.product-offer-2020__container","h1.product-top-2020__product-info__name" }; 
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
				 case 3 : 
					 priceString = headline.select(xpaths[1]).get(0).ownText()+""+headline.select(xpaths[2]).get(0).ownText();
					 break;
			 }
			price=Double.valueOf(priceString.replace(',','.').replaceAll(" ","").substring(0,priceString.replaceAll(" ","").length()-2));
		}

		newsHeadlines = doc.select(xpaths[shopID!=3 ? 1 :  4]);
		for (Element headline : newsHeadlines) {
			name=(headline.ownText());
		}
	}
	public void getItems(int id) {
		doc  = open(id);
		String priceString="";
		String[] xpaths = getSitesPaths();
		Elements newsHeadlines = doc.select(xpaths[0]);
		prices = new double[newsHeadlines.size()];
		shops = new String[newsHeadlines.size()];
		 for (int i=0;i <newsHeadlines.size();i++) {
			 switch(shopID) {
				 case 3:
					 prices[i]=Double.parseDouble((newsHeadlines.get(i).select(xpaths[1]).first().ownText()+newsHeadlines.get(i).select(xpaths[2]).first().ownText()).replace(',','.'));
					 shops[i]=newsHeadlines.get(i).select(xpaths[3]).first().attr("data-ShopUrl");
					 //shops[i].replace("ceneo", "");
					 break;
			 }
		 }
			
			newsHeadlines = doc.select(xpaths[4]);
			for (Element headline : newsHeadlines) {
				if(shopID!=2)
					name=headline.ownText().toString();
				else
					headline.attr("data-default");
			}
	}

	public String[] getShops() {
		return shops;
	}
	public void setShops(String[] shops) {
		this.shops = shops;
	}
	public double[] getPrices() {
		return prices;
	}
	public void setPrices(double[] prices) {
		this.prices = prices;
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
