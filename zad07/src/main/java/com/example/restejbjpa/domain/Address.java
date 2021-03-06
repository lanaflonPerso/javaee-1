package com.example.restejbjpa.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Address {

	private long id;
	private String street;
	private String buildingNumber;
	private String postCode;
	private String city;
	private Producer producer;
	
	public Address(String street, String buildingNumber, String postCode, String city) {
		super();
		this.street = street;
		this.buildingNumber = buildingNumber;
		this.postCode = postCode;
		this.city = city;
	}

	public Address() {
		
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(String buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	// Address belongs to producer
    @ManyToOne
    @JsonIgnore
    public Producer getProducer() {
        return producer;
    }

    @JsonIgnore
    public void setProducer(Producer producer) {
        this.producer = producer;
    }
	
}