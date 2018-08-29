package Clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ANDY ESCOBAR
 */
public class Transicion {
    
  
    @SerializedName("startState")
    @Expose
    private String startState;
    @SerializedName("input")
    @Expose
    private String input;
    @SerializedName("newState")
    @Expose
    private  String newState;
        
   
    /**
     * 
     * @param startState estado actual
     * @param input arista de transicion
     * @param newState nuevo estado
     */
    public Transicion(String startState, String input, String newState) {
        this.startState = startState;
        this.input = input;
        this.newState = newState;
    }
    
    
    public String getStartState() {
        return startState;
    }

    public void setStartState(String startState) {
        this.startState = startState;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getNewState() {
        return newState;
    }

    public void setNewState(String newState) {
        this.newState = newState;
    }
}
