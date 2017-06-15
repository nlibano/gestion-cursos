<%@ include file="../includes/header-admin.jsp"%>

	<h1>
		Altas, Bajas y Modificaciones de cursos
	</h1>

	<div class="container-form">
		<form:form action="admin/curso/crear" modelAttribute="curso" class="form-horizontal">
			
			<form:hidden path="id"/>
			
			<form:label path="nombre">Nombre del Curso</form:label>
			<form:input class="form-control" path="nombre"/>
			<form:errors path="nombre" class="alert alert-danger alert-dismissible error-red form-error"/>
			
			
			<form:label path="codigo">Código del Curso</form:label>
			<form:input class="form-control" path="codigo"/>	
			<form:errors path="codigo" class="alert alert-danger alert-dismissible error-red form-error"/>
						
			<c:if test="${curso.id == -1}">		
				<form:button class="btn btn-success" type="submit">Crear</form:button>
			</c:if>	
			<c:if test="${curso.id != -1}">		
				<form:button class="btn btn-success" type="submit">Modificar</form:button>
			</c:if>		
		</form:form>
		
		<c:if test="${curso.id != -1}">
			<div class="boton-delete">
				<button class="btn btn-danger" onclick="abrir_modal_eliminar('${curso.nombre}', ${curso.id})" data-target="#modal-eliminar" data-toogle="modal-eliminar">Eliminar</button>
			</div>
		</c:if>	
	
	</div>

	<!-- Modal Eliminar Curso -->
	<div id="modal-eliminar" class="modal fade" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-body">
					<p>
						¿Desea eliminar el curso <strong id="modal_nombre_curso"></strong>?
					</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">No</button>
					<a href="#" id="modal_nombre_id">
						<button  type="button" class="btn btn-danger">Si estoy	seguro</button>
					</a>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<!-- End: Modal Eliminar Curso -->
	
<%@ include file="../includes/scripts.jsp"%>

<script src="resources/js/cursos.js"></script>

<%@ include file="../includes/footer.jsp"%>