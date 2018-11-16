package com.example.servletdemo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.servletdemo.domain.Survey;
import com.example.servletdemo.service.SurveyService;

@WebServlet("/edit-survey")
public class EditSurveyServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		SurveyService ss = (SurveyService)getServletContext().getAttribute("app_survey");
		long id = Long.parseLong(request.getParameter("id"));
		List<Survey> allSurveys = ss.getAllSurveys();
		
		List<String> comments = new ArrayList<String>();
		
		for(String comment : request.getParameterValues("comments")) {
			comments.add(comment);
		}
		
		for (Iterator<Survey> iter = allSurveys.listIterator(); iter.hasNext(); ) {
            Survey s = iter.next();
            if (s.getId() == id) {
                s.setComments(comments);
            }
		}
		
		response.sendRedirect("allsurveys");
	}
	
	@Override
    public void init() throws ServletException {

        // application context
        getServletContext().setAttribute("app_survey", new SurveyService());
	}
}