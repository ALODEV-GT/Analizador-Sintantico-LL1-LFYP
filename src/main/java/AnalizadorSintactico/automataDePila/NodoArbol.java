package AnalizadorSintactico.automataDePila;

import java.util.ArrayList;

public class NodoArbol {

    private boolean esTerminal;
    private int idNoTerminal;
    private String lexema;
    private NodoArbol nodoPadre;
    ArrayList<NodoArbol> hijos = new ArrayList();

    public NodoArbol(boolean esTerminal, int idNoTerminal) {
        this.esTerminal = esTerminal;
        this.idNoTerminal = idNoTerminal;
    }

    public NodoArbol(boolean esTerminal, String lexema) {
        this.esTerminal = esTerminal;
        this.lexema = lexema;

    }

    public void agregarHijo(NodoArbol hijo) {
        hijos.add(hijo);
    }

    public NodoArbol(NodoArbol nodoPadre) {
        this.nodoPadre = nodoPadre;
    }

    public void agregarNodoPadre(NodoArbol nodoPadre) {
        this.nodoPadre = nodoPadre;
    }
}
