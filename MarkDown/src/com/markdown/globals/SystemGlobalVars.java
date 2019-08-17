package com.markdown.globals;

import org.apache.log4j.Logger;

public class SystemGlobalVars {
	/**
     * Atributos de la Clase
     */
    
    // Nombre del Archivo Ini
    public static String FILE_NAME_INI = "StsIni.ini";
    public static String ENCODING = "UTF-8";
    public static String PATH_INPUT_DIRECTORY = "Input";
    public static String PATH_OUTPUT_DIRECTORY = "Output";
    public static String PATH_DISCARD_DIRECTORY = "Discard";
    public static String PATH_LOG_DIRECTORY = "Log";
    public static Logger LOG = Logger.getLogger("log_sts_client");
}
