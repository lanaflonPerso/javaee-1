package com.example.servletdemo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/form")
public class FormServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><h2>Form servlet for Bicycle</h2>" +
				"<form action='data'>" +
				"Brand name: <input type='text' name='brand' /> <br />" +
				"Production date: <input type='text' name='productionDate' /> <br />" +
				"Price: <input type='number' name='price' step='0.01' /> <br />" +
				"<input type='radio' name='isDiscount'>Discount<br />" +
				"<input type='submit' value=' OK ' />" +
				"</form>" +
				"</body></html>");
		out.println("<a href=\"alldata\">Show all</a>");
		out.close();
	}

}