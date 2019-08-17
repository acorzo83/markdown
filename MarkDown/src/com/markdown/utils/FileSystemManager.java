package com.markdown.utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.log4j.Logger;

import com.markdown.globals.SystemGlobalVars;

public class FileSystemManager {
	/**
     * Atributos de Clase
     */
    private SystemGlobalVars oGlobalsVars = null;
    
    /**
     * Constructor
     */
    public FileSystemManager(){
        // Creamos - Objeto - SystemGlobals
        oGlobalsVars = new SystemGlobalVars();
        // Seteamos - Nombre de Clase - Logger
        oGlobalsVars.LOG = Logger.getLogger("FileSystemManager");
    }
    
    /**
     * Metodos Publicos
     */
    
    /**
     * Metodo: getObtAppPath
     * Autor: Acorzo
     * Fecha: 10/12/2015
     * @return 
     */
    public String getObtAppPath(){
        // Obtenemos - Ruta Absoluta - App
        return _getObtAppPath();
    }
    
    /**
     * Metodo: getObtExistFile
     * Autor: Acorzo
     * Fecha: 10/12/2015
     * @param path
     * @return 
     */
    public boolean getObtExistFile(String path){
        // Evaluamos - Existe Archivo
        return _getObtExistFile(path);
    }
    
    /**
     * Metodo: setCreateFile
     * Autor: Acorzo
     * Fecha: 10/12/2015
     * @param path
     * @return 
     */
    public boolean setCreateFile(String path){
        // Creamos - Archivo
        return _setCreateFile(path);
    }
    
    /**
     * Metodo: setWriteFile
     * Autor: Acorzo
     * Fecha: 10/12/2015
     * @param path
     * @param texto
     * @param encoding
     * @return 
     */
    public boolean setWriteFile(String path, Vector texto, String encoding){
        // Escribimos - Archivo
        return _setWriteFile(path, texto, encoding);
    }
    
    /**
     * Metodo: getObtReadFile
     * Autor: Acorzo
     * Fecha: 10/12/2015
     * @param path
     * @return 
     */
    public Vector getObtReadFile(String path){
        // Leemos - Archivo
        return _getObtReadFile(path);
    }
    
    /**
     * Metodo: getObtExistDirectory
     * Autor: Acorzo
     * Fecha: 10/12/2015
     * @param path
     * @return 
     */
    public boolean getObtExistDirectory(String path){
        // Evaluamos - Existe Directorio
        return _getObtExistDirectory(path);
    }
    
    /**
     * Metodo: setCreateDirectory
     * Autor: Acorzo
     * Fecha: 10/12/2015
     * @param path
     * @return 
     */
    public boolean setCreateDirectory(String path){
        // Creamos - Directorio
        return _setCreateDirectory(path);
    }
    
    /**
     * Metodo: setMoveFileTo
     * Autor: Acorzo
     * Fecha: 10/12/2015
     * @param pathOrigin
     * @param pathDestiny
     * @param fileName
     * @return 
     */
    public boolean setMoveFileTo(String pathOrigin, String pathDestiny, String fileName){
        // Movemos - Archivo
        return _setMoveFileTo(pathOrigin, pathDestiny, fileName);
    }
    
    /**
     * Metodo: getObtFilesToDirectory
     * Autor: Acorzo
     * Fecha: 10/12/2015
     * @param path
     * @return 
     */
    public Vector getObtFilesToDirectory(String path){
        // Obtenemos - Archivos en Directorio
        return _getObtFilesToDirectory(path);
    }
    
    /**
     * Metodo: setObtGZipDirectoryFiles
     * Autor: Acorzo
     * Fecha: 18/03/2016
     * @param path
     * @param nameZipFile
     * @return 
     */
    public boolean setObtGZipDirectoryFiles(String path, String nameZipFile, String outPath){
        // Comprimimos - Archivos en Directorio - Procesados
        return _setObtGZipDirectoryFiles(path, nameZipFile, outPath);
    }
    
    /**
     * Metodo: setDeleteFile
     * Autor: Acorzo
     * Fecha: 17/08/2019
     * @param path
     * @return
     */
    public boolean setDeleteFile(String path) {
    	// Eliminamos - Archivo
    	return _setDeleteFile(path);
    }
        
    /**
     * Metodos Privados
     */
    
