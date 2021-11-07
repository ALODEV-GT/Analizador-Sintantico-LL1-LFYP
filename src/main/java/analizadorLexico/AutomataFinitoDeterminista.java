package analizadorLexico;

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
    private final int[][] matrizTransicion = new int[14][12];
    private int estadoActual = 0;
    private int numFilaE = 1;
    private int numColumnaE = 0;
    private int numFilaT = 1;
    private int numColumnaT = 0;
    private boolean reiniciar = false;
    private String[] palabraReservadas = {"ESCRIBIR", "FIN", "REPETIR", "INICIAR", "SI", "VERDADERO", "FALSO", "ENTONCES"};

    /**
     * Convencion de la simbologia: 
     * S0=0
     * S1=1
     * S2=2 
     * S3=3 
     * S4=4 
     * S5=5 
     * S6=6 
     * S7=7 
     * S8=8
     * S9=9
     * S10=10 
     * S11=11
     * error=-1 (Todos los estados diferentes a los de aceptacion o
     * que no existe una transicion hacia estos)
     *
     * guionBajo (_)=0 guionMedio (-)=1 letra (L)=2 naturalesPositivos(1-9)=3 digito(D)=4
     * cero (0)=5 diagonal(/)=6 comillas(")=7 saltoLinea(\n)=8
     */
    {
        //f(S0,_)=S1                               //f(S0,-)=S1                                //f(S0,L)=S1                             //f(S0,1-9)=S1                              //f(S0,D)=S1                                //f(S0,0)=S1                               //f(S0,/)=S1                                 //f(S0,")=S1                                //f(S0,C)=S1                              //f(S0,\n)=S1                         //f(S0,A)=S1                              //f(S0,O)=S1                                                                          
       matrizTransicion[0][0] = 1;       matrizTransicion[0][1] = 12;       matrizTransicion[0][2] = 1;       matrizTransicion[0][3] = 4;       matrizTransicion[0][4] = -1;       matrizTransicion[0][5] = 3;       matrizTransicion[0][6] = 8;       matrizTransicion[0][7] = 5;       matrizTransicion[0][8] = -1;       matrizTransicion[0][9] = -1;        matrizTransicion[0][10] = 13;       matrizTransicion[0][11] = 12;
        //f(S1,_)=S1                               //f(S1,-)=S1                                //f(S1,L)=S1                             //f(S1,1-9)=S1                              //f(S1,D)=S1                                //f(S1,0)=S1                               //f(S1,/)=S1                                 //f(S1,")=S1                                //f(S1,C)=S1                              //f(S1,\n)=S1                             //f(S1,A)=S1                              //f(S1,O)=S1
       matrizTransicion[1][0] = -1;       matrizTransicion[1][1] = -1;       matrizTransicion[1][2] = 2;       matrizTransicion[1][3] = -1;       matrizTransicion[1][4] = -1;       matrizTransicion[1][5] = -1;       matrizTransicion[1][6] = -1;       matrizTransicion[1][7] = -1;       matrizTransicion[1][8] = -1;       matrizTransicion[1][9] = -1;       matrizTransicion[1][10] = -1;       matrizTransicion[1][11] = -1;
        //f(S2,_)=S1                               //f(S2,-)=S1                                //f(S2,L)=S1                             //f(S2,1-9)=S1                              //f(S2,D)=S1                                //f(S2,0)=S1                               //f(S2,/)=S1                                 //f(S2,")=S1                                //f(S2,C)=S1                              //f(S2,\n)=S1                             //f(S2,A)=S1                              //f(S2,O)=S1
       matrizTransicion[2][0] = 2;       matrizTransicion[2][1] = 2;       matrizTransicion[2][2] = 2;       matrizTransicion[2][3] = 2;       matrizTransicion[2][4] = -1;       matrizTransicion[2][5] = 2;       matrizTransicion[2][6] = -1;       matrizTransicion[2][7] = -1;       matrizTransicion[2][8] = -1;       matrizTransicion[2][9] = -1;          matrizTransicion[2][10] = -1;       matrizTransicion[2][11] = -1;
        //f(S3,_)=S1                               //f(S3,-)=S1                                //f(S3,L)=S1                             //f(S3,1-9)=S1                              //f(S3,D)=S1                                //f(S3,0)=S1                               //f(S3,/)=S1                                 //f(S3,")=S1                                //f(S3,C)=S1                              //f(S3,\n)=S1                             //f(S3,A)=S1                              //f(S3,O)=S1
       matrizTransicion[3][0] = -1;       matrizTransicion[3][1] = -1;       matrizTransicion[3][2] = -1;       matrizTransicion[3][3] = -1;       matrizTransicion[3][4] = -1;       matrizTransicion[3][5] = -1;       matrizTransicion[3][6] = -1;       matrizTransicion[3][7] = -1;       matrizTransicion[3][8] = -1;       matrizTransicion[3][9] = -1;      matrizTransicion[3][10] = -1;       matrizTransicion[3][11] = -1;
        //f(S4,_)=S1                               //f(S4,-)=S1                                //f(S4,L)=S1                             //f(S4,1-9)=S1                              //f(S4,D)=S1                                //f(S4,0)=S1                               //f(S4,/)=S1                                 //f(S4,")=S1                                //f(S4,C)=S1                              //f(S4,\n)=S1                             //f(S4,A)=S1                              //f(S4,O)=S1
       matrizTransicion[4][0] =-1;       matrizTransicion[4][1] = -1;       matrizTransicion[4][2] = -1;       matrizTransicion[4][3] = 4;       matrizTransicion[4][4] = -1;       matrizTransicion[4][5] = 4;       matrizTransicion[4][6] = -1;       matrizTransicion[4][7] = -1;       matrizTransicion[4][8] = -1;       matrizTransicion[4][9] = -1;        matrizTransicion[4][10] = -1;       matrizTransicion[4][11] = -1;
        //f(S5,_)=S1                               //f(S5,-)=S1                                //f(S5,L)=S1                             //f(S5,1-9)=S1                              //f(S5,D)=S1                                //f(S5,0)=S1                               //f(S5,/)=S1                                 //f(S5,")=S1                                //f(S5,C)=S1                              //f(S5,\n)=S1                               //f(S5,A)=S1                              //f(S5,O)=S1
        matrizTransicion[5][0] = 6;       matrizTransicion[5][1] = 6;       matrizTransicion[5][2] = 6;       matrizTransicion[5][3] = 6;       matrizTransicion[5][4] = -1;       matrizTransicion[5][5] = 6;       matrizTransicion[5][6] = 6;       matrizTransicion[5][7] = -1;       matrizTransicion[5][8] = 6;       matrizTransicion[5][9] = -1;      matrizTransicion[5][10] = 6;       matrizTransicion[5][11] = 6;
         //f(S6,_)=S1                               //f(S6,-)=S1                                //f(S6,L)=S1                             //f(S6,1-9)=S1                              //f(S6,D)=S1                                //f(S6,0)=S1                               //f(S6,/)=S1                                 //f(S6,")=S1                                //f(S6,C)=S1                              //f(S6,\n)=S1                            //f(S6,A)=S1                              //f(S6,O)=S1
        matrizTransicion[6][0] = 6;       matrizTransicion[6][1] = 6;       matrizTransicion[6][2] = 6;       matrizTransicion[6][3] = 6;       matrizTransicion[6][4] = -1;       matrizTransicion[6][5] = 6;       matrizTransicion[6][6] = 6;       matrizTransicion[6][7] = 7;       matrizTransicion[6][8] = 6;       matrizTransicion[6][9] = -1;       matrizTransicion[6][10] = 6;       matrizTransicion[6][11] = 6;
         //f(S7,_)=S1                               //f(S7,-)=S1                                //f(S7,L)=S1                             //f(S7,1-9)=S1                              //f(S7,D)=S1                                //f(S7,0)=S1                               //f(S7,/)=S1                                 //f(S7,")=S1                                //f(S7,C)=S1                              //f(S7,\n)=S1                            //f(S7,A)=S1                              //f(S7,O)=S1
        matrizTransicion[7][0] = -1;       matrizTransicion[7][1] = -1;       matrizTransicion[7][2] = -1;       matrizTransicion[7][3] = -1;       matrizTransicion[7][4] = -1;       matrizTransicion[7][5] = -1;       matrizTransicion[7][6] = -1;       matrizTransicion[7][7] = -1;       matrizTransicion[7][8] = -1;       matrizTransicion[7][9] = -1;     matrizTransicion[7][10] = -1;       matrizTransicion[7][11] = -1;
         //f(S8,_)=S1                               //f(S8,-)=S1                                //f(S8,L)=S1                             //f(S8,1-9)=S1                              //f(S8,D)=S1                                //f(S8,0)=S1                               //f(S8,/)=S1                                 //f(S8,")=S1                                //f(S8,C)=S1                              //f(S8,\n)=S1                            //f(S8,A)=S1                              //f(S8,O)=S1
        matrizTransicion[8][0] = -1;       matrizTransicion[8][1] = -1;       matrizTransicion[8][2] = -1;       matrizTransicion[8][3] = -1;       matrizTransicion[8][4] = -1;       matrizTransicion[8][5] = -1;       matrizTransicion[8][6] = 9;       matrizTransicion[8][7] = -1;       matrizTransicion[8][8] = -1;       matrizTransicion[8][9] = -1;      matrizTransicion[8][10] = -1;       matrizTransicion[8][11] = -1;
         //f(S9,_)=S1                               //f(S9,-)=S1                                //f(S9,L)=S1                             //f(S9,1-9)=S1                              //f(S9,D)=S1                                //f(S9,0)=S1                               //f(S9,/)=S1                                 //f(S9,")=S1                                //f(S9,C)=S1                              //f(S9,\n)=S1                            //f(S9,A)=S1                              //f(S9,O)=S1
        matrizTransicion[9][0] = 10;       matrizTransicion[9][1] = 10;       matrizTransicion[9][2] = 10;       matrizTransicion[9][3] = 10;       matrizTransicion[9][4] = -1;       matrizTransicion[9][5] = 10;       matrizTransicion[9][6] = 10;       matrizTransicion[9][7] = 10;       matrizTransicion[9][8] = 10;       matrizTransicion[9][9] = -1;     matrizTransicion[9][10] = 10;       matrizTransicion[9][11] = 10;
         //f(S10,_)=S1                               //f(S10,-)=S1                            //f(S10,L)=S1                             //f(S10,1-9)=S1                           //f(S10,D)=S1                             //f(S10,0)=S1                              //f(S10,/)=S1                               //f(S10,")=S1                              //f(S10,C)=S1                             //f(S10,\n)=S1                          //f(S10,A)=S1                              //f(S10,O)=S1
        matrizTransicion[10][0] = 10;     matrizTransicion[10][1] = 10;     matrizTransicion[10][2] = 10;     matrizTransicion[10][3] = 10;     matrizTransicion[10][4] = -1;     matrizTransicion[10][5] = 10;     matrizTransicion[10][6] = 10;     matrizTransicion[10][7] = 10;     matrizTransicion[10][8] = 10;     matrizTransicion[10][9] = 11; matrizTransicion[10][10] = 10;       matrizTransicion[10][11] = 10;
         //f(S11,_)=S1                               //f(S11,-)=S1                            //f(S11,L)=S1                             //f(S11,1-9)=S1                           //f(S11,D)=S1                             //f(S11,0)=S1                              //f(S11,/)=S1                               //f(S11,")=S1                              //f(S11,C)=S1                             //f(S11,\n)=S1                          //f(S11,A)=S1                              //f(S11,O)=S1
        matrizTransicion[11][0] = -1;     matrizTransicion[11][1] = -1;     matrizTransicion[11][2] = -1;     matrizTransicion[11][3] = -1;     matrizTransicion[11][4] = -1;     matrizTransicion[11][5] = -1;     matrizTransicion[11][6] = -1;     matrizTransicion[11][7] = -1;     matrizTransicion[11][8] = -1;     matrizTransicion[11][9] = -1;     matrizTransicion[11][10] = -1;       matrizTransicion[11][11] = -1;
         //f(S11,_)=S1                               //f(S11,-)=S1                            //f(S11,L)=S1                             //f(S11,1-9)=S1                           //f(S11,D)=S1                             //f(S11,0)=S1                              //f(S11,/)=S1                               //f(S11,")=S1                              //f(S11,C)=S1                             //f(S11,\n)=S1                          //f(S12,A)=S1                              //f(S12,O)=S1
        matrizTransicion[12][0] = -1;     matrizTransicion[12][1] = -1;     matrizTransicion[12][2] = -1;     matrizTransicion[12][3] = -1;     matrizTransicion[12][4] = -1;     matrizTransicion[12][5] = -1;     matrizTransicion[12][6] = -1;     matrizTransicion[12][7] = -1;     matrizTransicion[12][8] = -1;     matrizTransicion[12][9] = -1;     matrizTransicion[12][10] = -1;       matrizTransicion[12][11] = -1;
         //f(S11,_)=S1                               //f(S11,-)=S1                            //f(S11,L)=S1                             //f(S11,1-9)=S1                           //f(S11,D)=S1                             //f(S11,0)=S1                              //f(S11,/)=S1                               //f(S11,")=S1                              //f(S11,C)=S1                             //f(S11,\n)=S1                          //f(S13,A)=S1                              //f(S13,O)=S1
        matrizTransicion[13][0] = -1;     matrizTransicion[13][1] = -1;     matrizTransicion[13][2] = -1;     matrizTransicion[13][3] = -1;     matrizTransicion[13][4] = -1;     matrizTransicion[13][5] = -1;     matrizTransicion[13][6] = -1;     matrizTransicion[13][7] = -1;     matrizTransicion[13][8] = -1;     matrizTransicion[13][9] = -1;     matrizTransicion[13][10] = -1;       matrizTransicion[13][11] = -1;
   
    }

    //Alfabeto 
    //guionBajo _     tipoCaracter = 0
    //guionMedio - tipoCaracter = 1
    //letra  a-z, A-Z   tipoCaracter = 2
    char[] naturalesPositivos = {'1','2','3','4','5','6','7','8','9'};  // tipoCaracter = 3
    //digito 0-9   tipoCaracter = 4
    //cero 0  tipoCaracter = 5
    //diagonal   /   tipoCaracter = 6
    //comillas   "   tipoCaracter = 7
    //saltoLinea  \n  tipoCaracter = 8
    char[] signosAgrupacion = {'(', ')', '[', ']', '{', '}'};  // tipoCaracter = 9
    char[] operadores = {'+', '-', '*', '/', '^','='};  // tipoCaracter = 10

    public AutomataFinitoDeterminista(JTextArea taCodigoFuente) {
        this.taCodigoFuente = taCodigoFuente;
        this.codigoFuente = taCodigoFuente.getText();
    }

    public void analizar(JTextArea taTransiciones) {
        taTransiciones.setText("");
        while (posicion < codigoFuente.length()) {
            obtenerToken(taTransiciones);
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

            if (Character.isWhitespace(caracter) && this.estadoActual != 5 && this.estadoActual != 6 && this.estadoActual != 9 && this.estadoActual != 10) {
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

            if (estadoActual == 11) {
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
            TiposToken tipoToken = tipoToken();
            if (tipoToken().equals(TiposToken.IDENTIFICADOR)) {
                if (this.esPalabraReservada(token)) {
                    tipoToken = this.obtenerTipoTokenPalabraReservada(token);
                }
            }
            
            if (!tipoToken.equals(TiposToken.LITERAL) && !tipoToken.equals(TiposToken.COMENTARIO)) {
                token = token.replace(" ", "");
            } else {
                token = token.replace("\n", "");
            }

            Token nuevoToken = new Token(establecerTokenCaracter(tipoToken, token), token, this.numFilaT, this.numColumnaT - 1);
            tokens.add(nuevoToken);
            taTokens.append("------------------------------------------------\n");

        } else if (!token.isBlank() && tipoToken().equals(TiposToken.ERROR)) {
            Token error = new Token(tipoToken(), token.replace(" ", ""), numFilaE, numColumnaE);
            tokens.add(error);
            taTokens.append("------------------------------------------------\n");
        }
    }
    
    private TiposToken establecerTokenCaracter(TiposToken tipo, String token){
        TiposToken tipoToken = tipo;
        
        if (tipoToken.equals(TiposToken.OPERADOR)) {
            switch(token){
                case "+":
                    tipoToken = TiposToken.SIGNO_MAS;
                    break;
                case "-":
                    tipoToken = TiposToken.SIGNO_MENOS;
                    break;
                case "*":
                    tipoToken = TiposToken.SIGNO_POR;
                    break;
                case "/":
                    tipoToken = TiposToken.DIAGONAL;
                    break;
                case "^":
                    tipoToken = TiposToken.SIGNO_POTENCIA;
                    break;
                case "=":
                    tipoToken = TiposToken.SIGNO_IGUAL;
                    break;
            }
        }else if (tipoToken.equals(TiposToken.SIGNO_AGRUPACION)) {
            switch(token){
                case "(":
                    tipoToken = TiposToken.PARENTESIS_APERTURA;
                    break;
                case ")":
                    tipoToken = TiposToken.PARENTESIS_CIERRE;
                    break;
            }
        }
        
        return tipoToken;
    }

    private TiposToken obtenerTipoTokenPalabraReservada(String token) {
        TiposToken tipo = TiposToken.IDENTIFICADOR;
        if (token.equalsIgnoreCase(TiposToken.ESCRIBIR.toString())) {
            tipo = TiposToken.ESCRIBIR;
        } else if (token.equalsIgnoreCase(TiposToken.FIN.toString())) {
            tipo = TiposToken.FIN;
        } else if (token.equalsIgnoreCase(TiposToken.REPETIR.toString())) {
            tipo = TiposToken.REPETIR;
        } else if (token.equalsIgnoreCase(TiposToken.INICIAR.toString())) {
            tipo = TiposToken.INICIAR;
        } else if (token.equalsIgnoreCase(TiposToken.SI.toString())) {
            tipo = TiposToken.SI;
        } else if (token.equalsIgnoreCase(TiposToken.VERDADERO.toString())) {
            tipo = TiposToken.VERDADERO;
        } else if (token.equalsIgnoreCase(TiposToken.FALSO.toString())) {
            tipo = TiposToken.FALSO;
        } else if (token.equalsIgnoreCase(TiposToken.ENTONCES.toString())) {
            tipo = TiposToken.ENTONCES;
        }

        return tipo;
    }

    private boolean esPalabraReservada(String token) {
        boolean esPalabraReservada = false;
        for (String palabraReservada : this.palabraReservadas) {
            if (palabraReservada.equalsIgnoreCase(token)) {
                esPalabraReservada = true;
                break;
            }
        }
        return esPalabraReservada;
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
                tipoToken = TiposToken.IDENTIFICADOR;
                break;
            case 3:
                tipoToken = TiposToken.NUMERO_ENTERO;
                break;
            case 4:
                tipoToken = TiposToken.NUMERO_ENTERO;
                break;
            case 7:
                tipoToken = TiposToken.LITERAL;
                break;
            case 8:
                tipoToken = TiposToken.OPERADOR;
                break;
            case 11:
                tipoToken = TiposToken.COMENTARIO;
                break;
            case 12:
                tipoToken = TiposToken.OPERADOR;
                break;
            case 13:
                tipoToken = TiposToken.SIGNO_AGRUPACION;
                break;
            case 0:
                tipoToken = TiposToken.INICIO_TOKEN;
                break;
            default:
                tipoToken = TiposToken.ERROR;
        }
        return tipoToken;
    }

    //Alfabeto 
    //guionBajo _     tipoCaracter = 0
    //guionMedio - tipoCaracter = 1
    //letra  a-z, A-Z   tipoCaracter = 2
    //char[] naturalesPositivos = {'1','2','3','4','5','6','7','8','9'};  // tipoCaracter = 3
    //digito 0-9   tipoCaracter = 4
    //cero 0  tipoCaracter = 5
    //diagonal   /   tipoCaracter = 6
    //comillas   "   tipoCaracter = 7
    //cualquierCaracter tipoCaracter = 8
    //saltoLinea  \n  tipoCaracter = 9
    //agrupacion tipoCaracter = 10
    //operacion tipoCaracter =11
    private int obtenerTipoCaracter(char caracter) {
        int tipo = -1;

        if (caracter == '_') {
            tipo = 0;
        } else if (caracter == '-') {
            tipo = 1;
        } else if (Character.isLetter(caracter)) {
            tipo = 2;
        } else if (this.pertenece(naturalesPositivos, caracter)) {
            tipo = 3;
        } else if (caracter == '0') {
            tipo = 5;
        } else if (caracter == '/') {
            tipo = 6;
        } else if (caracter == '"') {
            tipo = 7;
        } else if (caracter == '\n') {
            tipo = 9;
        } else if (this.pertenece(signosAgrupacion, caracter)) {
            tipo = 10;
        } else if (this.pertenece(operadores, caracter)) {
            tipo = 11;
        } else {
            tipo = 8;
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
            if (estadoActual >= 0 && estadoActual <= 13) {  //S0-S13 
                estadoSiguiente = matrizTransicion[estadoActual][obtenerTipoCaracter(caracterTransicion)];
            }
        } catch (IndexOutOfBoundsException ex) {
            //dejar pasar el estado error=-1
        }

        return estadoSiguiente;
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

    public ArrayList<Token> obtenerTokens() {
        return this.tokens;
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
     * Devuelve una cadena para denotar singular (vez) o plural(veces)
     *
     * @param contador
     * @return
     */
    private String getSingPluralr(int contador) {
        String palabra = " veces.";
        if (contador == 1) {
            palabra = " vez.";
        }
        return palabra;
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
}
