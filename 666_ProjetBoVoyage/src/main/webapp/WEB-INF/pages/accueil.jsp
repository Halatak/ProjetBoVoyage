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
<body style="background: url('${pageContext.request.contextPath}/resources/images/Tropical-Rainforest-Landscape.jpg');
	background-attachment: fixed; background-size:cover;">

	<%-- La directive include --%>
	<jsp:include page="/resources/templates/navBar.jsp" />

	<br />
	<br />
	<br />

	<!-- Plans -->
	<section id="plans">
		<div class="container">
			<div class="row">


				<c:forEach items="${voyageListe}" var="v">
				<!-- item -->
				<div class="col-md-4 text-center">
					<div class="panel panel-danger panel-pricing">
						<div class="panel-heading">
							<i class="fa fa-desktop"></i>
							<h3>${v.destination.pays}</h3>
						</div>
						<div class="panel-body text-center">
							<p>
								<strong>Prix: ${v.prix}  &#8364;</strong>
							</p>
						</div>
						<div class="panel-body text-center">
							<p>
								<img src="../destination/photoDes?idDest=${v.destination.idDestination}" style="max-width:100px;">
							</p>
						</div>
						<ul class="list-group text-center">
							<li class="list-group-item"><i class="fa fa-check"></i>
								Départ: ${v.dateDepart}</li>
							<li class="list-group-item"><i class="fa fa-check"></i>
								Arrivée: ${v.dateArrivee}</li>
							<li class="list-group-item"><i class="fa fa-check"></i>
								Nombre de places: ${v.nbPlaces}</li>
							<li class="list-group-item"><i class="fa fa-check"></i> 
								Statut: ${v.statut}</li>
						</ul>
						<div class="panel-footer">
							<a class="btn btn-lg btn-block btn-success" href="${pageContext.request.contextPath}/panier/panierSoumettreAjouter?pId=${v.id}">Réserver</a>
						</div>
					</div>
				</div>
				<!-- /item -->
				</c:forEach>

			</div>
		</div>
	</section>
	<!-- /Plans -->

	<h1>${msg}</h1>
</body>
</html>