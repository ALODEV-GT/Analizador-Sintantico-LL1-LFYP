package AnalizadorSintactico.automataDePila;

import AnalizadorSintactico.pila.Pila;
import analizadorLexico.TiposToken;
import analizadorLexico.Token;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;

public class AutomataDePila {

    private final List<Token> tokens;
    private final Contenedor[][] tablaTransicion;
    private final Pila pila;
    private final TablaSimbolos tabla = new TablaSimbolos();
    private String errores = "";

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

    public void analizar(JTextArea taPila) {
        Token tokenActual;
        int idTipoTokenActual;
        int idProductorActual = 0;
        int numToken = 0;
        boolean seguir = true;
        boolean esAsignacion = false;
        Asignacion asignacion = null;

        taPila.append("PILA INICIAL:");
        this.imprimirPila(taPila);

        while (numToken < this.tokens.size() && seguir) {
            tokenActual = this.tokens.get(numToken);
            idTipoTokenActual = tokenActual.getTipoToken().getIdToken(); // Token: idToken
            taPila.append("\nToken: " + idTipoTokenActual);
            try {
                idProductorActual = this.pila.cima();
                if (idProductorActual < 0) { //Es un terminal
                    if (idProductorActual == TiposToken.EPSILON.getIdComoTerminal()) {
                        taPila.append("<-----------Reduce");
                        this.pila.retirar();
                        imprimirPila(taPila);
                    } else {
                        if (idProductorActual == tokenActual.getTipoToken().getIdComoTerminal()) {
                            taPila.append("<-----------Reduce");
                            this.pila.retirar();
                            imprimirPila(taPila);
                            numToken++;
                        }
                    }
                } else {
                    this.pila.retirar();
                    this.apilarProduccion(idProductorActual, idTipoTokenActual, taPila);
                }
            } catch (Exception ex) {
                seguir = false;
                this.evaluarError(idProductorActual, numToken);
            }
        }
        taPila.append("Se termino el analisis sintactico...");
        imprimirPila(taPila);
    }

    private void evaluarError(int idProductor, int numToken) {
        String siguientes;
        if (idProductor == 0) {
            errores += "Se esperaba un token de tipo: ESCRIBIR, REPETIR, SI, IDENTIFICADOR\n";
        } else {
            Token token = this.tokens.get(numToken - 1);
            siguientes = token.getTipoToken().obtenerSiguientes();

            errores += "Despues de "+token.getLexema()+". Se esperaba un token del tipo: " + siguientes + ". Fila: " + token.getNumFila() + " Columna: " + token.getNumColumna() + "\n";
        }
    }

    private void apilarProduccion(int idProductor, int idTokenActual, JTextArea taPila) {
        taPila.append("\n\nShift [" + idProductor + "]" + "[" + idTokenActual + "]");
        ArrayList<Integer> producciones = tablaTransicion[idProductor][idTokenActual].getProducciones();
        for (int i = producciones.size() - 1; i >= 0; i--) {
            this.pila.apilar(producciones.get(i));
        }
        imprimirPila(taPila);
    }

    private void imprimirPila(JTextArea taPila) {
        taPila.append(pila.listar());
    }

    public void mostrarErrores(JTextArea taErrores) {
        taErrores.setText("");
        taErrores.append(errores);
    }
}
