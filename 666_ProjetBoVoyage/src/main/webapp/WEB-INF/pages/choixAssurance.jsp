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
	<%@ include file='/resources/templates/navBar.jsp'%>

	<h1 style="color: red; text-align: center;">Formulaire pour
		ajouter une assurance</h1>

	<form:form cssClass="form-horizontal" method="post"
		action="panierSoumettreAssurance" commandName="asAjout">

		<div class="form-group">
			<label for="idAssurance" class="col-sm-2 control-label">Id
				Assurance</label>
			<div class="col-sm-5">
				<form:input cssClass="form-control" id="idAssurance"
					path="id" placeholder="Id Destination" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Ajouter une
					assurance</button>
			</div>
		</div>
	</form:form>
	<h1>${msg}</h1>
</body>
</html>