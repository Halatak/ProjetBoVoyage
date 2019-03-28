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
<title>Modifier un avion</title>
<%@ include file='/resources/templates/TagCSSJS.jsp'%>
</head>
<body>
	<%-- La directive include --%>
	<%@ include file='/resources/templates/navBar.jsp'%>

	<h1 style="color: red; text-align: center;">Formulaire pour
		modifier un hotel</h1>

	<form:form cssClass="form-horizontal" method="post"
		action="hotelSoumettreModifier" commandName="hoModif">


		<div class="form-group">
			<label for="idId" class="col-sm-2 control-label">Id</label>
			<div class="col-sm-5">
				<form:input cssClass="form-control" id="idId" path="id"
					placeholder="Id" />
			</div>
		</div>
		<div class="form-group">
			<label for="idNom" class="col-sm-2 control-label">Nom</label>
			<div class="col-sm-5">
				<form:input cssClass="form-control" id="idNom"
					path="nom" placeholder="Nom" />
			</div>
		</div>
		<div class="form-group">
			<label for="idDescription" class="col-sm-2 control-label">Nombre d'�toile</label>
			<div class="col-sm-5">
				<form:input cssClass="form-control" id="idNombreEtoile"
					path="nbEtoiles" placeholder="Nombre d'�toile" />
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
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Modifer un
					hotel</button>
			</div>
		</div>
	</form:form>
	<h1>${msg}</h1>

</body>
</html>