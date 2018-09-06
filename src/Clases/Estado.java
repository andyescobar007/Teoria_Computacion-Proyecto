/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;

/**
 *
 * @author ANDY ESCOBAR
 */
public class Estado {
    String name;
    ArrayList<Transicion>transiciones;

    public Estado(String name) {
        this.name = name;
        this.transiciones=new ArrayList<>();
    }
    
    
    
    public void addTransicion(String input,String siguiente_estado){
        transiciones.add(new Transicion(name, input,siguiente_estado));
    }
    
    public Transicion[] getAllTrancionesConEntry(String entry){
        ArrayList<Transicion>tmp_transiciones=new ArrayList<>();
        for (Transicion t : transiciones) {
            if(t.getInput().equals(entry)){
                tmp_transiciones.add(t);
            }
        }
        return tmp_transiciones.toArray(new Transicion[tmp_transiciones.size()]);
    }
    
    public String next_Estados(String input){
        String tmp="";
        Transicion[] tmp_transiciones=getAllTrancionesConEntry(input);
        for (int i = 0; i < tmp_transiciones.length; i++) {
            tmp+=tmp_transiciones[i].getNewState();
            if(i!=tmp_transiciones.length-1){
                tmp+=",";
            }
        }
        return tmp;    
        
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
