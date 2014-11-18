package com.smartbuy.entities;

public class Address implements java.io.Serializable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1036302040393077007L;
	private String country;
	private String state;
	private String city;
	private String street;
	private int streetNumber;
	private String unit;
	private String zipcode;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	public int getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}		
	
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
}
