package com.example.servletdemo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.servletdemo.domain.Bicycle;

public class StorageService {
	
	private List<Bicycle> db = new ArrayList<Bicycle>();
	
	public void add(Bicycle bicycle){
		Bicycle newBicycle = new Bicycle(bicycle.getBrand(), bicycle.getPrice(), bicycle.getProductionDate(), bicycle.isDiscount());
		db.add(newBicycle);
	}
	
	public List<Bicycle> getAllBicycles(){
		return db;
	}

}