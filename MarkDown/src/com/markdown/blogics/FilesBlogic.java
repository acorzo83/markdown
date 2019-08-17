package com.markdown.blogics;

import java.util.Vector;

import com.markdown.daos.FilesDao;

public class FilesBlogic {
	/**
	 * Atributos de la Clase
	 */
	
	/**
	 * Metodos Publicos
	 */
	
	/**
	 * Metodo: create
	 * Autor: Acorzo
	 * Fecha: 17/08/2019
	 * @param oObject
	 * @param oModulo
	 * @return
	 */
	public Vector create (Vector oObject, String oModulo) {
		// Variables - Locales
		Vector oResult = new Vector();
		
		// Ejecutamos - Proceso
		try {
			// Evaluamos - Modulo - Proceso - Ejecutar
			switch(oModulo) {
				// Creamos - Documento
				case "CDOCUMENT":
					// Ejecutamos - Proceso
					oResult = (new FilesDao()).cDocument(oObject);
					break;
			}
		} catch (Exception e) {
			// TODO: handle exception
			// Seteamos - Valores - Respuesta
			oResult = new Vector();
			oResult.add(false);
			oResult.add(true);
			oResult.add("[FilesBlogic] Ocurrio un error al momento de crear el documento [" + oModulo +"]: " + e.getMessage());
			// Mensaje - Consola
			System.out.println("[FilesBlogic] Ocurrio un error al momento de cargar los datos [" + oModulo +"]: " + e.getMessage());
		}
		
		// Retornamos - Valor
		return oResult;
	}
	
	/**
	 * Metodo: read
	 * Autor: Acorzo
	 * Fecha: 16/08/2019
	 * @param oObject
	 * @param oModulo
	 * @return
	 */
	public Vector read (Vector oObject, String oModulo) {
		// Variables - Locales
		Vector oResult = new Vector();
		
		// Ejecutamos - Proceso
		try {
			// Evauamos - Modulo - Proceso - Ejecutar
			switch(oModulo) {
				// Obtener - Listado de Documentos
				case "LISTDOCUMENTS":
					// Ejecutamos - Proceso
					oResult = (new FilesDao().mReadListDocuments(oObject));
					break;
			}
		} catch (Exception e) {
			// TODO: handle exception
			// Seteamos - Valores - Respuesta
			oResult = new Vector();
			oResult.add(false);
			oResult.add(true);
			oResult.add("[FilesBlogic] Ocurrio un error al momento de cargar los datos [" + oModulo +"]: " + e.getMessage());
			// Mensaje - Consola
			System.out.println("[FilesBlogic] Ocurrio un error al momento de cargar los datos [" + oModulo +"]: " + e.getMessage());
		}
		
		// Retornamos - Valor
		return oResult;
	}
	
	/**
	 * Metodo: update
	 * Autor: Acorzo
	 * Fecha: 17/08/2019
	 * @param oObject
	 * @param oModulo
	 * @return
	 */
	public Vector update (Vector oObject, String oModulo) {
		// Variables - Locales
		Vector oResult = new Vector();
		
		// Ejecutamos - Proceso
		try {
			// Evaluamos - Modulo - Proceso - Ejecutar
			switch(oModulo) {
				// Actualizar - Documento
				case "UDOCUMENT":
					// Ejecutamos - Proceso
					oResult = (new FilesDao().uDocument(oObject));
					break;
			}
		} catch (Exception e) {
			// TODO: handle exception
			// Seteamos - Valores - Respuesta
			oResult = new Vector();
			oResult.add(false);
			oResult.add(true);
			oResult.add("[FilesBlogic] Ocurrio un error al momento de editar el documento [" + oModulo +"]: " + e.getMessage());
			// Mensaje - Consola
			System.out.println("[FilesBlogic] Ocurrio un error al momento de editar el documento [" + oModulo +"]: " + e.getMessage());
		}
		
		// Retornamos - Valor
		return oResult;
	}
	
	/**
	 * Metodo: delete
	 * Autor: Acorzo
	 * Fecha: 17/08/2019
	 * @param oObject
	 * @param oModulo
	 * @return
	 */
	public Vector delete (Vector oObject, String oModulo) {
		// Variables - Locales
		Vector oResult = new Vector();
		
		// Ejecutamos - Proceso
		try {
			// Evaluamos - Modulo - Proceso - Ejecutar
			switch(oModulo) {
				// Eliminar - Documento
				case "DDOCUMENT":
					// Ejecutamos - Proceso
					oResult = (new FilesDao().dDocument(oObject));
					break;
			}
		} catch (Exception e) {
			// TODO: handle exception
			// Seteamos - Valores - Respuesta
			oResult = new Vector();
			oResult.add(false);
			oResult.add(true);
			oResult.add("[FilesBlogic] Ocurrio un error al momento de eliminar los datos [" + oModulo +"]: " + e.getMessage());
			// Mensaje - Consola
			System.out.println("[FilesBlogic] Ocurrio un error al momento de eliminar los datos [" + oModulo +"]: " + e.getMessage());
		}
		
		// Retornamos - Valor
		return oResult;
	}
}
