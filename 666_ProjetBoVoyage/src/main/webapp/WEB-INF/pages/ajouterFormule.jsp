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
<title>Ajouter une formule</title>
</head>
<body>
	<%-- La directive include --%>
	<%@ include file='/resources/templates/navBar.jsp'%>

	<h1 style="color: red; text-align: center;">Formulaire pour
		ajouter une formule</h1>

	<form:form cssClass="form-horizontal" method="post"
		action="soumettreFormuleADD" commandName="fAjout">

		<div class="form-group">
			<label for="idAvion" class="col-sm-2 control-label">Avion</label>
			<div class="col-sm-5">
				<form:input cssClass="form-control" id="idAvion" path="avion"
					placeholder="Avion" />
			</div>
		</div>
		<div class="form-group">
			<label for="idHotel" class="col-sm-2 control-label">Hotel</label>
			<div class="col-sm-5">
				<form:input cssClass="form-control" id="idHotel" path="hotel"
					placeholder="Hotel" />
			</div>
		</div>
		<div class="form-group">
			<label for="idVoiture" class="col-sm-2 control-label">Voiture</label>
			<div class="col-sm-5">
				<form:input cssClass="form-control" id="idVoiture" path="voiture"
					placeholder="Voiture" />
			</div>

		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Ajouter une
					formule</button>
			</div>
		</div>

	</form:form>

</body>
</html>