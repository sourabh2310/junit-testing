package com.cognizant.junit;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

import com.cognizant.junit.exception.EmptyBasketException;
import com.cognizant.junit.exception.ItemNotFoundException;

public class CostTest {

	// Test to check if the basket is empty
	@Test(expected = EmptyBasketException.class)
	public void testItemCheck_nullBasket() {
		HashMap<String, Integer> basket = new HashMap<>();
		boolean actuals = Cost.itemCheck(basket);
		boolean expecteds = true;
		assertEquals(expecteds, actuals);

	}

	// Test to check if basket contains some unavailable items
	@Test(expected = ItemNotFoundException.class)
	public void testItemCheck_invalidItem() {
		HashMap<String, Integer> basket = new HashMap<>();
		basket.put("Oranges", 10);
		basket.put("Apples", 5);
		basket.put("Mangoes", 20);
		basket.put("Peaches", 7);
		boolean actuals = Cost.itemCheck(basket);
		boolean expecteds = true;
		assertEquals(expecteds, actuals);

	}

	// Test to check if all items are available
	@Test
	public void testItemCheck_correctItem() {
		HashMap<String, Integer> basket = new HashMap<>();
		basket.put("Oranges", 10);
		basket.put("Apples", 5);
		basket.put("Peaches", 7);
		boolean actuals = Cost.itemCheck(basket);
		boolean expecteds = true;
		assertEquals(expecteds, actuals);

	}

	// Test to check the total cost the items in the basket
	@Test
	public void testTotalCostCaluclation() {
		HashMap<String, Integer> basket = new HashMap<>();
		basket.put("Bananas", 15);
		basket.put("Oranges", 10);
		basket.put("Apples", 5);
		basket.put("Lemons", 20);
		basket.put("Peaches", 7);
		double actuals = Cost.totalCostCaluclation(basket);
		double expecteds = 2420;
		assertEquals(expecteds, actuals, 0);

	}
}
