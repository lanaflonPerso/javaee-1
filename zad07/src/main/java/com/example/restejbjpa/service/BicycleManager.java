package com.example.restejbjpa.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.restejbjpa.domain.Bicycle;
import com.example.restejbjpa.domain.Book;
import com.example.restejbjpa.domain.Person;

@Stateless
public class BicycleManager {
	
	@PersistenceContext
	EntityManager em;
	
	public void addBicycle(Bicycle bicycle){	
		em.persist(bicycle);
	}
	
	public Bicycle getBicycle(Long id){
		Bicycle retrieved = em.find(Bicycle.class, id);
		return retrieved;
	}
	
	@SuppressWarnings("unchecked")
	public List<Bicycle> getAll(){
		return em.createNamedQuery("bicycle.all").getResultList();
	}
}