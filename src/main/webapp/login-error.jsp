<!doctype html>
<html lang="es">
<head>
	<meta charset="utf-8">
	<title>Login</title>
	
	<!-- Custom -->
	<link href="resources/css/custom.css" rel="stylesheet">
	<link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
	
</head>
<body class="login_bg">

	<div id="login">
		
		<form action="login" method="post">
			
			<h1 class="box-header">Login</h1>
			
			<div class="alert alert-danger alert-dismissible mensaje" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				El Usuario o la contrase&ntilde;a es incorrecto
			</div>
			 
			<label for="usuario">Usuario</label>
			<input type="text" id="usuario" name="usuario">
			
			<label for="clave">Password</label>
			<input type="password" id="clave" name="clave">
			
			<br>
			<input type="submit" value="validar">

		</form>
	</div>

 	<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
 		
</body>
</html>