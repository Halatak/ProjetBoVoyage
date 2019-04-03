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
<title>Résumé panier</title>
<%@ include file='/resources/templates/TagCSSJS.jsp'%>

</head>
<body>
	<%-- La directive include --%>
	<%@ include file='/resources/templates/navBarClient.jsp'%>

	<h1 style="color: red; text-align: center;">Récapitulatif panier</h1>


	<!-- Plans -->
	<section id="plans">
		<div class="container">
			<div class="row">

				<!-- item -->
				<div class="col-md-8 col-md-offset-2 text-center">
					<div class="panel panel-danger panel-pricing">

						<!-- Nom du pays de la destination -->
						<div class="panel-heading">
							<h2>${dossier.voyage.destination.pays}</h2>
						</div>
						<!-- Photo -->
						<div class="panel-body text-center">
							<p>
								<img
									src="../destination/photoDes?idDest=${dossier.voyage.destination.idDestination}"
									style="max-width: 250px;">
							</p>
						</div>

						<!-- Description -->
						<div class="panel-body text-center">
							<p>
								<strong>Description:</strong>
							</p>
						</div>
						<ul class="list-group text-center">
							<li class="list-group-item">
								${dossier.voyage.destination.description}</li>
						</ul>

						<!-- Groupe d'info -->
						<div class="panel-body text-center"><p><strong>Infos voyage:</strong></p></div>
						<ul class="list-group text-center">
							<li class="list-group-item"><i class="fa fa-plane"></i>
								Départ: ${dossier.voyage.dateDepart}</li>
							<li class="list-group-item"><i class="fa fa-plane"></i>
								Arrivée: ${dossier.voyage.dateArrivee}</li>
							<li class="list-group-item">Nombre de places choisies:
								${dossier.voyage.nbPlaces}</li>
						</ul>

						<!-- Assurance -->
						<div class="panel-body text-center"><p><strong>Assurance choisie:</strong></p></div>
						<ul class="list-group text-center">
							<li class="list-group-item">${dossier.assurance.id}</li>
						</ul>

						<!-- Formule -->
						<div class="panel-body text-center"><p><strong>Formule choisie:</strong></p></div>
						<ul class="list-group text-center">
							<li class="list-group-item">${formule.id}</li>
						</ul>

						<!-- Info client -->
						<div class="panel-body text-center"><p><strong>Infos client:</strong></p></div>
						<ul class="list-group text-center">
							<li class="list-group-item">Nom - prénom: ${dossier.client.nom}</li>
							<li class="list-group-item">Téléphone: ${dossier.client.telephone}</li>
							<li class="list-group-item">E-Mail: ${dossier.client.mail}</li>
						</ul>

						<!-- Prix -->
						<div class="panel-body text-center">
							<p>
								<strong>Prix: ${dossier.voyage.prix} &#8364;</strong>
							</p>
						</div>

						<div class="panel-footer">
							<a class="btn btn-lg btn-success"
								href="${pageContext.request.contextPath}/panier/dossierPanierSoumettreAjouterSansPayer">Enregistrer
								panier et payer plus tard</a> <a
								class="btn btn-lg btn-success fa fa-credit-card"
								href="${pageContext.request.contextPath}/panier/dossierPanierSoumettreAjouterPayerCB"
								style="font-size: 31px; width: 100px; height: 46px;"></a> <a
								class="btn btn-lg btn-success fa fa-cc-paypal"
								href="${pageContext.request.contextPath}/panier/dossierPanierSoumettreAjouter"
								style="font-size: 31px; width: 100px; height: 46px;"></a>

						</div>
					</div>
				</div>
				<!-- /item -->

			</div>
		</div>
	</section>
	<!-- /Plans -->


	<h1>${msg}</h1>
</body>
</html>