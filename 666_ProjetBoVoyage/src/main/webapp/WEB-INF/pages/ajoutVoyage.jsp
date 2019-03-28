<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <!-- Ajouter la taglib spring mvc form -->
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
     <!-- Ajouter la taglib de jstl core -->
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter un voyage</title>
<link rel="stylesheet" href="resources/css/monStyles.css" />
</head>
<body>
	<%-- La directive include --%>
	<%@ include file='/resources/templates/navBar.jsp'%>
	
	<h1 style="color:red; text-align:center;">Formulaire pour ajouter un voyage</h1>

<form:form cssClass="form-horizontal" method="post" action="soumettreVoyageAdd" commandName="vAjout">

  <div class="form-group">
    <label for="idDateDepart" class="col-sm-2 control-label">Date de d�part</label>
    <div class="col-sm-5">
      <form:input type="date" cssClass="form-control" id="idDateDepart" path="dateDepart" placeholder="Date de d�part"/>
    </div>
  </div>
  <div class="form-group">
    <label for="idDateArrive" class="col-sm-2 control-label">Date d'arriv�</label>
    <div class="col-sm-5">
      <form:input type="date" cssClass="form-control" id="idDateArrive" path="dateArrive" placeholder="Date d'arriv�"/>
    </div>
  </div>
    <div class="form-group">
    <label for="idNombrePlaces" class="col-sm-2 control-label">Nombre de places</label>
    <div class="col-sm-5">
      <form:input  cssClass="form-control" id="idNombrePlaces" path="nombrePlaces" placeholder="Nombre de places"/>
    </div>
     <div class="form-group">
    <label for="idPrix" class="col-sm-2 control-label">Prix</label>
    <div class="col-sm-5">
      <form:input  cssClass="form-control" id="idPrix" path="prix" placeholder="Prix"/>
    </div>
     <div class="form-group">
    <label for="idStatut" class="col-sm-2 control-label">Statut</label>
    <div class="col-sm-5">
      <form:input  cssClass="form-control" id="idStatut" path="statut" placeholder="Statut"/>
    </div>
     <div class="form-group">
    <label for="idDestination" class="col-sm-2 control-label">Destination</label>
    <div class="col-sm-5">
      <form:input  cssClass="form-control" id="idDestination" path="destination" placeholder="Destination"/>
    </div>
  </div>
 
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Ajouter un voyage</button>
    </div>
  </div>
  
</form:form>
</body>
</html>