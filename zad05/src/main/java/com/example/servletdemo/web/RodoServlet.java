package com.example.servletdemo.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/rodo")
public class RodoServlet extends HttpServlet {

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
		if(request.getParameterMap().containsKey("firstRodo") && request.getParameterMap().containsKey("secondRodo")) 
			session.setAttribute("rodo", "on");
		else 
			session.setAttribute("rodo", "off");
		

		
		response.sendRedirect("index");
		out.close();
	}
}