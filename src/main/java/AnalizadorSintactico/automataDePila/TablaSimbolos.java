package AnalizadorSintactico.automataDePila;

import java.util.ArrayList;

public class TablaSimbolos {

    private final ArrayList<Asignacion> tabla;

    public TablaSimbolos() {
        this.tabla = new ArrayList<>();
    }

    public void agregarAsignacion(Asignacion asignacion) {
        this.tabla.add(asignacion);
    }

    public Integer obtenerValor(String identificador) {
        Integer valor = null;
        for (Asignacion asignacion : tabla) {
            if (asignacion.getIdentificador().equals(identificador)) {
                valor = asignacion.getValor();
                break;
            }
        }
        return valor;
    }

    public ArrayList<Asignacion> getTabla() {
        return tabla;
    }
    
}
