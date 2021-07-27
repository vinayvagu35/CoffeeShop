package com.assesment.coffeeshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoffeeShop {
	
	static Scanner input = new Scanner(System.in);
	
	public static void printMenu() {
		System.out.println("--------------------------------------------");
  	    System.out.println("\t CHARLENE'S COFFEE CORNER");
    	System.out.println("--------------------------------------------");
    	System.out.println("\t\t YOUR MENU");
    	System.out.println("--------------------------------------------");
    	System.out.println("BEVERAGES");
    	System.out.println("---------");
    	System.out.println("1. COFFEE");
    	System.out.println("\t SMALL - 2.50CHF");
    	System.out.println("\t MEDIUM - 3.00CHF");
    	System.out.println("\t LARGE - 3.50CHF");
    	System.out.println("2. FRESHLY SQUEEZED ORANGE JUICE(250ml) - 3.95CHF");
    	System.out.println("\n");
    	System.out.println("SNACKS");
    	System.out.println("3. BACON ROLL - 4.50CHF");
    	System.out.println("\n");
    	System.out.println("EXTRAS");
    	System.out.println("\t MILK - 0.30CHF");
    	System.out.println("\t FOAMED MILK - 0.50CHF");
    	System.out.println("\t SPECIAL ROAST COFFEE - 0.90CHF");
    	System.out.println("--------------------------------------------");
  	    System.out.println("\t ********* OFFERS *********");
    	System.out.println("--------------------------------------------");
    	System.out.println(" 1. EVERY 5th BEVERAGE IS FOR FREE");
    	System.out.println(" 2. IF THE BEVERAGE AND A SNACK, ONE OF THE EXTRA'S IS FREE");
    }
	
	public static void orderProcessing() {
		String options;
		int beverageCount=0;
		int beverageOfferCount=0;
		int snackCount=0;
		List<Integer> offeredBeveragesItemsIndex = new ArrayList<Integer>();	
		
		
		//SETTING CUSTOMER NAME		
		Customer cust = new Customer();
		System.out.println("\nEnter Your Name:");
		options = input.nextLine();
		cust.setCustName(options.toUpperCase());
		
		//SETTING CUSTOMER STAMP ID		
		System.out.println("\nEnter Your StampId:");
		options = input.nextLine();
		cust.setCustStampId(options);
		
		//GETTING ORDER ITEMS DETAILS
		boolean notDone=true;
		
		do
		{
			OrderedItems items = new OrderedItems();
			System.out.println("\nEnter your Item:");
			options = input.nextLine();
			
			if(options.toLowerCase().contains("coffee")) {
				
				items.setItemType("Beverage");
				
				System.out.println("\nWhat Coffee would you like to have: Small/Medium/Large");
				options = input.nextLine();
				
				if(options.toLowerCase().contains("small")) {
					items.setItemName("SMALL COFFEE");
					items.setItemPrice(2.50);
				} 
				
				else if(options.toLowerCase().contains("medium")) {
					items.setItemName("MEDIUM COFFEE");
					items.setItemPrice(3.00);
				} 
				
				else if(options.toLowerCase().contains("large")) {
					items.setItemName("LARGE COFFEE");
					items.setItemPrice(3.50);
				} 
				
				else {
					System.out.println("\nPlease enter the correct one"); 
					continue;
				}
				
				System.out.println("\nWould you like to add any Extras: Milk/Foamed Milk/Special Roast Coffee or No");
				options = input.nextLine();
				
				if(options.toLowerCase().contains("milk")) {
					items.setItemName(items.getItemName()+" WITH EXTRA MILK");
					items.setIsExtra(0.30);
				} 
				else if(options.toLowerCase().contains("foamed")) {
					items.setItemName(items.getItemName()+" WITH EXTRA FOAMED MILK");
					items.setIsExtra(0.50);					
				} 
				else if ((options.toLowerCase().contains("special")) || (options.toLowerCase().contains("roast"))) 
				{
					items.setItemName(items.getItemName()+" WITH SPECIAL ROAST COFFEE");
					items.setIsExtra(0.90);					 
				}
				beverageCount++;
				beverageOfferCount++;
			}
			
			else if ((options.toLowerCase().contains("juice")) || (options.toLowerCase().contains("orange"))) {
				items.setItemType("Beverage");
				items.setItemName("FRESHLY SQUEEZED ORANGE JUICE(250ml)");
				items.setItemPrice(3.95);
				beverageCount++;
				beverageOfferCount++;
			}
			
			else if ((options.toLowerCase().contains("roll")) || (options.toLowerCase().contains("bacon"))) {
				items.setItemType("Snack");
				items.setItemName("BACON ROLL");
				items.setItemPrice(4.50);
				snackCount++;
			}
			
			else {
				System.out.println("\nPlease enter the correct one");
				continue;
			}
			cust.itemsOrdered.add(items);
			if(beverageCount==5) {
				offeredBeveragesItemsIndex.add(cust.itemsOrdered.size()-1);
				beverageCount=0;			
			}
			
			System.out.println("\nWould you like to add another item: Yes/No");
			options = input.nextLine();
			if(options.equalsIgnoreCase("No")) { 
				notDone=false;
			}
	
		}
		while(notDone);


		//DISPLAYING THE BILL
		System.out.println("\n--------------------------------------------");
	    System.out.println("\t CHARLENE'S COFFEE CORNER");
	    System.out.println("--------------------------------------------");
	    System.out.println("\t\t" +"HELLO "+cust.getCustName());
	    System.out.println("--------------------------------------------");
	    System.out.println("\t\tYOUR BILL");
	    System.out.println("--------------------------------------------");	
	    
	    //DISPLAYING THE BEVERAGES
	    if (beverageOfferCount>0) {
			System.out.println("BEVERAGES");
			System.out.println("---------");
			for (int itemsOrderedIterator=0; itemsOrderedIterator<cust.itemsOrdered.size();itemsOrderedIterator++) {
				if(cust.itemsOrdered.get(itemsOrderedIterator).getItemType().toLowerCase().contains("beverage")) {
				    System.out.printf("%s%s", cust.itemsOrdered.get(itemsOrderedIterator).getItemName().toString(), (cust.itemsOrdered.get(itemsOrderedIterator).getItemPrice()+cust.itemsOrdered.get(itemsOrderedIterator).getIsExtra()));
				    System.out.print("CHF\n");
				}  
			}
	    }
	    //DISPLAYING THE SNACKS
	    if(snackCount>0) {
	    	System.out.println("---------");
	    	System.out.println("SNACKS");
	    	System.out.println("---------");
	    	for (int itemsOrderedIterator=0; itemsOrderedIterator<cust.itemsOrdered.size();itemsOrderedIterator++) {
	    		if(cust.itemsOrdered.get(itemsOrderedIterator).getItemType().toLowerCase().contains("snack")) {
	    			System.out.printf("%s%s", cust.itemsOrdered.get(itemsOrderedIterator).getItemName().toString(), cust.itemsOrdered.get(itemsOrderedIterator).getItemPrice());
	    			System.out.print("CHF\n");
	    		}    
		 
	    	}
	    }
   
	    //CALCULATING TOTAL AMOUNT	
		double totalAmount= 0;	
		for (int itemsOrderedIterator=0; itemsOrderedIterator<cust.itemsOrdered.size();itemsOrderedIterator++) {
			totalAmount = totalAmount + cust.itemsOrdered.get(itemsOrderedIterator).getItemPrice()+cust.itemsOrdered.get(itemsOrderedIterator).getIsExtra();
		}
		
		//FORMATTING THE AMOUNT	
		cust.setTotalAmount(cust.setAmountFormat(totalAmount));	
		
		//DISPLAYING THE TOTAL AMOUNT
		System.out.println("--------------------------------------------");
		System.out.println("YOUR TOTAL AMOUNT IS " + cust.getTotalAmount() );
	
	
		//DISPLAYING OFFERED MENU	
		boolean isDiscount=false;
	
		while (snackCount>0&&beverageOfferCount>0) {
			for (int itemsOrderedIterator=0; itemsOrderedIterator<cust.itemsOrdered.size();itemsOrderedIterator++) {
				if(cust.itemsOrdered.get(itemsOrderedIterator).getIsExtra()>0) {
					System.out.println("IF THE BEVERAGE AND A SNACK, ONE OF THE EXTRA'S IS FREE OFFER");
					break;
				}
			}
	   
			for (int itemsOrderedIterator=0; itemsOrderedIterator<cust.itemsOrdered.size();itemsOrderedIterator++) {
				if(cust.itemsOrdered.get(itemsOrderedIterator).getItemType().toLowerCase().contains("beverage")&& cust.itemsOrdered.get(itemsOrderedIterator).getIsExtra()>0) {
					double discountAmount = cust.getTotalAmount() - cust.itemsOrdered.get(itemsOrderedIterator).getIsExtra();;
					cust.setTotalAmount(cust.setAmountFormat(discountAmount));
					System.out.printf("EXTRA OF THE DRINK - " + cust.itemsOrdered.get(itemsOrderedIterator).getItemName().toString()+" IS FREE\n");
					isDiscount=true;
				}
			}
			snackCount--;
			beverageOfferCount--;
		}
	
		if(offeredBeveragesItemsIndex.size()>0) {
			System.out.println("--------------------------------------------");	 
			System.out.println("\tEVERY 5TH BEVERAGE IS FOR FREE - OFFERED ITEMS");
			System.out.println("--------------------------------------------\n");
			for(int offeredBeveragesItemsIndexIterator=0; offeredBeveragesItemsIndexIterator<offeredBeveragesItemsIndex.size();offeredBeveragesItemsIndexIterator++) {	
				int itemsOrderedIterator=offeredBeveragesItemsIndex.get(offeredBeveragesItemsIndexIterator);
				System.out.println("\n"+cust.itemsOrdered.get(itemsOrderedIterator).getItemName().toString());
				double discountAmount = cust.getTotalAmount() - cust.itemsOrdered.get(itemsOrderedIterator).getItemPrice()-cust.itemsOrdered.get(itemsOrderedIterator).getIsExtra();;
				cust.setTotalAmount(cust.setAmountFormat(discountAmount));
				isDiscount=true;
			}
		}
		if(isDiscount) {	 
			System.out.println("YOUR PAYABLE AMOUNT AFTER DISCOUNT: " + cust.getTotalAmount()+"CHF");
		}	
	} 
	public static void main(String[] args) {
		printMenu();
		orderProcessing();
	}

}
