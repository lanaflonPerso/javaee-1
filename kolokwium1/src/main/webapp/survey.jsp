<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Survey</title>
</head>
<body>

<h1>Ankieta</h1>
<form action="add-survey">
    <label for="id">ID:</label>
    <input type="text" name="id" id="id" required="required" value="${sess_survey.id}"><br>

    <label for="from">Od:</label>
    <input type="text" name="from" id="from" required="required" value="${sess_survey.from}"><br>

    <label for="to">Do:</label>
    <input type="text" name="to" id="to" required="required" value="${sess_survey.to}"><br>

    <br><label>Częstotliwość:</label><br>
    <input type="radio" name="frequency" value="codziennie">Codziennie<br>
    <input type="radio" name="frequency" value="co tydzien">Co tydzień<br>
    <input type="radio" name="frequency" value="co miesiac">Co miesiąc<br>

    <br><label >Uwagi:</label><br>
    <input type="checkbox" name="comments" value="Niewygodne siodełko">Niewygodne siodełko<br>
    <input type="checkbox" name="comments" value="Zła regulacja hamulców">Zła regulacja hamulców<br>
    <input type="checkbox" name="comments" value="Zepsuta kierownica">Zepsuta kierownica<br><br>

    <input type="submit" value="Wyślij">
</form>

</body>
</html>