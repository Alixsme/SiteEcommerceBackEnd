<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Panier</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="FeuilleStyle.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">

</head>
<body>

<sec:authorize access="hasAuthority('client')">
<h3><div style="text-align: center;">Mon Panier</div></h3>
</sec:authorize> <br> <br>

<table>

<tr>
<td> Nom du produit </td>
<td> Quantite  </td>
<td></td>
<td></td>
</tr>

<tr>
<c:forEach items="${listelp}" var="lp">
<tr>
<td>${lp.produit.libProduit } </td>
<td>${lp.quantite}</td>

<td>
<form method="post" action="${pageContext.request.contextPath}/gestionClient/supprimerLignePanier">
<input type="hidden" name="idLignePanier" value="${lp.idLignePanier}">
<input type="submit" value="Supprimer Article">
</form>
</td>

<td>
<form:form method="post" action="${pageContext.request.contextPath}/gestionClient/Modif">
<input type="hidden" name="idLignePanier" value="${lp.idLignePanier}">
<input type="submit" value="Modifier">
</form:form>

</td>
</tr>


</c:forEach>
</table>

<br>
<br>

<!-- Faire un bouton pour valider le panier et passer la commande -->

<form:form method="post" action="${pageContext.request.contextPath}/gestionClient/creerLigneCommande">
<input type="submit" value="Passer la commande">
</form:form>


<br>

<br>

<form:form method="post" action="${pageContext.request.contextPath}/gestionClient/afficherProduit">
<input type="submit" value="Retour">
</form:form>


<form:form method="post" action="${pageContext.request.contextPath}/logout">
<input type="submit" value="Deconnexion" id="idDeco">
</form:form>

</body>






</html>