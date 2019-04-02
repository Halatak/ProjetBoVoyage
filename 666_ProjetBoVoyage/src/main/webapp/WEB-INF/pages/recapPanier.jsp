<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- Ajouter la taglib spring mvc form -->
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- Ajouter la taglib de jstl core -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Choisir une Assurance</title>
<%@ include file='/resources/templates/TagCSSJS.jsp'%>

</head>
<body>
	<%-- La directive include --%>
	<%@ include file='/resources/templates/navBarAccueil.jsp'%>

	<h1 style="color: red; text-align: center;">Formulaire pour
		ajouter une assurance</h1>

	<a
		href="${pageContext.request.contextPath}/panier/dossierPanierSoumettreAjouterSansPayer">Enregistrer
		panier et payer plus tard</a>
	<a
		href="${pageContext.request.contextPath}/panier/dossierPanierSoumettreAjouterPayerCB">Enregistrer
		Panier et payer via CB</a><
	<a
		href="${pageContext.request.contextPath}/panier/dossierPanierSoumettreAjouter">Enregistrer
		Panier et payer via paypal</a>

	<table class="table table-bordered" style="background-color: white;">

		<tr>
			<th>ID</th>
			<th>Date de d�part</th>
			<th>Date d'arriv�e</th>
			<th>Nombre de place</th>
			<th>Prix</th>
			<th>Statut</th>
			<th>Destination</th>
			<th>Operation</th>
		</tr>


		<tr>
			<td>${voyage.id}</td>
			<td>${voyage.dateDepart}</td>
			<td>${voyage.dateArrivee}</td>
			<td>${voyage.nbPlaces}</td>
			<td>${voyage.prix}</td>
			<td>${voyage.statut}</td>
			<td>${voyage.destination.pays}</td>
			<!-- 				<td><a class="btn btn-danger" -->
			<%-- 					href="${pageContext.request.contextPath}/voyage/soumettre-supprLien?pId=${v.id}">Supprimer</a> --%>
			<!-- 					<a class="btn btn-success" -->
			<%-- 					href="${pageContext.request.contextPath}/voyage/soumettre-modifLien?pId=${v.id}">Modifier</a> --%>
			<!-- 				</td> -->
		</tr>
	</table>






	<h1>${msg}</h1>
</body>
</html>