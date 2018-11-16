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
import javax.servlet.http.HttpSession;

import com.example.servletdemo.domain.Survey;
import com.example.servletdemo.service.SurveyService;

@WebServlet("/add-survey")
public class AddSurveyServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		SurveyService ss = (SurveyService)getServletContext().getAttribute("app_survey");
		
		Survey sessionSurvey = null;
		long id = Long.parseLong(request.getParameter("id"));
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String frequency = request.getParameter("frequency");
		String comments = "";
		
		for(String comment : request.getParameterValues("comments")) {
			comments += comment + " ";
		}
		
		if(session.getAttribute("sess_survey") != null) {
			sessionSurvey = (Survey) session.getAttribute("sess_survey");
			ss.removeSurvey(sessionSurvey);
		}
	
		sessionSurvey = new Survey(id,from,to,frequency,comments);
		ss.addSurvey(sessionSurvey);
		
		
		session.setAttribute("sess_survey", sessionSurvey);
		
		response.sendRedirect("final.jsp");
	}
	
	@Override
    public void init() throws ServletException {

        // application context
        getServletContext().setAttribute("app_survey", new SurveyService());
	}
}