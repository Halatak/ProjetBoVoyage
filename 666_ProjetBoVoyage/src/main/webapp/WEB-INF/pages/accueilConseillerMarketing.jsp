<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil Conseiller Marketing</title>

<%@ include file='/resources/templates/TagCSSJS.jsp'%>

</head>
<body>

	<%-- La directive include --%>
	<jsp:include page="/resources/templates/navBarConsMark.jsp" />

	coucou conseiller marketing

	<table class="table table-bordered">
		<tr>
			<th>ID</th>
			<th>Date de départ</th>
			<th>Date d'arrivée</th>
			<th>Nombre de place</th>
			<th>Prix</th>
			<th>Statut</th>
			<th>Destination</th>
			<th>Operation</th>
		</tr>

		<c:forEach items="${voyageCMListe}" var="v">
			<tr>
				<td>${v.id}</td>
				<td>${v.dateDepart}</td>
				<td>${v.dateArrivee}</td>
				<td>${v.nbPlaces}</td>
				<td>${v.prix}</td>
				<td>${v.statut}</td>
				<td>${v.destination.idDestination}</td>
				<td><a class="btn btn-danger"
					href="${pageContext.request.contextPath}/voyage/soumettre-supprLien?pId=${v.id}">Supprimer</a>
					<a class="btn btn-success"
					href="${pageContext.request.contextPath}/voyage/soumettre-modifLien?pId=${v.id}">Modifier</a>
				</td>

			</tr>
		</c:forEach>

	</table>
	<h1>${msg}</h1>

</body>
</html>