package analizadorLexico;

/**
 * Tokens posibles en el analizador lexico.
 *
 * @author midik
 */
public enum TiposToken {
    ESCRIBIR("ESCRIBIR", 0, -1, "NUMERO, ID o LITERAL"),
    REPETIR("REPETIR", 1, -2, "NUMERO o ID"),
    SI("SI", 2, -3, "VERDADERO o FALSO"),
    IDENTIFICADOR("IDENTIFICADOR", 3, -4, "*, /, FIN, ), +, -, ^, INICIAR"),
    NUMERO_ENTERO("NUMERO ENTERO", 4, -5, "*, /, FIN, ), +, -, ^, INICIAR"),
    LITERAL("LITERAL", 5, -6, "FIN"),
    VERDADERO("VERDADERO", 6, -7, "ENTONCES"),
    FALSO("FALSO", 7, -8, "ENTONCES"),
    SIGNO_MAS("SIGNO MAS", 8, -9, "ID, NUMERO o  ')' "),
    SIGNO_MENOS("SIGNO MENOS", 9, -10, "ID, NUMERO o  ')'"),
    SIGNO_POR("SIGNO POR", 10, -11, "ID, NUMERO, '('"),
    DIAGONAL("DIAGONAL", 11, -12, "ID, NUMERO, '('"),
    SIGNO_POTENCIA("SIGNO POTENCIA", 12, -13, "ID, NUMERO, '('"),
    PARENTESIS_APERTURA("PARENTESIS APERTURA", 13, -14, "ID, NUMERO, '('"),
    PARENTESIS_CIERRE("PARENTESIS CIERRE", 14, -15, "*, /, FIN, ), +, -"),
    ENTONCES("ENTONCES", 15, -16, "ESCRIBIR o FIN"),
    INICIAR("INICIAR", 16, -17, "ESCRIBIR o FIN"),
    SIGNO_IGUAL("SIGNO IGUAL", 17, -18, "-, ID, NUMERO, ("),
    FIN("FIN", 18, -19, "ESCRIBIR, REPETIR, SI, ID"),
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
