package Funcionalidad;

import java.util.ArrayList;

public class PilaDeshacer {

    private ArrayList<String> cambios;

    public PilaDeshacer() {
        this.cambios = new ArrayList<>();
    }

    public String obtenerCima() {
        String contenido = null;
        if (cambios.size() > 0) {
            contenido = cambios.get(cambios.size() - 2);
            cambios.remove(cambios.size() - 1);
            cambios.remove(cambios.size() - 1);
        }
        return contenido;
    }

    public void agregarCambio(String cambio) {
        cambios.add(cambio);
    }
    
    public int getSize(){
        return cambios.size();
    }
    
    public void vaciarPila(){
        cambios = new ArrayList<>();
    }

}
