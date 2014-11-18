package com.smartbuy.entities;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "shopping", schema = "smartbuy@SmartBuy")
public class Shopping {
	@Id
	private String Id;
	@Column
	private String customerId;
	@Column
	private double amount;
	@Column
	private boolean isPaid;
	
	private String billingAddress;
	private String shippingAddress;
	private Date createdTime;

}
