package com.cts.rbc.basket;

import java.util.HashMap;
import java.util.Map;

import com.cts.rbc.basket.exceptions.ItemNotFoundException;

public class ShoppingBasketImpl implements ShoppingBasket{

	private Map<String,Integer> basket=null;
	private Double totalCost=0.0;
	/**
	 * This method adds the fruit to the list of basket 
	 * and forms the hashmap to store count of each fruit items in the list
	 * If wrong item is added it will throw an exception 
	 *  
	 */
	public void addItem(String item)
	{
		
		try{
			if(FruitMapUtility.itemMap.containsKey(item)) {
				if(basket == null){
					basket= new HashMap<String,Integer>();
				}
				
				{
					int count;
					if(!basket.containsKey(item)){
						 count=0;
						basket.put(item, count+1);
					}else{
						count=basket.get(item);
						basket.put(item, count+1);
					}
				}
				
				
			}
			else{
				throw new ItemNotFoundException("Incorrect item type");

			}
			
		}catch(Exception e){
			e.printStackTrace();	
		}		
	}
	/**
	 * Method calculateTotalCost calculates the total cost of fruit items purchased.
	 * 
	 * **/
	public Double calculateTotalCost(){
		if(basket!=null){
			for(Map.Entry<String, Integer> item : basket.entrySet()){
				totalCost=totalCost+(item.getValue())*(FruitMapUtility.itemMap.get(item.getKey()));
			}
			
		}
		return totalCost;
	}
	/**
	 * Method getAllItems() returns the hashmap containing list of all fruit items selected and repeated count for each fruit item mapped respectively
	 * 
	 * **/
	public Map<String, Integer> getAllItems(){
		Map<String, Integer> allItems = new HashMap<String, Integer>();
		if(basket!=null)
		allItems.putAll(basket);
		return allItems;
		
	}
	
	
}
