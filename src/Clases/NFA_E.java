/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javafx.animation.Transition;

/**
 *
 * @author ANDY ESCOBAR
 */
public class NFA_E { 
    public final String vacio="ø";
    public final String epsilon="Ɛ";
    String estadoInicial;
    String[]estadosAceptacion;
    String[] estados;
    Transicion[] transiciones;
    String[] alfabeto;
    String estadoActual;
    HashMap<String, Transicion> hashTransiciones;
    ArrayList<Estado>estadosExistentes;

    /**
     * 
     * @param estadoInicial estado inicial de NFA-Ɛ
     * @param estadosAceptacion arreglo de estados de aceptacion
     * @param estados arreglo de estados
     * @param transiciones arreglo de transiciones
     * @param alfabeto  arreglo de alfabetos
     */
    public NFA_E(String estadoInicial, String[] estadosAceptacion, String[] estados, Transicion[] transiciones, String[] alfabeto) {
        this.estadoInicial = estadoInicial;
        this.estadosAceptacion = estadosAceptacion;
        this.estados = estados;
        this.transiciones = transiciones;
        this.alfabeto = alfabeto;
        this.estadoActual=estadoInicial;
        this.hashTransiciones=new HashMap<>();
        for(Transicion t: transiciones){
            for(String estado:t.getNewState().split(","))
            if(!(arrayToString(estados)+","+vacio).contains(estado)){
                System.out.println(arrayToString(estados)+" El estado no valido: "+estado);
                return;
            }
        }
    }
    
    
   private String arrayToString(String[] array){
        String stringEstado="";
        for (int i = 0; i < array.length; i++) {
            stringEstado+=array[i];
            if(i!=array.length-1){
                stringEstado+=",";
            }
        }
        return stringEstado;
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
    
    public Transicion[] getCerraduraEpsilion(){
       Transicion[] tempTransitions=new Transicion[estados.length];
       String epsilonTransitions;
       int lon=alfabeto.length;
        for (int i = 0; i < estados.length; i++){
            Transicion t=getTransicion(estados[i],epsilon);
            epsilonTransitions=t.getNewState();
            tempTransitions[i] = new Transicion(t.getStartState(),"C-"+epsilon+"(q)",getEstadosNuevo(t.getStartState(),epsilonTransitions));
        }
        return tempTransitions;
        
    }
    public Transicion getTransicion(String estado,String input){
        for (Transicion t : transiciones) {
            if(t.getStartState().equals(estado)&&t.getInput().equals(input)){
                return t;
            }
        }
        return null;
    }
    
    public Transicion[] getAllCerraduras(){
        ArrayList<Transicion> tempTransiciones=new ArrayList<>();
        String chainAlfabeto=arrayToString(alfabeto);
        String []temp=chainAlfabeto.replaceAll(epsilon+",","").split(",");
        
        for(Transicion t:getAllTransitions()){
            String tempStr=vacio; 
            int cont=0;
            for (String state : t.getNewState().split(",")) {
                if(state.equals(vacio)){
                    tempStr=vacio;
                }
                else{
                    tempStr=getEstadosNuevo(tempStr,getCerraduraEpsilonOf(state));
                }
            } 
            tempTransiciones.add(new Transicion(t.getStartState(),"C-"+epsilon+"("+t.getInput()+")", tempStr));
        }
        Transicion[]tempTransicions=new Transicion[tempTransiciones.size()];
        for (int i = 0; i < tempTransiciones.size(); i++) {
            tempTransicions[i] = tempTransiciones.get(i);
            
        }
        return tempTransicions;
    }
    
    public Transicion[] getAllTransitions(){
        ArrayList<Transicion> tempTransiciones=new ArrayList<>();
        String chainAlfabeto=arrayToString(alfabeto);
        String []temp=chainAlfabeto.replaceAll(epsilon+",","").split(",");
        for(Transicion t:getCerraduraEpsilion()){
            for (String alphat : temp) {
                tempTransiciones.add(new Transicion(t.getStartState(), transicion(alphat),convertToTransicionValida(getNewNextState(t,alphat))));
            }
        
        }
        
        Transicion[]tempTransicions=new Transicion[tempTransiciones.size()];
        for (int i = 0; i < tempTransiciones.size(); i++) {
            tempTransicions[i] = tempTransiciones.get(i);
            
        }
        
        return tempTransicions;
    
    }
    
    private String convertToTransicionValida(String pathTransition){
        String validT="";
        String[] tempArray=pathTransition.split(",");
  
        for (int i = 0; i < tempArray.length; i++){
            if (!tempArray[i].equals("")) {
                validT+=tempArray[i];
                if(i!=(tempArray.length-1)){
                    validT+=",";
                }
                
            }
        }
        return validT.equals("")?vacio:validT;
    }
    
    private String getNewNextState(Transicion t,String alphat){
        String temp=vacio;
        for (String s: t.getNewState().split(",")) {
            Transicion tempT=getTransicion(transiciones,s,alphat);
            temp=this.getEstadosNuevo(temp,tempT.getNewState());
        }
        return temp;
    
    }
    
    private Transicion getTransicion(Transicion[]transitions,String state,String input){
        for (Transicion transition : transitions) {
            if(transition.getStartState().equals(state)&&transition.getInput().equals(input)){
                return transition;
            }
        }
        return null;
    }
    
    public String getCerraduraEpsilonOf(String state){
        Transicion[] cerraduraEpsilon=getCerraduraEpsilion();
        for (Transicion transicion : cerraduraEpsilon) {
            if(transicion.getStartState().equals(state)){
                return transicion.getNewState();
            }   
        }
        return null;
    }
    public Transicion[] getLogTransiciones(){
        int size=getCerraduraEpsilion().length+getAllTransitions().length+getAllCerraduras().length;
        int pos=0;
        Transicion[] logTransiciones=new Transicion[size];
        for(int i=0;i<getCerraduraEpsilion().length;i++){
            logTransiciones[pos]=getCerraduraEpsilion()[i];
            pos++;
        }
        for (int i = 0; i < getAllTransitions().length; i++) {
            logTransiciones[pos] = getAllTransitions()[i];
            pos++;
            
        }
        for (int i = 0; i < getAllCerraduras().length; i++) {
          logTransiciones[pos] = getAllCerraduras()[i];
          pos++;
            
        }
        return logTransiciones;
    }
    
    public Transicion obtenerTransicion(String estado,String aristaTrascision){
        for(Transicion t:getLogTransiciones()){
            if(t.getStartState().equals(estado)&&t.getInput().equals(aristaTrascision)){
                return t;
            }
        }
        return null;
    }
    public String obtenerTransicion(String[] stado,String aristaTrascision){
        String tempInput=vacio;
        for( String estado:stado){
            for(Transicion t:getLogTransiciones()){
                if(t.getStartState().equals(estado)&&t.getInput().equals(cerradura(aristaTrascision))){
                    tempInput=getEstadosNuevo(tempInput,t.getNewState());
                }
            }
        }
        return tempInput.equals("")?vacio:tempInput;
    }
    
    public String cerradura(String nombre){
        return "C-"+epsilon+"("+transicion(nombre)+")";
    }
    public String transicion(String nombre){
        return "d[C-"+epsilon+"(q),"+nombre+"]";
    }
    
    
    public Transicion[] getTrancisionesDFA(){
        ArrayList<Transicion>arrayListTrasiciones=new ArrayList<>();
        estadosExistentes=new ArrayList<>();
        for(String alphatb:alfabeto){
            if(!alphatb.equals(epsilon)){
                Transicion t=obtenerTransicion(estadoInicial,cerradura(alphatb));
                if(t.getNewState().charAt(0)==','){
                    t.setNewState(t.getNewState().substring(1,t.getNewState().length()));
                }
               
                arrayListTrasiciones.add(new Transicion(estadoInicial, alphatb, t.getNewState()));
            }
        }
        estadosExistentes.add(new Estado(estadoInicial));
       
        while(getNuevoEstado(estadosExistentes, arrayListTrasiciones)!=null){
            Transicion trans=getNuevoEstado(estadosExistentes, arrayListTrasiciones);
            
            
            String stringtemp=vacio;
            for(String alphatb:alfabeto){
                if(!alphatb.equals(epsilon)){
                    stringtemp=obtenerTransicion(trans.getNewState().split(","),alphatb);

                    arrayListTrasiciones.add(new Transicion(trans.getNewState(), alphatb, stringtemp));

                } 
            }
            if(!trans.getNewState().equals(vacio)||!trans.getNewState().equals("")){
                estadosExistentes.add(new Estado(trans.getNewState()));
            }            
        }
        if(existenTransicionVacias(arrayListTrasiciones)){
            agregarEstadoMuerto(arrayListTrasiciones);
            
        }
        
        Transicion []newTransiciones=new  Transicion[arrayListTrasiciones.size()];
        for (int i = 0; i < arrayListTrasiciones.size(); i++) {
            newTransiciones[i] = arrayListTrasiciones.get(i);
            
        }
        return newTransiciones;
    }
    
    public String[] getEstadosDFA(){
        getTrancisionesDFA();
        String arrayState[]=new String[estadosExistentes.size()];
        for (int i = 0; i < estadosExistentes.size(); i++) {
            arrayState[i] = estadosExistentes.get(i).getName();
        }
        return arrayState;
    }
    
    public Transicion getTrasicionDFA(String estado,String input){
        for(Transicion t:getTrancisionesDFA()){
            if(t.getStartState().equals(estado)&&t.getInput().equals(input)){
                return t;
            }
        }
        return null;
    
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
        if(estado.contains(vacio)|| estado.charAt(0)==','){
            return true;
        }
        for (Estado estadosExistente : estadosExistentes) {
            if(estadosExistente.getName().equals(estado)){
                exist=true;
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
    
    private String[] getEstadosAceptacionDFA(){
        ArrayList<String>estadosDeAceptacion=new ArrayList<>();
        for (String estadoAceptado : estadosAceptacion) {
            for(String estado:getEstadosDFA()){
              if(estado.contains(estadoAceptado)&& !Arrays.asList(estadosDeAceptacion.toArray()).contains(estado)){
                  estadosDeAceptacion.add(estado);
              }
            } 
        }
        String []estados_aceptacion=new String[estadosDeAceptacion.size()];
        estados_aceptacion=estadosDeAceptacion.toArray(estados_aceptacion);
        return estados_aceptacion;
    }
    
    private String[] getAlfabeto(){
        ArrayList<String>ArrayList_Alfabeto=new ArrayList<>();
        for(String alphabet:alfabeto){
            if(!alphabet.equals(epsilon) && !Arrays.asList(ArrayList_Alfabeto.toArray()).contains(alfabeto)){
                ArrayList_Alfabeto.add(alphabet);
            }
        }
        return ArrayList_Alfabeto.toArray(new String[ArrayList_Alfabeto.size()]);
    }
    
    public DFA getDFA(){
        return new DFA(getEstadosDFA(),getAlfabeto(),getEstadosAceptacionDFA(),getTrancisionesDFA(),estadoInicial);
    }
  

    private void agregarEstadoMuerto(ArrayList<Transicion> arrayListTrasiciones) {
        for(String alphabet:getAlfabeto()){
            arrayListTrasiciones.add(new Transicion("qm",alphabet,"qm"));
        }
        estadosExistentes.add(new Estado("qm"));
        for (int i = 0; i < arrayListTrasiciones.size(); i++) {
            if(arrayListTrasiciones.get(i).getNewState().equals(vacio)){
                arrayListTrasiciones.get(i).setNewState("qm");
            }
        }
    }

    private boolean existenTransicionVacias(ArrayList<Transicion> arrayListTrasiciones) {
        for(Transicion t:arrayListTrasiciones){
           if(t.getNewState().equals(vacio)){
               return true;
           }
       }
       return false;
    }
    
    
    
      /**
     * 
     * @param args 
     */
    /*public static void main(String[] args) {
        String tempEstadoI="q0";
        String []tempEstadosAceptacion=("q2").split(",");
        String []tempEstados=("q0,q1,q2").split(",");
        String epsilon="Ɛ";
        String vacio="ø";
        String []tempAlfabeto=("Ɛ,a,b,c").split(",");
        Transicion[]tempTransiciones=new Transicion[tempEstados.length*tempAlfabeto.length];
        tempTransiciones[0]=new Transicion("q0",epsilon, "q1,q2");
        tempTransiciones[1]=new Transicion("q0","a", "q2");
        tempTransiciones[2]=new Transicion("q0","b",vacio);
        
        tempTransiciones[3]=new Transicion("q1",epsilon, vacio);
        tempTransiciones[4]=new Transicion("q1","a", "q2");
        tempTransiciones[5]=new Transicion("q1","b",vacio);
        
        tempTransiciones[6]=new Transicion("q2",epsilon, "q0");
        tempTransiciones[7]=new Transicion("q2","a", vacio);
        tempTransiciones[8]=new Transicion("q2","b","q1");
      
      
        tempTransiciones[0]=new Transicion("q0",epsilon, "q1,q2");
        tempTransiciones[1]=new Transicion("q0","a", vacio);
        tempTransiciones[2]=new Transicion("q0","b","q1");
        tempTransiciones[3]=new Transicion("q0","c","q2");
        
        tempTransiciones[4]=new Transicion("q1",epsilon, vacio);
        tempTransiciones[5]=new Transicion("q1","a", "q0");
        tempTransiciones[6]=new Transicion("q1","b","q2");
        tempTransiciones[7]=new Transicion("q1","c","q1,q0");
        
        tempTransiciones[8]=new Transicion("q2",epsilon,vacio);
        tempTransiciones[9]=new Transicion("q2","a", vacio);
        tempTransiciones[10]=new Transicion("q2","b",vacio);
        tempTransiciones[11]=new Transicion("q2","c",vacio);
        
        
        
        
        NFA_E nfae=new NFA_E(tempEstadoI,tempEstadosAceptacion,tempEstados,tempTransiciones, tempAlfabeto);
        
        nfae.getCerraduraEpsilion();
        System.out.println("Cerradura Epsilon");
        for (Transicion t: nfae.getCerraduraEpsilion()) {
            System.out.println("Estado: "+t.getStartState()+" Transicion: "+t.getInput()+" EstadoSiguiente: "+t.getNewState());
        }
        System.out.println("TRANSICIONES EPSILION");
        Transicion [] transitionE=nfae.getAllTransitions();
        for (Transicion t: transitionE) {
            System.out.println("EA: "+t.getStartState()+" input: "+t.getInput()+" ES: "+t.getNewState());
        }
        System.out.println("CERRADURAS");
        Transicion[] cerraduras=nfae.getAllCerraduras();
        for (Transicion t : cerraduras) {
            System.out.println("EA: "+t.getStartState()+" input: "+t.getInput()+" ES: "+t.getNewState());
        }
        
        System.out.println("TRANSIONES DFA");
        Transicion[] transicionesDFA=nfae.getTrancisionesDFA();
        for(Transicion t:transicionesDFA){
            System.out.println("EA: "+t.getStartState()+" input: "+t.getInput()+" ES: "+t.getNewState());
        }
        for(String tmp:nfae.getAlfabeto()){
            System.out.println(tmp);
            
        }
       
    }*/
   
}
