<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil</title>

<%@ include file='/resources/templates/TagCSSJS.jsp'%>

</head>
<body>

	<%-- La directive include --%>
	<jsp:include page="/resources/templates/navBar.jsp" />

	<table class="table table-bordered">
		<tr>
			<th>ID</th>
			<th>Date de départ</th>
			<th>Date d'arrivée</th>
			<th>Nombre de place</th>
			<th>Prix</th>
			<th>Statut</th>
			<th>Destination</th>
		</tr>

		<c:forEach items="${liste}" var="v">
			<tr>
				<td>${v.id}</td>
				<td>${v.dateDepart}</td>
				<td>${v.dateArrivee}</td>
				<td>${v.nbPlaces}</td>
				<td>${v.prix}</td>
				<td>${v.statut}</td>
				<td>${v.destination}</td>


			</tr>
		</c:forEach>

	</table>
</body>
</html>