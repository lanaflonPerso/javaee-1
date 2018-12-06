package com.example.restwsdemo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Singleton;

import com.example.restwsdemo.domain.Bicycle;

@Singleton
public class BicycleManager {
	
	private List<Bicycle> db = Collections.synchronizedList(new ArrayList<>());

	public void addBicycle(Bicycle bicycle) {
		db.add(bicycle);
	}

	public void deleteBicycle(Bicycle bicycle){
		db.remove(bicycle);
 	}
	
	public Bicycle getBicycle(Integer id) {
		return db.get(id);
	}
	
	public List<Bicycle> getAllBicycles(){
		return db;
	}
	
	public void deleteAllBicycles(){
		db.clear();
	}

}