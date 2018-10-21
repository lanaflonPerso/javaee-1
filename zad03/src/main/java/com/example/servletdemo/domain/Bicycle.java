package com.example.servletdemo.domain;

import java.util.Date;

public class Bicycle {
	
	private String brand;
	private double price;
	private Date productionDate;
	private boolean isDiscount;
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getProductionDate() {
		return productionDate;
	}
	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}
	public boolean isDiscount() {
		return isDiscount;
	}
	public void setDiscount(boolean isDiscount) {
		this.isDiscount = isDiscount;
	}
	
	public Bicycle() {
		super();
	}
	
	public Bicycle(String brand, double price, Date productionDate, boolean isDiscount) {
		super();
		this.brand = brand;
		this.price = price;
		this.productionDate = productionDate;
		this.isDiscount = isDiscount;
	}
	
	
	

}
