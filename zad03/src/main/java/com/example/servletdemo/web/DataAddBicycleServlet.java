package com.example.servletdemo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.servletdemo.domain.Bicycle;
import com.example.servletdemo.service.StorageService;

@WebServlet(urlPatterns = "/data-bicycle")
public class DataAddBicycleServlet extends HttpServlet {

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
		
		DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		long id = Long.parseLong(request.getParameter("id"));
		String producer = request.getParameter("producer");
		Date productionDate = null;
		try {
			productionDate = formatter.parse(request.getParameter("productionDate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		double price = Double.parseDouble(request.getParameter("price"));
		boolean isReserved = Boolean.parseBoolean(request.getParameter("isReserved"));

		Bicycle newBicycle = new Bicycle(id, producer, productionDate, price, isReserved);

		ss.addToDatabase(newBicycle);
		response.sendRedirect("all-bicycles");
		out.close();
	}
}