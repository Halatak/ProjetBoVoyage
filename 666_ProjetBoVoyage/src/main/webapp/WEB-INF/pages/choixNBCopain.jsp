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
<title>ChoisirAccompagnant</title>
<%@ include file='/resources/templates/TagCSSJS.jsp'%>

</head>
<body>
	<%-- La directive include --%>
	<%@ include file='/resources/templates/navBarAccueil.jsp'%>
	<br />
	<br />
	<br />

	<h1 style="color: red; text-align: center;">Ajouter un Accompagnant</h1>

	<form:form cssClass="form-horizontal" method="post"
		action="panierSoumettreNombreCopain" commandName="copInt">
		<div class="form-group">
			<label for="idco" class="col-sm-2 control-label">Nombre
				d'accompagnants</label>
			<div class="col-sm-5">
				<form:input type="number" cssClass="form-control" id="idco"
					path="nbCop" placeholder="Nombre accompagnants" required="true" />
			</div>
		</div>


		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Enregistrer</button>
			</div>
		</div>
	</form:form>


	<h1>${msg}</h1>
</body>
</html>