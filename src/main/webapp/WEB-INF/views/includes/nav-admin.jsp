<!-- Static navbar -->
      <nav class="navbar navbar-inverse">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="admin">Gestion Cursos</a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
          
          <!-- menu izquierda -->
            <ul class="nav navbar-nav">
              <li class="">
              	<a href="admin">Inicio</a>
              </li>        
            </ul>
          
          <!-- search -->

			<form class="navbar-form navbar-left">
				<div class="input-group">
					<label for="buscar_admin_curso" class="input-group-addon">
						<span class="glyphicon glyphicon-search"></span>
						&nbsp;Buscador
					</label>
					<input id="buscar_admin_curso" name="buscar_admin_curso" type="text" class="form-control" placeholder="Buscar curso">
				</div>
			</form>

			<!-- menu derecha -->  
            <ul class="nav navbar-nav navbar-right">
              <li class="active">
              	 <a href="logout">Logout</a>
              	</li>
            </ul>
            
                        
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>