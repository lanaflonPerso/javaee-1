package com.example.restejbjpa.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.restejbjpa.domain.Bicycle;
import com.example.restejbjpa.domain.Producer;
import com.example.restejbjpa.service.ProducerManager;


@Path("producer")
@Stateless
public class ProducerRESTService {

	@Inject
	private ProducerManager pm;
	
	@GET
	@Path("/{producerId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Producer getProducer(@PathParam("producerId") long id) {
		Producer p = pm.getProducer(id);
		return p;
	}
	
	@GET
	@Path("/allProducers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Producer> getProducers() {
		return pm.getAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addBicycle(@QueryParam("name") String name) {
		Producer producer = new Producer(name);
		pm.addProducer(producer);

		return Response.status(201).entity("Producer").build();
	}
	
	@GET
	@Path("/manytomany")
	@Produces(MediaType.TEXT_PLAIN)
	public String testRelations(){
		
		Producer p = new Producer("Prod");
		
		Bicycle b1 = new Bicycle("Fiat", 100);
		Bicycle b2 = new Bicycle("Ford", 200);

		List<Bicycle> bicycles = new ArrayList<>();
		bicycles.add(b1);
		bicycles.add(b2);
		
		p.addBicycles(bicycles);	
		pm.addProducer(p);
		
	
		System.out.println("Id b: " + b1.getId());
		
		System.out.println("\n\n@@@ Size of producers: " + b1.getProducers().size());
		
		//Car retrieved = pm.getCar(c1.getId());
		//Car retrieved = pm.updateCar(c1);
		
		
		//System.out.println("\n\n@@@ Size of owners: " + retrieved.getOwners().size());

		return "ManyToMany";
	}
}
