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
<title>Modifier Voyage</title>
<%@ include file='/resources/templates/TagCSSJS.jsp'%>
</head>
<body>

	<%-- La directive include --%>
	<%@ include file='/resources/templates/navBarConsMark.jsp'%>
	<br />
	<br />
	<br />

	<h1>Formulaire pour
		modifier un voyage</h1>

	<form:form cssClass="form-horizontal" method="post"
		action="voyageSoumettreModifier" commandName="voyModif">

		<div class="form-group">
			<label for="idId" class="col-sm-2 control-label">Id</label>
			<div class="col-sm-5">
				<form:input cssClass="form-control" id="idId" path="id"
					placeholder="Id" />
			</div>
		</div>
		<div class="form-group">
			<label for="idDateDepart" class="col-sm-2 control-label">Date
				de départ</label>
			<div class="col-sm-5">
				<form:input type="date" cssClass="form-control" id="idDateDepart"
					path="dateDepart" placeholder="Date de départ" />
			</div>
		</div>

		<div class="form-group">
			<label for="idHeureDepart" class="col-sm-2 control-label">Horaire
				départ Départ</label>
			<div class="col-sm-5">
				<form:input type="time" cssClass="form-control" id="idHeureDepart"
					path="heureDepart" placeholder="Heure Depart" />
			</div>
		</div>
		<div class="form-group">
			<label for="idDateArrive" class="col-sm-2 control-label">Date
				d'arrivé</label>
			<div class="col-sm-5">
				<form:input type="date" cssClass="form-control" id="idDateArrive"
					path="dateArrivee" placeholder="Date d'arrivé" />
			</div>
		</div>

		<div class="form-group">
			<label for="idHeureArrive" class="col-sm-2 control-label">Horaire
				arrivée Départ</label>
			<div class="col-sm-5">
				<form:input type="time" cssClass="form-control" id="idHeureArrive"
					path="heureArrive" placeholder="Heure Arrivee" />
			</div>
		</div>
		<div class="form-group">
			<label for="idNombrePlaces" class="col-sm-2 control-label">Nombre
				de places</label>
			<div class="col-sm-5">
				<form:input cssClass="form-control" id="idNombrePlaces"
					path="nbPlaces" placeholder="Nombre de places" />
			</div>
		</div>
		<div class="form-group">
			<label for="idPrix" class="col-sm-2 control-label">Prix</label>
			<div class="col-sm-5">
				<form:input cssClass="form-control" id="idPrix" path="prix"
					placeholder="Prix" />
			</div>
		</div>

		<div class="form-group">
			<label for="idStatut" class="col-sm-2 control-label">Statut</label>
			<div class="col-sm-1">
				<form:checkbox cssClass="form-control" id="idStatut" path="statut" />
			</div>
		</div>

		<div class="form-group">
			<label for="idDestination" class="col-sm-2 control-label">Destination</label>
			<div class="col-sm-5">
				<form:input cssClass="form-control" id="idDestination"
					path="destination.idDestination" placeholder="Destination" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Modifier</button>
			</div>
		</div>
	</form:form>
	<h1>${msg}</h1>

</body>
</html>