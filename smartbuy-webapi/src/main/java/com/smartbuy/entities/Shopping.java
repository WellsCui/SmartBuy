package com.smartbuy.entities;

import java.util.Date;
import java.util.UUID;

import javax.persistence.*;



@Entity
@Table(name = "shopping", schema = "smartbuy@SmartBuy"
,indexes = {@Index(name = "index_Shopping_createdTime",  columnList="createdTime"),
		@Index(name = "index_Shopping_customerId",  columnList="customerId")}
)

public class Shopping {
	@Id
	@Column(name = "id")
	private String id;
	@Column
	private String customerId;
	@Column
	private double amount;
	@Column
	private boolean isPaid;
	@Column
	private Address billingAddress;
	@Column
	private Address shippingAddress;
	
	@Column
	@com.impetus.kundera.index.Index( name = "index_Shopping_createdTime")
	private Date createdTime;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public boolean isPaid() {
		return isPaid;
	}
	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
	public Address getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
	public Address getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	

}
