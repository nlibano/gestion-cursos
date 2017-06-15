<%@ include file="../includes/header-admin.jsp"%>

	<h1>
		Migración de Cursos
	</h1>

	<div class="container-form"> 
		<form action="admin/upload" method="post" enctype="multipart/form-data">
			<div class="box__input">
				<input type="hidden" name="ruta" value="admin/upload">
				<input type="hidden" name="id" class="form-control" value="${receta.id}">
				
				<label for="imagen">Selecciona una imagen</label>
				<input id="image_file" type="file" class="form-control" name="imagen">
				<br>
				<input type="submit" class="btn btn-success" value="Subir Fichero">
			
			</div>
			<div id="preview"></div>
		</form>
	</div>

<%@ include file="../includes/footer.jsp"%>