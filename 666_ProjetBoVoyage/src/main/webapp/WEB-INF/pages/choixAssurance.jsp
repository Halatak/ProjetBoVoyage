<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Ajouter la taglib spring mvc form -->
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- Ajouter la taglib de jstl core -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ include file='/resources/templates/TagCSSJS.jsp'%>


</head>
<body>

<%-- La directive include --%>
	<%@ include file='/resources/templates/navBar.jsp'%>

	<h1 style="color: red; text-align: center;">Formulaire pour
		ajouter une assurance</h1>
		
		<form:form cssClass="form-horizontal" method="post"
		action="panierSoumettreAssurance" commandName="asAjout">

		<div class="form-group">
			<form:radiobutton path="id" value="2"/>Aucune assurance
		</div>
		
		<div class="form-group">
			<form:radiobutton path="id" value="1"/>
			Assurance voyage 30 euros<br/>
			Couverture des frais médicaux à l’étranger<br/>
			Rapatriement médical<br/>
			Couverture bagages en cas de vol, perte ou dommages<br/>
			Couverture annulation
		</div>
		
		

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Ajouter une
					assurance</button>
			</div>
		</div>
	</form:form>
</body>
</html>