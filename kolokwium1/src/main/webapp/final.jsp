<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thanks</title>
</head>
<body>
<jsp:useBean id="sess_survey" class="com.example.servletdemo.domain.Survey" scope="session" />

<h1>Dziękuje za wysłanie ankiety ${sess_survey.id} </h1>
<p>Data użytkowania produktu od ${sess_survey.from} do ${sess_survey.to} - częstotliwość: (${sess_survey.frequency})</p>
<p>Uwagi: ${sess_survey.comments}</p>

<a href="survey.jsp"><button>Zmień ustawienia</button></a>
<a href="allsurveys"><button>Wyświetl wszystkie ankiety</button></a>

</body>
</html>