<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RODO Index</title>
</head>
<body>
<h1>Agreement for RODO</h1>
<h3>Compulsory fields</h3>
<form action="rodo" method="get">
<input type="checkbox" name="firstRodo"> I agree RODO v1 <br/>
<input type="checkbox" name="secondRodo"> I agree RODO v2 <br/>
<br/>
<h3>Optional fields</h3>
<input type="checkbox" name="newsletter"> I would like to join to newsletter
<br/>


<c:if test="${sessionScope.rodo eq 'off'}">
	<p>You have to accept RODO to have access to site!</p>
</c:if>
<button style="margin: 10px" type="submit">Send</button>
</form>
</body>
</html>