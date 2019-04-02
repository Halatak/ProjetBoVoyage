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


	<div class="main">
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
								<td>${v.destination.pays}</td>
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


		<div class="row">
			<div class="panel panel-primary">

				<div class="panel-heading">
					<h3 class="panel-title">Liste des Avions</h3>
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
							<th>Prix</th>
							<th>Description</th>
							<th>Opération</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${avionListe}" var="av">
							<tr>
								<td>${av.idAvion}</td>
								<td>${av.prix}</td>
								<td>${av.description}</td>
								<td><a class="btn btn-danger"
									href="
									${pageContext.request.contextPath}/avion/avionSoumettre-supprLien?pId=${av.idAvion}">Supprimer</a>|<a
									class="btn btn-success"
									href="
									${pageContext.request.contextPath}/avion/avionSoumettre-modifLien?pId=${av.idAvion}">Modifier</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
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
							<tr style="text-align: center; vertical-align: middle;">
								<td>${ho.id}</td>
								<td>${ho.nom}</td>
								<td>${ho.prix}</td>
								<td>${ho.description}</td>
								<td>${ho.nbEtoiles}</td>
								<td><img src="photoHo?idHo=${ho.id}"
									style="max-width: 250px;"></td>
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


		<div class="row">
			<div class="panel panel-primary">

				<div class="panel-heading">
					<h3 class="panel-title">Liste des Voitures</h3>
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
							<th>Marque</th>
							<th>Prix</th>
							<th>Description</th>
							<th>Photo</th>
							<th>Opération</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${voitureListe}" var="voi">

							<tr>
								<td>${voi.idVoiture}</td>
								<td>${voi.marque}</td>
								<td>${voi.prix}</td>
								<td>${voi.description}</td>
								<td><img
									src="${pageContext.request.contextPath}/voiture/photoVoi?idVoi=${voi.idVoiture}"
									style="max-width: 250px;"></td>
								<td><a class="btn btn-danger"
									href="
									${pageContext.request.contextPath}/voiture/voitureSoumettre-supprLien?pId=${voi.idVoiture}">Supprimer</a>|<a
									class="btn btn-success"
									href="
									${pageContext.request.contextPath}/voiture/voitureSoumettre-modifLien?pId=${voi.idVoiture}">Modifier</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>


		<h1>${msg}</h1>
	</div>
</body>
</html>