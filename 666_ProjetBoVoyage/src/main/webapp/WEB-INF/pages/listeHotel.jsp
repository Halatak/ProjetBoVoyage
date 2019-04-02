<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des hotels</title>

<%@ include file='/resources/templates/TagCSSJS.jsp'%>

</head>
<body>

	<%-- La directive include --%>
	<jsp:include page="/resources/templates/navBarConsMark.jsp" />
	<div class="main">
		<div class="row">
			<div class="panel panel-primary">

				<div class="panel-heading">
					<h3 class="panel-title">Liste des Hôtels</h3>
					<div class="pull-right">
						<span class="clickable filter" data-toggle="tooltip"
							title="Toggle table filter" data-container="body"> <i
							class="glyphicon glyphicon-filter"></i>
						</span>
					</div>
				</div>
				<div class="input-group">
					<!-- USE TWITTER TYPEAHEAD JSON WITH API TO SEARCH -->
					<input class="form-control system-search" name="q"
						placeholder="Rechercher" required> <span
						class="input-group-btn">
						<button type="submit" class="btn btn-default">
							<i class="glyphicon glyphicon-search"></i>
						</button>
					</span>
				</div>
				<table class="table table-bordered table-list-search"
					style="background-color: white;">
					<thead>
						<tr>
							<th>ID</th>
							<th>Nom</th>
							<th>Prix</th>
							<th>Description</th>
							<th>Nombre d'étoile</th>
							<th>Photo</th>
							<th>Opération</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${hotelListe}" var="ho">
							<tr>
								<td>${ho.id}</td>
								<td>${ho.nom}</td>
								<td>${ho.prix}</td>
								<td>${ho.description}</td>
								<td>${ho.nbEtoiles}</td>
								<td><img src="photoHo?idHo=${ho.id}" style="max-width: 250px;"></td>
								<td><a class="btn btn-danger"
									href="
									${pageContext.request.contextPath}/hotel/hotelSoumettre-supprLien?pId=${ho.id}">Supprimer</a>|<a
									class="btn btn-success"
									href="
									${pageContext.request.contextPath}/hotel/hotelSoumettre-modifLien?pId=${ho.id}">Modifier</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
	</div>
	<h1>${msg}</h1>
</body>
</html>