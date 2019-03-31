<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Importer la lib jstl core -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login conseiller marketing</title>
</head>
<body
	style="background: url('${pageContext.request.contextPath}/resources/images/map-307442_960_720.png');
	background-attachment: fixed; background-size:cover;">

	<h1
		style="text-align: center; font-weight: bold; color: black; -webkit-text-fill-color: white; -webkit-text-stroke-width: 1.5px; -webkit-text-stroke-color: rgb(78, 105, 193); font-size: 3vw;">Bienvenue
		Conseiller !</h1>
	<br />
	<h2 style="text-align: center;
	font-weight: bold;
	color: white;
	-webkit-text-fill-color: white;
	-webkit-text-stroke-width: 1.5px;
	-webkit-text-stroke-color: rgb(78, 105, 193);
	font-size: 2vw;">Connectez-vous pour
		accéder à votre espace.</h2>
	<br />

	<form class="form-horizontal" action="connexion" method="post"
		style="text-align: center">
		<div class="form-group">
			Identifiant:
			<div class="col-sm-2">
				<input type="text" name="j_username" />
			</div>
		</div>
		<br />
		<div class="form-group">
			Mot de passe:
			<div class="col-sm-2">
				<input type="password" name="j_password" />
			</div>
		</div>
		<br /> <input type="submit" value="Se connecter" />

	</form>

	<c:if test="${not empty erreur}">
		<h1 style="color: red; text-align: center">La connexion a echoué.</h1>
	</c:if>

</body>
</html>