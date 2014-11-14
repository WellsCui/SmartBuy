package com.smartbuy.domain;

import java.util.Date;
import java.util.Set;

public class Payment {
	private String paymentId;
	private String shippingAddressId;
	private String billingAddressId;
	private double totalPrice;
	private String currencyId;
	private String customerId;
	private Date orderTime;
	private Set<String> orderIds;
	private PaymentStatus status;
	
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getShippingAddressId() {
		return shippingAddressId;
	}
	public void setShippingAddressId(String shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}
	public String getBillingAddressId() {
		return billingAddressId;
	}
	public void setBillingAddressId(String billingAddressId) {
		this.billingAddressId = billingAddressId;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Set<String> getOrderIds() {
		return orderIds;
	}
	public void setOrderIds(Set<String> orderIds) {
		this.orderIds = orderIds;
	}
	public PaymentStatus getStatus() {
		return status;
	}
	public void setStatus(PaymentStatus status) {
		this.status = status;
	}
	
}
