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
	<jsp:include page="/resources/templates/navBarAccueil.jsp" />

	<br />
	<br />
	<br />
	
	<h1>${msg}</h1>

	<!-- Plans -->
	<section id="plans">
		<div class="container">
			<div class="row">


				<c:forEach items="${voyageListe}" var="v">
					<!-- item -->
					<div class="col-md-4 text-center panel-accueil">
						<div class="panel panel-danger panel-pricing">
							<div class="panel-heading">
								<h2>${v.destination.pays}</h2>
							</div>
							
							<div class="panel-body text-center">
								<p>
									<img
										src="../destination/photoDes?idDest=${v.destination.idDestination}"
										style="width: 250px; height: 150px;">
								</p>
							</div>
							<div class="panel-body text-center">
								<p>
									<strong>Prix: ${v.prix} &#8364;</strong>
								</p>
							</div>
							<ul class="list-group text-center">
								<li class="list-group-item"><i class="fa fa-plane"></i>
									Départ: ${v.dateDepart}</li>
								<li class="list-group-item"><i class="fa fa-plane"></i>
									Arrivée: ${v.dateArrivee}</li>
								<li class="list-group-item">
									Nombre de places: ${v.nbPlaces}</li>
								<li class="list-group-item"><i class="fa fa-check"></i>
									Statut: ${v.statut}</li>
							</ul>
							<div class="panel-footer">
								<a class="btn btn-lg btn-block btn-success"
									href="${pageContext.request.contextPath}/panier/panierSoumettreAjouter?pId=${v.id}">Réserver</a>
							</div>
						</div>
					</div>
					<!-- /item -->
				</c:forEach>

			</div>
		</div>
	</section>
	<!-- /Plans -->
<div>
		<!-- Nous chargeons les fichiers CDN de Leaflet. Le CSS AVANT le JS -->
		<link rel="stylesheet"
			href="https://unpkg.com/leaflet@1.3.1/dist/leaflet.css"
			integrity="sha512-Rksm5RenBEKSKFjgI3a41vrjkw4EVPlJ3+OiI65vTjIdo9brlAacEuKOiQ5OFh7cOI1bkDwLqdLw3Zg0cRJAAQ=="
			crossorigin="" />
		<script src="https://unpkg.com/leaflet@1.3.1/dist/leaflet.js"
			integrity="sha512-/Nsx9X4HebavoBvEBuyp3I7od5tA0UzAxs+j83KgC8PU0kgB4XiK4Lfe4y4cgBtaRJQEIFCW+oC506aPT2L1zw=="
			crossorigin=""></script>
		<script type="text/javascript">
			// Nous initialisons une liste de marqueurs
			var lat = 30.291017;
			var lon = 11.78305;
			var macarte = null;
			var villes = {
				"Oslo" : {
					"lat" : 59.9138688,
					"lon" : 10.7522454
				},
				"Lima" : {
					"lat" : -12.046374,
					"lon" : -77.0427934
				},
				"Brasilia" : {
					"lat" : -14.235004,
					"lon" : -51.925280
				},
				"Manila" : {
					"lat" : 14.602137,
					"lon" : 121.050904
				},
				"Bangkok" : {
					"lat" : 13.7563309,
					"lon" : 100.5017651
				},
				"Guatemala" : {
					"lat" : 15.783471,
					"lon" : -90.230759
				}
			};
			// Fonction d'initialisation de la carte
			function initMap() {
				// Créer l'objet "macarte" et l'insèrer dans l'élément HTML qui a l'ID "map"
				macarte = L.map('map').setView([ lat, lon ], 1);
				// Leaflet ne récupère pas les cartes (tiles) sur un serveur par défaut. Nous devons lui préciser où nous souhaitons les récupérer. Ici, openstreetmap.fr
				L
						.tileLayer(
								'https://{s}.tile.openstreetmap.fr/osmfr/{z}/{x}/{y}.png',
								{
									// Il est toujours bien de laisser le lien vers la source des données
									attribution : 'données © <a href="//osm.org/copyright">OpenStreetMap</a>/ODbL - rendu <a href="//openstreetmap.fr">OSM France</a>',
									minZoom : 1,
									maxZoom : 20
								}).addTo(macarte);
				// var marker = L.marker([lat, lon]).addTo(macarte);
				// var markerNorvege = L.marker([59.9138688, 10.7522454]).addTo(macarte);
				// var markerPerou = L.marker([-12.046374, -77.0427934]).addTo(macarte);
				// var markerBresil = L.marker([-14.235004, -51.925280]).addTo(macarte);
				// var markerPhilippines = L.marker([14.602137, 121.050904]).addTo(macarte);
				// var markerThaïlande = L.marker([13.7563309, 100.5017651]).addTo(macarte);
				// Nous parcourons la liste des villes
				for (ville in villes) {
					var marker = L.marker(
							[ villes[ville].lat, villes[ville].lon ]).addTo(
							macarte);
					
					marker.bindPopup(ville);
				}

				//             for (ville in villes) {
				//         		var marker = L.marker([villes[ville].lat, villes[ville].lon]).addTo(macarte);
				//         	} 
			}
			window.onload = function() {
				// Fonction d'initialisation qui s'exécute lorsque le DOM est chargé
				initMap();
			};
		</script>

		<style type="text/css">
#map { 
	height: 400px;
	width: 600px;
}
</style>
		
	</div>
	<div>
		<center>
			<div id="map">
				<!-- Ici s'affichera la carte -->
			</div>
		</center>
	</div>
	
	
</body>
</html>