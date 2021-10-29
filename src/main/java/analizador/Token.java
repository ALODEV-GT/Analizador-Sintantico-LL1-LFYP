package analizador;

/**
 * Contiene los miembros necesarios para la construcion de un token.
 * @author midik
 */
public class Token {

    private TiposToken tipoToken;
    private String lexema;
    private int numFila;
    private int numColumna;

    public Token(TiposToken tipoToken, String lexema, int numFila, int numColumna) {
        this.tipoToken = tipoToken;
        this.lexema = lexema;
        this.numFila = numFila;
        this.numColumna = numColumna;
    }

    public TiposToken getTipoToken() {
        return tipoToken;
    }

    public String getLexema() {
        return lexema;
    }

    public int getNumFila() {
        return numFila;
    }

    public int getNumColumna() {
        return numColumna;
    }

    
}
