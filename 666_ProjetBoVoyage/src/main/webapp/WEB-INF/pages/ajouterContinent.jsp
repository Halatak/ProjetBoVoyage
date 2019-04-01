<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

	<h1 style="color: red; text-align: center;">Formulaire pour
		ajouter une destination</h1>

	<form:form cssClass="form-horizontal" method="post"
		action="continentSoumettreAjouter" commandName="contAjout" enctype="multipart/form-data">

		<div class="form-group">
			<label for="idDescription" class="col-sm-2 control-label">Description</label>
			<div class="col-sm-5">
				<form:input cssClass="form-control" id="idDescription" path="description"
					placeholder="Description" />
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
					destination</button>
			</div>
		</div>

	</form:form>
	<h1>${msg}</h1>
	
</body>
</html>