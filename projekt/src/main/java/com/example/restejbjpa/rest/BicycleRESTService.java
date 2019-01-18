package com.example.restejbjpa.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.restejbjpa.domain.Address;
import com.example.restejbjpa.domain.Bicycle;
import com.example.restejbjpa.domain.License;
import com.example.restejbjpa.domain.Producer;
import com.example.restejbjpa.service.BicycleManager;

@Path("bicycle")
@Stateless
public class BicycleRESTService {

	@Inject
	private BicycleManager bm;
	
	@GET
	@Path("/{bicycleId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Bicycle getBicycle(@PathParam("bicycleId") long id) {
		Bicycle b = bm.getBicycle(id);
		return b;
	}

	@GET
	@Path("/allBicycles")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bicycle> getBicycles() {
		return bm.getAll();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addBicycle(@QueryParam("model") String model, @QueryParam("price") double price) {
		Bicycle bicycle = new Bicycle(model, price);
		bm.addBicycle(bicycle);

		return Response.status(201).entity("Bicycle").build();
	}
	
	@PUT
	@Path("/{bicycleId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateBicycle(@PathParam("bicycleId") long id, 
	                               @QueryParam("model") String model, @QueryParam("price") double price) {

		Bicycle b = bm.getBicycle(id);
	    if (b == null) {
	        throw new WebApplicationException("Can't find it", 404);
	    }

	    b.setModel(model);
	    b.setPrice(price);

	    return Response.status(200).entity("Bicycle").build();
	}
	
	@GET
	@Path("/query/producers/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Producer> getProducersOfBicycle(@PathParam("id") Long id){		
		return bm.getProducersOfBicycle(id) ;
	}
	
	@GET
	@Path("/query/price/{price}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bicycle> getBicycleByPrice(@PathParam("price") double price){
		return bm.findByPrice(price);
	}
	

	@GET
	@Path("/query/bicyclesproducer/{pName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBicycleOfProducerByProducerName(@PathParam("pName") String name){
		
		List<Object[]> rawProducers = bm.getBicycleOfProducerByProducerName(name);
		JsonArrayBuilder producers = Json.createArrayBuilder();
		
		for(Object[] rawProducer: rawProducers){
			
			String pName = (String) rawProducer[0];
			String bModel = (String) rawProducer[1];
			double bPrice = (Double) rawProducer[2];
			
			producers.add(Json.createObjectBuilder()
					.add("name", pName)
					.add("model", bModel)
					.add("price", bPrice));
			
		}
		
		JsonObject json =  Json.createObjectBuilder().add("result", producers).build();
		return Response.ok(json, MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("/onetoone")
	@Produces(MediaType.TEXT_PLAIN)
	public String producerToManyAddresses(){
		
		Bicycle b1 = new Bicycle("LEVEL A1", 100);
		bm.addBicycle(b1);
		
		License l1 = new License(123);
		bm.addLicense(l1);
		
		b1.setLicense(l1);

		return "OneToOne";
	}
	

	@DELETE
	public Response clearBicycles() {
		bm.deleteAll();
		return Response.status(200).build();
	}

}