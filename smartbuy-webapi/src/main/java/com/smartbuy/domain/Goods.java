package com.smartbuy.domain;

import java.util.Map;

public class Goods {
	private String goodsId;
	private String name;
	private String currencyId;
	private double price;	
	private String sellerId;
	private double instock;
	private Map<String,String> goodsOptions;
	
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		sellerId = sellerId;
	}
	public double getInstock() {
		return instock;
	}
	public void setInstock(double instock) {
		this.instock = instock;
	}
	public Map<String, String> getGoodsOptions() {
		return goodsOptions;
	}
	public void setGoodsOptions(Map<String, String> goodsOptions) {
		this.goodsOptions = goodsOptions;
	}

}
