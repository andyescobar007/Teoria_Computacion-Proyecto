/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ANDY ESCOBAR
 */
    
    public class JsonFile {
        private FileWriter fileWriter;
        private File archivo;
        private final String DIRECTORY="src/ArchivoJson";
        private final String PATH;
        
        
        public JsonFile(String name){
            this.PATH=DIRECTORY+"//"+name+".json";
            archivo=new File(PATH);
            if(!new File(DIRECTORY).exists()){
                new File(DIRECTORY).mkdirs();
            }
        }
        public JsonFile(String directory,String nameFile){
            this.PATH=directory+"//"+nameFile+".json";
            archivo=new File(PATH);
            if(!new File(directory).exists()){
                new File(directory).mkdirs();
            }  
        }
       
        public File[] getFiles(){
            return new File(DIRECTORY).listFiles();
        }
        
        public void write(String json){
            try {   
                fileWriter=new FileWriter(archivo);
                fileWriter.write(json);
                fileWriter.close();
            } catch (IOException ex){
                System.err.println("Error al escribir en archivo: \n"+ex.getMessage());
            }
            
        }
        public  String toJSONObjectFormat(String jsonString) {
            JsonParser parser = new JsonParser();
            JsonObject json = parser.parse(jsonString).getAsJsonObject();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String prettyJson = gson.toJson(json);
            return prettyJson;
        }
         public  String toJSONArrayFormat(String jsonString) {
            JsonParser parser = new JsonParser();
            JsonArray json = parser.parse(jsonString).getAsJsonArray();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String prettyJson = gson.toJson(json);
            return prettyJson;
        }
       

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
        
    }