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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "bicycle.getAll", query = "Select b from Bicycle b"),
    @NamedQuery(name = "bicycle.deleteAll", query="Delete from Bicycle"),
    @NamedQuery(name = "bicycle.findByPrice", query = "Select b from Bicycle b where b.price = :price"),
    @NamedQuery(name = "bicycleProducer.findByProducerName",
	query = "Select p.name, b.model, b.price from Bicycle b JOIN b.producers p where p.name = :name")
})
public class Bicycle {
	
	private long id;
	private String model;
	private double price;
	private List<Producer> producers = new ArrayList<>();
	private License license;
	
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
	
	// Bicycle has unique license, License has unique bicycle
	@OneToOne
	public License getLicense() {
		return license;
	}
	public void setLicense(License license) {
		this.license = license;
	}
	
} 