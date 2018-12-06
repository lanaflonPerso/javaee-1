package com.example.restwsdemo.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.restwsdemo.domain.Bicycle;
import com.example.restwsdemo.service.BicycleManager;

@Path("bicycle")
@Stateless
public class BicycleRESTService {

	@Inject
	private BicycleManager bm;

	@GET
	@Path("/{bicycleId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Bicycle getBicycle(@PathParam("bicycleId") Integer id) {
		Bicycle b = bm.getBicycle(id);
		return b;
	}

	@GET
	@Path("/allBicycles")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bicycle> getBicycles() {
		return bm.getAllBicycles();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addBicycle(@QueryParam("producer") String producer, @QueryParam("price") double price) {
		Bicycle bicycle = new Bicycle(producer, price);
		bm.addBicycle(bicycle);

		return Response.status(201).entity("Bicycle").build();
	}

	@DELETE
	public Response clearBicycles() {
		bm.deleteAllBicycles();
		return Response.status(200).build();
	}

}