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
	<%@ include file='/resources/templates/navBarConsMark.jsp'%>

<br/>
<br/>
<br/>
	<h1>Formulaire pour
		modifier un avion</h1>

<br/>
	<form:form cssClass="form-horizontal" method="post"
		action="avionSoumettreModifier" commandName="avModif">


		<div class="form-group">
			<label for="idId" class="col-sm-2 control-label">Id</label>
			<div class="col-sm-5">
				<form:input cssClass="form-control" id="idId"
					path="idAvion" placeholder="Id" />
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
				<button type="submit" class="btn btn-default">Modifier</button>
			</div>
		</div>
	</form:form>
	<h1>${msg}</h1>

</body>
</html>