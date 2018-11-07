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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		StorageService ss = (StorageService) getServletContext().getAttribute("storageService");
		
		if(ss == null) {
			getServletContext().setAttribute("storageService", new StorageService());
		}
	
		List<Bicycle> allBicycles = ss.getAllBicycles();

		out.append("<html><body><h2>All bicycles:</h2>");

		for (Bicycle bicycle: allBicycles) {
			out.append("<p>Id: " + bicycle.getId() + "</p>");
			out.append("<p>Producer: " + bicycle.getProducer() + "</p>");
			out.append("<p>Production date: " + bicycle.getProductionDate() + "</p>");
			out.append("<p>Price: " + bicycle.getPrice() + "</p>");
			out.append("<p>Is Reserved: " + bicycle.isReserved() + "</p>");
			out.append("<form action='data-cart'><input type='hidden' name='add' value='" + bicycle.getId() +"' ><button type=submit>Add to shopping cart</button></form>");
		}

		out.append( "</br><li><a href='/servletjspdemo'>Index</a></li>");
		out.append("</body></html>");
		out.close();
	}
}