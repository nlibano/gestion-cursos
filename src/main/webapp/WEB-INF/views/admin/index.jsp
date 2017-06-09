<%@ include file="../includes/header-admin.jsp"%>

<h1>
	Gestion de Cursos
</h1>

<a href="admin/curso/edit"><button class="btn btn-primary">Crear Nuevo Curso</button></a>

<table class="table table-hover">
	<tr>
		<th>#</th>
		<th>Nombre Curso</th>
		<th>Código Curso</th>
		<th></th>
	</tr>
	
	<c:forEach items="${cursos}" var="c" varStatus="index">
		<tr>
			<td>${index.count}</td>
			<td>${c.nombre}</td>
			<td>${c.codigo}</td>
			<td><a href="admin/curso/edit/${c.id}"><span class="glyphicon glyphicon-pencil"></span></a><a href="admin/curso/delete/${c.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
		</tr>
	</c:forEach>

</table>

<%@ include file="../includes/footer.jsp"%>