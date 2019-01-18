package com.example.restejbjpa.service;

import java.util.List;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.restejbjpa.domain.Address;
import com.example.restejbjpa.domain.Producer;

@Stateless
public class ProducerManager {

	@PersistenceContext
	EntityManager em;
	
	public void addProducer(Producer producer){	
		em.persist(producer);
	}
	
	public Producer getProducer(Long id){
		Producer retrieved = em.find(Producer.class, id);
		return retrieved;
	}
	
	@SuppressWarnings("unchecked")
	public List<Producer> getAll(){
		return em.createNamedQuery("producer.all").getResultList();
	}
	
	public void addAddress(Address address){	
		em.persist(address);
	}
}
