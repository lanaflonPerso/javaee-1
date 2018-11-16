package com.example.servletdemo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.servletdemo.domain.Survey;
import com.example.servletdemo.service.SurveyService;

@WebServlet("/allsurveys")
public class GetAllSurveysServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		SurveyService ss = (SurveyService)getServletContext().getAttribute("app_survey");
		
		List<Survey> allSurveys = ss.getAllSurveys();
		
		out.append("<html><body>");
		
		  for (Survey survey: allSurveys) {
			  out.append("<p>ID: <b>" + survey.getId() + "</b></p>");
              out.append("<p>Od: " + survey.getFrom() + "</p>");
              out.append("<p>Do: " + survey.getTo() + "</p>");
              out.append("<p>Czestotliwosc: " + survey.getFrequency() + "</p>");
              out.append("<p>Tematy: " + survey.getComments() + "</p>");
		  }
		  
		  out.append("</body></html>");
		  out.close();
	}
	 @Override
	    public void init() throws ServletException {

	        // application context
	        getServletContext().setAttribute("app_survey", new SurveyService());
	}
}