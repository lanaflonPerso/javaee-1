package com.example.restejbjpa.rest;

import java.util.ArrayList;
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
import com.example.restejbjpa.service.ProducerManager;

@Path("bicycle")
@Stateless
public class BicycleRESTService {

	@Inject
	private BicycleManager bm;
	
	@Inject
	private ProducerManager pm;
	
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
	
	@GET
	@Path("/cheapest")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bicycle> getCheapest() {
		return bm.getCheapest();
	}
	
	@GET
	@Path("/count/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Object getBicyclesCountOfProducerByProducerName(@PathParam("name") String name) {
		return bm.getBicyclesCountOfProducerByProducerName(name);
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
	@Path("/query/addressByBicycle/{bModel}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAddressesByModel(@PathParam("bModel") String model){
		
		// MANY TO MANY - PRODUCERS BICYCLES
		Producer p = new Producer("KROSS");
		
		Bicycle b1 = new Bicycle("LEVEL A1", 100);
		Bicycle b2 = new Bicycle("LEVEL A2", 200);

		List<Bicycle> bicycles = new ArrayList<>();
		bicycles.add(b1);
		bicycles.add(b2);
		
		p.addBicycles(bicycles);	
		pm.addProducer(p);
		
		// ONE TO MANY - PRODUCER ADDRESSES
		Address a1 = new Address("Kolejowa", "70", "06-300", "Przasnysz");
		Address a2 = new Address("Abecadlowa", "15", "02-300", "Pruszcz");

		pm.addAddress(a1);
		pm.addAddress(a2);
		
		a1.setProducer(p);
		a2.setProducer(p);
		
		// QUERY
		List<Object[]> rawAddresses = bm.getAddressesByModel(model);
		JsonArrayBuilder addresses = Json.createArrayBuilder();
		JsonArrayBuilder result = Json.createArrayBuilder();
		
		for(Object[] rawAddress: rawAddresses){
			
			String aPostCode = (String) rawAddress[0];
			String aCity = (String) rawAddress[1];
			String aStreet = (String) rawAddress[2];
			String aBuldingNumber = (String) rawAddress[3];
			String pName = (String) rawAddress[4];
			String bModel = (String) rawAddress[5];
			
			addresses.add(Json.createObjectBuilder()
					.add("postCode", aPostCode)
					.add("city", aCity)
					.add("street", aStreet)
					.add("buildingNumber", aBuldingNumber));
			
			result.add(Json.createObjectBuilder()
					.add("address", addresses)
					.add("producerName", pName)
					.add("bicycleModel", bModel));
			
		}
		
		JsonObject json =  Json.createObjectBuilder().add("result", result).build();
		return Response.ok(json, MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("/onetoone")
	@Produces(MediaType.TEXT_PLAIN)
	public String bicycleToLicense(){
		
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