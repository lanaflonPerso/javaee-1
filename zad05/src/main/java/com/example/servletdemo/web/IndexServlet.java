package com.example.servletdemo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/index")
public class IndexServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        if(session.getAttribute("rodo") == "off") 
        	response.sendRedirect("");

        out.println("<html><body><h1>Welcome</h1> <br>" +
                "Menu: <br>" +
                "<ul>" +
                "<li><a href='add-bicycle'>Add a bicycle</a></li>" +
                "<li><a href='all-bicycles'>Show all bicycles</a></li>" +
                "<li><a href='cart'>Shopping cart</a></li>" +
                "</ul>" +
                "</body></html>");
        out.close();
    }

}
