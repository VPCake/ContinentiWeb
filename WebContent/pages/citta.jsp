<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elenco citta'</title>
</head>
<body>
	<form action="nazioni">
		<input type="submit" value="Torna indietro">
	</form>
	<c:forEach items="${citta}" var="city">

		<div>${city.name}-${city.population}</div>

	</c:forEach>
</body>
</html>