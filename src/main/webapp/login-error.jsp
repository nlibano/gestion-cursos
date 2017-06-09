<!doctype html>
<html lang="es">
<head>
	<meta charset="utf-8">
	<title>Login</title>
	
	<!-- Custom -->
	<link href="resources/css/custom.css" rel="stylesheet">
	
</head>
<body class="login_bg">

	<div id="login">
		
		<form action="login" method="post">
			
			<h1 class="box-header">Login</h1>
			
			<p>El Usuario o la contraseña es incorrecto</p>
			 
			<label for="usuario">Usuario</label>
			<input type="text" id="usuario" name="usuario">
			
			<label for="clave">Password</label>
			<input type="password" id="clave" name="clave">
			
			<br>
			<input type="submit" value="validar">

		</form>
	</div>
</body>
</html>