    /**
     * Metodo: getObtAppPath
     * Aurtor: Acorzo
     * Fecha: 10/12/2015
     * @return 
     */
    private String _getObtAppPath(){
        // Variables - Locales
        String ruta = null;
        File file = null;
        
        // Obtenemos - Ruta Absoluta - App
        try {
            // Instanciamos - Objetos
            file = new File("");
            // Obtenemos - Ruta
            ruta = file.getCanonicalPath();
        } catch (Exception e) {
            // Seteamos - Log
            oGlobalsVars.LOG.error("[FileSystemManager] Ocurrio un error al obtener la ruta de la app: " + e.getMessage());
            // Mensaje - Consola
            System.out.println("Ocurrio un error al obtener la ruta de la app: " + e.getMessage());
        }
        
        // Retornamos - Valor
        return ruta;
    }
    
    /**
     * Metodo: _getObtExistFile
     * Autor: Acorzo
     * Fecha: 10/12/2015
     * @param path
     * @return 
     */
    private boolean _getObtExistFile(String path){
        // Variables - Locales
        boolean isSuccess = false;
        File file = null;
        String pathFile = null;
        
        // Evaluamos - Existe Archivo
        try {
            // Armamos - Path - Evaluar
            pathFile = _getObtAppPath() + "/" + path;
            // Instanciamos - Objetos
            file = new File(pathFile);
            // Evauamos - Existe Archivo - Path
            if (file.exists()){
                // Cambiamos - Valor
                isSuccess = true;
            }else{
                // Cambiamos - Valor
                isSuccess = false;
            }
        } catch (Exception e) {
            // Seteamos - Log
            oGlobalsVars.LOG.error("[FileSystemManager] Ocurrio un error al validar la existencia del archivo: " + e.getMessage());
            // Mensaje - Consola
            System.out.println("Ocurrio un error al validar la existencia del archivo: " + e.getMessage());
        }
        
        // Retornamos - Valor
        return isSuccess;
    }
    
    /**
     * Metodo: _setCreateFile
     * Autor: Acorzo
     * Fecha: 10/12/2015
     * @param path
     * @return 
     */
    private boolean _setCreateFile(String path){
        // Variables - Locales
        boolean isSuccess = false;
        File file = null;
        String pathFile = null;
        
        // Creamos - Archivo
        try {
            // Armamos - Path - Creacion de Archivo
            pathFile = _getObtAppPath() + "/" + path;
            // Instanciamos - Objetos
            file = new File(pathFile);
            // Generamos - Archivo
            if (file.createNewFile()){
                // Cambiamos - Valor
                isSuccess = true;
                // Seteamos - Log
                oGlobalsVars.LOG.info("[FileSystemManager] Archivo creado satisfactoriamente! en: " + pathFile);
                // Mensaje - Consola
                System.out.println("Archivo creado satisfactoriamente! en: " + pathFile);
            }else{
                // Cambiamos - Valor
                isSuccess = false;
                // Seteamos - Log
                oGlobalsVars.LOG.warn("[FileSystemManager] Archivo ya existe! en : " + pathFile);
                // Mensaje - Consola
                System.out.println("Archivo ya existe! en : " + pathFile);
            }
        } catch (Exception e) {
            // Seteamos - Log
            oGlobalsVars.LOG.error("[FileSystemManager] Ocurrio un error al momento de crear el archivo: " + e.getMessage());
            // Mensaje - Consola
            System.out.println("Ocurrio un error al momento de crear el archivo: " + e.getMessage());
        }
        
        // Retornamos - Valor
        return isSuccess;
    }
    
    /**
     * Metodo: _setWriteFile
     * Autor: Acorzo
     * Fecha: 10/12/2015
     * @param path
     * @param texto
     * @param encoding
     * @return 
     */
    private boolean _setWriteFile(String path, Vector texto, String encoding){
        // Variables - Locales
        boolean isSuccess = false;
        PrintWriter file = null;
        String pathFile = null;
        
        // Escribimos - Archivo
        try {
            // Armamos - Path - Archivo a Escribir
            pathFile = _getObtAppPath() + "/" + path;
            // Instanciamos - Objetos
            file = new PrintWriter(pathFile,encoding);
            // Ciclo FOR
            for (int i=0; i < texto.size(); i++){
                // Escribimos - Archivo
                file.println(texto.elementAt(i).toString());
            }
            // Cerramos - Escritura de Archivo
            file.close();
            // Cambiamos - Valor
            isSuccess = true;
            // Seteamos - Log
            oGlobalsVars.LOG.info("[FileSystemManager] Se escribio el archivo satisfactoriamente! en: " + pathFile);
            // Mensaje - Consola
            System.out.println("Se escribio el archivo satisfactoriamente! en: " + pathFile);
        } catch (Exception e) {
            // Seteamos - Log
            oGlobalsVars.LOG.error("[FileSystemManager] Ocurrio un error al momento de escribir el archivo: " + e.getMessage());
            // Mensaje - Consola
            System.out.println("Ocurrio un error al momento de escribir el archivo: " + e.getMessage());
        }
        
        // Retornamos - Valor
        return isSuccess;
    }
    
