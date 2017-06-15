<%@ include file="includes/header-user.jsp"%>

	<h1>
		Ultimos Cursos Creados
	</h1>

	<table class="listado-tabla">
		<thead>
			<tr>
				<th>#</th>
				<th>Nombre</th>
				<th>Codigo</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${cursos}" var="c" varStatus="index">
				<tr>
					<td>${index.count}</td>
					<td>${c.nombre}</td>
					<td>${c.codigo}</td>
				</tr>
			</c:forEach>
		</tbody>
</table>

<%@ include file="includes/scripts.jsp"%>


<%@ include file="includes/footer.jsp"%>

