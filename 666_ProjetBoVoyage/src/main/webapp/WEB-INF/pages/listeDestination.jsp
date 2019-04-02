<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<%@ include file='/resources/templates/TagCSSJS.jsp'%>

</head>
<body
style="background: url('${pageContext.request.contextPath}/resources/images/Tropical-Rainforest-Landscape.jpg');
	background-attachment: fixed; background-size:cover;">
	<%-- La directive include --%>
	<jsp:include page="/resources/templates/navBarConsMark.jsp" />

	<table class="table table-bordered" style="background-color: white;">
		<tr>
			<th>ID</th>
			<th>Pays</th>
			<th>Description</th>
			<th>photo</th>
			<th>Opération</th>
		</tr>

		<c:forEach items="${destinationListe}" var="des">
			<tr style="text-align: center;">
				<td>${des.idDestination}</td>
				<td>${des.pays}</td>
				<td>${des.description}</td>
				<td><img src="photoDes?idDest=${des.idDestination}" style="max-width: 250px;"></td>
				<td><a class="btn btn-danger"
					href="
									${pageContext.request.contextPath}/destination/destinationSoumettre-supprLien?pId=${des.idDestination}">Supprimer</a>|<a
					class="btn btn-success"
					href="
									${pageContext.request.contextPath}/destination/destinationSoumettre-modifLien?pId=${des.idDestination}">Modifier</a></td>
			</tr>
		</c:forEach>

	</table>
	<h1>${msg}</h1>



</body>
</html>