package Funcionalidad;

import java.util.ArrayList;

public class PilaRehacer {

    private ArrayList<String> cambios;

    public PilaRehacer() {
        this.cambios = new ArrayList<>();
    }

    public String obtenerCima() {
        String contenido = null;
        if (cambios.size() > 0) {
            contenido = cambios.get(cambios.size() - 1);
            cambios.remove(cambios.size() - 1);
        }
        return contenido;
    }

    public void agregarCambio(String cambio) {
        cambios.add(cambio);
    }

    public void vaciarPila() {
        this.cambios = new ArrayList<>();
    }
}
