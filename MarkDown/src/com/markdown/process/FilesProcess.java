package com.markdown.process;

import java.util.Vector;

import com.markdown.blogics.FilesBlogic;
import com.markdown.interfaces.AbstractCrudInterface;
import com.markdown.utils.JsonSystemManager;

public class FilesProcess implements AbstractCrudInterface {

	@Override
	public String create(Vector oObject, String oModulo) {
		// TODO Auto-generated method stub
		// Variables - Locales
		Vector oResult = null;
		String oResponse = null;
		
		// Declaración de Variables
		FilesBlogic oFilesBlogic = null;
		
		// Evaluamos - Modulo a Procesar
		switch(oModulo) {
			case "CDOCUMENT":
				// Iniciamos - Proceso - Create - Documento
				try {
					// Instanciamos - Objetos
					oFilesBlogic = new FilesBlogic();
					
					// Ejecutamos - Proceso
					oResult = oFilesBlogic.create(oObject, oModulo);
					// Obtenemos - Result - JSON
					oResult = (new JsonSystemManager(oResult, "RP")).getObtDataJson();
					// Vaciamos - Response
					oResponse = oResult.elementAt(0).toString();
				} catch (Exception e) {
					// TODO: handle exception
					// Seteamos - Paramaetros
					oResult = new Vector();
					oResult.add(false);
					oResult.add(true);
					oResult.add("[FilesProcess] Ocurrio un error al momento de crear el documento [CDOCUMENT]: " + e.getMessage());
					// Obtenemos - Result - JSON
					oResult = (new JsonSystemManager(oResult, "RP")).getObtDataJson();
					// Vaciamos - Response
					oResponse = oResult.elementAt(0).toString();
				}
				break;
		}
		return oResponse;
	}

	@Override
	public String read(Vector oObject, String oModulo) {
		// TODO Auto-generated method stub
		// Variables - Locales
		Vector oResult = null;
		String oResponse = null;
		
		// Declaración de Variables
		FilesBlogic oFilesBlogic = null;
		
		// Evaluamos - Modulo a Procesar
		switch(oModulo) {
			// Listado de Documentos
			case "LISTDOCUMENTS":
				// Iniciamos - Proceso - Read - Documentos
				try {
					// Instanciamos - Objetos
					oFilesBlogic = new FilesBlogic();
					
					// Ejecutamos - Proceso
					oResult = oFilesBlogic.read(oObject, oModulo);
					// Obtenemos - Result - JSON
					oResult = (new JsonSystemManager(oResult, oModulo)).getObtDataJson();
					// Vaciamos - Response
					oResponse = oResult.elementAt(0).toString();
				} catch (Exception e) {
					// TODO: handle exception
					// Seteamos - Paramaetros
					oResult = new Vector();
					oResult.add(false);
					oResult.add(true);
					oResult.add("[FilesProcess] Ocurrio un error al momento de ejecutar el modulo [LISTDOCUMENTS]: " + e.getMessage());
					// Obtenemos - Result - JSON
					oResult = (new JsonSystemManager(oResult, "RP")).getObtDataJson();
					// Vaciamos - Response
					oResponse = oResult.elementAt(0).toString();
				}
				break;
		}
		
		// Retornamos - Valor
		return oResponse;
	}

	@Override
	public String update(Vector oObject, String oModulo) {
		// TODO Auto-generated method stub
		// Variables - Locales
		Vector oResult = null;
		String oResponse = null;
		
		// Declaración de Variables
		FilesBlogic oFilesBlogic = null;
		
		// Evaluamos - Modulo a Procesar
		switch(oModulo) {
			// Actualización de Documento
			case "UDOCUMENT":
				// Iniciamos - Proceso - Update - Documentos
				try {
					// Instanciamos - Objetos
					oFilesBlogic = new FilesBlogic();
					
					// Ejecutamos - Proceso
					oResult = oFilesBlogic.update(oObject, oModulo);
					// Obtenemos - Result - JSON
					oResult = (new JsonSystemManager(oResult, "RP")).getObtDataJson();
					// Vaciamos - Response
					oResponse = oResult.elementAt(0).toString();
				} catch (Exception e) {
					// TODO: handle exception
					// Seteamos - Paramaetros
					oResult = new Vector();
					oResult.add(false);
					oResult.add(true);
					oResult.add("[FilesProcess] Ocurrio un error al momento de editar el documento [UDOCUMENT]: " + e.getMessage());
					// Obtenemos - Result - JSON
					oResult = (new JsonSystemManager(oResult, "RP")).getObtDataJson();
					// Vaciamos - Response
					oResponse = oResult.elementAt(0).toString();
				}
				break;
		}
		
		// Retornamos - Valor
		return oResponse;
	}

	@Override
	public String delete(Vector oObject, String oModulo) {
		// TODO Auto-generated method stub
		// Variables - Locales
		Vector oResult = null;
		String oResponse = null;
		
		// Declaración de Variables
		FilesBlogic oFilesBlogic = null;
		
		// Evaluamos - Modulo a Procesar
		switch(oModulo) {
			// Eliminamos - Documento
			case "DDOCUMENT":
				// Iniciamos - Proceso - Delete - Documentos
				try {
					// Instanciamos - Objetos
					oFilesBlogic = new FilesBlogic();
					
					// Ejecutamos - Proceso
					oResult = oFilesBlogic.delete(oObject, oModulo);
					// Obtenemos - Result -JSON
					oResult = (new JsonSystemManager(oResult, "RP")).getObtDataJson();
					// Vaciamos - Response
					oResponse = oResult.elementAt(0).toString();
				} catch (Exception e) {
					// TODO: handle exception
					// Seteamos - Paramaetros
					oResult = new Vector();
					oResult.add(false);
					oResult.add(true);
					oResult.add("[FilesProcess] Ocurrio un error al momento de eliminar el documento [UDOCUMENT]: " + e.getMessage());
					// Obtenemos - Result - JSON
					oResult = (new JsonSystemManager(oResult, "RP")).getObtDataJson();
					// Vaciamos - Response
					oResponse = oResult.elementAt(0).toString();
				}
				break;
		}
		
		// Retornamos - Valor
		return oResponse;
	}

}