    /**
     * Metodo: _getObtReadFile
     * Autor: Acorzo
     * Fecha: 10/12/2015
     * @param path
     * @return 
     */
    private Vector _getObtReadFile(String path){
        // Variables - Locales
        boolean isSuccess = false;
        BufferedReader file = null;
        String pathFile = null;
        Vector texto = null;
        String line = null;
        
        // Leemos - Archivo
        try {
            // Armamos - Path - Archivo a Leer
            pathFile = _getObtAppPath() + "/" + path;
            // Instanciamos - Objetos
            file = new BufferedReader(new FileReader(pathFile));
            texto = new Vector();
            // Ciclo While
            while ((line = file.readLine()) !=null){
                // Evaluamos - Lineas - ! de ""
                if (!line.equals("")){
                    // Vaciamos - Contenido Archivo
                    texto.add(line);
                }
            }
        } catch (Exception e) {
            // Seteamos - Log
            oGlobalsVars.LOG.error("[FileSystemManager] Ocurrio un error al momento de leer el archivo: " + e.getMessage());
            // Mensaje - Consola
            System.out.println("Ocurrio un error al momento de leer el archivo: " + e.getMessage());
        } finally {
            // Cerramos - Archivo
            try {
                // Evaluamos - Recorrido de Archivo
                if (file != null){
                    // Cierra - Archivo
                    file.close();
                    // Cambiamos - Valor
                    isSuccess = true;
                    // Seteamos - Log
                    oGlobalsVars.LOG.info("[FileSystemManager] Se leyo y cerro el archivo correctamente! en :" + pathFile);
                    // Mensaje - Consola
                    System.out.println("Se leyo y cerro el archivo correctamente! en :" + pathFile);
                }
            } catch (Exception e) {
                // Seteamos - Log
                oGlobalsVars.LOG.error("[FileSystemManager] Ocurrio un error al momento de leer y cerrar el archivo: " + pathFile);
                // Mensaje - Consola
                System.out.println("Ocurrio un error al momento de leer y cerrar el archivo: " + pathFile);
            }
        }
        
        // Retornamos - Valor
        return texto;
    }
    
    /**
     * Metodo: _getObtExistDirectory
     * Autor: Acorzo
     * Fecha: 10/12/2015
     * @param path
     * @return 
     */
    private boolean _getObtExistDirectory(String path){
        // Variables - Locales
        boolean isSuccess = false;
        File file = null;
        String pathFile = null;
        
        // Evaluamos - Existe Directorio
        try {
            // Armamos - Path - Evaluar
            pathFile = _getObtAppPath() + "/" + path;
            System.out.println(pathFile);
            // Instanciamos - Objetos
            file = new File(pathFile);
            // Evaluamos - Existe Directorio - Path
            if (file.exists() && file.isDirectory()){
                // Cambiamos - Valor
                isSuccess = true;
            }else{
                // Cambiamos - Valor
                isSuccess = false;
            }
        } catch (Exception e) {
            // Seteamos - Log
            oGlobalsVars.LOG.error("[FileSystemManager] Ocurrio un error al validar la existencia del directorio: " + e.getMessage());
            // Mensaje - Consola
            System.out.println("Ocurrio un error al validar la existencia del directorio: " + e.getMessage());
        }
        
        // Retornamos - Valor
        return isSuccess;
    }
    
