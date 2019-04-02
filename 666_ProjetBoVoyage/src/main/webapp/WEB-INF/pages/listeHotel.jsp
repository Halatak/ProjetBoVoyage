<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des hotels</title>

<%@ include file='/resources/templates/TagCSSJS.jsp'%>

</head>
<body>

	<%-- La directive include --%>
	<jsp:include page="/resources/templates/navBarConsMark.jsp" />

<br/>
<br/>
<br/>
	<table class="table table-bordered"  style="background-color: white;">
		<tr>
			<th>ID</th>
			<th>Nom</th>
			<th>Prix</th>
			<th>Description</th>
			<th>Nombre d'étoile</th>
			<th>Photo</th>
			<th>Opération</th>
		</tr>

		<c:forEach items="${hotelListe}" var="ho">
			<tr style="text-align:center; vertical-align: middle;">
				<td>${ho.id}</td>
				<td>${ho.nom}</td>
				<td>${ho.prix}</td>
				<td>${ho.description}</td>
				<td>${ho.nbEtoiles}</td>
				<td><img src="photoHo?idHo=${ho.id}"  style="max-width: 250px;"></td>
				<td><a class="btn btn-danger"
					href="
									${pageContext.request.contextPath}/hotel/hotelSoumettre-supprLien?pId=${ho.id}">Supprimer</a>|<a
					class="btn btn-success"
					href="
									${pageContext.request.contextPath}/hotel/hotelSoumettre-modifLien?pId=${ho.id}">Modifier</a></td>
			</tr>
		</c:forEach>

	</table>
	<h1>${msg}</h1>
</body>
</html>