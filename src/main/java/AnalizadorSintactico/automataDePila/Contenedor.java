package AnalizadorSintactico.automataDePila;

import java.util.ArrayList;

public class Contenedor {

    private ArrayList<Integer> producciones;

    public Contenedor(ArrayList<Integer> producciones) {
        this.producciones = producciones;
    }

    public ArrayList<Integer> getProducciones() {
        return producciones;
    }

}
