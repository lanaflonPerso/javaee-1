package com.example.servletdemo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.servletdemo.domain.Bicycle;
import com.example.servletdemo.service.StorageService;

@WebServlet(urlPatterns = "/alldata")
public class AllDataServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		StorageService storageService = new StorageService();
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><h2>Your data</h2>");
		  for (Bicycle bicycle : storageService.getAllBicycles()) {
			  out.println(bicycle.getBrand());
		  }
	    out.println("</body></html>");
		
		out.close();
	}

}