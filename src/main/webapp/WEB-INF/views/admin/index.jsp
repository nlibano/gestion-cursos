<%@ include file="../includes/header-admin.jsp"%>

<h1>
	Gestión de Cursos
</h1>

<%@ include file="../includes/mensaje.jsp"%>

<div class="container-table">

	<div class="boton-gestion-cursos">
		<a href="admin/curso/edit"><button class="btn btn-primary"><span class="glyphicon glyphicon-plus"></span>&nbsp;&nbsp; Curso</button></a>
		<a href="admin/migrar" title="El fichero debe estar guardada en C:\\ y debe llamarse cursos.csv"><button class="btn btn-primary"><span class="glyphicon glyphicon-open-file"></span>&nbsp;&nbsp; Migrar Cursos</button></a>
	</div>
	
	<table class="tablePlugin hover row-border tabla-admin">
		<thead>
			<tr>
				<th>#</th>
				<th>Nombre Curso</th>
				<th>Código Curso</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${cursos}" var="c" varStatus="index">
				<tr>
					<td>${index.count}</td>
					<td>${c.nombre}</td>
					<td>${c.codigo}</td>
					<td>
						<a href="admin/curso/edit/${c.id}"><span class="glyphicon glyphicon-pencil edit"></span></a>
						<!-- <a href="admin/curso/delete/${c.id}"><span class="glyphicon glyphicon-trash"></span></a> -->
						<span onclick="abrir_modal_eliminar('${c.nombre}', ${c.id})" class="glyphicon glyphicon-trash delete" data-target="#modal-eliminar" data-toogle="modal-eliminar"></span>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
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

<script src="resources/js/datatables-custom.js"></script>
<script src="resources/js/upload-file.js"></script>
<script src="resources/js/cursos.js"></script>

<%@ include file="../includes/footer.jsp"%>