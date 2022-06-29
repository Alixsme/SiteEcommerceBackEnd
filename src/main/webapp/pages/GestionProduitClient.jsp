<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Produits</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="FeuilleStyle.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">

 <style>

    body
    {
        background-color: blanchedalmond;
    }      
    </style>

</head>
<body>

<sec:authorize access="hasAuthority('client')">
<h3><div style="text-align: center;">Gestion Produits</div></h3>
</sec:authorize> <br> <br>





<table class="table table-hover table-dark">
  <thead>
    <tr>
      <th scope="col">idProduit</th>
      <th scope="col">Nom Produit</th>
      <th scope="col">image</th>
      <th scope="col">Quantite Disponible</th>
      <th scope="col">Categorie</th>
       <th scope="col">Ajouter au Panier</th>
    </tr>
  </thead>
  
  
  <tbody>
  <c:forEach items="${listeProduits}" var="pe">
  
  
    <tr>
      <th scope="row">${pe.idProduit}</th>
      <td>
      <form method="post" action="pageProduit">
     <input type="hidden" name="idProduit" value="${pe.idProduit }">
<input type="submit" value="${pe.libProduit}">
</form>
      </td>
      <td> ${pe.img}</td>
      <td>${pe.quantite}</td>
      <td>${pe.cate.nomCategorie}</td>
      <td>
      <form:form method="post" action="${pageContext.request.contextPath}/gestionClient/ajouterAuPanier" >
      
      <input type="hidden" name="idProduit" value="${pe.idProduit}">
      <input type="text" name="quantite"> 
      <input type="submit" value="Ajouter au Panier">
      </form:form>
      </td>

    </tr>
    </c:forEach>
  </tbody>
</table> 


<a href="AccueilClient" style="text-align: right">Retour</a>
<br> <br>

<form:form method="post" action="/logout">
<input type="submit" value="Deconnexion" id="idDeco">
</form:form>

</body>










</html>