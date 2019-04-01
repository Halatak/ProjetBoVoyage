<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste Avion</title>

<%@ include file='/resources/templates/TagCSSJS.jsp'%>

</head>
<body>

	<%-- La directive include --%>
	<jsp:include page="/resources/templates/navBarConsMark.jsp" />

	<table class="table table-bordered">
		<tr>
			<th>ID</th>
			<th>Prix</th>
			<th>Description</th>
			<th>Photo</th>
			<th>Opération</th>
		</tr>

		<c:forEach items="${avionListe}" var="av">
			<tr>
				<td>${av.idAvion}</td>
				<td>${av.prix}</td>
				<td>${av.description}</td>
				<td></td>
				<td><a class="btn btn-danger"
					href="
									${pageContext.request.contextPath}/avion/avionSoumettre-supprLien?pId=${av.idAvion}">Supprimer</a>|<a
					class="btn btn-success"
					href="
									${pageContext.request.contextPath}/avion/avionSoumettre-modifLien?pId=${av.idAvion}">Modifier</a></td>
			</tr>
		</c:forEach>

	</table>
	<h1>${msg}</h1>
</body>
</html>