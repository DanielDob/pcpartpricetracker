package com.daniel.pcpartpricetracker;

import java.util.ArrayList;

import com.daniel.pcpartpricetracker.objects.PCPart;
import com.daniel.pcpartpricetracker.objects.Price;
import com.daniel.pcpartpricetracker.sql.logic.DatabaseManager;
import com.daniel.pcpartpricetracker.sql.logic.ScrapManager;

public class Scrap {

	public static void executeCrap(long time) {
		DatabaseManager dm = new DatabaseManager();
		
		for(int i =1;i<3;i++) {
			int shopID=i;
			ArrayList<PCPart>  parts = dm.collector(() ->(ArrayList<PCPart>)dm.getSession().createQuery("from PCPart as p where p.shop=:s", PCPart.class)
					.setCacheable(true)
					.setParameter("s", shopID)
				.getResultList()
			);
			ScrapManager sm = new ScrapManager(shopID);
			for(PCPart p : parts) {
				dm.run(() -> {
					double price = sm.getPrice();
					String name = sm.getName();
					dm.getSession().save(new Price(p.getCode(),shopID,price, time)); //TODO one time for all parts at one measure
				});
			}
		}
	}

	

}
