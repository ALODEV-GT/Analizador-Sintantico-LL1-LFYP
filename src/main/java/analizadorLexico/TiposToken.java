package analizadorLexico;

/**
 * Tokens posibles en el analizador lexico.
 *
 * @author midik
 */
public enum TiposToken {
    ESCRIBIR("ESCRIBIR", 0, -1, "siguientes ESCRIBIR"),
    REPETIR("REPETIR", 1, -2, "siguientes REPETIR"),
    SI("SI", 2, -3, "siguientes SI"),
    IDENTIFICADOR("IDENTIFICADOR", 3, -4, "siguientes IDENTIFICADOR"),
    NUMERO_ENTERO("NUMERO ENTERO", 4, -5, "siguientes NUMERO_ENTERO"),
    LITERAL("LITERAL", 5, -6, "siguientes LITERAL"),
    VERDADERO("VERDADERO", 6, -7, "siguientes VERDADERO"),
    FALSO("FALSO", 7, -8, "siguientes FALSO"),
    SIGNO_MAS("SIGNO MAS", 8, -9, "siguientes SIGNO MAS"),
    SIGNO_MENOS("SIGNO MENOS", 9, -10, "siguientes SIGNO MENOS"),
    SIGNO_POR("SIGNO POR", 10, -11, "siguientes SIGNO POR"),
    DIAGONAL("DIAGONAL", 11, -12, "siguientes DIAGONAL"),
    SIGNO_POTENCIA("SIGNO POTENCIA", 12, -13, "siguientes SIGNO POTENCIA"),
    PARENTESIS_APERTURA("PARENTESIS APERTURA", 13, -14, "siguientes PARENTESIS APERTURA"),
    PARENTESIS_CIERRE("PARENTESIS CIERRE", 14, -15, "siguientes PARENTESIS CIERRE"),
    ENTONCES("ENTONCES", 15, -16, "siguientes ENTONCES"),
    INICIAR("INICIAR", 16, -17, "siguientes INICIAR"),
    SIGNO_IGUAL("SIGNO IGUAL", 17, -18, "siguientes SIGNO IGUAL"),
    FIN("FIN", 18, -19, "siguientes FIN"),
    FIN_ARCHIVO("FIN ARCHIVO", 19, -20, "siguientes FIN ARCHIVO"),
    EPSILON("EPSILON", 100, -21, "siguientes EPSILON"),
    
    
    INICIO_TOKEN("INICIO", 100, -100, "siguientes"),
    COMENTARIO("COMENTARIO", 100, -100, "siguientes"),
    OPERADOR("OPERADOR", 100, -100, "nada"),
    SIGNO_AGRUPACION("SIGNO DE AGRUPACION", 100, -100, "siguientes"),
    ERROR("ERROR", 100, -100, "siguientes");

    private final String descripcion;
    private final int idToken;
    private final int idTerminal;
    private final String siguientes;

    private TiposToken(String descripcion, int idToken, int idTerminal, String siguientes) {
        this.descripcion = descripcion;
        this.idToken = idToken;
        this.idTerminal = idTerminal;
        this.siguientes = siguientes;
    }

    @Override
    public String toString() {
        return this.descripcion;
    }

    public int getIdToken() {
        return this.idToken;
    }

    public int getIdComoTerminal() {
        return this.idTerminal;
    }

    public String obtenerSiguientes() {
        return this.siguientes;
    }
}
