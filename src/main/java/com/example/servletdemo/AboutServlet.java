package com.example.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/about")
public class AboutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>"
				+ "<h1>Aleksander Szewczak</h1>"
				+ "<p>Student Uniwersytetu Gdanskiego</p>"
				+ "<p>Kierunek: Informatyka</p>"
				+ "<h2>Hobby</h2>"
				+ "<ul>"
				+ "<li>Pilka nozna</li>"
				+ "<li>Programowanie</li>"
				+ "<li>Siatkowka</li>"
				+ "</ul>"
				+ "</body></html>");
		out.close();
	}
}
