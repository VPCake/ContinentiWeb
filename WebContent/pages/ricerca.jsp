<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ricerca</title>
</head>
<body>
	<form action="ricerca">
		<input type="text" name="name"> <select name="code">
			<option value="" SELECTED>Nessuna nazione</option>
			<c:forEach items="${nazioni}" var="naz">
				<option value="${naz.code}">${naz.name}</option>
			</c:forEach>
		</select> <input type="submit" value="cerca">
	</form>

		<div>
			<a href="/ContinentiWeb/PreForm?ID=0">
					Inserimento</a>
		</div>
		<c:forEach items="${city}" var="cit">
			<div>${cit.name}
				<a href="/ContinentiWeb/PreForm?ID=${cit.id}">
					${cit.id}-Modifica</a>
			</div>
		</c:forEach>

</body>
</html>