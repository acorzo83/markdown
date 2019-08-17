package com.markdown.utils;

import java.util.Vector;
import org.json.*;

import com.markdown.moels.ModelBeanFilesInfo;

public class JsonSystemManager {
	/**
	 * Atributos de la Clase
	 */
	private String oStrJsonModel = null;
	private String oStrProceso = null;
	private Vector oVecJsonModel = null;
	
	/**
	 * Constructor
	 * @param pStrJson
	 * @param pProceso
	 */
	public JsonSystemManager(String pStrJson, String pProceso) {
		// Seteamos - Parametros
		this.oStrJsonModel = pStrJson;
		this.oStrProceso = pProceso;
	}
	
	/**
	 * Constructor
	 * @param vParamsJson
	 * @param pProceso
	 */
	public JsonSystemManager(Vector vParamsJson, String pProceso) {
		// Seteamos - Parametros
		this.oVecJsonModel = vParamsJson;
		this.oStrProceso = pProceso;
	}
	
	/**
	 * Metodos Publicos
	 */
	
	/**
	 * Metodo: getObtDataJson
	 * Autor: Acorzo
	 * Fecha: 16/08/2019
	 * @return
	 */
	public Vector getObtDataJson() {		
		// Retornamos - Objeto - Vector - Datos
		return __getObtDataJson();
	}
	
	
	
	/**
	 * Metodos Privados
	 */
	
	/**
	 * Metodo: __getObtDataJson
	 * Autor: Acorzo
	 * Fecha: 16/08/2019
	 * @return
	 */
	private Vector __getObtDataJson() {
		// Variables - Locales
		JSONObject oJSONObject = null;
		JSONObject oJSONObjectDetalle = null;
		JSONArray oJSONArray = null;
		JSONArray oJSONArrayDetalle = null;
		JSONObject oJSONDataList = null;
		Vector oResult = null;
		Vector oVectorData = null;
		
		// Declaración de Modelos
		ModelBeanFilesInfo oModelBeanFilesInfo = null;
		
		// Evaluamos - Proceso
		switch (this.oStrProceso) {
			// Lista de Documentos
			case "LISTDOCUMENTS":
				// Iniciamos - Proceso
				try {
					// Instanciamos - Objetos
					oJSONObject = new JSONObject();					
					oJSONArray = new JSONArray();
					oResult = new Vector();
					oVectorData = new Vector();	
					
					// Vaciamos - Parametros
					oJSONObject.put("success", (boolean) this.oVecJsonModel.elementAt(0));
					oJSONObject.put("error", (boolean) this.oVecJsonModel.elementAt(1));
					oJSONObject.put("message", this.oVecJsonModel.elementAt(2).toString());
					
					// Vaciamos - Data - Response
					oVectorData = (Vector) this.oVecJsonModel.elementAt(3);
					
					// Recorremos - Vector
					for (int i=0; i < oVectorData.size(); i++){
						// Creamos - Modelo
						oModelBeanFilesInfo = new ModelBeanFilesInfo();
						oJSONDataList = new JSONObject();
						// Vaciamos - Datos - Vector
						oModelBeanFilesInfo = (ModelBeanFilesInfo) oVectorData.elementAt(i);
						// Recuperamos - Modelo
						// Vaciamos - Datos de Registro
						oJSONDataList.put("oFileName", oModelBeanFilesInfo.getFileName());
						oJSONDataList.put("oFileContent", oModelBeanFilesInfo.getFileContent());
						oJSONArray.put(oJSONDataList);
						
					}
					// Vaciamos - Lista de Datos
					oJSONObject.put("oData", oJSONArray);
					// Vaciamos - Respuesta
					oResult.add(oJSONObject.toString());
				} catch (Exception e) {
					// TODO: handle exception
					// Mensaje - Consola
					System.out.println("[JsonSystemManager] Ocurrio un error al momento de generar el modelo [LISTDOCUMENTS]: " + e.getMessage());
				}
				break;
				
			// Respuesta - Formato - JSON
			case "RP":
				// Iniciamos - Proceso
				try {
					// Instanciamos - Objetos
					oJSONObject = new JSONObject();
					oResult = new Vector();					
					// Vaciamos - Parametros
					oJSONObject.put("success", (boolean) this.oVecJsonModel.elementAt(0));
					oJSONObject.put("error", (boolean) this.oVecJsonModel.elementAt(1));
					oJSONObject.put("message", this.oVecJsonModel.elementAt(2).toString());
					// Vaciamos - Respuesta
					oResult.add(oJSONObject.toString());
				} catch (Exception e) {
					// TODO: handle exception
					// Mensaje - Consola
					System.out.println("[JsonSystemManager] Ocurrio un error al momento de convertir a formato JSON [RP]: " + e.getMessage());
				}
				break;
		}
		
		// Retornamos - Valor
		return oResult;
	}
}
