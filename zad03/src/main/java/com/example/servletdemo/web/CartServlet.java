package com.example.servletdemo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.example.servletdemo.domain.Bicycle;

@WebServlet(urlPatterns = "/cart")
public class CartServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		if (session.getAttribute("cart") == null) {
			List<Bicycle> cart = new ArrayList<Bicycle>();
			session.setAttribute("cart", cart);
		}
		
		@SuppressWarnings("unchecked")
		List<Bicycle> allBicycles = (List<Bicycle>) session.getAttribute("cart");

		out.append("<html><body><h2>Your cart:</h2>");

		for (Bicycle bicycle: allBicycles) {
			out.append("<p>Id: " + bicycle.getId() + "</p>");
			out.append("<p>Producer: " + bicycle.getProducer() + "</p>");
			out.append("<p>Production date: " + bicycle.getProductionDate() + "</p>");
			out.append("<p>Price: " + bicycle.getPrice() + "</p>");
			out.append("<p>Is Reserved: " + bicycle.isReserved() + "</p></br>");
		}

		out.append("</br><li><a href='/servletjspdemo'>Index</a></li>");
		out.append("</body></html>");
		out.close();
	}
}