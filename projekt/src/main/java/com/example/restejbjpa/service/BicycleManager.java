package com.example.restejbjpa.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.restejbjpa.domain.Bicycle;
import com.example.restejbjpa.domain.License;
import com.example.restejbjpa.domain.Producer;

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
		return em.createNamedQuery("bicycle.getAll").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Bicycle> findByPrice(double price){
		return em.createNamedQuery("bicycle.findByPrice").setParameter("price", price).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Bicycle> getCheapest(){
		return em.createNamedQuery("bicycle.cheapest").setMaxResults(1).getResultList();
	}
	
	public Object getBicyclesCountOfProducerByProducerName(String name){
		return em.createNamedQuery("bicycleProducer.count").setParameter("name", name).getResultList().get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getAddressesByModel(String model){
		return em.createNamedQuery("bicycleProducerAddress.getAddressesByBicycleModel").setParameter("model", model).getResultList();
	}
	
	public Bicycle getBicycle(int id){
	        return em.find(Bicycle.class, id);
    }
	 
	public Bicycle updateBicycle(Bicycle bicycle) {
	        return em.merge(bicycle);
    }

    public void deleteAll(){
        em.createNamedQuery("bicycle.deleteAll").executeUpdate();
    }
    
    public void addLicense(License license) {
		em.persist(license);
	}
    
    
    public List<Producer> getProducersOfBicycle(Long id){
		Bicycle retrieved = em.find(Bicycle.class, id);
		List<Producer> result = new ArrayList<>(retrieved.getProducers());
		return result;
    }
    
    @SuppressWarnings("unchecked")
	public List<Object[]> getBicycleOfProducerByProducerName(String name){		
		return em.createNamedQuery("bicycleProducer.findByProducerName").setParameter("name", name).getResultList();
	}
}