package com.example.restejbjpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "bicycle.getAll", query = "Select b from Bicycle b"),
    @NamedQuery(name = "bicycle.deleteAll", query="Delete from Bicycle")
})
public class Bicycle {
	
	private long id;
	private String producer;
	private double price;
	
	public Bicycle() {
		super();
	}
	
	public Bicycle(String producer, double price) {
		super();
		this.producer = producer;
		this.setPrice(price);
	}
	
	public String getProducer() {
		return producer;
	}
	
	public void setProducer(String producer) {
		this.producer = producer;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
} 