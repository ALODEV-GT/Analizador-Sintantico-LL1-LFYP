package analizadorLexico;

/**
 * Tokens posibles en el analizador lexico.
 *
 * @author midik
 */
public enum TiposToken {
    ESCRIBIR("ESCRIBIR", 0, -1, "siguientes ESCRIBIR"),
    NUMERO_ENTERO("NUMERO ENTERO", 1, -2, "siguientes NUMERO_ENTERO"),
    IDENTIFICADOR("IDENTIFICADOR", 2, -3, "siguientes IDENTIFICADOR"),
    LITERAL("LITERAL", 3, -4, "siguientes LITERAL"),
    FIN("FIN", 4, -5, "siguientes FIN"),
    EPSILON("EPSILON", 10, -7, "siguientes"),
    FIN_ARCHIVO("FIN ARCHIVO", 5, -6, "siguientes"),
    COMENTARIO("COMENTARIO", 10, -10, "siguientes"),
    OPERADOR("OPERADOR", 10, -10, "nada"),
    SIGNO_AGRUPACION("SIGNO DE AGRUPACION", 10, -10, "siguientes"),
    ERROR("ERROR", 10, -10, "siguientes"),
    REPETIR("REPETIR", 10, -10, "siguientes"),
    INICIAR("INICIAR", 10, -10, "siguientes"),
    SI("SI", 10, -10, "nada"),
    VERDADERO("VERDADERO", 10, -10, "siguientes"),
    FALSO("FALSO", 10, -10, "nada"),
    ENTONCES("ENTONCES", 10, -10, "siguientes"),
    INICIO_TOKEN("INICIO", 10, -10, "siguientes");

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
