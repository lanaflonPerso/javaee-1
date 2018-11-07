package com.example.servletdemo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.servletdemo.domain.Bicycle;
import com.example.servletdemo.service.StorageService;

@WebServlet(urlPatterns = "/data-cart")
public class DataAddCartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		StorageService ss = (StorageService) getServletContext().getAttribute("storageService");
		
		List<Bicycle> bicycles = ss.getAllBicycles();
		Bicycle bicycleToCart = bicycles.get(Integer.parseInt(request.getParameter("add")) - 1);

		HttpSession session = request.getSession();
		if (session.getAttribute("cart") == null) {
			List<Bicycle> cart = new ArrayList<Bicycle>();
			session.setAttribute("cart", cart);
		}
		
		List<Bicycle> cart = (List<Bicycle>) session.getAttribute("cart");
		cart.add(bicycleToCart);
		
		response.sendRedirect("cart");
		out.close();
	}
	
	@Override
	public void init() throws ServletException {

		// application context
		getServletContext().setAttribute("storageService", new StorageService());
	}
}