package analizador;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JTextArea;

/**
 * Determina si los tokens son validos o invalidos, agrupandolos y permitiendo
 * mostrarlos en una interfaz grafica.
 *
 * @author midik
 */
public class AutomataFinitoDeterminista {

    private String codigoFuente;
    private JTextArea taCodigoFuente;
    private int posicion = 0;
    private final ArrayList<Token> tokens = new ArrayList<>();
    private Set<String> tokenSinRepetir = new HashSet<>();
    private final int[][] matrizTransicion = new int[8][6];
    private int estadoActual = 0;
    private int numFilaE = 1;
    private int numColumnaE = 0;
    private int numFilaT = 1;
    private int numColumnaT = 0;
    private boolean reiniciar = false;

    /**
     * Convencion de la simbologia: S0=0 S1=1 S2=2 S3=3 S4=4 S5=5 S6=6 S7=7
     * error=-1 (Todos los estados diferentes a los de aceptacion o que no
     * existe una transicion hacia estos)
     *
     * letra (L)=0 digito (D)=1 punto (.)=2 agrupacion (A)=3 operador (O)=4
     * puntuacion (P)=5
     */
    {
        //f(S0,L)=S1                                 
        matrizTransicion[0][0] = 1;
        //f(S0,D)=S2                            
        matrizTransicion[0][1] = 2;
        //f(S0, . )=error                                  
        matrizTransicion[0][2] = -1;
        //f(S0,A)=S5                               
        matrizTransicion[0][3] = 5;
        //f(S0,O)=S6                            
        matrizTransicion[0][4] = 6;
        //f(S0,P)=S7
        matrizTransicion[0][5] = 7;
        //f(S1,L)=S1                                 
        matrizTransicion[1][0] = 1;
        //f(S1,D)=S1                            
        matrizTransicion[1][1] = 1;
        //f(S1, . )=error                                  
        matrizTransicion[1][2] = -1;
        //f(S1,A)=error                               
        matrizTransicion[1][3] = -1;
        //f(S1,O)=error                            
        matrizTransicion[1][4] = -1;
        //f(S1,P)=error
        matrizTransicion[1][5] = -1;
        //f(S2,L)=error                                
        matrizTransicion[2][0] = -1;
        //f(S2,D)=S2                          
        matrizTransicion[2][1] = 2;
        //f(S2, . )=S3                                  
        matrizTransicion[2][2] = 3;
        //f(S2,A)=error                                
        matrizTransicion[2][3] = -1;
        //f(S2,O)=error                            
        matrizTransicion[2][4] = -1;
        //f(S2,P)=error
        matrizTransicion[2][5] = -1;
        //f(S3,L)=error                                
        matrizTransicion[3][0] = -1;
        //f(S3,D)=S4                            
        matrizTransicion[3][1] = 4;
        //f(S3, . )=error                                 
        matrizTransicion[3][2] = -1;
        //f(S3,A)=error                                
        matrizTransicion[3][3] = -1;
        //f(S3,O)=error                            
        matrizTransicion[3][4] = -1;
        //f(S3,P)=error
        matrizTransicion[3][5] = -1;
        //f(S4,L)=error                                
        matrizTransicion[4][0] = -1;
        //f(S4,D)=S4                            
        matrizTransicion[4][1] = 4;
        //f(S4, . )=error                                  
        matrizTransicion[4][2] = -1;
        //f(S4,A)=error                                
        matrizTransicion[4][3] = -1;
        //f(S4,O)=error                            
        matrizTransicion[4][4] = -1;
        //f(S4,P)=error
        matrizTransicion[4][5] = -1;
        //f(S5,L)=error                                 
        matrizTransicion[5][0] = -1;
        //f(S5,D)=error                            
        matrizTransicion[5][1] = -1;
        //f(S5, . )=error                                  
        matrizTransicion[5][2] = -1;
        //f(S5,A)=error                               
        matrizTransicion[5][3] = -1;
        //f(S5,O)=error                            
        matrizTransicion[5][4] = -1;
        //f(S5,P)=error
        matrizTransicion[5][5] = -1;
        //f(S6,L)=error                                 
        matrizTransicion[6][0] = -1;
        //f(S6,D)=error                            
        matrizTransicion[6][1] = -1;
        //f(S6, . )=error                                  
        matrizTransicion[6][2] = -1;
        //f(S6,A)=error                                
        matrizTransicion[6][3] = -1;
        //f(S6,O)=error                            
        matrizTransicion[6][4] = -1;
        //f(S6,P)=error
        matrizTransicion[6][5] = -1;
        //f(S7,L)=error                                 
        matrizTransicion[7][0] = -1;
        //f(S7,D)=error                            
        matrizTransicion[7][1] = -1;
        //f(S7, . )=error                                 
        matrizTransicion[7][2] = -1;
        //f(S7,A)=error                                
        matrizTransicion[7][3] = -1;
        //f(S7,O)=error                           
        matrizTransicion[7][4] = -1;
        //f(S7,P)=error
        matrizTransicion[7][5] = -1;
    }

