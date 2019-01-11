package com.example.restejbjpa.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	private String model;
	private double price;
	private List<Producer> producers = new ArrayList<>();
	
	public Bicycle() {
		super();
	}
	
	public Bicycle(String model, double price) {
		super();
		this.model = model;
		this.setPrice(price);
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
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
	
	@ManyToMany(mappedBy = "bicycles", fetch = FetchType.EAGER)
	public List<Producer> getProducers() {
		return producers;
	}

	public void setProducers(List<Producer> producers) {
		this.producers = producers;
	}
} 