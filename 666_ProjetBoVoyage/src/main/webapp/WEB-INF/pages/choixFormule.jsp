<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- Ajouter la taglib spring mvc form -->
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- Ajouter la taglib de jstl core -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ include file='/resources/templates/TagCSSJS.jsp'%>
</head>
<body>
	<%-- La directive include --%>
	<%@ include file='/resources/templates/navBarAccueil.jsp'%>

	<h1>Choisir une Formule</h1>

	<!-- Plans -->
	<section id="plans">
		<div class="container">
			<div class="row">


				<c:forEach items="${foAjout}" var="f">
					<!-- item -->
					<div class="col-md-4 text-center">
						<div class="panel panel-danger panel-pricing">


							<div class="panel-heading">
								<h2>${f.typeFormule}</h2>
							</div>

							<ul class="list-group text-center">
								<li class="list-group-item">Pays:
									${f.voyage.destination.pays}</li>
							</ul>
							<c:if test="${ not empty f.avion}">
								<ul class="list-group text-center">
									<li class="list-group-item">Compagnie Aerienne:
										${f.avion.description}</li>
								</ul>
							</c:if>
							<c:if test="${ not empty f.hotel}">
								<div class="panel-body text-center">
									<p>
										<img src="../hotel/photoHo?idHo=${f.hotel.id}"
											style="max-width: 250px;">
									</p>
								</div>

								<ul class="list-group text-center">
									<li class="list-group-item">Hotel: ${f.hotel.nom}</li>
									<li class="list-group-item">${f.hotel.description}</li>
								</ul>
							</c:if>
							<c:if test="${ not empty f.voiture}">
								<div class="panel-body text-center">
									<p>
										<img src="../voiture/photoVoi?idVoi=${f.voiture.idVoiture}"
											style="max-width: 250px;">
									</p>
								</div>


								<ul class="list-group text-center">
									<li class="list-group-item">Modele: ${f.voiture.marque}</li>
									<li class="list-group-item">${f.voiture.description}</li>
								</ul>
							</c:if>
							<div class="panel-footer">
								<a class="btn btn-lg btn-block btn-success"
									href="${pageContext.request.contextPath}/panier/panierAfficheAssurance">Réserver</a>
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