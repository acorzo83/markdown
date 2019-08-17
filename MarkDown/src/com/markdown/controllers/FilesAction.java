package com.markdown.controllers;

import java.util.Map;
import java.util.Vector;

import org.apache.struts2.interceptor.SessionAware;

import com.markdown.process.FilesProcess;
import com.opensymphony.xwork2.ActionSupport;

public class FilesAction extends ActionSupport implements SessionAware {
	/**
	 * Atributos de la Clase
	 */
	private static final long serialVersionUID = 7165717942492917787L;
	private String oid = null;
	private String opt = null;
	private String response = null;
	private String nombreDoc = null;
	private String contenidoDoc = null;
	
	public String execute() {
		// Variables - Locales
		Vector oResult = null;
		FilesProcess oFilesProcess = null;
		
		
		// Evaluamos - Accion - Realizar
		switch(this.oid) {
			// CRUD
			// Create
			case "C":
				// Evaluamos - Modulo a Procesar
				switch(this.opt) {
					// Creación - Documento
					case "CDOCUMENT":
						// Instanciamos - Objetos
						oResult = new Vector();
						oFilesProcess = new FilesProcess();
						
						// Vaciamos - Parametros
						oResult.add(this.nombreDoc);
						oResult.add(this.contenidoDoc);
						
						// CReamos - Documento - Lado del Servidor
						response = oFilesProcess.create(oResult, this.opt);
						break;
				}
				break;
			
			// Read
			case "R":
				// Evaluamos - Modulo a Procesar
				switch(this.opt) {
					// Lista de Documentos
					case "LISTDOCUMENTS":
						// Instanciamos - Objetos
						oResult = new Vector();
						oFilesProcess = new FilesProcess();
					
						// Obtenemos - Lista de Documentos - Almacenados
						response = oFilesProcess.read(oResult, this.opt);
						break;
				}
				break;
				
			// Update
			case "U":
				// Evaluamos - Modulo a Procesar
				switch(this.opt) {
					// Actualización - Documento
					case "UDOCUMENT":
						// Instanciamos - Objetos
						oResult = new Vector();
						oFilesProcess = new FilesProcess();
						
						// Vaciamos - Parametros
						oResult.add(this.nombreDoc);
						oResult.add(this.contenidoDoc);
						
						// Editamos - Documento - Lado del Servidor
						response = oFilesProcess.update(oResult, this.opt);
						break;
				}
				break;
				
			// Delete
			case "D":
				// Evaluamos - Modulo a Procesar
				switch(this.opt) {
					// Eliminamos - Documento
					case "DDOCUMENT":
						// Instanciamos - Objetos
						oResult = new Vector();
						oFilesProcess = new FilesProcess();
						
						// Vaciamos - Parametros
						oResult.add(this.nombreDoc);
						
						// Eliminamos - Documento - Lado del Servidor
						response = oFilesProcess.delete(oResult, this.opt);
						break;
				}
				break;
			
		}
		
		// Retornamos - Valor
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Parametros
	 */
	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getOpt() {
		return opt;
	}

	public void setOpt(String opt) {
		this.opt = opt;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getNombreDoc() {
		return nombreDoc;
	}

	public void setNombreDoc(String nombreDoc) {
		this.nombreDoc = nombreDoc;
	}

	public String getContenidoDoc() {
		return contenidoDoc;
	}

	public void setContenidoDoc(String contenidoDoc) {
		this.contenidoDoc = contenidoDoc;
	}
}
