<%@ include file="../includes/header-admin.jsp"%>

	<h1>
		Altas, Bajas y Modificaciones de cursos
	</h1>

	
		<form:form action="admin/curso/crear" modelAttribute="curso">
			
			<form:hidden path="id"/>
			
			<form:label path="nombre">Nombre del Curso</form:label>
			<form:input path="nombre"/>
			<form:errors path="nombre" class="form-error"/>
			
			<form:label path="codigo">Código del Curso</form:label>
			<form:input path="codigo"/>
			<form:errors path="codigo" class="form-error"/>
			<c:if test="${curso.id == -1}">		
				<form:button class="btn btn-success" type="submit">Crear</form:button>
			</c:if>	
			<c:if test="${curso.id != -1}">		
				<form:button class="btn btn-success" type="submit">Modificar</form:button>
			</c:if>		
		</form:form>
	


<%@ include file="../includes/footer.jsp"%>