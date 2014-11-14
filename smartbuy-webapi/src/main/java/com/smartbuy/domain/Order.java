package com.smartbuy.domain;

import java.util.Date;
import java.util.Map;

public class Order {
	
	private String orderId;
	private String goodsId;
	private double quantity;
	private double totalPrice;
	private String currencyId;
	private String customerId;
	private Map<String,String> goodsOptions;
	private Date orderTime;
	private OrderStatus status;
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
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
	public Map<String, String> getGoodsOptions() {
		return goodsOptions;
	}
	public void setGoodsOptions(Map<String, String> goodsOptions) {
		this.goodsOptions = goodsOptions;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
}
