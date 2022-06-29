<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page du Produit</title>

<style>

    body
    {
        background-color: blanchedalmond;
    }      
    </style>


</head>
<body>

<sec:authorize access="hasAuthority('admin')">
<h3><div style="text-align: center;">Description du Produit</div></h3>
</sec:authorize> <br> <br>

<form:form method="POST" action="pageProduit" enctype="multipart/form-data" modelAttribute="p">

<table border="1px">
<tr> 
<td>Id</td>
<td>Nom du produit</tr>
<td>Image</td>
<td>Quantite</td>
</tr>

<tr> 
<td>${produit.idProduit}</td>
<td>${produit.libProduit}</tr>
<td><img src="${p.img}" style="height: 200px; width: 200px;"></td>
<td>${produit.quantite}</td>
</tr>


</table>




<nav class="navbar navbar-dark bg-dark">
     <form:form method="post" action="${pageContext.request.contextPath}/gestionClient/ajouterAuPanier" >
      
      <input type="hidden" name="idProduit" value="${pe.idProduit}">
      <input type="text" name="quantite"> 
      <input type="submit" value="Ajouter au Panier">
      </form:form>

  </nav>


</form:form>


</body>
</html>