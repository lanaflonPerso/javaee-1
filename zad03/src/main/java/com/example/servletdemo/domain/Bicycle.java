package com.example.servletdemo.domain;

import java.util.Date;

public class Bicycle {
	
	private long id;
	private String producer;
	private Date productionDate;
	private double price;
	private boolean isReserved;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public Date getProductionDate() {
		return productionDate;
	}
	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isReserved() {
		return isReserved;
	}
	public void setReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}
	
	public Bicycle(long id, String producer, Date productionDate, double price, boolean isReserved) {
		super();
		this.id = id;
		this.producer = producer;
		this.productionDate = productionDate;
		this.price = price;
		this.isReserved = isReserved;
	}
	public Bicycle() {
		super();
	}
	
	
	
	
	

}
