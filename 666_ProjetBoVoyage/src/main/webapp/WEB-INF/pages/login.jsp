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
<body>

	<form action="connexion" method="post">
		Identifiant: <input type="text" name="j_username" /> <br /> Mot de
		passe: <input type="password" name="j_password" /> <br /> <input
			type="submit" value="Se connecter" />

	</form>

	<c:if test="${not empty erreur}">
		<h1 style="color: red; text-align: center">La connexion a echoué.</h1>
	</c:if>

</body>
</html>