    /**
     * Metodo: _setCreateDirectory
     * Autor: Acorzo
     * Fecha: 10/12/2015
     * @param path
     * @return 
     */
    private boolean _setCreateDirectory(String path){
        // Variables - Locales
        boolean isSuccess = false;
        File file = null;
        String pathFile = null;
        
        // Creamos - Directorio
        try {
            // Armamos - Path - Directorio
            pathFile = _getObtAppPath() + "/" + path;
            // Instanciamos - Objetos
            file = new File(pathFile);
            // Creamos - Directorio
            if (file.mkdir()){
                // Cambiamos - Valor
                isSuccess = true;
                // Seteamos - Log
                oGlobalsVars.LOG.info("[FileSystemManager] El directorio se creo satisfactoriamente! en: " + pathFile);
                // Mensaje - Consola
                System.out.println("El directorio se creo satisfactoriamente! en: " + pathFile);
            }else{
                // Cambiamos - Valor
                isSuccess = false;
                // Seteamos - Log
                oGlobalsVars.LOG.warn("[FileSystemManager] El directorio no se pudo crear en: " + pathFile);
                // Mensaje - Consola
                System.out.println("El directorio no se pudo crear en: " + pathFile);
            }
        } catch (Exception e) {
            // Seteamos - Log
            oGlobalsVars.LOG.error("[FileSystemManager] Ocurrio un error al momento de generar el directorio: " + e.getMessage());
            // Mensaje - Consola
            System.out.println("Ocurrio un error al momento de generar el directorio: " + e.getMessage());
        }
        
        // Retornamos - Valor
        return isSuccess;
    }
    
    /**
     * Metodo: _setDeleteFile
     * Autor: Acorzo
     * Fecha: 17/08/2019
     * @param path
     * @return
     */
    private boolean _setDeleteFile(String path) {
    	// Variables - Locales
    	boolean isSuccess = false;
    	File file = null;
    	String pathFile = null;
    	
    	// Eliminamos - Archivo
    	try {
			// Armamos - Path - Archivo
    		pathFile = _getObtAppPath() + "/" + path;
    		// Instanciamos - Objetos
    		file = new File(pathFile);
    		// Evaluamos - Existe Archivo
    		if (file.exists()) {
    			// Eliminamos - Archivo
    			file.delete();
    			// Cambiamos - Valor
    			isSuccess = true;
    		}else {
    			// Cambiamos - Valor
    			isSuccess = false;
    		}
		} catch (Exception e) {
			// TODO: handle exception
			// Seteamos - Log
            oGlobalsVars.LOG.error("[FileSystemManager] Ocurrio un error al momento de eliminar el directorio: " + e.getMessage());
            // Mensaje - Consola
            System.out.println("Ocurrio un error al momento de eliminar el archivo: " + e.getMessage());
            // Cambiamos - Valor
            isSuccess = false;
		}
    	
    	// Retornamos - Valor
    	return isSuccess;
    }
    
    /**
     * Metodo: _setDeleteDirectory
     * Autor: Acorzo
     * Fecha: 20/03/2016
     * @param path
     * @return 
     */
    private boolean _setDeleteDirectory(String path){
        // Variables - Locales
        boolean isSuccess = false;
        File file = null;
        String pathFile = null;
        File[] files = null;
        
        // Eliminamos - Directorio
        try {
            // Armamos - Path - Directorio
            pathFile = _getObtAppPath() + "/" + path;
            // Instanciamos - Objetos
            file = new File(pathFile);
            // Evaluamos - Es Directorio
            if (file.exists()){
                // Obtenemos - Lista de Archivos - Eliminar
                files = file.listFiles();
                // Evaluamos - Directorio - Archivos
                if (files != null){
                    // Directorio con Archivos
                    // Eliminamos - Archivos
                    // Ciclo FOR
                    for (int i=0; i < files.length; i++){
                        // Eliminamos - Archivos
                        files[i].delete();
                    }
                }
            }
            // Eliminamos - Directorio
            file.delete();
            // Cambiamos - Valor
            isSuccess = true;
        } catch (Exception e) {
            // Seteamos - Log
            oGlobalsVars.LOG.error("[FileSystemManager] Ocurrio un error al momento de eliminar el directorio: " + e.getMessage());
            // Mensaje - Consola
            System.out.println("Ocurrio un error al momento de eliminar el directorio: " + e.getMessage());
            // Cambiamos - Valor
            isSuccess = false;
        }
        
        // Retornamos - Valor
        return isSuccess;
    }
    
