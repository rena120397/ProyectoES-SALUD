 <%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Es+Salud</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="css/normalize.css"> 
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
  <link rel="icon" type="image/png" href="img/hospital.png"/>
  <link rel="stylesheet" type="text/css" href="css/estilo.css"> 
</head>
<body>

        <div class="jumbotron jumbotron-fluid img-responsive text-center text-white">
                <h1 class="font-weight-bold">ES+SALUD</h1> 
                <h4>Confiabilidad, Seguridad y rapidez</h4> 
        </div>
  <!-- Nav tabs -->
  <div class="contenedor d-flex flex-column">
  <ul class="nav nav-tabs flex-row-reverse" role="tablist">
    <li class="nav-item">
      <a class="nav-link font-weight-bold text-gray" data-toggle="tab" href="#nosotros">Nosotros</a>
    </li>
    <li class="nav-item">
      <a class="nav-link font-weight-bold text-gray" data-toggle="tab" href="#intranet">Intranet</a>
    </li>
    <li class="nav-item">
      <a class="nav-link active font-weight-bold text-gray" data-toggle="tab" href="#home">Afiliados</a>
    </li>
  </ul>

  <!-- Tab panes -->
    <div class="tab-content navi">
        <div id="home" class="container tab-pane active"><br>
            <h2 class="text-center">AFILIADOS</h2>
            <form action="ServletValidacion" name="miformulario" method="POST">
                <div class="form-group">
                    <label for="dni">Usuario:</label>
                    <input type="text"  id="dni" class="form-control" name="dni" maxlength="8" required placeholder="Ingrese Documento de Identidad">
                </div>
                <div class="form-group">
                    <label for="pwd">Contraseña:</label>
                    <input type="password" class="form-control" id="pwd" name="password" required placeholder="Ingrese Contraseña">
                </div>
                <p class="help-block textored font-weight-bold"> ${mensaje}</p><br>
                <div class="form-group form-check"d="target">
                    <label class="form-check-label">
                    <input class="form-check-input" type="checkbox"> Recuerdame
                </label>
                </div>
                <button type="submit" class="btn btn-success text-center" id="mostrar">INGRESAR</button>
                <button type="reset" class="btn btn-danger text-center">BORRAR</button>
            </form>
        </div>
        <div id="intranet" class="container tab-pane fade"><br>
            <h2 class="text-center">INTRANET</h2>
            <form method="POST" action="Controler">
                <div class="form-group">
                    <label for="usuario">Usuario:</label>
                    <input type="text" name="usuario" class="form-control" id="usuario" required placeholder="Ingrese Usuario">
                </div>
                <div class="form-group">
                    <label for="pwd">Contraseña:</label>
                    <input type="password" name="contra" class="form-control" id="pwd" required placeholder="Ingrese Contraseña">
                </div>
                <p class="help-block textored font-weight-bold"> ${mensaje}</p><br>
                <div class="form-group form-check">
                    <label class="form-check-label">
                    <input class="form-check-input" type="checkbox"> Recuerdame
                </label>
                </div>
                <button type="submit" class="btn btn-success text-center">INGRESAR</button>
                <button type="reset" class="btn btn-danger text-center">BORRAR</button>
                <br>
            </form>
        </div>
        <div id="nosotros" class="container tab-pane fade"><br>
            <h3>Objetivo</h3><hr>
                <p class='text-justify'>El Seguro Social de Salud, EsSalud, es un organismo público descentralizado, con personería jurídica de derecho público interno, adscrito al Ministerio de Trabajo y Promoción del Empleo.
                <p class="text-justify">Tiene por finalidad dar cobertura a los asegurados y sus derechohabientes, a través del otorgamiento de prestaciones de prevención, promoción, recuperación, rehabilitación, prestaciones económicas, y prestaciones sociales que corresponden al régimen contributivo de la Seguridad Social en Salud, así como otros seguros de riesgos humanos.</p>
            <h3>Mision</h3><hr>
                <p class='text-justify'>“Somos una entidad pública de Seguridad Social de Salud que tiene como fin la protección de la población asegurada brindando prestaciones de salud, económicas y sociales con calidad, integralidad, eficiencia y buen gobierno corporativo, colaborando con el Estado Peruano en alcanzar el Aseguramiento Universal en Salud”.</p>
            <h3>Vision</h3><hr>
                <p class='text-justify'>“Ser líder en Seguridad Social de Salud en América Latina, superando las expectativas de los asegurados y de los empleadores en la protección de su salud y siendo reconocida por su buen trato, con una gestión moderna y a la vanguardia de la innovación”.</p>
            <h3>Ubicacion</h3><hr>
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3904.1167978281546!2d-77.04068688456528!3d-11.89695469156724!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x9105d0f219d02d4b%3A0x9ef1552cf3a7a67!2sEssalud+Cap+III+Paul+Nogier+-+Carabayllo!5e0!3m2!1sen!2spe!4v1526886843444" width="100%" height="400" frameborder="0" style="border:0" allowfullscreen></iframe>
        </div>
    </div>
  <hr>
  <hr>
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
   </div> 
    <div class="modal fade" id="mostrarmodal" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
            <div class="container">
           <div class="modal-header">
                <h3>Atención Afiliados: </h3>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>     
           </div>
           <div class="modal-body">
               <h5 class="">La contraseña esta conformada por: </h5><hr>  
               <h6 class="pad"> 4 primeros digitos de su dni DNI y </h6>
               <h6 class="pad"> Su apellido paterno </h6><hr>  
               <h5>Ejemplo: <span class="font-weight-bold"> 9837PUSE </span></h5>
               </div>
           </div>
           <div class="modal-footer">
          <a href="#" data-dismiss="modal" class="btn btn-danger">Cerrar</a>
           </div>
      </div>
   </div>
</div>
    <script>
      $(document).ready(function()
      {
         $("#mostrarmodal").modal("show");
      });
    </script>
    <script src="js/general.js"></script>
</body>
</html>