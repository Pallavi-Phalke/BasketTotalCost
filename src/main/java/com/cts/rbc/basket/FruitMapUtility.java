package com.cts.rbc.basket;


	import java.util.HashMap;
	import java.util.Map;

	public class FruitMapUtility {
		public static Map<String,Double> itemMap= new HashMap<String,Double>();
		
		/**
		 * Currently hardcoded the data but can be fetched from DB also
		 */
		static{
			
			itemMap.put("Bananas",10.0);
			itemMap.put("Apples",120.0);
			itemMap.put("Oranges",80.0);
			itemMap.put("Lemons",40.0);
			itemMap.put("Peaches",150.0);
			
		}
	}

