<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ include file='/resources/templates/TagCSSJS.jsp'%>
</head>
<body>

	<%-- La directive include --%>
	<jsp:include page="/resources/templates/navBarConsMark.jsp" />
	<br />
	<br />
	<br />

	<table class="table table-bordered">
		<tr>
			<th>ID</th>
			<th>Description</th>
			<th>photo</th>
		</tr>

		<c:forEach items="${continentListe}" var="des">
			<tr>
				<td>${des.idContinent}</td>
				<td>${des.description}</td>
				<td><img src="photoCont?idCont=${des.idContinent}"></td>
				
			</tr>
		</c:forEach>

	</table>
	<h1>${msg}</h1>


</body>
</html>