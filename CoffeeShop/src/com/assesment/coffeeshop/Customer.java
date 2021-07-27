package com.assesment.coffeeshop;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Customer {
	
	private String custStampId;
	private String custName;
	
	List<OrderedItems> itemsOrdered = new ArrayList<OrderedItems>();
	private double totalAmount;

	public String getCustStampId() {
		return custStampId;
	}

	public void setCustStampId(String custStampId) {
		this.custStampId = custStampId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public List<OrderedItems> getItemsOrdered() {
		return itemsOrdered;
	}

	public void setItemsOrdered(List<OrderedItems> itemsOrdered) {
		this.itemsOrdered = itemsOrdered;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double setAmountFormat(double amount)
	{
		DecimalFormat df = new DecimalFormat("#.##");
		return Double.parseDouble(df.format(amount));
	
    }
}