    //Alfabeto
    char[] signosAgrupacion = {'(', ')', '[', ']', '{', '}'};  // tipoCaracter = 3
    char[] operadores = {'+', '-', '*', '/', '%'};  // tipoCaracter = 4
    char[] signosPuntuacion = {'.', ',', ';', ':'}; //tipoCaracter = 5
    //Digitos 0-9       tipoCaracter=0
    //Letras a-z, A-Z   tipoCarater=1
    //punto                 tipoCaracter=2

    public AutomataFinitoDeterminista(JTextArea taCodigoFuente) {
        this.taCodigoFuente = taCodigoFuente;
        this.codigoFuente = taCodigoFuente.getText();
    }

    /**
     * Agrupa los tokens sin repetirlos.
     */
    private void getTokenSinRepetir() {
        for (Token t : tokens) {
            if (!t.getTipoToken().equals(TiposToken.ERROR)) {
                tokenSinRepetir.add(t.getLexema());
            }
        }
    }

    /**
     * Muestra en el JTextArea indicado, las veces que se repite un token.
     *
     * @param taNumVeces
     */
    public void imprimirContadorTokens(JTextArea taNumVeces) {
        taNumVeces.setText("");
        getTokenSinRepetir();

        for (String s : tokenSinRepetir) {
            int contador = 0;
            for (int i = 0; i < tokens.size(); i++) {
                if (s.equals(tokens.get(i).getLexema())) {
                    contador++;
                }
            }
            taNumVeces.append(s + "  ----> " + contador + getSingPluralr(contador) + "\n");
        }
    }

    /**
     * Devuelve una cadena para denotar singular (vez) o plural(veces)
     *
     * @param contador
     * @return
     */
    public String getSingPluralr(int contador) {
        String palabra = " veces.";
        if (contador == 1) {
            palabra = " vez.";
        }
        return palabra;
    }

    public void analizar(JTextArea taTransiciones) {
        taTransiciones.setText("");
        while (posicion < codigoFuente.length()) {
            obtenerToken(taTransiciones);
        }
    }

    /**
     * Muestra los tokens detectados en el JTextArea indicado.
     *
     * @param taTokens
     */
    public void mostrarTokens(JTextArea taTokens) {
        taTokens.setText("");
        for (Token t : tokens) {
            taTokens.append(t.getLexema() + " ----> " + t.getTipoToken().toString() + " Fila: " + t.getNumFila() + ",Columna:  " + t.getNumColumna() + "\n");
        }
    }

    /**
     * Muestra los errores en el JTexArea indicado.
     *
     * @param taErrores
     */
    public void mostrarErrores(JTextArea taErrores) {
        taErrores.setText("");
        for (Token e : tokens) {
            if (e.getTipoToken().equals(TiposToken.ERROR)) {
                taErrores.append("Error: " + e.getLexema() + " en la fila " + e.getNumFila() + " columna: " + e.getNumColumna() + "\n");
            }
        }
    }

