<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Get Bicycle Data</title>
</head>
<body>

<jsp:useBean id="storage" class="com.example.servletdemo.service.StorageService" scope="application" />
<jsp:useBean id="bicycle" class="com.example.servletdemo.domain.Bicycle" scope="session" />

<form action="addBicycle.jsp">

  Producer: <input type="text" name="producer" value="${bicycle.producer}" /><br />
  Production date: <input type="date"  name="productionDate" value="${bicycle.productionDate}" /><br />
  Price: <input type="text"  name="price" value="${bicycle.price}" /><br />
  Is Reserved: <select name="isReserved"><option value="true">Yes</option><option value="false">No</option></select><br />
  <input type="submit" value=" OK ">
  
</form>

</body>
</html>