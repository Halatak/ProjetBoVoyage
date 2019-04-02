<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- Ajouter la taglib spring mvc form -->
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- Ajouter la taglib de jstl core -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supprimer un hotel</title>
<%@ include file='/resources/templates/TagCSSJS.jsp'%>
</head>
<body>
	<%-- La directive include --%>
	<%@ include file='/resources/templates/navBarConsMark.jsp'%>

	<h1>Formulaire pour
		supprimer un hotel</h1>

	<form:form cssClass="form-horizontal" method="post"
		action="hotelSoumettreSupprimer" commandName="hoSuppr">


		<div class="form-group">
			<label for="idId" class="col-sm-2 control-label">Id</label>
			<div class="col-sm-5">
				<form:input cssClass="form-control" id="idId" path="id"
					placeholder="Id" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Supprimer un hotel</button>
			</div>
		</div>
	</form:form>
	<h1>${msg}</h1>

</body>
</html>