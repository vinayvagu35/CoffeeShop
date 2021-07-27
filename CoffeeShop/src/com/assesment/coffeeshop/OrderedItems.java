package com.assesment.coffeeshop;

public class OrderedItems {
	private String itemName;
	private double itemPrice;
	private String itemType;
	private double isExtra=0;
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public double getIsExtra() {
		return isExtra;
	}
	public void setIsExtra(double d) {
		this.isExtra = d;
	}
}