    /**
     * Metodo: _setMoveFileTo
     * Autor: Acorzo
     * Fecha: 10/12/2015
     * @param pathOrigin
     * @param pathDestiny
     * @return 
     */
    private boolean _setMoveFileTo(String pathOrigin, String pathDestiny, String fileName){
        // Variables - Locales
        boolean isSuccess = false;
        File file = null;
        String pathFileOrigin = null;
        String pathFileDestiny = null;
        
        // Movemos - Archivo
        try {
            // Evaluamos - Ruta - Archivo
            if (!pathOrigin.equals("")){
                // Armamos - Ruta - Archivo
                pathOrigin = pathOrigin + "/" + fileName;
            }else{
                // Armamos - Ruta - Archivo
                pathOrigin = fileName;
            }
            
            // Armamos - Paths - Archivo Origen & Destino
            pathFileOrigin = _getObtAppPath() + "/" + pathOrigin;
            pathFileDestiny = _getObtAppPath() + "/" + pathDestiny + "/";
            // Instanciamos - Objetos
            file = new File(pathFileOrigin);
            // Evaluamos - Directorio - Destino
            if (_getObtExistDirectory(pathDestiny)){
                // Movemos - Archivo
                if (file.renameTo(new File(pathFileDestiny + file.getName()))){
                    // Cambiamos - Valor
                    isSuccess = true;
                    // Seteamos - Log
                    oGlobalsVars.LOG.info("[FileSystemManager] El archivo fue movido satisfactoriamente! de: " + pathFileOrigin + " a: " + pathFileDestiny);
                    // Mensaje - Consola
                    System.out.println("El archivo fue movido satisfactoriamente! de: " + pathFileOrigin + " a: " + pathFileDestiny);
                }else{
                    // Cambiamos - Valor
                    isSuccess = false;
                    // Seteamos - Log
                    oGlobalsVars.LOG.warn("[FileSystemManager] El archivo no fue movido debido a que el archivo o directorio de origen y/o destino no existen");
                    // Mensaje - Consola
                    System.out.println("El archivo no fue movido debido a que el archivo o directorio de origen y/o destino no existen");
                }
            }else{
                // Creamos - Directorio
                if (_setCreateDirectory(pathDestiny)){
                    // Movemos - Archivo
                    if (file.renameTo(new File(pathFileDestiny + file.getName()))){
                        // Cambiamos - Valor
                        isSuccess = true;
                        // Seteamos - Log
                        oGlobalsVars.LOG.info("[FileSystemManager] El archivo fue movido satisfactoriamente! de: " + pathFileOrigin + " a: " + pathFileDestiny);
                        // Mensaje - Consola
                        System.out.println("El archivo fue movido satisfactoriamente! de: " + pathFileOrigin + " a: " + pathFileDestiny);
                    }else{
                        // Cambiamos - Valor
                        isSuccess = false;
                        // Seteamos - Log
                        oGlobalsVars.LOG.warn("[FileSystemManager] El archivo no fue movido debido a que el archivo o directorio de origen y/o destino no existen");
                        // Mensaje - Consola
                        System.out.println("El archivo no fue movido debido a que el archivo o directorio de origen y/o destino no existen");
                    }
                }
            }
        } catch (Exception e) {
            // Seteamos - Log
            oGlobalsVars.LOG.error("[FileSystemManager] Ocurrio un error al momento de mover el archivo: "  + e.getMessage());
            // Mensaje - Consola
            System.out.println("Ocurrio un error al momento de mover el archivo: "  + e.getMessage());
        }
        
        // Retornamos - Valor
        return isSuccess;
    }
    
    /**
     * Metodo: _getObtFilesToDirectory
     * Autor: Acorzo
     * Fecha: 10/12/2015
     * @param path
     * @return 
     */
    private Vector _getObtFilesToDirectory(String path){
        // Variables - Locales
        File file = null;
        File[] oListaArchivos = null;
        String pathFile = null;
        Vector texto = null;
        
        // Obtenemos - Archivos en Directorio
        try {
            pathFile = _getObtAppPath() + "/" + path;
            // Instanciamos - Objetos
            file = new File(pathFile);
            texto = new Vector();
            // Vaciamos - Lista de Archivos
            oListaArchivos = file.listFiles();
            // Obtenemos - Nombres de Archivos - Directorio
            // Ciclo FOR
            for (File fileRow : oListaArchivos){
                // Evaluamos - Es Archivo
                if (fileRow.isFile()){
                    // Vaciamos - Nombre de Archivo
                    texto.add(fileRow.getName());
                }
            }
        } catch (Exception e) {
            // Seteamos - Log
            oGlobalsVars.LOG.error("[FileSystemManager] Ocurrio un error al momento de obtener el listado de archivos: " + e.getMessage());
            // Mensaje - Consola
            System.out.println("Ocurrio un error al momento de obtener el listado de archivos: " + e.getMessage());
        }
        
        // Retornamos - Valor
        return texto;
    }
    
