package Clases;



import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;



/**
 *
 * @author ANDY ESCOBAR
 */
public class DFA {
    String descripcion;
    boolean validaSubString;
    String estados[];
    String alfabeto[];
    String estadosAceptacion[];
    String estadoInicial;
    String estadoActual;
    Transicion[] Transiciones;
    
    private final  HashMap<String, Transicion> transiciones = new HashMap<>();

    
    

    
    public DFA(String[] states, String[] alfabeto,String[] estadosAceptacion, Transicion[] transitions, String startState) {
        
        this.descripcion="";
        this.validaSubString=false;
        this.estados = states;
        this.alfabeto = alfabeto;
        this.estadosAceptacion = estadosAceptacion;

        this.estadoInicial = startState;
        this.estadoActual = startState;
        this.Transiciones=transitions;
        

        for (Transicion t : transitions) {
            List<String> statesAsList = Arrays.asList(this.estados);
            if (!statesAsList.contains(t.getNewState())
                || !statesAsList.contains(t.getStartState())) {
                throw new InvalidParameterException
                    ("No existe un transicion hacia eso estado");
            }

            if (!Arrays.asList(this.alfabeto).contains(t.getInput())) {
                throw new InvalidParameterException
                    ("Transicion posee una entranda valida");
            }

            String key = getKeyForTransicion(t.getInput(), t.getStartState());

            this.transiciones.put(key, t);   
        }      
    }

    /**
     * Resetear el estado actual al inicio;
     */
    public void reset() {
        estadoActual = estadoInicial;
        
    }

    public boolean isAccepting() {
        return Arrays.asList(estadosAceptacion).contains(estadoActual);
    } 
    public String getEstadoActual() {
        return estadoActual;
    }

    
   
    private String getKeyForTransicion(String input, String state) {
        return input + "," + state;
    }
     public DFA input(String input) {
        // Check that this input is contained within the input alphabet
        if (!Arrays.asList(alfabeto).contains(input)) {
            throw new InvalidParameterException
                ("'" + input + "' is not a valid input");
        }

        String key = getKeyForTransicion(input, estadoActual);

        Transicion transition = transiciones.get(key);
        if (transition == null) {
            throw new InvalidParameterException
                ("No transition found for: " + input);
        }

        estadoActual = transition.getNewState();

        return this;
    }
     
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isValidaSubString() {
        return validaSubString;
    }

    public void setValidaSubString(boolean validaSubString) {
        this.validaSubString = validaSubString;
    }

     
     
    public String[] getEstados() {
        return estados;
    }

    public void setEstados(String[] estados) {
        this.estados = estados;
    }

    public String[] getAlfabeto() {
        return alfabeto;
    }

    public void setAlfabeto(String[] alfabeto) {
        this.alfabeto = alfabeto;
    }

    public String[] getEstadosAceptacion() {
        return estadosAceptacion;
    }

    public void setEstadosAceptacion(String[] estadosAceptacion) {
        this.estadosAceptacion = estadosAceptacion;
    }

    public String getEstadoInicial() {
        return estadoInicial;
    }

    public void setEstadoInicial(String estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    public Transicion[] getTransiciones() {
        return Transiciones;
    }

    public void setTransiciones(Transicion[] Transiciones) {
        this.Transiciones = Transiciones;
    }
     
     
     
}
    
   
