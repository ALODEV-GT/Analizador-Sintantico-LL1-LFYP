package AnalizadorSintactico.automataDePila;

import AnalizadorSintactico.pila.Pila;
import analizadorLexico.TiposToken;
import analizadorLexico.Token;
import java.util.ArrayList;
import java.util.List;

public class AutomataDePila {

    private final List<Token> tokens;
    private final Contenedor[][] tablaTransicion;
    private final Pila pila;

    public AutomataDePila(List<Token> tokens) {
        this.tablaTransicion = new TablaProducciones().getTablaTransicion();
        this.tokens = tokens;
        this.agregarFinArchivo();
        this.pila = new Pila();
        this.iniciarPila();
    }

    private void iniciarPila() {
        this.pila.apilar(TiposToken.FIN_ARCHIVO.getIdComoTerminal());
        this.pila.apilar(0); // no terminal inicial
    }

    private void agregarFinArchivo() {
        this.tokens.add(new Token(TiposToken.FIN_ARCHIVO, "$", 0, 0));
    }

    public void analizar() {
        Token tokenActual;
        int idTipoTokenActual;
        int idProductorActual = 0;
        int numToken = 0;
        boolean seguir = true;

        System.out.println("PILA INICIAL:");
        this.imprimirPila();

        while (numToken < this.tokens.size() && seguir) {
            tokenActual = this.tokens.get(numToken);
            idTipoTokenActual = tokenActual.getTipoToken().getIdToken(); // Token: idToken
            System.out.println("Token: " + idTipoTokenActual);
            try {
                idProductorActual = this.pila.cima();
                if (idProductorActual < 0) { //Es un terminal
                    if (idProductorActual == TiposToken.EPSILON.getIdComoTerminal()) { 
                        System.out.println("<-----------Reduce");
                        this.pila.retirar();
                        imprimirPila();
                    } else {
                        if (idProductorActual == tokenActual.getTipoToken().getIdComoTerminal()) {
                            System.out.println("<-----------Reduce");
                            this.pila.retirar();
                            imprimirPila();
                            numToken++;
                        }
                    }
                } else {
                    this.pila.retirar();
                    this.apilarProduccion(idProductorActual, idTipoTokenActual);
                }
            } catch (Exception ex) {
                seguir = false;
                System.out.println("OCURRIO UN ERROR +----------+---------------------+----------------------------+------------------------------->");
                System.out.println("Token: " + tokenActual.getLexema());
                ex.printStackTrace(System.out);
            }

        }

        System.out.println("Se termino el analisis sintactico...");
        imprimirPila();
    }

    private void evaluarError(int idProductor, int numToken) {
        String siguientes;
        if (idProductor == 0) {
            System.out.println("Se esperaba un token de tipo: ESCRIBIR, REPETIR, SI, IDENTIFICADOR");
        } else {
            siguientes = this.tokens.get(numToken - 1).getTipoToken().obtenerSiguientes();
            System.out.println("Se esperaba un token del tipo: " + siguientes);
        }
    }

    private void apilarProduccion(int idProductor, int idTokenActual) {
        System.out.println("Shift [" + idProductor + "]" + "[" + idTokenActual + "]");
        ArrayList<Integer> producciones = tablaTransicion[idProductor][idTokenActual].getProducciones();
        for (int i = producciones.size() - 1; i >= 0; i--) {
            this.pila.apilar(producciones.get(i));
        }
        imprimirPila();
    }

    private void imprimirPila() {
        System.out.println("\n");
        System.out.println("<<-- Pila -->>");
        pila.listar();
        System.out.println("-------------");
        System.out.println("\n");
    }

}
