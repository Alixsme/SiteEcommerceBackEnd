<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modification Panier</title>


<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="FeuilleStyle.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">

</head>
<body>

<sec:authorize access="hasAuthority('client')">
</sec:authorize>

<form method="POST" action="${pageContext.request.contextPath}/gestionClient/modifierLignePanier" >
 <input type="hidden" name="idLignePanier" value="${lp.idLignePanier}"/>
 
             <table>
               
               <tr>
               <td>Nom Produit </td>
              <td>Quantite</td>
               </tr>
           
     
                <tr>
                    <td>${lp.produit.libProduit }</td>
                </tr>
                <tr>
                    <td><input type="text" value="${lp.quantite}" name="quantite"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Valider Modification"/></td>
                </tr>
            </table>
        </form>



</body>










</html>