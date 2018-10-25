package com.example.servletdemo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.servletdemo.domain.Bicycle;
import com.example.servletdemo.service.StorageService;

@WebServlet(urlPatterns = "/all-bicycles")
public class AllBicyclesServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		StorageService ss = (StorageService) getServletContext().getAttribute("storage_service");
	
		List<Bicycle> allBicycles = ss.getAllBicycles();

		out.append("<html><body><h2>All bicycles:</h2>");

		for (Bicycle bicycle: allBicycles) {
			out.append("<p>Id: " + bicycle.getId() + "</p>");
			out.append("<p>Producer: " + bicycle.getProducer() + "</p>");
			out.append("<p>Production date: " + bicycle.getProductionDate() + "</p>");
			out.append("<p>Price: " + bicycle.getPrice() + "</p>");
			out.append("<p>Is Reserved: " + bicycle.isReserved() + "</p>");
			out.append("<form action='data-cart'><input type='submit' name='add' value='" + bicycle.getId() +"' ></form>");
		}

		out.append( "</br><li><a href='index'>Index</a></li>");
		out.append("</body></html>");
		out.close();
	}
	
	@Override
	public void init() throws ServletException {

		// application context
		getServletContext().setAttribute("storage_service", new StorageService());
	}
}