<%@ include file="../includes/header.jsp"%>

<h1>
	Bienvenido al index del administrador
</h1>

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
			<td>ver modificar borrar</td>
		</tr>
	</c:forEach>

</table>

<%@ include file="../includes/footer.jsp"%>