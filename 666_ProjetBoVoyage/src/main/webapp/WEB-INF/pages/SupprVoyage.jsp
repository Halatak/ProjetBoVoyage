<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supprimer Voyage</title>
<%@ include file='/resources/templates/TagCSSJS.jsp'%>
</head>
<body>

	<%-- La directive include --%>
	<%@ include file='/resources/templates/navBar.jsp'%>

	<h1 style="color: red" align="center">Formulaire de suppression</h1>
	<form:form cssClass="form-horizontal" method="post"
		action="voyageSoumettreSupprimer" commandName="voySuppr">

		<div class="form-group">
			<label for="idEtu" class="col-sm-2 control-label">Id Voyage:
			</label>
			<div class="col-sm-5">
				<form:input cssClass="form-control" id="idEtu" placeholder="Id"
					path="id" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-success">Supprimer</button>
			</div>
		</div>


	</form:form>

</body>
</html>