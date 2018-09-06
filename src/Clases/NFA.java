/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author ANDY ESCOBAR
 */
public class NFA {

    private final String vacio="ø";
    private Estado[] estadosDFA;
    String estadoInicial;
    String[] alfabeto;
    String[] estadosAceptacion;
    Estado[] estados;
    
    
    public NFA(String estadoInicialNFA,String[] alfabetoNFA, String[] estadoAceptacionNFA, Estado[] allEstadosNFA) {
        this.estadoInicial=estadoInicialNFA;
        this.alfabeto=alfabetoNFA;
        this.estadosAceptacion=estadoAceptacionNFA;
        this.estados=allEstadosNFA;
    }
    
    
    private Transicion[] getTransicionesNFA(){
        ArrayList<Transicion>tmpTranciones=new ArrayList<>();
        for(Estado e:estados){
            for(Transicion t:e.transiciones){
                tmpTranciones.add(t);
            }
        }
        return tmpTranciones.toArray(new Transicion[tmpTranciones.size()]);
    
    }

    public Transicion[] getTransicionesDFA(){
        ArrayList<Transicion>tmp_transiciones=new ArrayList<>();
        ArrayList<Estado>estado_existentes=new ArrayList<>();
        Estado estado=buscarEstado(estadoInicial);
        for (String alphatbet:alfabeto){
            String tmp_transicion="";
            Transicion[]tmp_allTransicion=estado.getAllTrancionesConEntry(alphatbet);
            for (int i = 0; i < tmp_allTransicion.length; i++) {
                tmp_transicion += tmp_allTransicion[i].getNewState();
                if(i!=tmp_allTransicion.length-1){
                    tmp_transicion+=",";
               }
            }
            tmp_transiciones.add(new Transicion(estado.name, alphatbet, tmp_transicion));
        }      
        estado_existentes.add(estado);
        
        
        while(getNuevoEstado(estado_existentes,tmp_transiciones)!=null){
            //
           
            Transicion trans=getNuevoEstado(estado_existentes,tmp_transiciones);
            String tmp_buscar=vacio;
            for (String alphatbet:alfabeto){
                tmp_buscar=obtenerTransicion(trans.getNewState().split(","),alphatbet);
                tmp_buscar=tmp_buscar.charAt(0)==','?tmp_buscar.substring(1,tmp_buscar.length()):tmp_buscar;
                tmp_transiciones.add(new Transicion(trans.getNewState(), alphatbet, tmp_buscar));
                
            }
            if(!trans.getNewState().equals(vacio)||!trans.getNewState().equals("")){
                estado_existentes.add(new Estado(trans.getNewState()));
            }     
        }
        if(existenTransicionVacias(tmp_transiciones)){
            agregarEstadoMuerto(tmp_transiciones,estado_existentes);
            
        }
        estadosDFA=estado_existentes.toArray(new Estado[estado_existentes.size()]);
        return tmp_transiciones.toArray(new Transicion[tmp_transiciones.size()]);
    }
    
    private String getEstadosNuevo(String chainEstados,String chainEstados2){
        
        ArrayList<String> listEstados=new ArrayList<>();
        
        for (String c : chainEstados.split(",")) {
            if(!c.contains(vacio)){
                listEstados.add(c);
            }
        }
       
        for(String estado:chainEstados2.split(",")){
            if(!chainEstados.contains(estado) && !estado.equals(vacio)){
                listEstados.add(estado);
            }
        }
        
       
        String nuevosEstados="";
        for (int i = 0; i < listEstados.size(); i++) {
            nuevosEstados += listEstados.get(i);
            if(i!=listEstados.size()-1){
             nuevosEstados+=",";
            }
        }
       
        return nuevosEstados;
    }
    
     public String obtenerTransicion(String[] stado,String aristaTrascision){
        String tempInput=vacio;
        for( String estado:stado){
            for(Transicion t:getTransicionesNFA()){
                if(t.getStartState().equals(estado)&&t.getInput().equals(aristaTrascision)){
                    tempInput=getEstadosNuevo(tempInput,t.getNewState());
                }
            }
        }
        return tempInput.equals("")?vacio:tempInput;
    }
     
    private String[] getEstadoAceptacionDFA(){
        ArrayList<String>tmp_EA=new ArrayList<>();
        for(String estado:getEstadoDFA()){
            if(Arrays.asList(estadosAceptacion).contains(estado)){
                tmp_EA.add(estado);
            }
        }
        return tmp_EA.toArray(new String[tmp_EA.size()]);
    }
    
    private Transicion getNuevoEstado(ArrayList<Estado> estadosExistentes, ArrayList<Transicion> array) {
        for(int i=0;i< array.size();i++){
            if(!existEstado(array.get(i),array.get(i).getNewState(),estadosExistentes)){
                return array.get(i);
            }
        }return null;
    }
    
    private boolean existEstado(Transicion transicion,String estado, ArrayList<Estado> estadosExistentes) {
        boolean exist=false;
        if(estado.contains(vacio) || estado.charAt(0)==','){
            return true;
        }
        for (Estado estadosExistente : estadosExistentes) {
            if(estadosExistente.getName().equals(estado)){
                 return true;
            }else if(estado.length()==estadosExistente.getName().length()) {
                
                exist = esIgualEstado(estado,estadosExistente.getName());
                if(exist){
                    transicion.setNewState(estadosExistente.getName());
                }
             }
        }
        return exist;
    }
    
    private boolean esIgualEstado(String estado, String estadosExistente) {
        for(String c:estado.split(",")){   
            if(!estadosExistente.contains(c)){
               return false;
            }
        }
        return true;
    }

    
    
    public Estado buscarEstado(String name){
        for (Estado estado :estados ) {
            if(estado.name.equals(name)){
                return estado;
            }
        }
        return null;
    }

    private boolean existenTransicionVacias(ArrayList<Transicion> tmp_transiciones) {
        for(Transicion t:tmp_transiciones){
           if(t.getNewState().equals(vacio)){
               return true;
           }
       }
       return false;
    }

    private void agregarEstadoMuerto(ArrayList<Transicion> tmp_transiciones, ArrayList<Estado> estado_existentes) {
        for(String alphabet:alfabeto){
            tmp_transiciones.add(new Transicion("qm",alphabet,"qm"));
        }
        estado_existentes.add(new Estado("qm"));
        for (int i = 0; i < tmp_transiciones.size(); i++) {
            if(tmp_transiciones.get(i).getNewState().equals(vacio)){
                tmp_transiciones.get(i).setNewState("qm");
            }
        }
    }

    public Estado[] getEstadosDFA() {
        return estadosDFA;
    }

    public void setEstadosDFA(Estado[] estadosDFA) {
        this.estadosDFA = estadosDFA;
    }
    
    public Transicion getTransicionDFA(String estado, String input){
        for(Transicion t: getTransicionesDFA()){
            if(t.getStartState().equals(estado)&&t.getInput().equals(input)){
                return t;
            }
        }
        return null;
    }
    
    public DFA convertToDFA(){
        getTransicionesDFA();
       return new DFA(getEstadoDFA(), alfabeto, getEstadoAceptacionDFA(), getTransicionesDFA(), estadoInicial);
    }
    
    public String[] getEstadoDFA(){
        ArrayList<String>tmp_estados=new ArrayList<>();
        for (Estado estado :getEstadosDFA() ) {
            tmp_estados.add(estado.name);
        }
        return tmp_estados.toArray(new String[tmp_estados.size()]);
    }
   
    
}
