<%@page import="modelo.perfil"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html xmlns:h="http://xmlns.jcp.org/jsf/html"
      xmlns:f="http://xmlns.jcp.org/jsf/core">
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Es+Salud</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/normalize.css"> 
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
        <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/img/hospital.png"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilo.css">  
    </head>
    <body>
        <div class="jumbotron jumbotron-fluid img-responsive text-center text-white">
                <h1 class="font-weight-bold">ES+SALUD</h1> 
                <h4>Confiabilidad, Seguridad y rapidez</h4> 
        </div>
        <div class="container">
            <h2 class="textored" ><a class="textored" href="Salir"><i class="fa fa-arrow-left"></i> SALIR </a><br><br></h2>
            <h2>Bienvenido Usuario: <c:out value="${sessionScope.perse.ndocum}"/></h2><hr><br>
            <div class="card-deck text-center">
                <div class="card bg-primary shadow">
                    <div class="card-body">
                    <a href="${pageContext.request.contextPath}/servletsalud?eleccion=u1">                 
                            <p class="card-text text-white font-weight-bold">PERFIL DEL USUARIO</p><hr>
                    </a>
                    </div>
                </div>        
                        
                <div class="card bg-warning shadow">
                    <div class="card-body">
                    <a href="${pageContext.request.contextPath}/servletsalud?eleccion=u2">       
                            <p class="card-text text-white font-weight-bold">GENERAR CITA</p><hr>     
                    </a>
                    </div>
                </div> 
                        
                <div class="card bg-success shadow">
                    <div class="card-body">
                    <a href="${pageContext.request.contextPath}/servletsalud?eleccion=u3">        
                            <p class="card-text text-white font-weight-bold">DOCTORES DISPONIBLES</p><hr>
                    </a>
                    </div>
                </div>
                
                <div class="card bg-info shadow">
                    <div class="card-body">
                    <a href="${pageContext.request.contextPath}/servletsalud?eleccion=u4">    
                            <p class="card-text text-white font-weight-bold">HISTORIAL DE CITAS</p><hr>
                    </a>
                    </div>
                </div>
                            
            </div><br>
        </div><hr>  
        <!-- Footer -->
	<section id="footer">
		<div class="container">
			<div class="row text-center text-xs-center">
				<div class="col-xs-12 col-sm-6 col-md-6">
					<h5>Enlaces Empresariales Internos</h5>
					<ul class="list-unstyled quick-links">
						<li><a href="../index.html"><i class="fa fa-angle-double-right"></i>Inicio</a></li>
						<li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>About</a></li>
						<li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>FAQ</a></li>
						<li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>Videos</a></li>
					</ul>
				</div>
				<div class="col-xs-12 col-sm-6 col-md-6">
					<h5>Enlaces Empresariales Externos</h5>
					<ul class="list-unstyled quick-links">
						<li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>Inicio</a></li>
						<li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>About</a></li>
						<li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>FAQ</a></li>
						<li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>Videos</a></li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 mt-2 mt-sm-5">
					<ul class="list-unstyled list-inline social text-center">
						<li class="list-inline-item"><a href="https://www.facebook.com/EsSaludPeruOficial/" target="_blank"><i class="fa fa-facebook"></i></a></li>
						<li class="list-inline-item"><a href="https://twitter.com/essaludperu?lang=es" target="_blank"><i class="fa fa-twitter"></i></a></li>
						<li class="list-inline-item"><a href="https://www.instagram.com/essaludperu/" target="_blank"><i class="fa fa-instagram"></i></a></li>
						<li class="list-inline-item"><a href="http://www.essalud.gob.pe/" target="_blank"><i class="fa fa-google-plus"></i></a></li>
						<li class="list-inline-item"><a href="http://www.essalud.gob.pe/" target="_blank"><i class="fa fa-envelope"></i></a></li>
					</ul>
				</div>
				</hr>
			</div>	
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 mt-2 mt-sm-2 text-center text-white">
					<p>Propiedad de ES+SALUD CARABAYLLO</p>
					<p class="h6">&copy All right Reversed. Grupo 5 Curso Integrador</p>
				</div>
				</hr>
			</div>	
		</div>
	</section>
	<!-- ./Footer -->
    </body>
</html>
