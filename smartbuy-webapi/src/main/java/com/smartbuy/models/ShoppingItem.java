package com.smartbuy.models;

import java.util.Date;

public class ShoppingItem {
	private String id;
	private String customerId;
	private String shoppingId;
	private String commodityId;
	private String paymentId;
	
	private String property1Value;
	private String property2Value;
	private String property3Value;
	private double quantity;
	private double price;
	private double amount;
	private ShoppingItemStatus  status;
	private Date createdTime;
}
