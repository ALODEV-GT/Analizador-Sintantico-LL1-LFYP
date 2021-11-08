package AnalizadorSintactico.automataDePila;

import analizadorLexico.TiposToken;

public class Asignacion {

    private String identificador;
    private TiposToken tipo = TiposToken.NUMERO_ENTERO;
    private int valor;

    public Asignacion() {
    }

    public Asignacion(String identificador, int valor) {
        this.identificador = identificador;
        this.valor = valor;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public TiposToken getTipo() {
        return tipo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

}
