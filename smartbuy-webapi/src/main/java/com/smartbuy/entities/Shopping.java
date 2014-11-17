package com.smartbuy.entities;

import java.util.Date;

import javax.persistence.*;

@Entity
public class shopping {
	@Id
	private String Id;
	private String customerId;
	private double amount;
	private boolean isPaid;
	private String billingAddress;
	private String shippingAddress;
	private Date createdTime;

}
