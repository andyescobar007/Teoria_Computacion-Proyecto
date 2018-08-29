/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANDY ESCOBAR
 */
public class Manager_DFA {
    public DFA listDFA[];
    private JsonFile jsonFile;

    
    public Manager_DFA(JsonFile jsonFile){
        this.listDFA=new DFA[1];
        this.jsonFile=jsonFile;
    }
    
    public Manager_DFA(ArrayList<DFA> arrayDFA){
        this.listDFA=(DFA[])arrayDFA.toArray();
    }
   
    public void addNewDFA(String descripcion,boolean substring,DFA newDFA){
        newDFA.setDescripcion(descripcion);
        newDFA.setValidaSubString(substring);
        try {
            BufferedReader br=new BufferedReader(new FileReader(jsonFile.getArchivo()));
            
            Gson gson=new Gson();
            DFA[] tempListDFA=gson.fromJson(br, DFA[].class);
           
            if(tempListDFA!=null){
                listDFA=new DFA[tempListDFA.length+1];
                for (int i = 0; i < tempListDFA.length; i++) {
                    listDFA[i] = tempListDFA[i];    
                }
            }
            int lastpos=listDFA.length-1;
            listDFA[lastpos]=newDFA;
            String json= jsonFile.toJSONArrayFormat(gson.toJson(listDFA));
            jsonFile.write(json);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Manager_DFA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public DFA findDFA(String description){
        try {
            BufferedReader br =new BufferedReader(new FileReader(jsonFile.getArchivo()));
            Gson gson=new Gson();
            DFA[] arrayDFA=gson.fromJson(br, DFA[].class);
            for (DFA dfa : arrayDFA) {
                if(dfa.getDescripcion().equals(description)){
                    return dfa;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Manager_DFA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    
}
