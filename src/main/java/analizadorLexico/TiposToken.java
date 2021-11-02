package analizadorLexico;

/**
 * Tokens posibles en el analizador lexico.
 * @author midik
 */
public enum TiposToken {
    IDENTIFICADOR("Identificador"),
    NUMERO_ENTERO("Numero entero"),
    COMENTARIO("Comentario"),
    LITERAL("Literal"),
    OPERADOR("Operador"),
    SIGNO_AGRUPACION("Signo de agrupacion"),
    ERROR("Error"),
    ESCRIBIR("ESCRIBIR"),
    FIN("FIN"),
    REPETIR("REPETIR"),
    INICIAR("INICIAR"),
    SI("SI"),
    VERDADERO("VERDADERO"),
    FALSO("FALSO"),
    ENTONCES("ENTONCES"),
    INICIO_TOKEN("inicio");

    private final String descripcion;

    private TiposToken(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return this.descripcion;
    }
}
