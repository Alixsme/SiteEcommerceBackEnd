<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulaire d'inscription</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="FeuilleStyle.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">

</head>
<body>

<form:form action="${pageContext.request.contextPath }/traiterInscription" method="post" modelAttribute="u">

<table>

 <tr>
                    <td><form:label path="nom">Nom</form:label></td>
                    <td><form:input path="nom"/></td>
                </tr>
                <tr>
                    <td><form:label path="prenom">Prenom</form:label></td>
                    <td><form:input path="prenom"/></td>
                </tr>
                <tr>
                    <td><form:label path="dateNaissance">Date de naissance</form:label></td>
                    <td><form:input path="dateNaissance"/></td>
                </tr>
                <tr>
                    <td><form:label path="username">Username</form:label></td>
                    <td><form:input path="username"/></td>
                </tr>
                <tr>
                    <td><form:label path="password">Password</form:label></td>
                    <td><form:input path="password"/></td>
                </tr>
                
                <td><input type="submit" value="ajouter" style="text-align: right"/></td>

</table>

</form:form>





</body>
</html>