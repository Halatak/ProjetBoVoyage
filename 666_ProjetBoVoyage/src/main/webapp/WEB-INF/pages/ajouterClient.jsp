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
<title>Ajouter un avion</title>
<%@ include file='/resources/templates/TagCSSJS.jsp'%>
</head>
<body>
	<%-- La directive include --%>
	<%@ include file='/resources/templates/navBar.jsp'%>

	<h1 style="color: red; text-align: center;">Formulaire pour
		s'enregistrer</h1>

	<form:form cssClass="form-horizontal" method="post"
		action="clientSoumettreAjouter" commandName="clAjout">

		<div class="form-group">
			<label for="idMail" class="col-sm-2 control-label">Mail</label>
			<div class="col-sm-5">
				<form:input cssClass="form-control" id="idMail"
					path="mail" placeholder="Mail" />
			</div>
		</div>
		<div class="form-group">
			<label for="idPrix" class="col-sm-2 control-label">Mot de passe</label>
			<div class="col-sm-5">
				<form:input cssClass="form-control" id="idMdp" path="mdp"
					placeholder="Mot de passe" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">S'enregistrer et ajouter une carte bancaire</button>
			</div>
		</div>

	</form:form>
	<h1>${msg}</h1>

</body>
</html>