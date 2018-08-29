/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author ANDY ESCOBAR
 */
public class TextFile {
    private final String DIRECTORY_PATH="src/ArchivosTexto";
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    
    public TextFile(String path){
        try {
            archivo = new File (DIRECTORY_PATH+"//"+path);
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
        } catch (FileNotFoundException  ex) {
            System.err.println("Error al cargar archivo");
        }   
    }
    public TextFile(){
        archivo = new File (DIRECTORY_PATH);   
    }
    
    
    public BufferedReader getContenido(){
        return br;
    }
    
    public File[] getFiles(){
        if(archivo.exists()){
            return archivo.listFiles();
        }
        return null;
    }
    
}