    /**
     * Lee caracter por caracter hasta formar un token.
     *
     * @param taTokens
     */
    private void obtenerToken(JTextArea taTokens) {
        boolean seguir = true;
        estadoActual = 0;
        String token = "";
        char caracter = ' ';

        while (seguir && posicion < codigoFuente.length()) {
            if (reiniciar) {
                numFilaT++;
                numColumnaT = 0;
            }

            caracter = codigoFuente.charAt(posicion);

            if (Character.isWhitespace(caracter)) {
                seguir = false;
            } else {
                this.reiniciar = false;
                int auxEstadoActual = estadoActual;
                estadoActual = obtenerEstadoSiguiente(estadoActual, caracter);
                token += caracter;
                taTokens.append("Pase del estado S" + auxEstadoActual + " al estado S" + estadoActual + " con: [" + caracter + "]" + "\n");
            }

            if (estadoActual == -1) {
                seguir = false;
            }
            numColumnaT++;
            numColumnaE++;

            posicion++;
            if (caracter == '\n') {
                reiniciar = true;
                numFilaE++;
                numColumnaE = 0;
            }
        }

        if (!token.isBlank() && !tipoToken().equals(TiposToken.ERROR)) {
            Token nuevoToken = new Token(tipoToken(), token.replace(" ", ""), this.numFilaT, this.numColumnaT - 1);
            tokens.add(nuevoToken);
            taTokens.append("------------------------------------------------\n");
        } else if (!token.isBlank() && tipoToken().equals(TiposToken.ERROR)) {
            Token error = new Token(tipoToken(), token.replace(" ", ""), numFilaE, numColumnaE);
            tokens.add(error);
            taTokens.append("------------------------------------------------\n");
        }
    }

    /**
     * Duevuelve el tipo de token segun el estado actual.
     *
     * @return El tipo del token.
     */
    private TiposToken tipoToken() {
        TiposToken tipoToken;
        //Estados de aceptacion
        //S1=identificador, S2=entero, S4=decimal, S5=sAgrupacion, s6=operador, S7=sPuntuacion
        switch (estadoActual) {
            case 1:
                tipoToken = TiposToken.IDENTIFICADOR;
                break;
            case 2:
                tipoToken = TiposToken.NUMERO_ENTERO;
                break;
            case 4:
                tipoToken = TiposToken.NUMERO_DECIMAL;
                break;
            case 5:
                tipoToken = TiposToken.SIGNO_AGRUPACION;
                break;
            case 6:
                tipoToken = TiposToken.OPERADOR;
                break;
            case 7:
                tipoToken = TiposToken.SIGNO_PUNTUACION;
                break;
            default:
                tipoToken = TiposToken.ERROR;
        }
        return tipoToken;
    }

    //Devuelve el tipo del caracter letra(L)=0 digito(D)=1 punto(.)=2
    //agrupacion(A)=3 operador (O)=4 puntuacion(P)=5
    private int obtenerTipoCaracter(char caracter) {
        int tipo = -1;

        if (Character.isLetter(caracter)) {
            tipo = 0;
        } else if (Character.isDigit(caracter)) {
            tipo = 1;
        } else if (estadoActual == 2 && caracter == '.') {
            tipo = 2;
        } else if (pertenece(signosAgrupacion, caracter)) {
            tipo = 3;
        } else if (pertenece(operadores, caracter)) {
            tipo = 4;
        } else if (pertenece(signosPuntuacion, caracter)) {
            tipo = 5;
        }
        return tipo;
    }

    /**
     * Verifica la existencia de un caracter en un conjunto de caracteres
     * especificados.
     *
     * @param caracteres
     * @param caracter
     * @return true si pertenece al grupo de caracteres, de lo contrario sera
     * false.
     */
    private boolean pertenece(char[] caracteres, char caracter) {
        boolean pertenece = false;
        for (char c : caracteres) {
            if (c == caracter) {
                pertenece = true;
                break;
            }
        }
        return pertenece;
    }

    /**
     * Obtiene el siguiente estado, despues de hacer uso de una funcion de
     * transicion.
     *
     * @param estadoActual Estando actual en el AFD
     * @param caracterTransicion Caracter para hacer la transicion hacia el
     * siguiente estado.
     * @return El siguiente estado
     */
    private int obtenerEstadoSiguiente(int estadoActual, char caracterTransicion) {
        int estadoSiguiente = -1;

        try {
            if (estadoActual >= 0 && estadoActual <= 7) {  //S0-S7 
                estadoSiguiente = matrizTransicion[estadoActual][obtenerTipoCaracter(caracterTransicion)];
            }
        } catch (IndexOutOfBoundsException ex) {
            //dejar pasar el estado error=-1
        }

        return estadoSiguiente;
    }

}
