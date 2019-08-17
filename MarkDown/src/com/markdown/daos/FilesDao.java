package com.markdown.daos;

import java.util.Vector;

import com.markdown.moels.ModelBeanFilesInfo;
import com.markdown.utils.FileSystemManager;

public class FilesDao {
	/**
	 * Atributos de la Clase
	 */
	
	/**
	 * Constructor
	 */
	public FilesDao() {
	}
	
	/**
	 * Metodo: dDocument
	 * Autor: Acorzo
	 * Fecha: 17/08/2019
	 * @param oObject
	 * @return
	 */
	public Vector dDocument(Vector oObject) {
		// Variables - Locales
		Vector oResult = new Vector();
		Vector oResultListFiles = new Vector();
		Vector oData = new Vector();
		FileSystemManager oFileSystemManager = null;
		String oParamNombreDoc = null;
		boolean oExiste = false;
		
		// Eliminamos - Documento
		try {
			// Inistanciamos - Objetos
			oFileSystemManager = new FileSystemManager();
			
			// Vaciamos - Parametros
			oParamNombreDoc = oObject.elementAt(0).toString();
			
			// Evauamos - Existe - Directorio - Documentos
			if (oFileSystemManager.getObtExistDirectory("Documents")) {
				// Obtenemos - Listado de Archivos + Contenido
				oResultListFiles = oFileSystemManager.getObtFilesToDirectory("Documents");
				// Evaluamos - Cantidad de Archivos - Encontrados
				if (oResultListFiles.size() > 0) {
					// Evaluamos - Existe - Nombre de Documento
					// Ciclo FOR
					for (int i=0; i < oResultListFiles.size(); i++){
						// Realizamos - Evaluación - Documento Existente
						if (oResultListFiles.elementAt(i).toString().equals(oParamNombreDoc)) {
							// Archivo Existe
							// Cambiamos - Valor
							oExiste = true;
							// Salimos del Ciclo
							i = oResultListFiles.size();
						}
					}
					
					// Evaluamos - Existe - Archivo
					if (oExiste) {
						// Eliminamos - Documento
						if (oFileSystemManager.setDeleteFile("Documents/" + oParamNombreDoc)) {
							// Seteamos - Valores - Respuesta
							oResult = new Vector();
							oResult.add(true);
							oResult.add(false);
							oResult.add("El documento fue eliminado con exito!");
							oResult.add(oData);
						}else {
							// Seteamos - Valores - Respuesta
							oResult = new Vector();
							oResult.add(false);
							oResult.add(true);
							oResult.add("Ocurrio un error al momento de eliminar el documento del servidor");
							oResult.add(oData);
						}
					}else {
						// Seteamos - Valores - Respuesta
						oResult = new Vector();
						oResult.add(false);
						oResult.add(true);
						oResult.add("El documento que se intenta eliminar, no existe en los registros del servidor");
						oResult.add(oData);
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			// Seteamos - Valores - Respuesta
			oResult = new Vector();
			oResult.add(false);
			oResult.add(true);
			oResult.add("[FilesDao] Ocurrio un error al momento de eliminar el documento: [DDOCUMENT]: " + e.getMessage());
			oResult.add(oData);
		}
		
		// Retornamos - Valor
		return oResult;
	}
	
	/**
	 * Metodo: uDocument
	 * Autor: Acorzo
	 * Fecha: 17/08/2019
	 * @param oObject
	 * @return
	 */
	public Vector uDocument(Vector oObject) {
		// Variables - Locales
		Vector oResult = new Vector();
		Vector oResultListFiles = new Vector();
		Vector oData = new Vector();
		Vector oContentFile = new Vector();
		FileSystemManager oFileSystemManager = null;
		String oParamNombreDoc = null;
		String oParamContentDoc = null;
		boolean oExiste = false;
		
		// Actualizamos - Documento
		try {
			// Instanciamos - Objetos
			oFileSystemManager = new FileSystemManager();
						
			// Vaciamos - Parametros
			oParamNombreDoc = oObject.elementAt(0).toString();
			oParamContentDoc = oObject.elementAt(1).toString();
			oContentFile.add(oParamContentDoc);
			
			// Evauamos - Existe - Directorio - Documentos
			if (oFileSystemManager.getObtExistDirectory("Documents")) {
				// Obtenemos - Listado de Archivos + Contenido
				oResultListFiles = oFileSystemManager.getObtFilesToDirectory("Documents");
				// Evaluamos - Cantidad de Archivos - Encontrados
				if (oResultListFiles.size() > 0) {
					// Evaluamos - Existe - Nombre de Documento
					// Ciclo FOR
					for (int i=0; i < oResultListFiles.size(); i++){
						// Realizamos - Evaluación - Documento Existente
						if (oResultListFiles.elementAt(i).toString().equals(oParamNombreDoc)) {
							// Archivo Existe
							// Cambiamos - Valor
							oExiste = true;
							// Salimos del Ciclo
							i = oResultListFiles.size();
						}
					}
					
					// Evaluamos - Existe - Archivo
					if (oExiste) {
						// Eliminamos - Documento
						if (oFileSystemManager.setDeleteFile("Documents/" + oParamNombreDoc)) {
							// Creamos - Documento
							if (oFileSystemManager.setCreateFile("Documents/" + oParamNombreDoc)) {
								// Vaciamos - Contenido - Documento
								if (oFileSystemManager.setWriteFile("Documents/" + oParamNombreDoc, oContentFile, "UTF-8")) {
									// Seteamos - Valores - Respuesta
									oResult = new Vector();
									oResult.add(true);
									oResult.add(false);
									oResult.add("El documento fue editado con exito!");
									oResult.add(oData);
								}else {
									// Seteamos - Valores - Respuesta
									oResult = new Vector();
									oResult.add(false);
									oResult.add(true);
									oResult.add("Ocurrio un error al momento de escribir el contenido del archivo en el servidor");
									oResult.add(oData);
								}
							}else {
								// Seteamos - Valores - Respuesta
								oResult = new Vector();
								oResult.add(false);
								oResult.add(true);
								oResult.add("Ocurrio un error al momento de editar el archivo del lado del servidor");
								oResult.add(oData);
							}
						}else {
							// Seteamos - Valores - Respuesta
							oResult = new Vector();
							oResult.add(false);
							oResult.add(true);
							oResult.add("Ocurrio un error al momento de editar el archivo del lado del servidor");
							oResult.add(oData);
						}
					}else {
						// Seteamos - Valores - Respuesta
						oResult = new Vector();
						oResult.add(false);
						oResult.add(true);
						oResult.add("El documento que se intenta editar, no existe en los registros del servidor");
						oResult.add(oData);
					}
				}
			}else {
				// Creamos - Directorio
				if (oFileSystemManager.setCreateDirectory("Documents")){
					// Creamos - Documento
					if (oFileSystemManager.setCreateFile("Documents/" + oParamNombreDoc)) {
						// Vaciamos - Contenido - Documento
						if (oFileSystemManager.setWriteFile("Documents/" + oParamNombreDoc, oContentFile, "UTF-8")) {
							// Seteamos - Valores - Respuesta
							oResult = new Vector();
							oResult.add(true);
							oResult.add(false);
							oResult.add("El documento fue editado con exito!");
							oResult.add(oData);
						}else {
							// Seteamos - Valores - Respuesta
							oResult = new Vector();
							oResult.add(false);
							oResult.add(true);
							oResult.add("Ocurrio un error al momento de editar el contenido del archivo en el servidor");
							oResult.add(oData);
						}
					}else {
						// Seteamos - Valores - Respuesta
						oResult = new Vector();
						oResult.add(false);
						oResult.add(true);
						oResult.add("Ocurrio un error al momento de editar el archivo del lado del servidor");
						oResult.add(oData);
					}
				}else {
					// Mensaje - Consola
					System.out.println("No se pudo crear el directorio. Por favor, verifique...");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			// Seteamos - Valores - Respuesta
			oResult = new Vector();
			oResult.add(false);
			oResult.add(true);
			oResult.add("[FilesDao] Ocurrio un error al momento de editar el documento: [UDOCUMENT]: " + e.getMessage());
			oResult.add(oData);
		}
		
		// Retornamos - Valor
		return oResult;
	}
	
	/**
	 * Metodo: cDocument
	 * Autor: Acorzo
	 * Fecha: 17/08/2019
	 * @param oObject
	 * @return
	 */
	public Vector cDocument(Vector oObject) {
		// Variables - Locales
		Vector oResult = new Vector();
		Vector oResultListFiles = new Vector();
		Vector oData = new Vector();
		Vector oContentFile = new Vector();
		FileSystemManager oFileSystemManager = null;
		String oParamNombreDoc = null;
		String oParamContentDoc = null;
		boolean oExiste = false;
		
		// Creamos - Documento
		try {
			// Instanciamos - Objetos
			oFileSystemManager = new FileSystemManager();
			
			// Vaciamos - Parametros
			oParamNombreDoc = oObject.elementAt(0).toString();
			oParamContentDoc = oObject.elementAt(1).toString();
			oContentFile.add(oParamContentDoc);
			
			
			// Evauamos - Existe - Directorio - Documentos
			if (oFileSystemManager.getObtExistDirectory("Documents")) {
				// Obtenemos - Listado de Archivos + Contenido
				oResultListFiles = oFileSystemManager.getObtFilesToDirectory("Documents");
				// Evaluamos - Cantidad de Archivos - Encontrados
				if (oResultListFiles.size() > 0) {
					// Evaluamos - Existe - Nombre de Documento
					// Ciclo FOR
					for (int i=0; i < oResultListFiles.size(); i++){
						// Realizamos - Evaluación - Documento Existente
						if (oResultListFiles.elementAt(i).toString().equals(oParamNombreDoc)) {
							// Archivo Existe
							// Cambiamos - Valor
							oExiste = true;
							// Salimos del Ciclo
							i = oResultListFiles.size();
						}
					}
					
					// Evaluamos - Existe - Archivo
					if (oExiste) {
						// Seteamos - Valores - Respuesta
						oResult = new Vector();
						oResult.add(false);
						oResult.add(true);
						oResult.add("El archivo con el nombre: " + oParamNombreDoc + ", ya existe en nuestros registros. Por favor, intente ingresando otro nombre.");
						oResult.add(oData);
					}else{
						// Creamos - Documento
						if (oFileSystemManager.setCreateFile("Documents/" + oParamNombreDoc)) {
							// Vaciamos - Contenido - Documento
							if (oFileSystemManager.setWriteFile("Documents/" + oParamNombreDoc, oContentFile, "UTF-8")) {
								// Seteamos - Valores - Respuesta
								oResult = new Vector();
								oResult.add(true);
								oResult.add(false);
								oResult.add("El documento fue almacenado con exito!");
								oResult.add(oData);
							}else {
								// Seteamos - Valores - Respuesta
								oResult = new Vector();
								oResult.add(false);
								oResult.add(true);
								oResult.add("Ocurrio un error al momento de escribir el contenido del archivo en el servidor");
								oResult.add(oData);
							}
						}else {
							// Seteamos - Valores - Respuesta
							oResult = new Vector();
							oResult.add(false);
							oResult.add(true);
							oResult.add("Ocurrio un error al momento de crear el archivo del lado del servidor");
							oResult.add(oData);
						}
					}
				}
			}else {
				// Creamos - Directorio
				if (oFileSystemManager.setCreateDirectory("Documents")){
					// Creamos - Documento
					if (oFileSystemManager.setCreateFile("Documents/" + oParamNombreDoc)) {
						// Vaciamos - Contenido - Documento
						if (oFileSystemManager.setWriteFile("Documents/" + oParamNombreDoc, oContentFile, "UTF-8")) {
							// Seteamos - Valores - Respuesta
							oResult = new Vector();
							oResult.add(true);
							oResult.add(false);
							oResult.add("El documento fue almacenado con exito!");
							oResult.add(oData);
						}else {
							// Seteamos - Valores - Respuesta
							oResult = new Vector();
							oResult.add(false);
							oResult.add(true);
							oResult.add("Ocurrio un error al momento de escribir el contenido del archivo en el servidor");
							oResult.add(oData);
						}
					}else {
						// Seteamos - Valores - Respuesta
						oResult = new Vector();
						oResult.add(false);
						oResult.add(true);
						oResult.add("Ocurrio un error al momento de crear el archivo del lado del servidor");
						oResult.add(oData);
					}
				}else {
					// Mensaje - Consola
					System.out.println("No se pudo crear el directorio. Por favor, verifique...");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			// Seteamos - Valores - Respuesta
			oResult = new Vector();
			oResult.add(false);
			oResult.add(true);
			oResult.add("[FilesDao] Ocurrio un error al momento de crear el documento: [CDOCUMENT]: " + e.getMessage());
			oResult.add(oData);
		}
		
		// Retornamos - Valor
		return oResult;
	}
	
	/**
	 * Metodo: mReadListDocuments
	 * Autor: Acorzo
	 * Fecha: 16/08/2019
	 * @param oObject
	 * @return
	 */
	public Vector mReadListDocuments(Vector oObject) {
		// Variables - Locales
		Vector oResult = new Vector();
		Vector oResultListFiles = new Vector();
		Vector oData = new Vector();
		Vector oContentFile = new Vector();
		String oContentFileText = "";
		FileSystemManager oFileSystemManager = null;
		ModelBeanFilesInfo oModelBeanFilesInfo = null;
		
		// Obtenemos - Datos - Documentos
		try {
			// Instanciamos - Objetos
			oFileSystemManager = new FileSystemManager();
			oModelBeanFilesInfo = new ModelBeanFilesInfo();
			
			// Evaluamos - Existe - Directorio - Documentos
			if (oFileSystemManager.getObtExistDirectory("Documents")) {
				// Obtenemos - Listado de Archivos + Contenido
				oResultListFiles = oFileSystemManager.getObtFilesToDirectory("Documents");
				// Evaluamos - Cantidad de Archivos - Encontrados
				if (oResultListFiles.size() > 0) {
					// Obtenemos - Nombre de Archivo + Contenido
					// Ciclo For
					for (int i=0; i < oResultListFiles.size(); i++) {
						// Instanciamos - Objetos
						oModelBeanFilesInfo = new ModelBeanFilesInfo();
						
						// Limpiamos - Variables
						oContentFileText = "";
						
						// Obtenemos - Contenido - Archivo
						oContentFile = oFileSystemManager.getObtReadFile("Documents/" + oResultListFiles.elementAt(i).toString());
						// Vaciamos - Contenido - Formato de Texto
						// Ciclo FOR
						for (int c=0; c < oContentFile.size(); c++) {
							// Vaciamos - Contenido
							oContentFileText += oContentFile.elementAt(c).toString() + "\n";
						}
						
						// Vaciamos - Archivo + Contenido
						oModelBeanFilesInfo.setFileName(oResultListFiles.elementAt(i).toString());
						oModelBeanFilesInfo.setFileContent(oContentFileText);
						oData.add(oModelBeanFilesInfo);
					}
				}else {
					// Mensaje - Consola
					System.out.println("No se encontraron documentos en el servidor");
				}
			}else {
				// No Existe - Directorio
				// Creamos - Directorio
				if (oFileSystemManager.setCreateDirectory("Documents")){
					// Obtenemos - Listado de Archivos + Contenido
					oResultListFiles = oFileSystemManager.getObtFilesToDirectory("Documents");
					// Evaluamos - Cantidad de Archivos - Encontrados
					if (oResultListFiles.size() < 0) {
						// Mensaje - Consola
						System.out.println("No se encontraron documentos en el servidor");
					}
				}else {
					// Mensaje - Consola
					System.out.println("No se pudo crear el directorio. Por favor, verifique...");
				}
			}
			
			// Seteamos - Valores - Respuesta
			oResult = new Vector();
			oResult.add(true);
			oResult.add(false);
			oResult.add("Recuperación de datos exitosa!");
			oResult.add(oData);
		} catch (Exception e) {
			// TODO: handle exception
			// Seteamos - Valores - Respuesta
			oResult = new Vector();
			oResult.add(false);
			oResult.add(true);
			oResult.add("[FilesDao] Ocurrio un error al momento de recuperar los datos: [LISTDOCUMENTS]: " + e.getMessage());
			oResult.add(oData);
		}
		
		// Retornamos - Valor
		return oResult;
	}
}
