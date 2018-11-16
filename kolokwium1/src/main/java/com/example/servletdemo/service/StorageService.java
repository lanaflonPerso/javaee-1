package com.example.servletdemo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.servletdemo.domain.Bicycle;

public class StorageService {
	
	private List<Bicycle> db = new ArrayList<Bicycle>();
	
	public void addToDatabase(Bicycle bicycle) {
		Bicycle newBicycle = new Bicycle(bicycle.getId(), bicycle.getProducer(), bicycle.getProductionDate(), bicycle.getPrice(), bicycle.isReserved());
		db.add(newBicycle);
	}
	
	public List<Bicycle> getAllBicycles() {
		return db;
	}
}
