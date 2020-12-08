package com.cognizant.junit;

import java.util.HashMap;
import java.util.Scanner;

import com.cognizant.junit.exception.EmptyBasketException;
import com.cognizant.junit.exception.ItemNotFoundException;

public class Cost {

	// Item Names
	static String[] item = { "Bananas", "Oranges", "Apples", "Lemons", "Peaches" };
	
	// Respective Item Prices
	static int[] price = { 40, 50, 100, 20, 60 };

	//Method to take items from user
	public static void itemInput() {
		Scanner sc = new Scanner(System.in);
		int option;
		String item;
		int quantity;
		HashMap<String, Integer> basket = new HashMap<>();
		do {
			System.out.println("Welcome to Mart \n " + "1.Add new Item \n " + "2. Calculate Cost \n " + "3. Exit");
			option = sc.nextInt();
			if (option == 1) {
				System.out.println("Bananas : 40 \n" + " Oranges : 50 \n" + " Apples : 100 \n" + " Lemons : 20 \n"
						+ " Peaches : 60 \n" + "Enter item:");
				item = sc.next();
				System.out.println("Enter quantity");
				quantity = sc.nextInt();
				basket.put(item, quantity);
			}
			if (option == 2) {
				itemCheck(basket);     // Calling itemCheck() Method to check whether item is available or not
				totalCostCaluclation(basket);    // Calling totalCostCalculation() method to calculate total cost of the items.
			}
			if (option < 1 || option > 3) {
				System.out.println("Invalid Input, Choose correct option.");
			}
		} while (option != 3);
	}

	public static boolean itemCheck(HashMap<String, Integer> basket) {

		int count = 0;
		if (basket.isEmpty()) {                                       // if no item is available in basket 
			throw new EmptyBasketException("No item has been added");      
		}
		for (String str : basket.keySet()) {
			count = 0;
			for (int i = 0; i < 5; i++) {
				if (str.equals(item[i])) {
					count++;
				}
			}
			if (count != 1) {                            // if a particular item is not available 
				throw new ItemNotFoundException(str + " not available");
			}
		}
		return true;
	}

	public static double totalCostCaluclation(HashMap<String, Integer> basket) {
		double cost = 0;
		for (String str : basket.keySet()) {
			for (int i = 0; i < 5; i++) {
				if (str.equals(item[i])) {
					cost = cost + price[i] * basket.get(str);           // Calculates the total cost of the basket items.
				} 
			}
		}
		return cost;
	}
}
