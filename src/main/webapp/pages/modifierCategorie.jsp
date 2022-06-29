<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<sec:authorize access="hasAuthority('admin')">
</sec:authorize>

<form:form method="POST" action="modifierCategorie" modelAttribute="ce">
 <form:hidden path="idCategorie"/>
             <table>
                <tr>
                    <td><form:label path="nomCategorie">Nom</form:label></td>
                    <td><form:input path="nomCategorie"/></td>
                </tr>
                <tr>
                    <td><form:label path="description">Description</form:label></td>
                    <td><form:input path="description"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Modifier"/></td>
                </tr>
            </table>
        </form:form>
        
<a href="afficherCategorie">Retour Categories</a>	



<form:form method="post" action="/logout">
<input type="submit" value="Déconnexion">
</form:form>

</body>
</html>