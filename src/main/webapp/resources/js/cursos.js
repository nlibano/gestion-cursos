		
	function abrir_modal_eliminar(nombre, id){
		$("#modal-eliminar").modal();
		
		var url = "/formacion/admin/curso/delete/" + id + "";
		
		$('#modal_nombre_curso').text(nombre);
		$('#modal_nombre_id').attr("href", url);
		
	}
