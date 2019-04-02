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

	<br />
	<br />
	<br />
	<div class="row">
		<div class="panel panel-primary">

			<div class="panel-heading">
				<h3 class="panel-title">Liste des voyages</h3>
				<div class="pull-right">
					<span class="clickable filter" data-toggle="tooltip"
						title="Toggle table filter" data-container="body"> <i
						class="glyphicon glyphicon-filter"></i>
					</span>
				</div>
			</div>
			<div class="input-group">
				<!-- USE TWITTER TYPEAHEAD JSON WITH API TO SEARCH -->
				<input class="form-control" id="system-search" name="q"
					placeholder="Rechercher" required> <span
					class="input-group-btn">
					<button type="submit" class="btn btn-default">
						<i class="glyphicon glyphicon-search"></i>
					</button>
				</span>
			</div>

			<table class="table table-bordered table-list-search" style="background-color: white;">
			<thead>
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
				</thead>
				<tbody>
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
				</tbody>
			</table>
		</div>
	</div>
	<h1>${msg}</h1>

</body>
</html>