    /**
     * Metodo: _setObtGZipDirectoryFiles
     * Autor: Acorzo
     * Fecha: 18/03/2016
     * @param path
     * @param nameZipFile
     * @return 
     */
    private boolean _setObtGZipDirectoryFiles(String path, String nameZipFile, String outPath){
        // Variables - Locales
        File sDirectory = null;
        File oFileZip = null;
        String[] arrFilesDirectory = null;
        byte[] oBuffer = null;
        int oBytesRead;
        ZipOutputStream out = null;
        FileInputStream oFileInput;
        ZipEntry oZipEntry;
        boolean isSuccess = false;
        
        // Ejecutamos - Compresion de Archivos - Directorios
        try {
            // Instanciamos - Objetos
            sDirectory = new File(getObtAppPath() + "/" + path);
            oBuffer = new byte[4096];
            out = new ZipOutputStream(new FileOutputStream(nameZipFile + ".zip"));

            // Evalulamos - Es Directorio
            if (sDirectory.isDirectory()){
                // Obtenemos - Listado de Archivos - Directorio
                arrFilesDirectory = sDirectory.list();
                
                // Recorremos - Listado de Archivos
                for (int i=0; i < arrFilesDirectory.length; i++){
                    // Leemos - Archivos
                    oFileZip = new File(sDirectory, arrFilesDirectory[i]);
                    // Evaluamos - Existen Directorios - Dentro de Directorio Raiz
                    if (oFileZip.isDirectory()){
                        // Continuamos - Proceso
                        continue;
                    }
                    
                    // Leemos - Archivo
                    oFileInput = new FileInputStream(oFileZip);
                    // Generamos - Entrada ZIP
                    oZipEntry = new ZipEntry(oFileZip.getPath());
                    // Almacenamos - El archivo a Procesar
                    out.putNextEntry(oZipEntry);
                    // Leemos los Bytes
                    // Ciclo WHILE
                    while ((oBytesRead = oFileInput.read(oBuffer)) != -1){
                        // Copiamos - Bytes
                        out.write(oBuffer,0,oBytesRead);
                    }
                    
                    // Cerramos - Lectura de Bytes - Archivo
                    oFileInput.close();
                }
                // Cerramos - Salida de Datos
                out.close();
            }
            
            // Movemos - Archivo a Output
            if (_setMoveFileTo("", outPath, nameZipFile + ".zip")){
                // Eliminamos - Directorio - Temporal
                if(_setDeleteDirectory(outPath + "/" + nameZipFile)){
                    // Seteamos - Log
                    oGlobalsVars.LOG.info("[FileSystemManager] El directorio: " + nameZipFile + " fue eliminado exitosamente!");
                    // Mesnaje - Consola
                    System.out.println("[FileSystemManager] El directorio: " + nameZipFile + " fue eliminado exitosamente!");
                }else{
                    // Seteamos - Log
                    oGlobalsVars.LOG.warn("[FileSystemManager] El directorio: " + nameZipFile + " no pudo ser eliminado");
                    // Mensaje - Consola
                    System.out.println("[FileSystemManager] El directorio: " + nameZipFile + " no pudo ser eliminado");
                }
            }else{
                // Seteamos - Log
                oGlobalsVars.LOG.warn("[FileSystemManager] No se pudo mover el archivo: " + nameZipFile + ".zip al directorio de destino");
                // Mensaje - Consola
                System.out.println("[FileSystemManager] No se pudo mover el archivo: " + nameZipFile + ".zip al directorio de destino");
            }
            
            
            // Vaciamos - Valor
            isSuccess = true;
        } catch (Exception e) {
            // Seteamos - Log
            oGlobalsVars.LOG.error("[FileSystemManager] Ocurrio un error al momento de comprimir el listado de archivos: " + e.getMessage());
            // Mensaje - Consola
            System.out.println("Ocurrio un error al momento de comprimir el listado de archivos: " + e.getMessage());
            // Vaciamos - Valor
            isSuccess = false;
        }
        
        // Retornamos - Valor
        return isSuccess;
    }
}
