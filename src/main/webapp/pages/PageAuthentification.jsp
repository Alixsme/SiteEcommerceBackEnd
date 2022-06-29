<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Authentification</title>

	<link rel="stylesheet" type="text/css" href="CSS/FeuilleStyle.css">
	 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">

</head>

<body>

<!-- 
<form:form action="traiterAuth" method="post"> 

login:<input type="text" name="username"/> <br>

password:<input type="password" name="password"/> <br>

<input type="submit" value=Valider> <br>


</form:form>
 -->

<form:form action="traiterAuth" method="post"> 

<section class="vh-100" style="background-color: #9A616D;">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col col-xl-10">
        <div class="card" style="border-radius: 1rem;">
          <div class="row g-0">
            <div class="col-md-6 col-lg-5 d-none d-md-block">
              <img src="../../image/Authentification.jpg"
                alt="image login" class="img-fluid" style="border-radius: 1rem 0 0 1rem;" />
            </div>
            <div class="col-md-6 col-lg-7 d-flex align-items-center">
              <div class="card-body p-4 p-lg-5 text-black">

             

                  <div class="d-flex align-items-center mb-3 pb-1">
                    <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
                    <span class="h1 fw-bold mb-0">MusicShack</span>
                  </div>

                  <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Sign into your account</h5>

                  <div class="form-outline mb-4">
                  
                    <input type="text" name="username" id="form2Example17" class="form-control form-control-lg" />
                    <label class="form-label" for="form2Example17">Username</label>
                  </div>

                  <div class="form-outline mb-4">
                    <input type="password" name="password" id="form2Example27" class="form-control form-control-lg" />
                    <label class="form-label" for="form2Example27">Password</label>
                  </div>

                  <div class="pt-1 mb-4">
                   <input type="submit" value="Valider">
                  </div>

                  <a class="small text-muted" href="#!">Forgot password?</a>
                  <p class="mb-5 pb-lg-2" style="color: #393f81;">Pas de compte ? 
                  
                  <a href="#!" style="color: #393f81;">S'inscrire
                   <form:form method="post" action="/inscription">
                        <input type="submit" value="s'inscrire">
                        </form:form></a>
                  
                  <a href="#!" class="small text-muted">Terms of use.</a>
                  <a href="#!" class="small text-muted">Privacy policy</a>
               
               
                <a class="dropdown-item" href="#">Se deconnecter

                      <form:form method="post" action="/logout">
                        <input type="submit" value="Deconnexion" id="idDeco">
                        </form:form>
                    </a>
               
               
               
               
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</form:form>












	<form:form method="post" action="${pageContext.request.contextPath}/logout">
	<input type="submit" value="Deconnexion">
	</form:form>
	

<c:if test="${param.error!=null}"> 

		Erreur de connection 
	
	</c:if>
	
	
	
<c:if test="${param.logout!=null}"> 

		Vous êtes déconnectés
	
	</c:if>	
	

	
	
	
	</body>
</html>