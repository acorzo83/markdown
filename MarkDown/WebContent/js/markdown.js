/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function(){
	// Variables - Locales
	var oDocuments = null;
	
	// Almacenamiento - Local
	localStorage.setItem("fileName","");
	
	// Ocultamos - Botones
	$("#oBtnEditar").hide();
	$("#oBtnGuardar").hide();
	$("#oBtnEliminar").hide();
	$("#oBtnCancelar").hide();
	
	// Desactivams - Text Area
	$("#oTextEditor").attr("disabled",true).prop("disabled",true);
	
	// Obtenemos - Documentos - Existentes - Lado del Servidor
	oDocuments = oGetDataDocumentsServer();
	
	// Accion - Boton - Nuevo
	$("#oBtnNuevo").click(function(){
		// Activación - TextEditor
		$("#oTextEditor").removeAttr("disabled").prop("disbled",false);
		
		// Movemos - Foco - TextEditor
		$("#oTextEditor").focus();
		
		// Ocultamos - Botones
		$("#oBtnNuevo").hide();
		
		// Mostramos - Botones
		$("#oBtnGuardar").show();
		$("#oBtnCancelar").show();
	});
	
	// accion - Boton - Eliminar
	$("#oBtnEliminar").click(function(){
		// Variables - Locales
		
		// Mensaje - Usuario
		$.confirm({
		    title: "Editar Documento",
		    content: "Esta a punto de eliminar un documento, ¿Desea continuar?",
		    type: "green",
		    buttons: {
		        confirm: {
		        	text: "SI",
		        	btnClass: "btn-green",
		        	action: function () {
		        		// Vaciamos - Url
				    	url = "MarkDown/Files";
				    	// Definimos - Accion
				    	oid = "D";
				    	// Definimos - Opción - Ejecutar
				    	opt = "DDOCUMENT";
				    	
				    	// Ejecutamos - Proceso
				    	$.ajax({ async: false, type: "POST", url: url, dataType: "json",
				    		data: {
				    			oid: oid,
				    			opt: opt,
				    			nombreDoc: localStorage.getItem("fileName"),
				    			contenidoDoc: $("#oTextEditor").val()
				    		},
				    		success: function (response){
				    			// Parseamos - Resultado - Obtenido - JSON
				    			response = JSON.parse(response);
				    			
				    			// Evaluamos - Respuesta
				    			if (response.success){
				    				// Mensaje - Usuario
				    				oCustomMessageApp("1", "Eliminar de Documento", response.message,"green","OK","btn-green",null);
				    				// Ocultamos - Botones
				    				$("#oBtnEditar").hide();
				    				$("#oBtnGuardar").hide();
				    				$("#oBtnEliminar").hide();
				    				$("#oBtnCancelar").hide();
				    				
				    				// Mostramos - Botones
				    				$("#oBtnNuevo").show();
				    				
				    				// Limpiamos - TextArea
				    				$("#oTextEditor").val("");
				    				
				    				// Desactivams - Text Area
					        		$("#oTextEditor").attr("disabled",true).prop("disabled",true);
					        		
					        		// Obtenemos - Documentos - Existentes - Lado del Servidor
					    			oDocuments = oGetDataDocumentsServer();
					    			
					    			// Limpiamos - Preview
					    			$("#oTextPreview").html("");
					    			
					    			// Limpiamos - LocalStorage
					        		localStorage.setItem("fileName","");
				    			}
				    			
				    			if (response.error){
				    				// Mensaje - Usuario
				    				oCustomMessageApp("1", "Eliminar Documento", response.message,"red","OK","btn-red",null);
				    			}
				    		},
				    		error: function (response){
				    			// Mensaje - Usuario
								$.alert({ title: '¡Error!', content: "Ocurrio un error al momento de intentar eliminar el documento en el servidor.", type: "red",
								    buttons: {
								    	ok: {
								    		text: "OK",
								    		btnClass: "btn-red",
								    		action: function(){
								    			// Por el momento no se requiere ninguna acción
								    		}
								    	}
								    }
								});
				    		}
				    	});
		        	}
		        },
		        cancel: {
		        	text: "NO",
		        	action: function () {
		        		// Mensaje - Usuario
						$.alert({ title: 'Eliminar documento', content: "¡El proceso de eliminación del documento fue cancelado!", type: "orange",
						    buttons: {
						    	ok: {
						    		text: "OK",
						    		btnClass: "btn-orange",
						    		action: function(){
						    			// Por el momento no se realiza ninguna accion
						    		}
						    	}
						    }
						});
		        	}
		        }
		    }
		});
	});
	
	// Acción - Boton - Editar(Guardar)
	$("#oBtnEditar").click(function(){
		// Variables - Locales
		
		
		// Mensaje - Usuario
		$.confirm({
		    title: "Editar Documento",
		    content: "Esta a punto de editar un documento, ¿Desea continuar?",
		    type: "green",
		    buttons: {
		        confirm: {
		        	text: "SI",
		        	btnClass: "btn-green",
		        	action: function () {
		        		// Vaciamos - Url
				    	url = "MarkDown/Files";
				    	// Definimos - Accion
				    	oid = "U";
				    	// Definimos - Opción - Ejecutar
				    	opt = "UDOCUMENT";
				    	
				    	// Ejecutamos - Proceso
				    	$.ajax({ async: false, type: "POST", url: url, dataType: "json",
				    		data: {
				    			oid: oid,
				    			opt: opt,
				    			nombreDoc: localStorage.getItem("fileName"),
				    			contenidoDoc: $("#oTextEditor").val()
				    		},
				    		success: function (response){
				    			// Parseamos - Resultado - Obtenido - JSON
				    			response = JSON.parse(response);
				    			
				    			// Evaluamos - Respuesta
				    			if (response.success){
				    				// Mensaje - Usuario
				    				oCustomMessageApp("1", "Editar de Documento", response.message,"green","OK","btn-green",null);
				    				// Ocultamos - Botones
				    				$("#oBtnEditar").hide();
				    				$("#oBtnGuardar").hide();
				    				$("#oBtnEliminar").hide();
				    				$("#oBtnCancelar").hide();
				    				
				    				// Mostramos - Botones
				    				$("#oBtnNuevo").show();
				    				
				    				// Limpiamos - TextArea
				    				$("#oTextEditor").val("");
				    				
				    				// Desactivams - Text Area
					        		$("#oTextEditor").attr("disabled",true).prop("disabled",true);
					        		
					        		// Obtenemos - Documentos - Existentes - Lado del Servidor
					    			oDocuments = oGetDataDocumentsServer();
					    			
					    			// Limpiamos - Preview
					    			$("#oTextPreview").html("");
					    			
					    			// Limpiamos - LocalStorage
					        		localStorage.setItem("fileName","");
				    			}
				    			
				    			if (response.error){
				    				// Mensaje - Usuario
				    				oCustomMessageApp("1", "Editar Documento", response.message,"red","OK","btn-red",null);
				    			}
				    		},
				    		error: function (response){
				    			// Mensaje - Usuario
								$.alert({ title: '¡Error!', content: "Ocurrio un error al momento de intentar editar el documento en el servidor.", type: "red",
								    buttons: {
								    	ok: {
								    		text: "OK",
								    		btnClass: "btn-red",
								    		action: function(){
								    			// Por el momento no se requiere ninguna acción
								    		}
								    	}
								    }
								});
				    		}
				    	});
		        	}
		        },
		        cancel: {
		        	text: "NO",
		        	action: function() {
		        		// Mensaje - Usuario
						$.alert({ title: 'Editar documento', content: "¡El proceso de edición del documento fue cancelado!", type: "orange",
						    buttons: {
						    	ok: {
						    		text: "OK",
						    		btnClass: "btn-orange",
						    		action: function(){
						    			// Por el momento no se realiza ninguna accion
						    		}
						    	}
						    }
						});
		        	}
		        }
		    }
		});
	});
	
	// Acción - Boton - Guardar
	$("#oBtnGuardar").click(function(){
		// Variables - Locales
		var oNombreDocumento = null; 
		var oIsValidData = true;
		
		// Mensaje - Usuario
		$.confirm({
		    title: "Guardar Documento",
		    content: "Esta a punto de guardar un nuevo documento, ¿Desea contonuar?",
		    type: "green",
		    buttons: {
		        confirm: {
		        	text: "SI",
		        	btnClass: "btn-green",
		        	action: function () {
		        		$.confirm({
		        			title: "Por favor, ingrese el nombre que tendra el documento",
		        			content: "" +
		        					 "<form acion='' class=''>" +
		        					 "<div class=''>" +
		        					 "<label type='text' placeholder='Nombre del Documento' class='' required/>"+
		        					 "<input type='text' id='oNombreDocumento' placeholder='Ingresa el Nombre del Documento' class='documento form-control' required />" +
		        					 "</div>" +
		        					 "</form>",
		        			type: "green",
		        			buttons: {
		        				ok: {
		        					text: "OK",
		        					btnClass: "btn-green",
		        					action: function() {
		        						// Recuperamos - Valor - Nombre del Documento
		        						oNombreDocumento = this.$content.find(".documento").val();
		        						
		        						// Validación - Campos
		        						if (oNombreDocumento == ""){
		        							// Mensaje - Usuario
		        							oCustomMessageApp("1", "Validación de campo", "El campo: Nombre del Documento, no contiene ningún valor. Comprobar ...","red","OK","btn-red",null);
		        							// Cambiamos - Valor
		    								oIsValidData = false;
		    								// Retornamos - Valor
		    								return;
		        						}
		        						
		        						// Validamos - Datos Validos
		        						if (oIsValidData){
		        							// Vaciamos - Url
		        					    	url = "MarkDown/Files";
		        					    	// Definimos - Accion
		        					    	oid = "C";
		        					    	// Definimos - Opción - Ejecutar
		        					    	opt = "CDOCUMENT";
		        					    	
		        					    	// Ejecutamos - Proceso
		        					    	$.ajax({ async: false, type: "POST", url: url, dataType: "json",
		        					    		data: {
		        					    			oid: oid,
		        					    			opt: opt,
		        					    			nombreDoc: oNombreDocumento,
		        					    			contenidoDoc: $("#oTextEditor").val()
		        					    		},
		        					    		success: function (response){
		        					    			// Parseamos - Resultado - Obtenido - JSON
		        					    			response = JSON.parse(response);
		        					    			
		        					    			// Evaluamos - Respuesta
		        					    			if (response.success){
		        					    				// Mensaje - Usuario
		        					    				oCustomMessageApp("1", "Guardar Documento", response.message,"green","OK","btn-green",null);
		        					    				// Ocultamos - Botones
		        					    				$("#oBtnGuardar").hide();
		        					    				$("#oBtnCancelar").hide();
		        					    				
		        					    				// Mostramos - Botones
		        					    				$("#oBtnNuevo").show();
		        					    				
		        					    				// Limpiamos - TextArea
		        					    				$("#oTextEditor").val("");
		        					    				
		        					    				// Desactivams - Text Area
		        						        		$("#oTextEditor").attr("disabled",true).prop("disabled",true);
		        						        		
		        						        		// Obtenemos - Documentos - Existentes - Lado del Servidor
		        						    			oDocuments = oGetDataDocumentsServer();
		        						    			
		        						    			// Limpiamos - Preview
		        						    			$("#oTextPreview").html("");
		        					    			}
		        					    			
		        					    			if (response.error){
		        					    				// Mensaje - Usuario
		        					    				oCustomMessageApp("1", "Guardar Documento", response.message,"red","OK","btn-red",null);
		        					    			}
		        					    		},
		        					    		error: function (response){
		        					    			// Mensaje - Usuario
		        									$.alert({ title: '¡Error!', content: "Ocurrio un error al momento de intentar almacenar el documento en el servidor.", type: "red",
		        									    buttons: {
		        									    	ok: {
		        									    		text: "OK",
		        									    		btnClass: "btn-red",
		        									    		action: function(){
		        									    			// Por el momento no se requiere ninguna acción
		        									    		}
		        									    	}
		        									    }
		        									});
		        					    		}
		        					    	});
		        							
		        						}
		        					}
		        				},
		        				cancel: {
		        					text: "CANCELAR",
		        					action: function(){
		        						// Mensaje - Usuario
		        						$.alert({ title: 'Guardar documento', content: "¡El proceso de almacenamiento fue cancelado!", type: "orange",
		        						    buttons: {
		        						    	ok: {
		        						    		text: "OK",
		        						    		btnClass: "btn-orange",
		        						    		action: function(){
		        						    			// Por el momento no se realiza ninguna accion
		        						    		}
		        						    	}
		        						    }
		        						});
		        					}
		        				}
		        			}
		        		});
		        	}
		        },
		        cancel: {
		        	text: "CANCELAR",
		        	action: function () {
		        		// Mensaje - Usuario
						$.alert({ title: 'Guardar documento', content: "¡El proceso de almacenamiento fue cancelado!", type: "orange",
						    buttons: {
						    	ok: {
						    		text: "OK",
						    		btnClass: "btn-orange",
						    		action: function(){
						    			// Ocultamos - Botones
						    			$("#oBtnGuardar").hide();
						    			$("#oBtnCancelar").hide();
						    			
						    			// Mostramos - Botones
						    			$("#oBtnNuevo").show();
						    			
						    			// Desactivams - Text Area
						    			$("#oTextEditor").attr("disabled",true).prop("disabled",true);
						    		}
						    	}
						    }
						});
		        	}
		        }
		    }
		});
	});
	
	// Accion - Boton - Cancelar
	$("#oBtnCancelar").click(function(){
		// Mensaje - Usuario
		$.confirm({
		    title: "Cancelar proceso",
		    content: "Esta a punto de cancelar el proceso en curso, ¿Desea continuar?",
		    type: "orange",
		    buttons: {
		        confirm: {
		        	text: "SI",
		        	btnClass: "btn-orange",
		        	action: function () {
		        		// Limpiamos - Text - Editor
		        		$("#oTextEditor").val("");
		        		
		        		// Limpiamos - Preview
		    			$("#oTextPreview").html("");
		        		
		        		// Ocultamos - Botones
		        		$("#oBtnEditar").hide();
		        		$("#oBtnGuardar").hide();
		        		$("#oBtnEliminar").hide();
		        		$("#oBtnCancelar").hide();
		        		
		        		// Mostramos - Botones
		        		$("#oBtnNuevo").show();
		        		
		        		// Desactivams - Text Area
		        		$("#oTextEditor").attr("disabled",true).prop("disabled",true);
		        		
		        		// Limpiamos - LocalStorage
		        		localStorage.setItem("fileName","");
		        	}
		        },
		        cancel: {
		        	text: "NO",
		        	action: function (){
		        		// No se requiere reaizar ninguna accion
		        	}
		        }
		    }
		});
	});
	
	
    // Acciones - Editor + Preview
    $("#oTextEditor").keyup(function(){
        // Variables - Locales
        var oTextPreview = null;
        var oTextPreviewLinea = null;
        var oTextPreviewHTML = "";
        var oComodinTexto = null;
        var oUsoUnicode = false;
        
        // Vaciamos - Texto
        oTextPreview = $("#oTextEditor").val();
        // Separamos Texto - Salto de Linea
        oTextPreviewLinea = oTextPreview.split(/\n/);
        
        // Armamos - HTML - Preview
        // Ciclo FOR
        for (var i=0; i < oTextPreviewLinea.length; i++){            
            // Evaluamos - Comodin - Texto #
            if (oTextPreviewLinea[i].substring(0,1) == "#"){
                // Cambiamos - Valor - Comodin
                oComodinTexto = "#";
            }
            
            // Evaluamos - Comodin - Texto ...
            if (oTextPreviewLinea[i].substring(0,3) == "..."){
                if (!oUsoUnicode){
                    // Cambiamos - Valor - Comodin
                    oComodinTexto = "unicode";
                    // Eliminamos - Valor - Linea
                    oTextPreviewLinea[i] = "";
                    // Cambiamos - Valor
                    oUsoUnicode = true;
                }else{
                    // Cambiamos - Valor - Comodin
                    oComodinTexto = "";
                    // Eliminamos - Valor - Linea
                    oTextPreviewLinea[i] = "";
                     // Cambiamos - Valor
                    oUsoUnicode = false;
                }
            }else if (oUsoUnicode){
                // Cambiamos - Valor - Comodin
                oComodinTexto = "unicode";
            }
            
            // Evaluamos - Comodin - Texto ###
            if (oTextPreviewLinea[i].substring(0,3) == "###"){
                // Cambiamos - Valor - Comodin
                oComodinTexto = "###";
            }
            
            
            // Evaluamos - Comodin 
            switch(oComodinTexto){
                // #
                case "#":
                    // Agregamos - HTML - Preview
                    oTextPreviewHTML += "<h1><p>" + oTextPreviewLinea[i].substring(1, oTextPreviewLinea[i].length) + "</p></h1>";
                    break;
                    
                // ... / ...
                case "unicode":
                    // Agregamos - HTML - Preview
                    oTextPreviewHTML += "<pre><span style='font-family:\"Courier New\", Courier, monospace'>" + oTextPreviewLinea[i] + "</span></pre>"; 
                    break;
                    
                // ###
                case "###":
                    // Agregamos - HTML - Preview
                    oTextPreviewHTML += "<p style='font-size: 20px; font-weight: bold;'>" + oTextPreviewLinea[i].substring(3, oTextPreviewLinea[i].length) + "</p>";
                    break;
                    
                default:
                    // Agregamos - HTML - Preview
                    oTextPreviewHTML += "<p>" + oTextPreviewLinea[i] + "</p>";
                    break;
            }
            
            // Limpiamos - Comodin
            oComodinTexto = "";
        }
        
        $("#oTextPreview").html();
        $("#oTextPreview").html(oTextPreviewHTML); 
    });
    
    
    /**
     * Función: oGetDataDocumentsServer
     * Autor: Acorzo
     * Fecha: 17/08/2019
     */
    function oGetDataDocumentsServer(){
    	// Variables - Locales
    	var url = "";
    	var oid = "";
    	var opt = "";
    	var oData = null;
    	var oHtmlFiles = "";
    	
    	// Vaciamos - Url
    	url = "MarkDown/Files";
    	// Definimos - Accion
    	oid = "R";
    	// Definimos - Opción - Ejecutar
    	opt = "LISTDOCUMENTS";
    	
    	// Ejecutamos - Proceso
    	$.ajax({ async: false, type: "POST", url: url, dataType: "json",
    		data: {
    			oid: oid,
    			opt: opt
    		},
    		success: function (response){
    			// Parseamos - Resultado - Obtenido - JSON
    			response = JSON.parse(response);
    			
    			// Evaluamos - Respuesta
    			if (response.success){
    				// Evaluamos - No - Registros
    				if (response.oData.length > 0){
    					// Vaciamos - Documentos - Existentes
    					// Limpiamos - Div
    					$("#MDBBody-Documents-Files").html("");
    					
    					// Generamos - Files
    					// Ciclo FOR
    					for (var i=0; i < response.oData.length; i++){
    						// Vaciamos - Codificación - Documentos
    						oHtmlFiles += "<div class=\"MDBBody-Documents-Files-Content\">" +
    									  "	<div class=\"MDBBody-Documents-Files-Content-Picture\">" +
    									  "		<img src=\"./img/Document.png\" width=\"100%\" />" +
    									  "	</div>" +
    									  "	<div class=\"MDBBody-Documents-Files-Content-Title\">" +
    									  "		<span class=\"oFontTitleFile\" oFileName=\"" + response.oData[i].oFileName + "\">" + response.oData[i].oFileName + "</span>" +
    									  "	</div>"
    									  "</div>";
    					}
    					
    					// Vaciamos - Documentos - Existentes
    					$("#MDBBody-Documents-Files").html(oHtmlFiles);
    				}else{
    					// Mensaje - Usuario
						$.alert({ title: 'Obtener documentos', content: "Por el momento no existen documentos registrados en el servidor. Por favor, intente crear un nuevo documento...", type: "orange",
						    buttons: {
						    	ok: {
						    		text: "OK",
						    		btnClass: "btn-orange",
						    		action: function(){
						    			// Por el momento no se requiere ninguna acción
						    		}
						    	}
						    }
						});
    				}
    			}
    			
    			// Vaciamos - Valor
    			oData = response;
    			
    			// Accion - Texto - Nombre de Archivo
    			$(".oFontTitleFile").unbind().click(function(){
    				// Variables - Locales
    				var oFileNameText = null;
    				
    				// Obtenemos - Nombre de Archivo y Cargamos Contenido
    				oFileNameText = $(this).attr("oFileName");
    				
    				// Cargamos - Contenido - Archivo
    				oLoadDataSelectedFile(oFileNameText);
    			});
    		},
    		error: function (response){
    			// Mensaje - Usuario
				$.alert({ title: '¡Error!', content: "Ocurrio un error al momento de intentar recuperar los documentos del servidor.", type: "red",
				    buttons: {
				    	ok: {
				    		text: "OK",
				    		btnClass: "btn-red",
				    		action: function(){
				    			// Por el momento no se requiere ninguna acción
				    		}
				    	}
				    }
				});
    		}
    	});
    	
    	// Retornamos - Valor
    	return oData;
    }
    
    /**
     * Funcion: oLoadDataSelectedFile
     * Autor: Acorzo
     * Fecha: 17/08/2019
     */
    function oLoadDataSelectedFile(oNameFile){
    	// Variables - Locales
    	var oContentFile = null;
    	var oExiste = false;
    	
        var oTextPreviewLinea = null;
        var oTextPreviewHTML = "";
        var oComodinTexto = null;
        var oUsoUnicode = false;
    	
    	// Obtenemos - Contenido de Archivo
    	// Ciclo FOR
    	for (var i=0; i < oDocuments.oData.length; i++){
    		// Buscamos - Contenido de Archivo * Nombre
    		if (oDocuments.oData[i].oFileName == oNameFile){
    			// Limpiamos - Contenido - Editor
    	    	$("#oTextEditor").text("");
    			// Cargamos - Contenido del Archivo
    			$("#oTextEditor").val(oDocuments.oData[i].oFileContent);
    			// Vaciamos - Contenido del Archivo - Preview
    			oContentFile = oDocuments.oData[i].oFileContent;
    			// Cambiamos - Valor
    			oExiste = true;
    			// Salimos - Ciclo
    			break;
    		}
    	}
    	
    	// Evaluamos - Existe Contenido
    	if (!oExiste){
    		// Mensaje - Consola
    		console.log("No existe contenido para el archivo seleccionado.");
    	}else{
    		// Ocultamos - Botones
    		$("#oBtnNuevo").hide();
    		
    		// Mostramos - Botones
    		$("#oBtnEditar").show();
    		$("#oBtnCancelar").show();
    		$("#oBtnEliminar").show();
    		
    		// Activación - TextEditor
    		$("#oTextEditor").removeAttr("disabled").prop("disbled",false);
    		
    		// Movemos - Foco - TextEditor
    		$("#oTextEditor").focus();
    		
    		// Seteamos - Nombre de Archivo
    		localStorage.setItem("fileName",oNameFile);
    		
    		// Generamos - Preview
    		// Separamos Texto - Salto de Linea
            oTextPreviewLinea = oContentFile.split(/\n/);
            
            // Armamos - HTML - Preview
            // Ciclo FOR
            for (var i=0; i < oTextPreviewLinea.length; i++){            
                // Evaluamos - Comodin - Texto #
                if (oTextPreviewLinea[i].substring(0,1) == "#"){
                    // Cambiamos - Valor - Comodin
                    oComodinTexto = "#";
                }
                
                // Evaluamos - Comodin - Texto ...
                if (oTextPreviewLinea[i].substring(0,3) == "..."){
                    if (!oUsoUnicode){
                        // Cambiamos - Valor - Comodin
                        oComodinTexto = "unicode";
                        // Eliminamos - Valor - Linea
                        oTextPreviewLinea[i] = "";
                        // Cambiamos - Valor
                        oUsoUnicode = true;
                    }else{
                        // Cambiamos - Valor - Comodin
                        oComodinTexto = "";
                        // Eliminamos - Valor - Linea
                        oTextPreviewLinea[i] = "";
                         // Cambiamos - Valor
                        oUsoUnicode = false;
                    }
                }else if (oUsoUnicode){
                    // Cambiamos - Valor - Comodin
                    oComodinTexto = "unicode";
                }
                
                // Evaluamos - Comodin - Texto ###
                if (oTextPreviewLinea[i].substring(0,3) == "###"){
                    // Cambiamos - Valor - Comodin
                    oComodinTexto = "###";
                }
                
                
                // Evaluamos - Comodin 
                switch(oComodinTexto){
                    // #
                    case "#":
                        // Agregamos - HTML - Preview
                        oTextPreviewHTML += "<h1><p>" + oTextPreviewLinea[i].substring(1, oTextPreviewLinea[i].length) + "</p></h1>";
                        break;
                        
                    // ... / ...
                    case "unicode":
                        // Agregamos - HTML - Preview
                        oTextPreviewHTML += "<pre><span style='font-family:\"Courier New\", Courier, monospace'>" + oTextPreviewLinea[i] + "</span></pre>"; 
                        break;
                        
                    // ###
                    case "###":
                        // Agregamos - HTML - Preview
                        oTextPreviewHTML += "<p style='font-size: 20px; font-weight: bold;'>" + oTextPreviewLinea[i].substring(3, oTextPreviewLinea[i].length) + "</p>";
                        break;
                        
                    default:
                        // Agregamos - HTML - Preview
                        oTextPreviewHTML += "<p>" + oTextPreviewLinea[i] + "</p>";
                        break;
                }
                
                // Limpiamos - Comodin
                oComodinTexto = "";
            }
            
            $("#oTextPreview").html();
            $("#oTextPreview").html(oTextPreviewHTML);
    	}
    }
    
    /**
	 * Función: oCustomMessageApp
	 * Autor: Acorzo
	 * Fecha: 17/08/2018
	 */
	function oCustomMessageApp(oMessage,oTitle, oContent, oType, oButtonText, oButtonClass, oActionFcn){
		// Validamos - Tipo de Mensaje
		switch(oMessage){
			// Alert
			case "1":
				// Mensaje - Usuario
				$.alert({
				    title: oTitle,
				    content: oContent,
				    type: oType,
				    buttons: {
				    	oButton: {
				    		text: oButtonText,
				    		btnClass: oButtonClass,
				    		action: oActionFcn
				    	}
				    }
				});
				break;
		}
	}
});

