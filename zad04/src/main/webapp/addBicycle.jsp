<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a bicycle</title>
</head>
<body>
<jsp:useBean id="bicycle" class="com.example.servletdemo.domain.Bicycle" scope="session" />

<jsp:setProperty name="bicycle" property="*" /> 

<jsp:useBean id="storage" class="com.example.servletdemo.service.StorageService" scope="application" />

<% 
  storage.addToDatabase(bicycle);
%>

<p>Following bicycle has been added to storage: </p>
<p>Produecr: ${bicycle.producer} </p>
<p>Date of production: <jsp:getProperty name="bicycle" property="productionDate"></jsp:getProperty></p>
<p>
  <a href="showAllBicycles">Show all bicycles</a>
</p>
</body>
</html>