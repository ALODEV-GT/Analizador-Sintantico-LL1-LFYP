package analizador;

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

/**
 * Permite resaltar las palabras claves que se desean buscar.
 * @author midik
 */
public class Buscador {

    private final JTextArea taCodigoFuente;
    private final String palabraClave;
    private final char[] caracteres;
    private int posicion = 0;
    private final Highlighter highlighter;

    public Buscador(JTextArea taCodigoFuente, String palabraClave) {
        this.taCodigoFuente = taCodigoFuente;
        this.palabraClave = palabraClave;
        caracteres = palabraClave.toCharArray();
        highlighter = taCodigoFuente.getHighlighter();
        highlighter.removeAllHighlights();
    }

    public int buscarCoincidencias() throws IndexOutOfBoundsException {
        String codigoFuente = taCodigoFuente.getText();
        char caracter;
        int numCoincidencias = 0;

        while (posicion < codigoFuente.length()) {
            caracter = codigoFuente.charAt(posicion);
            if (caracter == caracteres[0]) {
                int contador = 0;
                for (int i = 0; i < palabraClave.length(); i++) {
                    caracter = codigoFuente.charAt(posicion);
                    if (caracter == caracteres[i]) {
                        contador++;
                    }
                    posicion++;
                }

                if (contador == palabraClave.length()) {
                    pintarCoincidencia(posicion - palabraClave.length(), posicion);
                    numCoincidencias++;
                }
            } else {
                posicion++;
            }
        }
        return numCoincidencias;
    }

    private void pintarCoincidencia(int posInicial, int posFinal) {
        DefaultHighlighter.DefaultHighlightPainter highlightPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.GREEN);
        try {
            highlighter.addHighlight(posInicial, posFinal, highlightPainter);
        } catch (BadLocationException ex) {
            ex.printStackTrace(System.out);
        }
    }

}
