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
<title>Ajouter une voiture</title>
<%@ include file='/resources/templates/TagCSSJS.jsp'%>
</head>
<body>
	<%-- La directive include --%>
	<%@ include file='/resources/templates/navBarConsMark.jsp'%>

<br/>
<br/>
<br/>
	<h1>Formulaire pour
		ajouter une voiture</h1>

	<form:form cssClass="form-horizontal" method="post"
		action="voitureSoumettreAjouter" commandName="voiAjout" enctype="multipart/form-data" >

		<div class="form-group">
			<label for="idMarque" class="col-sm-2 control-label">Marque</label>
			<div class="col-sm-5">
				<form:input cssClass="form-control" id="idMarque" path="marque"
					placeholder="Marque" />
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
			<label for="idPhoto" class="col-sm-2 control-label">Photo</label>
			<div class="col-sm-5">
				<input type="file" name="file" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Ajouter une
					voiture</button>
			</div>
		</div>

	</form:form>
</body>
</html>