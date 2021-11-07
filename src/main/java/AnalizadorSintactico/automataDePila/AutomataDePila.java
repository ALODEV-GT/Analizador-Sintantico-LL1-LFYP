package AnalizadorSintactico.automataDePila;

import AnalizadorSintactico.pila.Pila;
import analizadorLexico.TiposToken;
import analizadorLexico.Token;
import java.util.ArrayList;
import java.util.List;
public class AutomataDePila {

    private final List<Token> tokens;
    private final Contenedor[][] tablaTransicion = new Contenedor[7][6];
    private final Pila pila;

    public AutomataDePila(List<Token> tokens) {
        this.tokens = tokens;
        this.agregarFinArchivo();
        this.pila = new Pila();
        this.iniciarPila();
    }
    /**FILAS
     * I = 0
     * E= 1
     * C = 2
     * N = 3
     * Y = 4
     * M = 5
     * F = 6
     */
    
    /**COLUMNAS
     * ESCRIBIR = 0
     * numero = 1
     * id = 2
     * literal = 3
     * fin = 4
     * $ (fin de archivo) = 5
     */
    
    /** ID TERMINALES
     * ESCRIBIR = -1
     * numero = -2
     * id = -3
     * literal = -4
     * fin = -5
     * $ (fin de archivo) = -6
     * ε = -7
     */

    {
        ArrayList<Integer> producciones00 = new ArrayList<>();
        producciones00.add(1);
        producciones00.add(0);
        tablaTransicion[0][0] = new Contenedor(producciones00);
        
        ArrayList<Integer> producciones05 = new ArrayList<>();
        producciones05.add(-7);
        tablaTransicion[0][5] = new Contenedor(producciones05);
        
        ArrayList<Integer> producciones10 = new ArrayList<>();
        producciones10.add(-1);
        producciones10.add(2);
        producciones10.add(6);
        tablaTransicion[1][0] = new Contenedor(producciones10);
        
        ArrayList<Integer> producciones21 = new ArrayList<>();
        producciones21.add(3);
        tablaTransicion[2][1] = new Contenedor(producciones21);
        
        ArrayList<Integer> producciones22 = new ArrayList<>();
        producciones22.add(4);
        tablaTransicion[2][2] = new Contenedor(producciones22);
        
        ArrayList<Integer> producciones23 = new ArrayList<>();
        producciones23.add(5);
        tablaTransicion[2][3] = new Contenedor(producciones23);

        ArrayList<Integer> producciones31 = new ArrayList<>();
        producciones31.add(-2);
        tablaTransicion[3][1] = new Contenedor(producciones31);
        
        ArrayList<Integer> producciones42 = new ArrayList<>();
        producciones42.add(-3);
        tablaTransicion[4][2] = new Contenedor(producciones42);
        
        ArrayList<Integer> producciones53 = new ArrayList<>();
        producciones53.add(-4);
        tablaTransicion[5][3] = new Contenedor(producciones53);
        
        ArrayList<Integer> producciones64 = new ArrayList<>();
        producciones64.add(-5);
        tablaTransicion[6][4] = new Contenedor(producciones64);
    }
    
    private void iniciarPila(){
        this.pila.apilar(-6); 
        this.pila.apilar(0);
    }
    
    private void agregarFinArchivo(){
        this.tokens.add(new Token(TiposToken.FIN_ARCHIVO, "$", 0, 0));
    }
    
    public void analizar(){
        Token tokenActual;
        int idTipoTokenActual;
        int idProductorActual=0;
        int numToken = 0;
        boolean seguir = true;
        
        while(numToken < this.tokens.size() && seguir){
            tokenActual = this.tokens.get(numToken);
            idTipoTokenActual = tokenActual.getTipoToken().getIdToken(); // Token: token
            System.out.println("Token: " + idTipoTokenActual);
            try { 
                idProductorActual = this.pila.cima();
                if (idProductorActual < 0) { //Es un terminal
                    if (idProductorActual == TiposToken.EPSILON.getIdComoTerminal()) { //FIN DE ARCHIVO
                            System.out.println("<-----------Reduce");
                            this.pila.retirar();
                            imprimirPila();
                    }else{
                        if (idProductorActual == tokenActual.getTipoToken().getIdComoTerminal()) {
                            System.out.println("<-----------Reduce");
                            this.pila.retirar();
                            imprimirPila();
                            numToken++;
                        }
                    }
                }else{
                    this.pila.retirar();
                    this.apilarProduccion(idProductorActual, idTipoTokenActual);
                }
            } catch (Exception ex) {
//                seguir = false;
//                ex.printStackTrace(System.out);   
                this.pila.apilar(idProductorActual);
                this.evaluarError(idProductorActual, numToken);
                 this.imprimirPila();
                if (!this.pila.esVacia()) {
                    this.pila.retirar();
                }else{
                    seguir = false;
                }
                this.imprimirPila();
            }
            
            
        }
            
         System.out.println("Se termino el analisis sintactico...");
         imprimirPila();
    }
    
    private void evaluarError(int idProductor, int numToken){
        String siguientes;
        if (idProductor == 0) {
            System.out.println("Se esperaba un token de tipo: ESCRIBIR, REPETIR, SI, IDENTIFICADOR");
        }else{
            siguientes = this.tokens.get(numToken-1).getTipoToken().obtenerSiguientes();
            System.out.println("Se esperaba un token del tipo: " + siguientes);
        }
    }
    
    private void apilarProduccion(int idProductor, int idTokenActual){
        System.out.println("Shift ["+ idProductor+"]" +"[" +idTokenActual+"]");
        ArrayList<Integer> producciones = tablaTransicion[idProductor][idTokenActual].getProducciones();
        for (int i = producciones.size()-1; i >= 0; i--) {
            this.pila.apilar(producciones.get(i));
        }
         imprimirPila();
    }
    
    private void imprimirPila(){
        System.out.println("\n");
        System.out.println("<<-- Pila -->>");
        pila.listar();
        System.out.println("-------------");
        System.out.println("\n");
    }
    

}
