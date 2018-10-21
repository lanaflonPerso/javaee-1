package com.example.servletdemo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.servletdemo.domain.Bicycle;
import com.example.servletdemo.service.StorageService;

@WebServlet(urlPatterns = "/data")
public class DataServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String brand = request.getParameter("brand");
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date productionDate = null;
		try {
			productionDate = formatter.parse(request.getParameter("productionDate"));
		} catch (ParseException e) { }
		double price = Double.parseDouble(request.getParameter("price"));
		boolean isDiscount = request.getParameter("isDiscount") != null;
		StorageService storageService = new StorageService();
	
		Bicycle bicycle = new Bicycle(brand,price,productionDate,isDiscount);
		storageService.add(bicycle);
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		
		out.println("<html><body><h2>Your data</h2>" +
				"<p>Brand name: " + brand + "<br />" +
				"<p>Production date: " + productionDate + "<br />" +
				"<p>Price: " + price + "<br />" +
				"<p>Is Discount?: " + isDiscount + "<br />" +
				"</body></html>");
		out.println("<a href=\"alldata\">Show all</a>");
		out.close();
	}

}