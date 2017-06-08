<!-- Static navbar -->
      <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><spring:message code="nav.app.name" text="Web App"/></a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
          
          <!-- menu izquierda -->
            <ul class="nav navbar-nav">
              <li class="">
              	<a href="usuario"><spring:message code="nav.usuario" text="Usuario"/></a>
              </li>
              <li>
              	<a href="receta"><spring:message code="nav.recetas" text="Recetas"/></a>
              </li>
              <li>
              	<a href="ingrediente"><spring:message code="nav.ingrdientes" text="Ingredientes"/></a>
              </li>             
            </ul>
          
          <!-- search -->

			<form class="navbar-form navbar-left">
				<div class="input-group">
					<label for="buscar_receta" class="input-group-addon">
						<span class="glyphicon glyphicon-search"></span>
						&nbsp;Buscador
					</label>
					<input id="buscar_receta" name="buscar_receta" type="text" class="form-control" placeholder="Busca tu receta">
				</div>
			</form>

			<!-- menu derecha -->  
            <ul class="nav navbar-nav navbar-right">
              <li class="active">
              	 <a href="${requestScope['javax.servlet.forward.request_uri']}?locale=es">ES</a>
              	</li>
              <li>
              	<a href="${requestScope['javax.servlet.forward.request_uri']}?locale=eu">EU</a>
              </li>
              <li>
              	<a href="${requestScope['javax.servlet.forward.request_uri']}?locale=en">EN</a>
              </li>
            </ul>
            
                        
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>