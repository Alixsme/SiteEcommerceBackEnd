<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion Produits</title>

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



<sec:authorize access="hasAuthority('admin')">
<h3><div style="text-align: center;">Gestion Produits</div></h3>
</sec:authorize> <br> <br>


<form:form method="POST" action="saveProduit" enctype="multipart/form-data" modelAttribute="p">
 
<form:hidden path="idProduit"/>
             <table>
                <tr>
                    <td><form:label path="libProduit">Description Produit</form:label></td>
                    <td><form:input path="libProduit"/></td>
                </tr>
                <tr>
                    <td><form:label path="img">image</form:label></td>
                    <td><input type="file" name="file"></td>
                </tr>
                <tr>
                    <td><form:label path="quantite">Quantite Disponible</form:label></td>
                    <td><form:input path="quantite"/></td>
                </tr>
                <tr>
                 <td>  Categorie : <select name="cate" >
                   <c:forEach items="${listeCategorie}" var="c">
                   <option value="${c.idCategorie}">${c.nomCategorie}</option>
                   </c:forEach>
                   </select>
                   </td>
                </tr>
                
                <tr>
                    <td><input type="submit" value="Ajouter" style="text-align: right"/></td>
                </tr>
            </table>
        </form:form>



<table class="table table-hover table-dark">
  <thead>
    <tr>
      <th scope="col">idProduit</th>
      <th scope="col">Nom Produit</th>
      <th scope="col">image</th>
      <th scope="col">Quantite Disponible</th>
      <th scope="col">Categorie</th>
      <th scope="col">Modifier</th>
      <th scope="col">Supprimer</th>

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
   

      <td><a href="modifierProduit?idProduit=${pe.idProduit }">Modifier</a></td> 
	<td><a href="supprimerProduit?idProduit=${pe.idProduit }">Supprimer</a></td> 

    </tr>
    </c:forEach>
  </tbody>
</table> 


<a href="Accueil" style="text-align: right">Retour</a>
<br> <br>

<form:form method="post" action="/logout">
<input type="submit" value="Deconnexion" id="idDeco">
</form:form>



</body>
</html>