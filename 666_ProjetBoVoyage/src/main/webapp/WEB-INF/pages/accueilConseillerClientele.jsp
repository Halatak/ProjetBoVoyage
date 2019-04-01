<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil Conseiller Marketing</title>

<%@ include file='/resources/templates/TagCSSJS.jsp'%>

</head>
<body>

	<%-- La directive include --%>
	<jsp:include page="/resources/templates/navBarConsClient.jsp" />

	coucou conseiller marketing

	<table class="table table-bordered">
		<tr>
			<th>ID</th>
			<th>Numero</th>
			<th>Etat</th>
			<th>Voyage</th>
			<th>Nom Client</th>
			<th>Prenom Client</th>
			<th>Assurance</th>
			<th>Conseiller</th>
			<th>Opération</th>
		</tr>

		<c:forEach items="${dossierListe}" var="d">
			<tr>
				<td>${d.id}</td>
				<td>${d.numero}</td>
				<td>${d.etat}</td>
				<td>${d.voyage.id}</td>
				<td>${d.client.nom}</td>
				<td>${d.client.prenom}</td>
				<td>${d.assurance.type}</td>
				<td>${d.conseillerClientele.idCon}</td>
				<td><a class="btn btn-danger"
					href="${pageContext.request.contextPath}/dossier/soumettre-supprLien?pId=${d.id}">Supprimer</a>
					<a class="btn btn-success"
					href="${pageContext.request.contextPath}/dossier/soumettre-modifLien?pId=${d.id}">Modifier</a>
				</td>

			</tr>
		</c:forEach>

	</table>
	<h1>${msg}</h1>

</body>
</html>