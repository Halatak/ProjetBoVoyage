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
	<%@ include file='/resources/templates/navBarClient.jsp'%>

	<h1 style="color: red; text-align: center;">Formulaire pour
		ajouter un Client</h1>

	<form:form cssClass="form-horizontal" method="post"
		action="panierSoumettreClient" commandName="cliAjout">
		<div class="form-group">
			<label for="idciv" class="col-sm-2 control-label">Civilitée</label>
			<div class="col-sm-5">
				<form:input cssClass="form-control" id="idciv" path="civilite"
					placeholder="Civilité" required="true" />
			</div>
		</div>
		<div class="form-group">
			<label for="idnom" class="col-sm-2 control-label">Nom</label>
			<div class="col-sm-5">
				<form:input cssClass="form-control" id="idnom" path="nom"
					placeholder="Nom" required="true" />
			</div>
		</div>
		<div class="form-group">
			<label for="idPrenom" class="col-sm-2 control-label">Prenom</label>
			<div class="col-sm-5">
				<form:input cssClass="form-control" id="idPrenom" path="prenom"
					placeholder="Prenom" required="true" />
			</div>
		</div>
		<div class="form-group">
			<label for="iddateNaissance" class="col-sm-2 control-label">Date de naissance</label>
			<div class="col-sm-5">
				<form:input type="date" cssClass="form-control" id="iddateNaissance"
					path="dateNaissance" placeholder="Date Naissance" required="true" />
			</div>
		</div>
		<div class="form-group">
			<label for="idtelephone" class="col-sm-2 control-label">Telephone</label>
			<div class="col-sm-5">
				<form:input cssClass="form-control" id="idtelephone"
					path="telephone" placeholder="Telephone" required="true" />
			</div>
		</div>

		<div class="form-group">
			<label for="idMail" class="col-sm-2 control-label">Mail</label>
			<div class="col-sm-5">
				<form:input cssClass="form-control" id="idMail" path="mail"
					placeholder="Mail" required="true" />
			</div>
		</div>


		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">S'enregistrer
					et ajouter une adresse</button>
			</div>
		</div>
	</form:form>


	<h1>${msg}</h1>
</body>
</html>