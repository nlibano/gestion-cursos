	/*
	 * Buscador en la barra de navegacion para buscar cursos mediante la API 
	 * Busca cursos que contengan su nombre o codigo, minimo 3 letras
	 * 
	 */
	
	"use-strict"
	
	$(function() {
		console.debug('buscar-curso.js ready');
		
		/*** Autocomplete ***/
		$( "#buscar_curso" ).autocomplete({
			source: function( request, response){
								
				var url = "/formacion/api/curso/?filter=" + $("#buscar_curso").val().trim() + "";
				
				$.ajax( {
					"url" : url,
					"type" : "GET",
					"dataType": "json",					
					"success" : function(data) {
						
						var aString = [];
	
						$.each(data, function(i, v){
							aString.push({'label': v.nombre, 'value': v.id})	;
						});
						
						response (aString);
						
						console.log("Llego el contenido %o y no hubo error", aString);
			            
					}
					
				});
				
			},
		      minLength: 2,
		      select: function( event, ui ) {
		        console.debug( "Selected: " + ui.item.label + " con id: " + ui.item.value);
		        		        
		        window.location.href = 'user/edit/' + ui.item.value + '';
		      }
		    });
		
		/****** Buscador Para Admin *******/
		
		/*** Autocomplete ***/
		$( "#buscar_admin_curso" ).autocomplete({
			source: function( request, response){
								
				var url = "/formacion/api/curso/?filter=" + $("#buscar_admin_curso").val().trim() + "";
				
				$.ajax( {
					"url" : url,
					"type" : "GET",
					"dataType": "json",					
					"success" : function(data) {
						
						var aString = [];
	
						$.each(data, function(i, v){
							aString.push({'label': v.nombre, 'value': v.id})	;
						});
						
						response (aString);
						
						console.log("Llego el contenido %o y no hubo error", aString);
			            
					}
					
				});
				
			},
		      minLength: 2,
		      select: function( event, ui ) {
		        console.debug( "Selected: " + ui.item.label + " con id: " + ui.item.value);
		        		        
		        window.location.href = 'admin/curso/edit/' + ui.item.value + '';
		      }
		    });
		
	});
		
