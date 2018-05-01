package com.cts.rbc.basket;

import java.util.Map;

public interface ShoppingBasket {
	public void addItem(String item);
	public Double calculateTotalCost();
	public Map<String, Integer> getAllItems();
	
}
