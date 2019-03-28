<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- Ajouter la taglib spring mvc form -->
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- Ajouter la taglib de jstl core -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter un hotel</title>
</head>
<body>
	<%-- La directive include --%>
	<%@ include file='/resources/templates/navBar.jsp'%>

	<h1 style="color: red; text-align: center;">Formulaire pour
		ajouter un hotel</h1>

	<form:form cssClass="form-horizontal" method="post"
		action="soumettreHotelADD" commandName="hAjout">

		<div class="form-group">
			<label for="idNom" class="col-sm-2 control-label">Nom</label>
			<div class="col-sm-5">
				<form:input cssClass="form-control" id="idNom" path="nom"
					placeholder="Nom" />
			</div>
		</div>
		<div class="form-group">
			<label for="idDescription" class="col-sm-2 control-label">Description</label>
			<div class="col-sm-5">
				<form:input cssClass="form-control" id="idDescription"
					path="description" placeholder="Description" />
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
			<label for="idNombreEtoile" class="col-sm-2 control-label">Nombre
				d'étoile</label>
			<div class="col-sm-5">
				<form:input cssClass="form-control" id="idNombreEtoile"
					path="nombreEtoile" placeholder="Nombre d'étoile" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Ajouter un
					hotel</button>
			</div>
		</div>

	</form:form>
</body>
</html>