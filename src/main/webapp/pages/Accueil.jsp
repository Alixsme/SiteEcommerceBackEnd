<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>

	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="FeuilleStyle.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">

    <style>

    #idBarre
        {
           text-align: right;
        }     

        </style>

</head>


<body>

<sec:authorize access="hasAuthority('admin')">
</sec:authorize>


<div class="container">
    <!--Header--> <div class="row"> 

        <nav class="navbar navbar-expand-lg navbar-secondary bg-secondary">
            <a class="navbar-brand" href="#"> 
                <img src="../../image/logo.jpg" height="50" width="50">
                <b> Music Shack </b> </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarContent">
                <span class="navbar-toggler-icon"></span>
             </button>

            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">

              <ul class="navbar-nav">
                <li class="nav-item nav-link active">
                    <a class="nav-link" href="Accueil.jsp"> Accueil </span></a>
                </li>
                <li class="nav-item nav-link">
                    <a class="nav-link" href="#"> Menu 1 </a>
                </li>
               

                <li class="nav-item nav-link" id="idBarre">
                    <form class="form-inline">
                        <input class="form-control mr-sm-2" type="search" placeholder="Rechercher" aria-label="Search">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Rechercher</button>
                      </form>

                </li>

                <li class="nav-item nav-link" id="idBarre">
               
                <button type="button" class="btn btn-default btn-sm">
                <span class="glyphicon glyphicon-shopping-cart">  </span>
                <b>Panier</b>
                
               
            </button>
                </li>
                
                
                <li class="nav-item dropdown" id="idBarre"> 
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" id="idco">
                         Compte 
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                     
                      <a class="dropdown-item" href="#">S'inscrire
                      <form:form method="post" action="/inscription">
                        <input type="submit" value="s'inscrire">
                        </form:form></a>

                      <a class="dropdown-item" href="Authentification.jsp">Se connecter</a>
                      <div class="dropdown-divider"></div>
                      
                      <a class="dropdown-item" href="#">Se deconnecter

                      <form:form method="post" action="/logout">
                        <input type="submit" value="Deconnexion" id="idDeco">
                        </form:form>
                    </a>

                    </div>
                  </li>
              </ul>
              </div>
            </div>
          </nav>


    </div>




    <!--Hero section--> <div class="row"> 
        <p id="idslogan"><div style="text-align: center;"> <strong> Quality Service for quality sound </strong></div></p>
        
      
        
        <img src="../../image/music.jpg" height="450" width="50">

    </div>

    <!--Produits/Categories--> <div class="row">
        <div class="col-6">  <br> 
            <div class="card-body">
                <div class="card-title"> <b> Categories </b></div> <br>
                <div class="card-body">
                    

                            <!--Diaporama de differentes images-->

                    <div class="carousel slide" data-ride="carousel">
                        <div class="carousel-inner">
                           <div class="carousel-item active">
                              <img src="../../image/rock.png" class="d-block w-50" alt="...">
                           </div>
                           <div class="carousel-item">
                              <img src="../../image/jazz.jpg" class="d-block w-50" alt="...">
                           </div>
                        </div>
                     </div>

				


					
                    <a href="${pageContext.request.contextPath}/gestionAdmin/afficherCategorie">Gestion Categories</a>
                    
                </div>
             </div> 
        </div>

        <div class="col-6"><br> 
            <div class="card-body">
                <div class="card-title"> <b> Produits </b></div> <br>
                <div class="card-body">
                   

                    <div class="carousel slide" data-ride="carousel">
                        <div class="carousel-inner">
                           <div class="carousel-item active">
                              <img src="../../image/vynyl.jpg" class="d-block w-50" alt="...">
                           </div>
                           <div class="carousel-item">
                              <img src="../../image/tshirt.jpg" class="d-block w-50" alt="...">
                           </div>
                        </div>
                     </div>

                    <a href="${pageContext.request.contextPath}/gestionAdmin/afficherProduit">Gestion Produits</a>
                </div>
             </div>
        </div> 
    </div>





    <!--Footer--> 	
    <footer id="footer">
        <div class="row">
            <div class="col">
     
                <ul class="list-inline text-center"> <p class="text-info">
                <li class="list-inline-item"> <a href="#"> Rajouter lien Information   </a></li>
                <li class="list-inline-item"> <a href="#"> Rajouter lien Contact</a></li> </p>
                </ul>
            </div>
        </div>
    </footer> <br>

<form:form method="post" action="/logout">
<input type="submit" value="Deconnexion" id="idDeco">
</form:form>


</body>
</html>