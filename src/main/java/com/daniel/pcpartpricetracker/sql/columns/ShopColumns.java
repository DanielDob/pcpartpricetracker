package com.daniel.pcpartpricetracker.sql.columns;

import java.util.ArrayList;

import com.daniel.pcpartpricetracker.objects.PCPart;

public interface ShopColumns extends BaseColumns<PCPart.Shop>{
	
	public static final String PRICE_TABLE="price";
	
	public static final String PC_PART_ID="pc_part_id";
	public static final String SHOP_ID= "shop_id";
	public static final String PRICE = "price";
	
}
