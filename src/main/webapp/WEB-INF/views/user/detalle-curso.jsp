<%@ include file="../includes/header-user.jsp"%>

	<h1>
		Detalle del Curso
	</h1>

	<div class="container-form">
		<form action="#" class="form-horizontal">
				
			<label for="nombre">Nombre del Curso</label>		
			<input class="form-control" type="text" id="nombre" name="nombre" value="${curso.nombre}" readonly="readonly"/>			
			
			<label for="codigo">Código del Curso</label>		
			<input class="form-control" id="codigo" name="codigo" value="${curso.codigo}" readonly="readonly"/>	
		</form>
	
	</div>
	
<%@ include file="../includes/scripts.jsp"%>

<%@ include file="../includes/footer.jsp"%>