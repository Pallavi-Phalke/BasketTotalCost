package com.cts.rbc.basket;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.cts.rbc.basket.exceptions.ItemNotFoundException;

public class BasketCalculateTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testAddingItemsInBasket() {
		ShoppingBasket b = new ShoppingBasketImpl();
		
		b.addItem("Bananas");
		b.addItem("Bananas");
		b.addItem("Apples");
		b.addItem("Apples");
		b.addItem("Apples");
		b.addItem("Lemons");

		String actual = Double.toString(b.calculateTotalCost());
		
		assertEquals("420.0", actual);
	}
	
	@Test
	public void testGetAllItemsFromBasket() {
		ShoppingBasket b = new ShoppingBasketImpl();
		
		b.addItem("Bananas");
		b.addItem("Oranges");
		b.addItem("Bananas");
		b.addItem("Apples");
		b.addItem("Apples");
		b.addItem("Apples");
		b.addItem("Lemons");
		final Map<String, Integer> allItems = b.getAllItems();
		assertEquals(4, allItems.size());
		assertEquals(2, allItems.get("Bananas").intValue());
		assertEquals(3, allItems.get("Apples").intValue());
		
	}
	
	@Test
	public void testAddingWrongItemsInBasket() {
		ShoppingBasket b = new ShoppingBasketImpl();
		
		b.addItem("Watermelon");
		String actual = Double.toString(b.calculateTotalCost());//.calculateCost());
		
		assertEquals("0.0", actual);
		
	}
	
	@Test(expected = AssertionError.class)
	public void testFooThrowsIndexOutOfBoundsException() throws ItemNotFoundException {
	  boolean thrown = false;
	  ShoppingBasket b = new ShoppingBasketImpl();
	  b.addItem("Watermelon");
	  assertTrue(thrown);
	}
	
	
	
}
