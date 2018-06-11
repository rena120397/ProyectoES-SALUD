<%@page import="app.modelo.vo.Usuario"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/normalize.css"> 
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
        <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/img/hospital.png"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilo.css">  
        <title>Es+Salud</title>
    </head>
    <body>
        <div class="jumbotron jumbotron-fluid img-responsive text-center text-white">
            <h1 class="font-weight-bold">ES+SALUD</h1> 
            <h4>Confiabilidad, Seguridad y rapidez</h4> 
        </div>
        <div class="container">
            <h2>Bienvenido <c:out value="${sessionScope.bUsuario.NOMBRE}"/></h2><hr>
            <h4>Selecione la opción:</h4>
            <div class="card-deck">
                <c:if test="${(accion eq 'goRegistrar')}">
                    <c:if test="${(bUsuario.ID_PERFIL == 1)}">
                        <form class="card bg-primary car" method="POST" action="Listar">
                            <input type="hidden" name="accion" value="goRegistrarAdministradores">
                            <button class="bg-primary card-body text-center text-white" type="submit" value="Registrar Usuario.">    
                                <p class="card-text text-white font-weight-bold">ADMINISTRADORES</p><hr>
                            </button>
                        </form> 
                    </c:if>
                    <c:if test="${(bUsuario.ID_PERFIL == 1)}">
                        <form class="card bg-warning" method="POST" action="Listar">
                            <input type="hidden" name="accion" value="goRegistrarPersonal">
                            <button class="bg-warning card-body text-center text-white" type="submit" value="Listar Usuario.">    
                                <p class="card-text text-white font-weight-bold">PERSONAL</p><hr>
                            </button>
                        </form>
                    </c:if>
                    <c:if test="${(bUsuario.ID_PERFIL == 1) || (bUsuario.ID_PERFIL == 2)}">
                        <form class="card bg-success" method="POST" action="listar">
                            <input type="hidden" name="accion" value="goRegistrarMedicos">
                            <button class="bg-success card-body text-center text-white" type="submit" value="Mantenimiento.">    
                                <p class="card-text text-white font-weight-bold">MEDICOS</p><hr>
                            </button>
                        </form>
                        <form class="card bg-success" method="POST" action="listar">
                            <input type="hidden" name="accion" value="goRegistrarPacientes">
                            <button class="bg-success card-body text-center text-white" type="submit" value="Mantenimiento.">    
                                <p class="card-text text-white font-weight-bold">PACIENTES</p><hr>
                            </button>
                        </form>
                    </c:if>
                </c:if>
                <c:if test="${(accion eq 'goListar')}">
                    <c:if test="${(bUsuario.ID_PERFIL == 1)}">
                        <form class="card bg-primary car" method="POST" action="Listar">
                            <input type="hidden" name="accion" value="goListarAdministradores">
                            <button class="bg-primary card-body text-center text-white" type="submit" value="Registrar Usuario.">    
                                <p class="card-text text-white font-weight-bold">ADMINISTRADORES</p><hr>
                            </button>
                        </form> 
                    </c:if>
                    <c:if test="${(bUsuario.ID_PERFIL == 1)}">
                        <form class="card bg-warning" method="POST" action="Listar">
                            <input type="hidden" name="accion" value="goListarPersonal">
                            <button class="bg-warning card-body text-center text-white" type="submit" value="Listar Usuario.">    
                                <p class="card-text text-white font-weight-bold">PERSONAL</p><hr>
                            </button>
                        </form>
                    </c:if>
                    <c:if test="${(bUsuario.ID_PERFIL == 1) || (bUsuario.ID_PERFIL == 2)}">
                        <form class="card bg-success" method="POST" action="listar">
                            <input type="hidden" name="accion" value="goListarMedicos">
                            <button class="bg-success card-body text-center text-white" type="submit" value="Mantenimiento.">    
                                <p class="card-text text-white font-weight-bold">MEDICOS</p><hr>
                            </button>
                        </form>
                        <form class="card bg-success" method="POST" action="listar">
                            <input type="hidden" name="accion" value="goListarPacientes">
                            <button class="bg-success card-body text-center text-white" type="submit" value="Mantenimiento.">    
                                <p class="card-text text-white font-weight-bold">PACIENTES</p><hr>
                            </button>
                        </form>
                    </c:if>
                </c:if>
                <c:if test="${(accion eq 'goManteniiento')}">
                    <c:if test="${(bUsuario.ID_PERFIL == 1)}">
                        <form class="card bg-primary car" method="POST" action="Listar">
                            <input type="hidden" name="accion" value="goMantenimientoAdm">
                            <button class="bg-primary card-body text-center text-white" type="submit" value="Registrar Usuario.">    
                                <p class="card-text text-white font-weight-bold">ADMINISTRADORES</p><hr>
                            </button>
                        </form> 
                    </c:if>
                    <c:if test="${(bUsuario.ID_PERFIL == 1)}">
                        <form class="card bg-warning" method="POST" action="Listar">
                            <input type="hidden" name="accion" value="goMantenimientoPer">
                            <button class="bg-warning card-body text-center text-white" type="submit" value="Listar Usuario.">    
                                <p class="card-text text-white font-weight-bold">PERSONAL</p><hr>
                            </button>
                        </form>
                    </c:if>
                    <c:if test="${(bUsuario.ID_PERFIL == 1) || (bUsuario.ID_PERFIL == 2)}">
                        <form class="card bg-success" method="POST" action="listar">
                            <input type="hidden" name="accion" value="goMantenimientoMed">
                            <button class="bg-success card-body text-center text-white" type="submit" value="Mantenimiento.">    
                                <p class="card-text text-white font-weight-bold">MEDICOS</p><hr>
                            </button>
                        </form>
                        <form class="card bg-success" method="POST" action="listar">
                            <input type="hidden" name="accion" value="goMantenimientoPac">
                            <button class="bg-success card-body text-center text-white" type="submit" value="Mantenimiento.">    
                                <p class="card-text text-white font-weight-bold">PACIENTES</p><hr>
                            </button>
                        </form>
                    </c:if>
                </c:if>
                
            </div>


        </div>

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

